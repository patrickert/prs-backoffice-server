package com.prs.backoffice.plate

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RestController
@RequestMapping("/lists")
class PlateListController(val repository: PlateListRepository, val service: PlateListService) {

    @GetMapping
    fun getPlateLists(): List<PlateListDTO> = service.findAll()

    @GetMapping("/{listId}")
    fun getPlateLists(@PathVariable("listId") listId: Long): ResponseEntity<PlateListDTO> {
        return service.findById(listId)
                .map { list -> ResponseEntity(list, HttpStatus.OK) }
                .orElse(ResponseEntity(HttpStatus.NOT_FOUND))
    }

    @PostMapping
    fun newList(@RequestBody listDTO: PlateListDTO): PlateListDTO = service.newList(listDTO)

    @PutMapping("/{listId}")
    fun updateList(@PathVariable("listId") listId: Long, @RequestBody list: PlateListDTO): ResponseEntity<Any> {
        if (!repository.existsById(listId)) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        list.id = listId
        service.newList(list)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @DeleteMapping("/{listId}")
    fun deleteList(@PathVariable("listId") listId: Long): ResponseEntity<Any> {
        if (!repository.existsById(listId)) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        repository.deleteById(listId)
        return ResponseEntity(listId, HttpStatus.OK)
    }

    @GetMapping("/info/{plate}")
    fun getMetadataForPlate(@PathVariable plate: String) = service.findEmailsForPlate(plate)

}
