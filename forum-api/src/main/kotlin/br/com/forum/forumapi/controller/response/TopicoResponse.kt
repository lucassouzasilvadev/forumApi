package br.com.forum.forumapi.controller.response

import br.com.forum.forumapi.model.StatusTopico
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime
data class TopicoResponse(
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime,
    val dataAlteracao: LocalDate?
): Serializable
