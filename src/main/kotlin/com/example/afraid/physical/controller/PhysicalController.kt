package com.example.afraid.physical.controller

import com.example.afraid.physical.domain.*
import com.example.afraid.physical.dto.AllOrganStatusResponse
import com.example.afraid.physical.service.PhysicalService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Physical Health", description = "장기별 건강 정보 관리 API")
@CrossOrigin(originPatterns = ["*"], maxAge = 3600, allowCredentials = "false")
@RestController
@RequestMapping("/api/physical")
class PhysicalController(
    private val physicalService: PhysicalService
) {

    @Operation(
        summary = "모든 기관 상태 조회", 
        description = "사용자 ID로 모든 기관의 건강 상태를 한 번에 조회합니다. 전체 건강 상태와 각 기관별 상태 통계를 제공합니다."
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "조회 성공", 
            content = [Content(mediaType = "application/json", schema = Schema(implementation = AllOrganStatusResponse::class))]),
        ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음", content = [Content()])
    ])
    @GetMapping("/status/{userId}")
    fun getAllOrganStatusByUserId(
        @Parameter(description = "사용자 ID", example = "1001") @PathVariable userId: Long
    ): ResponseEntity<AllOrganStatusResponse> {
        val response = physicalService.getAllOrganStatusByUserId(userId)
        return ResponseEntity.ok(response)
    }

    @Operation(summary = "심장 건강 정보 조회", description = "사용자 ID로 심장 건강 정보를 조회합니다.")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "조회 성공", 
            content = [Content(mediaType = "application/json", schema = Schema(implementation = Heart::class))]),
        ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음", content = [Content()])
    ])
    @GetMapping("/heart/{userId}")
    fun getHeartByUserId(
        @Parameter(description = "사용자 ID", example = "1001") @PathVariable userId: Long
    ): ResponseEntity<List<Heart>> {
        val heart = physicalService.getHeartByUserId(userId)
        return ResponseEntity.ok(heart)
    }

    @Operation(summary = "뼈 건강 정보 조회", description = "사용자 ID로 뼈 건강 정보를 조회합니다.")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "조회 성공", 
            content = [Content(mediaType = "application/json", schema = Schema(implementation = Bone::class))]),
        ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음", content = [Content()])
    ])
    @GetMapping("/bone/{userId}")
    fun getBoneByUserId(
        @Parameter(description = "사용자 ID", example = "1001") @PathVariable userId: Long
    ): ResponseEntity<List<Bone>> {
        val bone = physicalService.getBoneByUserId(userId)
        return ResponseEntity.ok(bone)
    }

    @Operation(summary = "척추 건강 정보 조회", description = "사용자 ID로 척추 건강 정보를 조회합니다.")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "조회 성공", 
            content = [Content(mediaType = "application/json", schema = Schema(implementation = Spine::class))]),
        ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음", content = [Content()])
    ])
    @GetMapping("/spine/{userId}")
    fun getSpineByUserId(
        @Parameter(description = "사용자 ID", example = "1001") @PathVariable userId: Long
    ): ResponseEntity<List<Spine>> {
        val spine = physicalService.getSpineByUserId(userId)
        return ResponseEntity.ok(spine)
    }

    @Operation(summary = "눈 건강 정보 조회", description = "사용자 ID로 눈 건강 정보를 조회합니다.")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "조회 성공", 
            content = [Content(mediaType = "application/json", schema = Schema(implementation = Eye::class))]),
        ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음", content = [Content()])
    ])
    @GetMapping("/eye/{userId}")
    fun getEyeByUserId(
        @Parameter(description = "사용자 ID", example = "1001") @PathVariable userId: Long
    ): ResponseEntity<List<Eye>> {
        val eye = physicalService.getEyeByUserId(userId)
        return ResponseEntity.ok(eye)
    }

    @Operation(summary = "폐 건강 정보 조회", description = "사용자 ID로 폐 건강 정보를 조회합니다.")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "조회 성공", 
            content = [Content(mediaType = "application/json", schema = Schema(implementation = Lung::class))]),
        ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음", content = [Content()])
    ])
    @GetMapping("/lung/{userId}")
    fun getLungByUserId(
        @Parameter(description = "사용자 ID", example = "1001") @PathVariable userId: Long
    ): ResponseEntity<List<Lung>> {
        val lung = physicalService.getLungByUserId(userId)
        return ResponseEntity.ok(lung)
    }

    @Operation(summary = "심장 건강 정보 등록", description = "새로운 심장 건강 정보를 등록합니다.")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "등록 성공",
            content = [Content(mediaType = "application/json", schema = Schema(implementation = Heart::class))]),
        ApiResponse(responseCode = "400", description = "잘못된 요청 데이터", content = [Content()])
    ])
    @PostMapping("/heart")
    fun createHeart(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "심장 건강 정보", required = true
        ) @RequestBody heart: Heart
    ): ResponseEntity<Heart> {
        val savedHeart = physicalService.saveHeart(heart)
        return ResponseEntity.ok(savedHeart)
    }

    @Operation(summary = "뼈 건강 정보 등록", description = "새로운 뼈 건강 정보를 등록합니다.")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "등록 성공",
            content = [Content(mediaType = "application/json", schema = Schema(implementation = Bone::class))]),
        ApiResponse(responseCode = "400", description = "잘못된 요청 데이터", content = [Content()])
    ])
    @PostMapping("/bone")
    fun createBone(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "뼈 건강 정보", required = true
        ) @RequestBody bone: Bone
    ): ResponseEntity<Bone> {
        val savedBone = physicalService.saveBone(bone)
        return ResponseEntity.ok(savedBone)
    }

    @Operation(summary = "척추 건강 정보 등록", description = "새로운 척추 건강 정보를 등록합니다.")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "등록 성공",
            content = [Content(mediaType = "application/json", schema = Schema(implementation = Spine::class))]),
        ApiResponse(responseCode = "400", description = "잘못된 요청 데이터", content = [Content()])
    ])
    @PostMapping("/spine")
    fun createSpine(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "척추 건강 정보", required = true
        ) @RequestBody spine: Spine
    ): ResponseEntity<Spine> {
        val savedSpine = physicalService.saveSpine(spine)
        return ResponseEntity.ok(savedSpine)
    }

    @Operation(summary = "눈 건강 정보 등록", description = "새로운 눈 건강 정보를 등록합니다.")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "등록 성공",
            content = [Content(mediaType = "application/json", schema = Schema(implementation = Eye::class))]),
        ApiResponse(responseCode = "400", description = "잘못된 요청 데이터", content = [Content()])
    ])
    @PostMapping("/eye")
    fun createEye(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "눈 건강 정보", required = true
        ) @RequestBody eye: Eye
    ): ResponseEntity<Eye> {
        val savedEye = physicalService.saveEye(eye)
        return ResponseEntity.ok(savedEye)
    }

    @Operation(summary = "폐 건강 정보 등록", description = "새로운 폐 건강 정보를 등록합니다.")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "등록 성공",
            content = [Content(mediaType = "application/json", schema = Schema(implementation = Lung::class))]),
        ApiResponse(responseCode = "400", description = "잘못된 요청 데이터", content = [Content()])
    ])
    @PostMapping("/lung")
    fun createLung(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "폐 건강 정보", required = true
        ) @RequestBody lung: Lung
    ): ResponseEntity<Lung> {
        val savedLung = physicalService.saveLung(lung)
        return ResponseEntity.ok(savedLung)
    }
}