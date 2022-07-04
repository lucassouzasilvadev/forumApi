package br.com.forum.forumapi.service

import br.com.forum.forumapi.model.Usuario
import br.com.forum.forumapi.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val usuarioRepository: UsuarioRepository): UserDetailsService {

    fun buscarPorId(id: Long): Usuario {
        return usuarioRepository.findById(id).get()
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val usuario = usuarioRepository.findByEmail(username) ?: throw RuntimeException()
        return UserDetail(usuario)
    }

}
