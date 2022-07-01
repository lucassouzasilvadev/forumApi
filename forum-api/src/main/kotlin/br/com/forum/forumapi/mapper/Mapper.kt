package br.com.forum.forumapi.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}
