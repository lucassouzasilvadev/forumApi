package br.com.forum.forumapi.repository

import br.com.forum.forumapi.controller.response.TopicoPorCategoria
import br.com.forum.forumapi.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicoRepository: JpaRepository<Topico, Long> {
    fun findByCursoNome(nomeCurso: String?, paginacao: Pageable): Page<Topico>

    @Query("SELECT new br.com.forum.forumapi.controller.response.TopicoPorCategoria (curso.categoria, count(t)) FROM Topico t JOIN t.curso curso GROUP BY curso.categoria")
    fun relatorio(): List<TopicoPorCategoria>
}