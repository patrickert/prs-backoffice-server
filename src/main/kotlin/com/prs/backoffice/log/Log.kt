package com.prs.backoffice.log

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "logs")
class Log {
    @Id
    var id: String? = null

    var timestamp: String? = null
    var plate: String? = null
    var url: String? = null
    var camera: Int = 0

}