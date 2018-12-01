package io.github.xshoji.springbootmultimodule

import io.github.xshoji.springbootmultimodule.domain.repository.CommentRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@SpringBootApplication
@RestController
@RequestMapping("/comment")
class SpringBootMultiModuleApplication {

    @Autowired
    private val commentRepository: CommentRepositoryImpl? = null;

    /**
     * - [【Spring Boot入門（5）】RestAPI(POST)を作ってみる | なんちゃってSEの備忘録](https://poppingcarp.com/spring-boot_intro_rest_post/)
     */
    @RequestMapping(value = "/{userName}", method = arrayOf(RequestMethod.GET), produces = arrayOf("application/json"))
    @ResponseStatus(HttpStatus.CREATED)
    internal operator fun get(@PathVariable userName: String): MutableList<String>? {
        return commentRepository?.get(userName)
    }

    /**
     * - [【Spring Boot入門（5）】RestAPI(POST)を作ってみる | なんちゃってSEの備忘録](https://poppingcarp.com/spring-boot_intro_rest_post/)
     */
    @RequestMapping(value = "/{userName}/{message}", method = arrayOf(RequestMethod.GET), produces = arrayOf("application/json"))
    @ResponseStatus(HttpStatus.CREATED)
    internal fun add(@PathVariable userName: String, @PathVariable message: String): String {
        commentRepository?.add(userName, message)
        return message
    }

    companion object {

        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(SpringBootMultiModuleApplication::class.java, *args)
        }
    }
}
