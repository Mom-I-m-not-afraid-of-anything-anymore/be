package com.example.afraid.physical.controller

import com.example.afraid.physical.domain.*
import com.example.afraid.physical.service.PhysicalService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/physical")
class PhysicalController(
    private val physicalService: PhysicalService
) {


    @GetMapping("/heart/{userId}")
    fun getHeartByUserId(@PathVariable userId: Long): ResponseEntity<List<Heart>> {
        val heart = physicalService.getHeartByUserId(userId)
        return ResponseEntity.ok(heart)
    }

    @GetMapping("/bone/{userId}")
    fun getBoneByUserId(@PathVariable userId: Long): ResponseEntity<List<Bone>> {
        val bone = physicalService.getBoneByUserId(userId)
        return ResponseEntity.ok(bone)
    }

    @GetMapping("/spine/{userId}")
    fun getSpineByUserId(@PathVariable userId: Long): ResponseEntity<List<Spine>> {
        val spine = physicalService.getSpineByUserId(userId)
        return ResponseEntity.ok(spine)
    }

    @GetMapping("/eye/{userId}")
    fun getEyeByUserId(@PathVariable userId: Long): ResponseEntity<List<Eye>> {
        val eye = physicalService.getEyeByUserId(userId)
        return ResponseEntity.ok(eye)
    }

    @GetMapping("/lung/{userId}")
    fun getLungByUserId(@PathVariable userId: Long): ResponseEntity<List<Lung>> {
        val lung = physicalService.getLungByUserId(userId)
        return ResponseEntity.ok(lung)
    }

    @PostMapping("/heart")
    fun createHeart(@RequestBody heart: Heart): ResponseEntity<Heart> {
        val savedHeart = physicalService.saveHeart(heart)
        return ResponseEntity.ok(savedHeart)
    }

    @PostMapping("/bone")
    fun createBone(@RequestBody bone: Bone): ResponseEntity<Bone> {
        val savedBone = physicalService.saveBone(bone)
        return ResponseEntity.ok(savedBone)
    }

    @PostMapping("/spine")
    fun createSpine(@RequestBody spine: Spine): ResponseEntity<Spine> {
        val savedSpine = physicalService.saveSpine(spine)
        return ResponseEntity.ok(savedSpine)
    }

    @PostMapping("/eye")
    fun createEye(@RequestBody eye: Eye): ResponseEntity<Eye> {
        val savedEye = physicalService.saveEye(eye)
        return ResponseEntity.ok(savedEye)
    }

    @PostMapping("/lung")
    fun createLung(@RequestBody lung: Lung): ResponseEntity<Lung> {
        val savedLung = physicalService.saveLung(lung)
        return ResponseEntity.ok(savedLung)
    }
}