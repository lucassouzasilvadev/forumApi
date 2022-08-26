package br.com.forum.forumapi.controller.form

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class NovoTopicoForm(
@field:NotEmpty @field:Size(min = 5, max = 100, message = "titulo deve ter entre 5 e 100 caracteres") val titulo: String,
    @field:NotEmpty(message = "mensagem não pode estar em branco") val mensagem: String,
    @field:NotNull val idCurso: Long,
    @field:NotNull val idAutor: Long
)