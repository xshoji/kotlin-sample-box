package io.github.xshoji.springbootmultimodule.domain.repository

import org.springframework.stereotype.Component

import java.util.ArrayList
import java.util.concurrent.ConcurrentHashMap

/**
 * - [SpringDataJPA · hyukke/HelloWorldTS Wiki](https://github.com/hyukke/HelloWorldTS/wiki/SpringDataJPA)
 */
@Component
class CommentRepositoryImpl : CommentRepository {
    internal var comments: ConcurrentHashMap<String, MutableList<String>> = ConcurrentHashMap<String, MutableList<String>>()

    override fun add(userName: String, comment: String) {
        get(userName).add(comment)
    }

    override fun get(userName: String): MutableList<String> {
        if (!comments.containsKey(userName)) {
            comments.put(userName, ArrayList<String>())
        }
        return comments[userName]!!
    }
}
