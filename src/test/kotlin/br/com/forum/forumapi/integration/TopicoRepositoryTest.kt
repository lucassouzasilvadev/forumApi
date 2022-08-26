//package br.com.alura.forum.integration
//
//import br.com.alura.forum.configuration.DatabaseContainerConfiguration
//import br.com.forum.forumapi.ForumApiApplication
//import br.com.forum.forumapi.ForumApiApplicationTests
//import br.com.forum.forumapi.controller.response.TopicoPorCategoria
//import br.com.forum.forumapi.model.TopicoTest
//import br.com.forum.forumapi.repository.TopicoRepository
//import org.assertj.core.api.Assertions.assertThat
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
//import org.springframework.data.domain.PageRequest
//import org.springframework.test.context.ContextConfiguration
//import org.testcontainers.junit.jupiter.Testcontainers
//
//@Testcontainers
////@ContextConfiguration(classes = [ForumApiApplication::class])
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//class TopicoRepositoryTest : DatabaseContainerConfiguration() {
//
//    @Autowired
//    private lateinit var topicoRepository: TopicoRepository
//
//    private val paginacao = PageRequest.of(0,5)
//    private val topico = TopicoTest.build()
//
//    @Test
//    fun `deve gerar um relatorio`() {
//        topicoRepository.save(topico)
//        val relatorio = topicoRepository.relatorio()
//
//        assertThat(relatorio).isNotNull
//        assertThat(relatorio.first()).isExactlyInstanceOf(TopicoPorCategoria::class.java)
//    }
//
//    @Test
//    fun `deve buscar um topico por nome`() {
//        topicoRepository.save(topico)
//        val resultado = topicoRepository.findByCursoNome(nomeCurso = "Kotlin", paginacao = paginacao)
//
//        assertThat(resultado.totalElements).isEqualTo(1)
//    }
//}