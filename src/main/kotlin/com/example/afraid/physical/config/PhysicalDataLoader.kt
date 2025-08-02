package com.example.afraid.physical.config

import com.example.afraid.physical.domain.*
import com.example.afraid.physical.domain.type.Status
import com.example.afraid.physical.repository.*
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.LocalDate

@Component
class PhysicalDataLoader(
    private val heartRepository: HeartRepository,
    private val boneRepository: BoneRepository,
    private val spineRepository: SpineRepository,
    private val eyeRepository: EyeRepository,
    private val lungRepository: LungRepository
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        if (heartRepository.count() == 0L) {
            loadDummyData()
        }
    }

    private fun loadDummyData() {

        // 심장 데이터
        val hearts = listOf(
            Heart(
                status = Status.GOOD,
                userId = 1001L,
                systolicBp = 120,
                diastolicBp = 80,
                heartRate = 72,
                totalCholesterol = 180,
                hdlCholesterol = 50,
                ldlCholesterol = 100,
                triglycerides = 120,
                ecgFindings = "정상동율동",
                echocardiogramEf = 60,
                lvWallThickness = BigDecimal("10.5"),
                examDate = LocalDate.now().minusDays(30)
            ),
            Heart(
                status = Status.WARNING,
                userId = 1002L,
                systolicBp = 140,
                diastolicBp = 90,
                heartRate = 85,
                totalCholesterol = 220,
                hdlCholesterol = 40,
                ldlCholesterol = 130,
                triglycerides = 180,
                ecgFindings = "경미한 부정맥",
                echocardiogramEf = 55,
                lvWallThickness = BigDecimal("11.2"),
                examDate = LocalDate.now().minusDays(15)
            ),
            Heart(
                status = Status.DANGER,
                userId = 1003L,
                systolicBp = 160,
                diastolicBp = 100,
                heartRate = 95,
                totalCholesterol = 250,
                hdlCholesterol = 35,
                ldlCholesterol = 160,
                triglycerides = 220,
                ecgFindings = "심방세동",
                echocardiogramEf = 45,
                lvWallThickness = BigDecimal("13.5"),
                examDate = LocalDate.now().minusDays(7)
            )
        )
        heartRepository.saveAll(hearts)

        // 뼈 데이터
        val bones = listOf(
            Bone(
                status = Status.GOOD,
                userId = 1001L,
                boneDensityTScore = BigDecimal("-0.5"),
                boneDensityZScore = BigDecimal("-0.3"),
                lumbarBoneDensity = BigDecimal("1.120"),
                femurBoneDensity = BigDecimal("1.080"),
                examDate = LocalDate.now().minusDays(60),
                osteoporosisDiagnosis = "정상"
            ),
            Bone(
                status = Status.WARNING,
                userId = 1002L,
                boneDensityTScore = BigDecimal("-1.5"),
                boneDensityZScore = BigDecimal("-1.2"),
                lumbarBoneDensity = BigDecimal("0.950"),
                femurBoneDensity = BigDecimal("0.920"),
                examDate = LocalDate.now().minusDays(45),
                osteoporosisDiagnosis = "골감소증"
            ),
            Bone(
                status = Status.DANGER,
                userId = 1003L,
                boneDensityTScore = BigDecimal("-2.8"),
                boneDensityZScore = BigDecimal("-2.5"),
                lumbarBoneDensity = BigDecimal("0.780"),
                femurBoneDensity = BigDecimal("0.750"),
                examDate = LocalDate.now().minusDays(30),
                osteoporosisDiagnosis = "골다공증"
            )
        )
        boneRepository.saveAll(bones)

        // 척추 데이터
        val spines = listOf(
            Spine(
                status = Status.GOOD,
                userId = 1001L,
                cervicalLordosis = BigDecimal("30.0"),
                thoracicKyphosis = BigDecimal("35.0"),
                lumbarLordosis = BigDecimal("50.0"),
                scoliosisAngle = BigDecimal("5.0"),
                discHeight = "정상",
                compressionFracture = "없음",
                examDate = LocalDate.now().minusDays(90)
            ),
            Spine(
                status = Status.WARNING,
                userId = 1002L,
                cervicalLordosis = BigDecimal("25.0"),
                thoracicKyphosis = BigDecimal("45.0"),
                lumbarLordosis = BigDecimal("45.0"),
                scoliosisAngle = BigDecimal("12.0"),
                discHeight = "경미한 감소",
                compressionFracture = "L1 경미한 압박",
                examDate = LocalDate.now().minusDays(60)
            ),
            Spine(
                status = Status.DANGER,
                userId = 1003L,
                cervicalLordosis = BigDecimal("20.0"),
                thoracicKyphosis = BigDecimal("55.0"),
                lumbarLordosis = BigDecimal("35.0"),
                scoliosisAngle = BigDecimal("25.0"),
                discHeight = "현저히 감소",
                compressionFracture = "L1, L2 압박골절",
                examDate = LocalDate.now().minusDays(30)
            )
        )
        spineRepository.saveAll(spines)

        // 눈 데이터
        val eyes = listOf(
            Eye(
                status = Status.GOOD,
                userId = 1001L,
                leftEyeUncorrected = "1.0",
                rightEyeUncorrected = "1.0",
                leftEyeCorrected = "1.0",
                rightEyeCorrected = "1.0",
                leftEyePressure = 15,
                rightEyePressure = 16,
                leftEyeSphere = BigDecimal("0.00"),
                rightEyeSphere = BigDecimal("0.00"),
                leftEyeCylinder = BigDecimal("0.00"),
                rightEyeCylinder = BigDecimal("0.00"),
                fundusFindings = "정상",
                colorVisionTest = "정상",
                examDate = LocalDate.now().minusDays(180)
            ),
            Eye(
                status = Status.WARNING,
                userId = 1002L,
                leftEyeUncorrected = "0.6",
                rightEyeUncorrected = "0.8",
                leftEyeCorrected = "1.0",
                rightEyeCorrected = "1.0",
                leftEyePressure = 18,
                rightEyePressure = 19,
                leftEyeSphere = BigDecimal("-2.50"),
                rightEyeSphere = BigDecimal("-1.75"),
                leftEyeCylinder = BigDecimal("-0.50"),
                rightEyeCylinder = BigDecimal("-0.25"),
                fundusFindings = "경미한 망막변화",
                colorVisionTest = "정상",
                examDate = LocalDate.now().minusDays(120)
            ),
            Eye(
                status = Status.DANGER,
                userId = 1003L,
                leftEyeUncorrected = "0.3",
                rightEyeUncorrected = "0.4",
                leftEyeCorrected = "0.8",
                rightEyeCorrected = "0.9",
                leftEyePressure = 24,
                rightEyePressure = 23,
                leftEyeSphere = BigDecimal("-5.00"),
                rightEyeSphere = BigDecimal("-4.75"),
                leftEyeCylinder = BigDecimal("-1.50"),
                rightEyeCylinder = BigDecimal("-1.25"),
                fundusFindings = "당뇨망막병증 의심",
                colorVisionTest = "이상",
                examDate = LocalDate.now().minusDays(60)
            )
        )
        eyeRepository.saveAll(eyes)

        // 폐 데이터
        val lungs = listOf(
            Lung(
                status = Status.GOOD,
                userId = 1001L,
                fvc = BigDecimal("4.20"),
                fev1 = BigDecimal("3.50"),
                fev1FvcRatio = BigDecimal("0.83"),
                pef = BigDecimal("520.0"),
                chestXrayFindings = "정상",
                sputumTest = "음성",
                oxygenSaturation = 98,
                examDate = LocalDate.now().minusDays(120)
            ),
            Lung(
                status = Status.WARNING,
                userId = 1002L,
                fvc = BigDecimal("3.80"),
                fev1 = BigDecimal("2.90"),
                fev1FvcRatio = BigDecimal("0.76"),
                pef = BigDecimal("420.0"),
                chestXrayFindings = "경미한 음영",
                sputumTest = "음성",
                oxygenSaturation = 96,
                examDate = LocalDate.now().minusDays(90)
            ),
            Lung(
                status = Status.DANGER,
                userId = 1003L,
                fvc = BigDecimal("3.20"),
                fev1 = BigDecimal("2.10"),
                fev1FvcRatio = BigDecimal("0.66"),
                pef = BigDecimal("320.0"),
                chestXrayFindings = "폐기종 소견",
                sputumTest = "양성",
                oxygenSaturation = 92,
                examDate = LocalDate.now().minusDays(30)
            )
        )
        lungRepository.saveAll(lungs)

        println("Physical dummy data loaded successfully!")
    }
}