package br.com.forum.forumapi.model

import br.com.forum.forumapi.controller.response.TopicoResponse
import java.time.LocalDate
import java.time.LocalDateTime

object TopicoResponseTest {
    fun build() = TopicoResponse(
        id = 1,
        titulo = "Kotlin Basico",
        mensagem = "Aprendendo Kotlin Básico",
        status = StatusTopico.NAO_RESPONDIDO,
        dataCriacao = LocalDateTime.now(),
        dataAlteracao = LocalDate.now()
    )
}