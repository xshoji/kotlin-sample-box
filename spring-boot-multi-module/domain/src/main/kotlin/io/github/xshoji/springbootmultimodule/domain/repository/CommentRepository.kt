package io.github.xshoji.springbootmultimodule.domain.repository

/**
 * - [SpringDataJPA · hyukke/HelloWorldTS Wiki](https://github.com/hyukke/HelloWorldTS/wiki/SpringDataJPA)
 */
interface CommentRepository {
    fun add(userName: String, comment: String)
    operator fun get(userName: String): MutableList<String>
}
