package br.com.forum.forumapi.repository

import br.com.forum.forumapi.model.Resposta
import org.springframework.data.jpa.repository.JpaRepository

interface RespostaRepository: JpaRepository<Resposta, Int>