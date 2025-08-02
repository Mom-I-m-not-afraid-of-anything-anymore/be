# 건강 관리 시스템 API 명세서

## 기본 정보
- **Base URL**: `http://localhost:8080`
- **Content-Type**: `application/json`
- **API Version**: v1.0.0

## 공통 응답 형식

### 상태 코드
- `200 OK`: 성공
- `404 Not Found`: 리소스를 찾을 수 없음
- `500 Internal Server Error`: 서버 오류

### 건강 상태 값
```typescript
enum Status {
  GOOD = "GOOD",      // 정상
  NORMAL = "NORMAL",  // 주의 
  BAD = "BAD"         // 위험
}
```

---

## 📋 API 목록

### 1. 전체 기관 상태 조회 (추천)
모든 기관의 건강 상태를 한 번에 조회하는 메인 API

**URL**: `GET /api/physical/status/{userId}`

**매개변수**:
- `userId` (path): 사용자 ID (예: 1001)

**응답 예시**:
```json
{
  "userId": 1001,
  "overallStatus": "BAD",
  "organs": [
    {
      "organName": "심장",
      "organType": "HEART",
      "status": "GOOD",
      "lastExamDate": "2024-12-18"
    },
    {
      "organName": "뼈",
      "organType": "BONE", 
      "status": "NORMAL",
      "lastExamDate": "2024-10-13"
    },
    {
      "organName": "척추",
      "organType": "SPINE",
      "status": "BAD",
      "lastExamDate": "2025-01-13"
    },
    {
      "organName": "눈",
      "organType": "EYE",
      "status": "NORMAL", 
      "lastExamDate": "2024-11-03"
    },
    {
      "organName": "폐",
      "organType": "LUNG",
      "status": "GOOD",
      "lastExamDate": "2024-12-03"
    }
  ],
  "totalOrgans": 5,
  "healthyOrgans": 2,
  "warningOrgans": 2,
  "dangerOrgans": 1
}
```

**TypeScript 인터페이스**:
```typescript
interface AllOrganStatusResponse {
  userId: number;
  overallStatus: Status;
  organs: OrganStatus[];
  totalOrgans: number;
  healthyOrgans: number;
  warningOrgans: number;
  dangerOrgans: number;
}

interface OrganStatus {
  organName: string;
  organType: string;
  status: Status;
  lastExamDate: string | null;
}
```

---

### 2. 심장 정보 조회
**URL**: `GET /api/physical/heart/{userId}`

**응답 예시**:
```json
[
  {
    "id": "heart_673a1b2c3d4e5f",
    "status": "GOOD",
    "userId": 1001,
    "systolicBp": 118,
    "diastolicBp": 78,
    "heartRate": 68,
    "totalCholesterol": 175,
    "hdlCholesterol": 55,
    "ldlCholesterol": 95,
    "triglycerides": 110,
    "ecgFindings": "정상동율동",
    "echocardiogramEf": 62,
    "lvWallThickness": 9.8,
    "examDate": "2024-12-18"
  }
]
```

**TypeScript 인터페이스**:
```typescript
interface Heart {
  id: string;
  status: Status;
  userId: number;
  systolicBp?: number;        // 수축기 혈압 (mmHg)
  diastolicBp?: number;       // 이완기 혈압 (mmHg)
  heartRate?: number;         // 심박수 (bpm)
  totalCholesterol?: number;  // 총 콜레스테롤 (mg/dL)
  hdlCholesterol?: number;    // HDL 콜레스테롤 (mg/dL)
  ldlCholesterol?: number;    // LDL 콜레스테롤 (mg/dL)
  triglycerides?: number;     // 중성지방 (mg/dL)
  ecgFindings?: string;       // 심전도 소견
  echocardiogramEf?: number;  // 심초음파 EF (%)
  lvWallThickness?: number;   // 좌심실벽 두께 (mm)
  examDate?: string;          // 검사일 (YYYY-MM-DD)
}
```

---

### 3. 뼈 정보 조회
**URL**: `GET /api/physical/bone/{userId}`

**응답 예시**:
```json
[
  {
    "id": "bone_673a1b2c3d4e5f",
    "status": "NORMAL",
    "userId": 1001,
    "boneDensityTScore": -1.8,
    "boneDensityZScore": -1.3,
    "lumbarBoneDensity": 0.885,
    "femurBoneDensity": 0.912,
    "examDate": "2024-10-13",
    "osteoporosisDiagnosis": "골감소증"
  }
]
```

**TypeScript 인터페이스**:
```typescript
interface Bone {
  id: string;
  status: Status;
  userId: number;
  boneDensityTScore?: number;     // 골밀도 T-score
  boneDensityZScore?: number;     // 골밀도 Z-score
  lumbarBoneDensity?: number;     // 요추 골밀도 (g/cm²)
  femurBoneDensity?: number;      // 대퇴골 골밀도 (g/cm²)
  examDate?: string;              // 검사일
  osteoporosisDiagnosis?: string; // 골다공증 진단
}
```

---

### 4. 척추 정보 조회
**URL**: `GET /api/physical/spine/{userId}`

**응답 예시**:
```json
[
  {
    "id": "spine_673a1b2c3d4e5f",
    "status": "BAD",
    "userId": 1001,
    "cervicalLordosis": 18.5,
    "thoracicKyphosis": 58.0,
    "lumbarLordosis": 32.0,
    "scoliosisAngle": 8.5,
    "discHeight": "현저한 감소",
    "compressionFracture": "L4-L5 디스크 탈출증",
    "examDate": "2025-01-13"
  }
]
```

**TypeScript 인터페이스**:
```typescript
interface Spine {
  id: string;
  status: Status;
  userId: number;
  cervicalLordosis?: number;      // 경추 전만각 (도)
  thoracicKyphosis?: number;      // 흉추 후만각 (도)
  lumbarLordosis?: number;        // 요추 전만각 (도)
  scoliosisAngle?: number;        // 척추측만각 (도)
  discHeight?: string;            // 추간판 높이
  compressionFracture?: string;   // 척추압박골절
  examDate?: string;              // 검사일
}
```

---

### 5. 눈 정보 조회
**URL**: `GET /api/physical/eye/{userId}`

**응답 예시**:
```json
[
  {
    "id": "eye_673a1b2c3d4e5f",
    "status": "NORMAL",
    "userId": 1001,
    "leftEyeUncorrected": "0.4",
    "rightEyeUncorrected": "0.5",
    "leftEyeCorrected": "1.0",
    "rightEyeCorrected": "1.0",
    "leftEyePressure": 19,
    "rightEyePressure": 20,
    "leftEyeSphere": -3.25,
    "rightEyeSphere": -2.75,
    "leftEyeCylinder": -0.75,
    "rightEyeCylinder": -0.50,
    "fundusFindings": "경미한 망막 변화",
    "colorVisionTest": "정상",
    "examDate": "2024-11-03"
  }
]
```

**TypeScript 인터페이스**:
```typescript
interface Eye {
  id: string;
  status: Status;
  userId: number;
  leftEyeUncorrected?: string;    // 좌안 나안시력
  rightEyeUncorrected?: string;   // 우안 나안시력
  leftEyeCorrected?: string;      // 좌안 교정시력
  rightEyeCorrected?: string;     // 우안 교정시력
  leftEyePressure?: number;       // 좌안 안압 (mmHg)
  rightEyePressure?: number;      // 우안 안압 (mmHg)
  leftEyeSphere?: number;         // 좌안 구면도수 (디옵터)
  rightEyeSphere?: number;        // 우안 구면도수 (디옵터)
  leftEyeCylinder?: number;       // 좌안 난시도수 (디옵터)
  rightEyeCylinder?: number;      // 우안 난시도수 (디옵터)
  fundusFindings?: string;        // 안저검사 소견
  colorVisionTest?: string;       // 색각검사
  examDate?: string;              // 검사일
}
```

---

### 6. 폐 정보 조회
**URL**: `GET /api/physical/lung/{userId}`

**응답 예시**:
```json
[
  {
    "id": "lung_673a1b2c3d4e5f",
    "status": "GOOD",
    "userId": 1001,
    "fvc": 4.35,
    "fev1": 3.68,
    "fev1FvcRatio": 0.85,
    "pef": 545.0,
    "chestXrayFindings": "정상",
    "sputumTest": "음성",
    "oxygenSaturation": 99,
    "examDate": "2024-12-03"
  }
]
```

**TypeScript 인터페이스**:
```typescript
interface Lung {
  id: string;
  status: Status;
  userId: number;
  fvc?: number;                   // 폐활량 FVC
  fev1?: number;                  // 1초강제호기량 FEV1
  fev1FvcRatio?: number;          // FEV1/FVC 비율
  pef?: number;                   // 최대호기류속도 PEF (L/min)
  chestXrayFindings?: string;     // 흉부X선 소견
  sputumTest?: string;            // 객담검사 결과
  oxygenSaturation?: number;      // 산소포화도 (%)
  examDate?: string;              // 검사일
}
```

---

## 🚀 사용 예시

### JavaScript/TypeScript
```typescript
// 전체 기관 상태 조회 (추천)
const getAllOrganStatus = async (userId: number): Promise<AllOrganStatusResponse> => {
  const response = await fetch(`http://localhost:8080/api/physical/status/${userId}`);
  return response.json();
};

// 특정 기관 정보 조회
const getHeartInfo = async (userId: number): Promise<Heart[]> => {
  const response = await fetch(`http://localhost:8080/api/physical/heart/${userId}`);
  return response.json();
};

// 사용법
const userStatus = await getAllOrganStatus(1001);
console.log(`전체 상태: ${userStatus.overallStatus}`);
console.log(`위험 기관 수: ${userStatus.dangerOrgans}`);
```

### React Hook 예시
```typescript
import { useState, useEffect } from 'react';

const useHealthData = (userId: number) => {
  const [data, setData] = useState<AllOrganStatusResponse | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(`http://localhost:8080/api/physical/status/${userId}`);
        const result = await response.json();
        setData(result);
      } catch (err) {
        setError('데이터 로딩 실패');
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, [userId]);

  return { data, loading, error };
};
```

## 📝 참고사항

1. **테스트 사용자**: 현재 `userId: 1001`에만 데이터가 있습니다.
2. **CORS**: 모든 도메인에서 접근 가능하도록 설정되어 있습니다.
3. **Swagger UI**: `http://localhost:8080/swagger-ui.html`에서 API 테스트 가능합니다.
4. **날짜 형식**: 모든 날짜는 `YYYY-MM-DD` 형식입니다.
5. **배열 응답**: 개별 기관 API들은 배열로 응답하지만, 현재는 각각 1개의 데이터만 있습니다.

## 🎯 추천 사용법

**메인 대시보드**용으로는 `GET /api/physical/status/{userId}` API만 사용하시면 됩니다. 이 API 하나로 모든 기관의 상태와 통계를 한 번에 가져올 수 있습니다.

상세 정보가 필요한 경우에만 개별 기관 API를 사용하세요.