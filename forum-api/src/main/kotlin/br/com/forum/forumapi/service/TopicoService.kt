package br.com.forum.forumapi.service

import br.com.forum.forumapi.controller.form.AtualizacaoTopicoForm
import br.com.forum.forumapi.controller.form.NovoTopicoForm
import br.com.forum.forumapi.controller.response.TopicoResponse
import br.com.forum.forumapi.exception.NotFoundException
import br.com.forum.forumapi.mapper.TopicoFormMapper
import br.com.forum.forumapi.mapper.TopicoViewMapper
import br.com.forum.forumapi.model.Topico
import br.com.forum.forumapi.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private val topicoRepository: TopicoRepository,
    private val topicoResponseMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Tópico não encontrado!"
    ) {

    fun listar(): List<TopicoResponse>{
        return topicoRepository.findAll().stream().map {
                t -> topicoResponseMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun listarPorId(id: Long): TopicoResponse {
        val topico =  topicoRepository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
       return  topicoResponseMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoResponse {
        val topico = topicoFormMapper.map(form)
        topicoRepository.save(topico)
        return topicoResponseMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoResponse {
        val topico = topicoRepository.findById(form.id).orElseThrow { NotFoundException(notFoundMessage) }
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        return topicoResponseMapper.map(topico)
    }

    fun deletar(id: Long) {
       topicoRepository.deleteById(id)
    }
}