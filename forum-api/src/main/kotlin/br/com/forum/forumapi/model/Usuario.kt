package br.com.forum.forumapi.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val email: String,
    val senha: String,
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_role")
    @JsonIgnore
    val role: List<Role> = mutableListOf()
)
