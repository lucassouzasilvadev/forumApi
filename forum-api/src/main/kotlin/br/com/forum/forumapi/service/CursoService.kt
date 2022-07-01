package br.com.forum.forumapi.service

import br.com.forum.forumapi.model.Curso
import br.com.forum.forumapi.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(private val cursoRepository: CursoRepository) {

    fun buscarPorId(id: Long): Curso{
        return cursoRepository.findById(id).get()
    }
}
