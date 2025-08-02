package com.example.afraid.physical.domain.type

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "건강 상태", example = "GOOD")
enum class Status {
    @Schema(description = "정상") GOOD,
    @Schema(description = "주의") NORMAL,
    @Schema(description = "위험") BAD
}