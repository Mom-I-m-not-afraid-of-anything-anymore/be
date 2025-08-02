package com.example.afraid.physical.service

import com.example.afraid.physical.domain.*
import com.example.afraid.physical.domain.type.Status
import com.example.afraid.physical.dto.AllOrganStatusResponse
import com.example.afraid.physical.dto.OrganStatus
import com.example.afraid.physical.repository.*
import org.springframework.stereotype.Service

@Service
class PhysicalService(
    private val heartRepository: HeartRepository,
    private val boneRepository: BoneRepository,
    private val spineRepository: SpineRepository,
    private val eyeRepository: EyeRepository,
    private val lungRepository: LungRepository
) {

    fun getHeartByUserId(userId: Long): List<Heart> {
        return heartRepository.findByUserId(userId)
    }

    fun getBoneByUserId(userId: Long): List<Bone> {
        return boneRepository.findByUserId(userId)
    }

    fun getSpineByUserId(userId: Long): List<Spine> {
        return spineRepository.findByUserId(userId)
    }

    fun getEyeByUserId(userId: Long): List<Eye> {
        return eyeRepository.findByUserId(userId)
    }

    fun getLungByUserId(userId: Long): List<Lung> {
        return lungRepository.findByUserId(userId)
    }

    fun saveHeart(heart: Heart): Heart {
        return heartRepository.save(heart)
    }

    fun saveBone(bone: Bone): Bone {
        return boneRepository.save(bone)
    }

    fun saveSpine(spine: Spine): Spine {
        return spineRepository.save(spine)
    }

    fun saveEye(eye: Eye): Eye {
        return eyeRepository.save(eye)
    }

    fun saveLung(lung: Lung): Lung {
        return lungRepository.save(lung)
    }

    fun getAllOrganStatusByUserId(userId: Long): AllOrganStatusResponse {
        val hearts = heartRepository.findByUserId(userId)
        val bones = boneRepository.findByUserId(userId)
        val spines = spineRepository.findByUserId(userId)
        val eyes = eyeRepository.findByUserId(userId)
        val lungs = lungRepository.findByUserId(userId)

        val organStatuses = mutableListOf<OrganStatus>()

        // 심장 상태 추가
        hearts.forEach { heart ->
            organStatuses.add(
                OrganStatus(
                    organName = "심장",
                    organType = "HEART",
                    status = heart.status,
                    lastExamDate = heart.examDate
                )
            )
        }

        // 뼈 상태 추가
        bones.forEach { bone ->
            organStatuses.add(
                OrganStatus(
                    organName = "뼈",
                    organType = "BONE",
                    status = bone.status,
                    lastExamDate = bone.examDate
                )
            )
        }

        // 척추 상태 추가
        spines.forEach { spine ->
            organStatuses.add(
                OrganStatus(
                    organName = "척추",
                    organType = "SPINE",
                    status = spine.status,
                    lastExamDate = spine.examDate
                )
            )
        }

        // 눈 상태 추가
        eyes.forEach { eye ->
            organStatuses.add(
                OrganStatus(
                    organName = "눈",
                    organType = "EYE",
                    status = eye.status,
                    lastExamDate = eye.examDate
                )
            )
        }

        // 폐 상태 추가
        lungs.forEach { lung ->
            organStatuses.add(
                OrganStatus(
                    organName = "폐",
                    organType = "LUNG",
                    status = lung.status,
                    lastExamDate = lung.examDate
                )
            )
        }

        // 통계 계산
        val totalOrgans = organStatuses.size
        val healthyOrgans = organStatuses.count { it.status == Status.GOOD }
        val warningOrgans = organStatuses.count { it.status == Status.NORMAL }
        val dangerOrgans = organStatuses.count { it.status == Status.BAD }

        // 전체 상태 결정 (가장 심각한 상태를 기준으로)
        val overallStatus = when {
            dangerOrgans > 0 -> Status.BAD
            warningOrgans > 0 -> Status.NORMAL
            else -> Status.GOOD
        }

        return AllOrganStatusResponse(
            userId = userId,
            overallStatus = overallStatus,
            organs = organStatuses,
            totalOrgans = totalOrgans,
            healthyOrgans = healthyOrgans,
            warningOrgans = warningOrgans,
            dangerOrgans = dangerOrgans
        )
    }
}