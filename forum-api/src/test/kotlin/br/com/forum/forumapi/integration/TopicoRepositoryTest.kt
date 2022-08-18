package br.com.forum.forumapi.integration

import br.com.forum.forumapi.controller.response.TopicoPorCategoria
import br.com.forum.forumapi.model.TopicoTest
import br.com.forum.forumapi.repository.TopicoRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TopicoRepositoryTest {

    @Autowired
    private lateinit var topicoRepository: TopicoRepository

    private val topicoTest = TopicoTest.build()

    companion object {
        @Container
        private val mySqlContainer = MySQLContainer<Nothing>("mysql:8.0.29").apply {
                withDatabaseName("testeDb")
                withUsername("lucas")
                withPassword("123456")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", mySqlContainer::getJdbcUrl);
            registry.add("spring.datasource.password", mySqlContainer::getPassword);
            registry.add("spring.datasource.username", mySqlContainer::getUsername);
        }
    }

    @Test
    fun `deve gerar um relatorio` (){
        topicoRepository.save(topicoTest)
        val relatorio = topicoRepository.relatorio()

        assertThat(relatorio).isNotNull
        assertThat(relatorio.first()).isExactlyInstanceOf(TopicoPorCategoria::class.java)
    }

    @Test
    fun `deve listar topico pelo nome do curso`(){
        topicoRepository.save(topicoTest)
        val findByCursoNome = topicoRepository.findByCursoNome(topicoTest.curso.nome, PageRequest.of(0,5))

        assertThat(findByCursoNome).isNotNull
    }


}