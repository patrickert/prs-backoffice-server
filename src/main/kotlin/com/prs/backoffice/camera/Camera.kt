package com.prs.backoffice.camera

import javax.persistence.*


@Entity
@Table(name = "camera")
class Camera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0
    var name: String? = ""
    var code: String? = ""
    var lat: Double? = 0.0
    var long: Double? = 0.0
}