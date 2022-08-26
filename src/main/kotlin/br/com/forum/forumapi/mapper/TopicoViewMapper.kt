package br.com.forum.forumapi.mapper

import br.com.forum.forumapi.controller.response.TopicoResponse
import br.com.forum.forumapi.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper: Mapper<Topico, TopicoResponse> {
    override fun map(t: Topico): TopicoResponse {
       return TopicoResponse(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status,
            dataAlteracao = t.dataAlteracao
        )
    }
}