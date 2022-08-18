package br.com.forum.forumapi.model

object TopicoTest {
    fun build() = Topico(
        id = 1,
        titulo = "Kotlin Basico",
        mensagem = "Aprendendo Kotlin Básico",
        curso = CursoTest.build(),
        autor = UsuarioTest.build()
    )
}