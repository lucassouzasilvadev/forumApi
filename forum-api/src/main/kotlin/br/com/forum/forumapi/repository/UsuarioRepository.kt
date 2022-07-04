package br.com.forum.forumapi.repository

import br.com.forum.forumapi.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long> {

    fun findByEmail(username: String?): Usuario?

}