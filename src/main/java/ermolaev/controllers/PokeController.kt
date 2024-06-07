package ermolaev.controllers

import ermolaev.query.QueryToPokeAPI
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PokeController {
    @get:GetMapping("/pokemon")
    val all: String?
        get() = QueryToPokeAPI.sendQuery("")

    @GetMapping("/pokemon/{name}")
    fun findByName(@PathVariable("name") name: String?): String? {
        return name?.let { QueryToPokeAPI.sendQuery(it) }
    }
}
