package com.prs.backoffice.log


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/records")
class LogController(val repository: LogRepository) {

    @GetMapping
    fun getAll(): List<Log> = repository.findAll()
}