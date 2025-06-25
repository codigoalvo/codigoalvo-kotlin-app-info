package br.com.codigoalvo.appinfo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
@PropertySource("classpath:git.properties")
open class AppInfoApplication

fun main(args: Array<String>) {
    runApplication<AppInfoApplication>(*args)
}