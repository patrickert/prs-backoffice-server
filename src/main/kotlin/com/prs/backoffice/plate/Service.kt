package com.prs.backoffice.plate

import org.springframework.stereotype.Service
import java.util.*


@Service
class PlateListService(val repository: PlateListRepository) {

    fun findAll(): List<PlateListDTO> = repository.findAll().map { plateList -> plateList.toPlateListDTO() }

    fun findById(listId: Long): Optional<PlateListDTO> = repository.findById(listId).map { list -> list.toPlateListDTO() }

    fun newList(listDTO: PlateListDTO): PlateListDTO {
        var list = listDTO.toPlateList()
        repository.save(list)
        return list.toPlateListDTO()
    }

    fun findEmailsForPlate(plate: String): List<String> = findAll()
            .filter { list -> list.list.contains(plate)}
            .map { list -> list.metadata }


}