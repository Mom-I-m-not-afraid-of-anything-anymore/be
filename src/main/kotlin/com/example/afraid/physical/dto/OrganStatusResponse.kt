package com.example.afraid.physical.dto

import com.example.afraid.physical.domain.type.Status
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

@Schema(description = "특정 기관의 상태 정보")
data class OrganStatus(
    @Schema(description = "기관명", example = "심장")
    val organName: String,
    
    @Schema(description = "기관 타입", example = "HEART")
    val organType: String,
    
    @Schema(description = "건강 상태")
    val status: Status,
    
    @Schema(description = "마지막 검사일", example = "2024-01-15")
    val lastExamDate: LocalDate?
)

@Schema(description = "사용자의 모든 기관 상태 정보")
data class AllOrganStatusResponse(
    @Schema(description = "사용자 ID", example = "1001")
    val userId: Long,
    
    @Schema(description = "전체 건강 상태", example = "GOOD")
    val overallStatus: Status,
    
    @Schema(description = "각 기관별 상태 정보")
    val organs: List<OrganStatus>,
    
    @Schema(description = "총 기관 수", example = "5")
    val totalOrgans: Int,
    
    @Schema(description = "정상 기관 수", example = "3")
    val healthyOrgans: Int,
    
    @Schema(description = "주의 기관 수", example = "1")
    val warningOrgans: Int,
    
    @Schema(description = "위험 기관 수", example = "1")
    val dangerOrgans: Int
)