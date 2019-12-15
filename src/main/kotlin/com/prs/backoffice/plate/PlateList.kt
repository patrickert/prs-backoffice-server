package com.prs.backoffice.plate

import javax.persistence.*

@Entity
@Table(name = "plate_list")
class PlateList(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
                var name: String,
                var action: String,
                var metadata: String,
                var list: String) {

    fun toPlateListDTO(): PlateListDTO = PlateListDTO (id, name, action, metadata, list.split(","))
}

class PlateListDTO(var id: Long, var name: String, var action: String, var metadata: String, var list: List<String>) {
    fun toPlateList(): PlateList = PlateList (id, name, action, metadata, list.joinToString(","))
}