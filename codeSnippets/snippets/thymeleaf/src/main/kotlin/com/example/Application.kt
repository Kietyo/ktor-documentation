package com.example

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.thymeleaf.*
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    install(Thymeleaf) {
        setTemplateResolver(ClassLoaderTemplateResolver().apply {
            prefix = "templates/"
            suffix = ".html"
            characterEncoding = "utf-8"
        })
    }
    routing {
        get("/index") {
            val sampleUser = User(1, "John")
            call.respond(ThymeleafContent("index", mapOf("user" to sampleUser)))
        }
    }
}

data class User(val id: Int, val name: String)
