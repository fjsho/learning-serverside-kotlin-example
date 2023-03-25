package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam

@RestController
@RequestMapping("greeter")
class GreeterController {
    @GetMapping("/hello")
    fun hello(
        @RequestParam("name") name: String
    ): HelloResponse {
        return HelloResponse("Hello ${name}!!")
    }

    @GetMapping("/hello/{name}")
    fun helloPathValue(
        @PathVariable("name") name: String
    ): HelloResponse {
        return HelloResponse("Hello ${name}!! (path param)")
    }

    @PostMapping("/hello")
    fun helloByPost(
        @RequestBody request: HelloRequest
    ): HelloResponse {
        return HelloResponse("Hello ${request.name}!!")
    }
}