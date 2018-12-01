package io.github.xshoji.springbootactuator

import lombok.Data
import lombok.Getter
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

import java.util.ArrayList
import java.util.Date
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

@SpringBootApplication
@RestController
@RequestMapping("/comment")
class SpringBootMultiModuleApplication {

    @get:RequestMapping(value = "/", method = arrayOf(RequestMethod.GET), produces = arrayOf("application/json"))
    @get:ResponseStatus(HttpStatus.OK)
    internal val all: ConcurrentMap<String, MutableList<Comment>> = ConcurrentHashMap()

    inner class Comment(val createdOn: Date, val user: String, val message: String)

    @RequestMapping(value = "/{user}", method = arrayOf(RequestMethod.GET), produces = arrayOf("application/json"))
    @ResponseStatus(HttpStatus.OK)
    internal operator fun get(@PathVariable user: String): List<Comment> {
        return all.getOrDefault(user, ArrayList())
    }

    /**
     * - [【Spring Boot入門（5）】RestAPI(POST)を作ってみる | なんちゃってSEの備忘録](https://poppingcarp.com/spring-boot_intro_rest_post/)
     */
    @RequestMapping(value = "/{user}/{message}", method = arrayOf(RequestMethod.GET), produces = arrayOf("application/json"))
    @ResponseStatus(HttpStatus.CREATED)
    internal fun add(@PathVariable user: String, @PathVariable message: String): Comment {
        var comments = all.getOrDefault(user, ArrayList())
        val comment = Comment(Date(), user, message)
        comments.add(comment)
        all.put(user, comments)
        return comment
    }

    companion object {

        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(SpringBootMultiModuleApplication::class.java, *args)
        }
    }
}
