package com.prs.backoffice.log


import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/records")
class LogController(val repository: LogRepository) {

    @GetMapping
    fun getAll(): List<Log> = repository.findAll()

    @PostMapping
    fun postLog(@RequestBody log: Log) = repository.save(log)
}