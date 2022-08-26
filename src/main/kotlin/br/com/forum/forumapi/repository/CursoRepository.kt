package br.com.forum.forumapi.repository

import br.com.forum.forumapi.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository: JpaRepository<Curso, Long> {

}