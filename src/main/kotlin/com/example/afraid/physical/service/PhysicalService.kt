package com.example.afraid.physical.service

import com.example.afraid.physical.domain.*
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
}