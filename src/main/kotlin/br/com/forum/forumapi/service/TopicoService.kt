package br.com.forum.forumapi.service

import br.com.forum.forumapi.controller.form.AtualizacaoTopicoForm
import br.com.forum.forumapi.controller.form.NovoTopicoForm
import br.com.forum.forumapi.controller.response.TopicoPorCategoria
import br.com.forum.forumapi.controller.response.TopicoResponse
import br.com.forum.forumapi.exception.NotFoundException
import br.com.forum.forumapi.mapper.TopicoFormMapper
import br.com.forum.forumapi.mapper.TopicoViewMapper
import br.com.forum.forumapi.repository.TopicoRepository
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDate


@Service
class TopicoService(
    private val topicoRepository: TopicoRepository,
    private val topicoResponseMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Tópico não encontrado!"
    ) {

    @Cacheable(cacheNames = ["topico"], key = "#root.method.name")
    fun listar(nomeCurso: String?,
               paginacao: Pageable
    ): Page<TopicoResponse> {
        val topicos = if (nomeCurso == null) {
            topicoRepository.findAll(paginacao);
        }else {
            topicoRepository.findByCursoNome(nomeCurso, paginacao)
        }
        return topicos.map { t -> topicoResponseMapper.map(t) }
    }

    fun listarPorId(id: Long): TopicoResponse {
        val topico =  topicoRepository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
       return  topicoResponseMapper.map(topico)
    }

    @CacheEvict(cacheNames = ["topico"], allEntries = true)
    fun cadastrar(form: NovoTopicoForm): TopicoResponse {
        val topico = topicoFormMapper.map(form)
        topicoRepository.save(topico)
        return topicoResponseMapper.map(topico)
    }

    @CacheEvict(cacheNames = ["topico"], allEntries = true)
    fun atualizar(form: AtualizacaoTopicoForm): TopicoResponse {
        val topico = topicoRepository.findById(form.id).orElseThrow { NotFoundException(notFoundMessage) }
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        topico.dataAlteracao = LocalDate.now()
        return topicoResponseMapper.map(topico)
    }

    @CacheEvict(cacheNames = ["topico"], allEntries = true)
    fun deletar(id: Long) {
       topicoRepository.deleteById(id)
    }

    fun relatorio(): List<TopicoPorCategoria>{
        return topicoRepository.relatorio()
    }

}



