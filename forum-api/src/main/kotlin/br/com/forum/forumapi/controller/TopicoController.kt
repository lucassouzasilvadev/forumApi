package br.com.forum.forumapi.controller
import br.com.forum.forumapi.controller.form.AtualizacaoTopicoForm
import br.com.forum.forumapi.controller.form.NovoTopicoForm
import br.com.forum.forumapi.controller.response.TopicoPorCategoria
import br.com.forum.forumapi.controller.response.TopicoResponse
import br.com.forum.forumapi.service.TopicoService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    @Cacheable("topico")
    fun listarTopicos(
        @RequestParam(required = false)nomeCurso: String?,
        @PageableDefault(size = 5, sort = ["dataCriacao"], direction = Sort.Direction.DESC) paginacao: Pageable
    ): Page<TopicoResponse> {
      return service.listar(nomeCurso, paginacao)
    }

    @GetMapping("/{id}")
    fun listarTopicosPorId(@PathVariable id: Long): TopicoResponse{
        return service.listarPorId(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["topico"], allEntries = true)
    fun cadastrar(@RequestBody @Valid form: NovoTopicoForm, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoResponse> {
        val topicoResponse = service.cadastrar(form)
        val uri = uriBuilder.path("/topicos/${topicoResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoResponse)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["topico"], allEntries = true)
    fun atualizar(@RequestBody @Valid form: AtualizacaoTopicoForm): ResponseEntity<TopicoResponse>{
        val topicoView = service.atualizar(form)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = ["topico"], allEntries = true)
    fun deleteTopico(@PathVariable id: Long){
        service.deletar(id)
    }

    @GetMapping("/relatorio")
    fun relatorio(): List<TopicoPorCategoria>{
        return service.relatorio()
    }

}