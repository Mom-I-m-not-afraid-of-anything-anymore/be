package com.example.afraid.physical.repository

import com.example.afraid.physical.domain.*
import org.springframework.data.mongodb.repository.MongoRepository

interface HeartRepository : MongoRepository<Heart, String> {
    fun findByUserId(userId: Long): List<Heart>
}

interface BoneRepository : MongoRepository<Bone, String> {
    fun findByUserId(userId: Long): List<Bone>
}

interface SpineRepository : MongoRepository<Spine, String> {
    fun findByUserId(userId: Long): List<Spine>
}

interface EyeRepository : MongoRepository<Eye, String> {
    fun findByUserId(userId: Long): List<Eye>
}

interface LungRepository : MongoRepository<Lung, String> {
    fun findByUserId(userId: Long): List<Lung>
}