package br.com.forum.forumapi.service

import br.com.forum.forumapi.model.Curso
import br.com.forum.forumapi.model.Usuario
import br.com.forum.forumapi.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(private val usuarioRepository: UsuarioRepository) {

    fun buscarPorId(id: Long): Usuario {
        return usuarioRepository.findById(id).get()
    }
}
