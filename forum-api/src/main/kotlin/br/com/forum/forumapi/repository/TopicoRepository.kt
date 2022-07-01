package br.com.forum.forumapi.repository

import br.com.forum.forumapi.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {
    fun findByCursoNome(nomeCurso: String?): List<Topico>
}