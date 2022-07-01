package br.com.forum.forumapi.mapper

import br.com.forum.forumapi.controller.form.NovoTopicoForm
import br.com.forum.forumapi.model.Topico
import br.com.forum.forumapi.service.CursoService
import br.com.forum.forumapi.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
): Mapper<NovoTopicoForm, Topico>{

    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }
}
