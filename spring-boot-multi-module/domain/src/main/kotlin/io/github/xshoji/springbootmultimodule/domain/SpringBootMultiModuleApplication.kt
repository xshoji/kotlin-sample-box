package io.github.xshoji.springbootmultimodule.domain

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringBootMultiModuleApplication {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(SpringBootMultiModuleApplication::class.java, *args)
        }
    }
}
