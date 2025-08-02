package com.example.afraid.physical.domain

import com.example.afraid.generateDocumentId
import com.example.afraid.physical.domain.type.Status
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDate


// 심장
@Document
data class Heart(
    @Id val id: String = generateDocumentId(),
    val status: Status,
    val userId: Long,
    val systolicBp: Short? = null,
    val diastolicBp: Short? = null,
    val heartRate: Byte? = null,
    val totalCholesterol: Short? = null,
    val hdlCholesterol: Short? = null,
    val ldlCholesterol: Short? = null,
    val triglycerides: Short? = null,
    val ecgFindings: String? = null,
    val echocardiogramEf: Byte? = null,
    val lvWallThickness: BigDecimal? = null,
    val examDate: LocalDate? = null,
)

// 뼈
@Document
data class Bone(
    @Id val id: String = generateDocumentId(),
    val status: Status,
    val userId: Long,
    val boneDensityTScore: BigDecimal? = null,
    val boneDensityZScore: BigDecimal? = null,
    val lumbarBoneDensity: BigDecimal? = null,
    val femurBoneDensity: BigDecimal? = null,
    val examDate: LocalDate? = null,
    val osteoporosisDiagnosis: String? = null,
)

// 척추
@Document
data class Spine(
    @Id val id: String = generateDocumentId(),
    val status: Status,
    val userId: Long,
    val cervicalLordosis: BigDecimal? = null,
    val thoracicKyphosis: BigDecimal? = null,
    val lumbarLordosis: BigDecimal? = null,
    val scoliosisAngle: BigDecimal? = null,
    val discHeight: String? = null,
    val compressionFracture: String? = null,
    val examDate: LocalDate? = null,
)

// 눈
@Document
data class Eye(
    @Id val id: String = generateDocumentId(),
    val status: Status,
    val userId: Long,
    val leftEyeUncorrected: String? = null,
    val rightEyeUncorrected: String? = null,
    val leftEyeCorrected: String? = null,
    val rightEyeCorrected: String? = null,
    val leftEyePressure: Byte? = null,
    val rightEyePressure: Byte? = null,
    val leftEyeSphere: BigDecimal? = null,
    val rightEyeSphere: BigDecimal? = null,
    val leftEyeCylinder: BigDecimal? = null,
    val rightEyeCylinder: BigDecimal? = null,
    val fundusFindings: String? = null,
    val colorVisionTest: String? = null,
    val examDate: LocalDate? = null,
)

// 폐
@Document
data class Lung(
    @Id val id: String = generateDocumentId(),
    val status: Status,
    val userId: Long,
    val fvc: BigDecimal? = null,
    val fev1: BigDecimal? = null,
    val fev1FvcRatio: BigDecimal? = null,
    val pef: BigDecimal? = null,
    val chestXrayFindings: String? = null,
    val sputumTest: String? = null,
    val oxygenSaturation: Byte? = null,
    val examDate: LocalDate? = null,
)

/*
## 1. 뼈 (Bone) 테이블

|한글명|영문 컬럼명|데이터 타입|정상범위/단위|
|---|---|---|---|
|골밀도 T-score|bone_density_t_score|DECIMAL(4,2)|≥ -1.0|
|골밀도 Z-score|bone_density_z_score|DECIMAL(4,2)|≥ -2.0|
|요추 골밀도|lumbar_bone_density|DECIMAL(5,3)|g/cm²|
|대퇴골 골밀도|femur_bone_density|DECIMAL(5,3)|g/cm²|
|검사일|exam_date|DATE|검진 날짜|
|골다공증 진단|osteoporosis_diagnosis|VARCHAR(20)|정상/골감소증/골다공증|

## 2. 척추 (Spine) 테이블

|한글명|영문 컬럼명|데이터 타입|정상범위/단위|
|---|---|---|---|
|경추 전만각|cervical_lordosis|DECIMAL(4,1)|20-40°|
|흉추 후만각|thoracic_kyphosis|DECIMAL(4,1)|20-50°|
|요추 전만각|lumbar_lordosis|DECIMAL(4,1)|40-60°|
|척추측만각|scoliosis_angle|DECIMAL(4,1)|< 10°|
|추간판 높이|disc_height|VARCHAR(50)|정상/감소/현저히감소|
|척추압박골절|compression_fracture|VARCHAR(100)|골절 부위|
|검사일|exam_date|DATE|검진 날짜|

## 3. 심장 (Heart) 테이블

|한글명|영문 컬럼명|데이터 타입|정상범위/단위|
|---|---|---|---|
|수축기혈압|systolic_bp|SMALLINT|90-120 mmHg|
|이완기혈압|diastolic_bp|SMALLINT|60-80 mmHg|
|심박수|heart_rate|TINYINT|60-100 bpm|
|총콜레스테롤|total_cholesterol|SMALLINT|< 200 mg/dL|
|HDL콜레스테롤|hdl_cholesterol|SMALLINT|≥ 40(남)/50(여) mg/dL|
|LDL콜레스테롤|ldl_cholesterol|SMALLINT|< 100 mg/dL|
|중성지방|triglycerides|SMALLINT|< 150 mg/dL|
|심전도 소견|ecg_findings|VARCHAR(100)|정상동율동/부정맥 등|
|심초음파 EF|echocardiogram_ef|TINYINT|≥ 55%|
|좌심실벽두께|lv_wall_thickness|DECIMAL(3,1)|< 12 mm|
|검사일|exam_date|DATE|검진 날짜|

## 4. 폐 (Lung) 테이블

|한글명|영문 컬럼명|데이터 타입|정상범위/단위|
|---|---|---|---|
|폐활량 FVC|fvc|DECIMAL(4,2)|예측치의 80% 이상|
|1초강제호기량 FEV1|fev1|DECIMAL(4,2)|예측치의 80% 이상|
|FEV1/FVC 비율|fev1_fvc_ratio|DECIMAL(4,2)|≥ 0.70|
|최대호기류속도 PEF|pef|DECIMAL(5,1)|L/min|
|흉부X선 소견|chest_xray_findings|VARCHAR(200)|정상/이상음영 등|
|객담검사 결과|sputum_test|VARCHAR(100)|음성/양성|
|산소포화도|oxygen_saturation|TINYINT|≥ 95%|
|검사일|exam_date|DATE|검진 날짜|

## 5. 눈 (Eye) 테이블

|한글명|영문 컬럼명|데이터 타입|정상범위/단위|
|---|---|---|---|
|좌안 나안시력|left_eye_uncorrected|VARCHAR(10)|1.0 이상|
|우안 나안시력|right_eye_uncorrected|VARCHAR(10)|1.0 이상|
|좌안 교정시력|left_eye_corrected|VARCHAR(10)|1.0 이상|
|우안 교정시력|right_eye_corrected|VARCHAR(10)|1.0 이상|
|좌안 안압|left_eye_pressure|TINYINT|10-21 mmHg|
|우안 안압|right_eye_pressure|TINYINT|10-21 mmHg|
|좌안 구면도수|left_eye_sphere|DECIMAL(4,2)|디옵터|
|우안 구면도수|right_eye_sphere|DECIMAL(4,2)|디옵터|
|좌안 난시도수|left_eye_cylinder|DECIMAL(4,2)|디옵터|
|우안 난시도수|right_eye_cylinder|DECIMAL(4,2)|디옵터|
|안저검사 소견|fundus_findings|VARCHAR(200)|정상/당뇨망막병증 등|
|색각검사|color_vision_test|VARCHAR(20)|정상/이상|
|검사일|exam_date|DATE|검진 날짜|
*/
