package br.com.forum.forumapi.controller

import br.com.forum.forumapi.controller.response.TopicoPorCategoria
import br.com.forum.forumapi.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/relatorios")
class RelatorioController(
    private val topicoService: TopicoService
) {

    @GetMapping
    fun relatorio(): List<TopicoPorCategoria>{
        return topicoService.relatorio()
    }

}