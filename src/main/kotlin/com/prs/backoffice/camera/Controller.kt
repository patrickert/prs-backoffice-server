package com.prs.backoffice.camera

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RestController
@RequestMapping("/cameras")
class CameraController(val repository: CameraRepository) {

    @GetMapping
    fun getCameras(): List<Camera> = repository.findAll()

    @GetMapping("/{cameraId}")
    fun getCamera(@PathVariable("cameraId") cameraId: Long): ResponseEntity<Camera> {
        return repository.findById(cameraId)
                .map { camera -> ResponseEntity(camera, HttpStatus.OK) }
                .orElse(ResponseEntity(HttpStatus.NOT_FOUND))
    }

    @PostMapping
    fun newCamera(@RequestBody camera: Camera): Camera {
        repository.save(camera)
        return camera
    }

    @PutMapping
    fun updateCamera(@RequestBody camera: Camera): ResponseEntity<Any> {
        if (!repository.existsById(camera.id)) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        repository.save(camera)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @DeleteMapping("/{cameraId}")
    fun deleteCamera(@PathVariable("cameraId") cameraId: Long): ResponseEntity<Any> {
        if (!repository.existsById(cameraId)) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        repository.deleteById(cameraId)
        return ResponseEntity(cameraId, HttpStatus.OK)
    }
}
