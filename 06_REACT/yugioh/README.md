🃏 Yugioh Card Maker – Backend (Spring Boot + JPA)

React 기반 카드 생성 UI와 연동되는 Yu-Gi-Oh 카드 생성 서비스 백엔드입니다.
기존 방식에서 Spring Data JPA 기반 구조로 전환하며,
Controller → Service → Repository → Entity 계층을 명확히 분리하여 설계했습니다.


🛠 Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- H2 Database
- Gradle
- REST API


📁 Package Structure
```
src/main/java/com/kh/yugioh
 ├── controller
 │   ├── CardController           # 카드 관련 REST API
 │   ├── MemberController         # 회원 관련 REST AP
 │   └── dto
 │       ├── request              # 클라이언트 요청 DTO
 │       │   ├── CardRequest
 │       │   ├── LoginRequest
 │       │   └── MemberRequest
 │       └── response             # 응답 전용 DTO
 │           ├── CardResponse
 │           ├── LoginResponse
 │           └── MemberResponse
 │
 ├── entity
 │   ├── Card                     # Card 엔티티
 │   └── Member                   # Member 엔티티
 │
 ├── repository
 │   ├── CardRepository
 │   ├── MemberRepository
 │   ├── CardRepositoryImpl
 │   └── MemberRepositoryImpl
 │
 ├── service
 │   ├── CardService
 │   ├── CardServiceImpl
 │   ├── MemberService
 │   └── MemberServiceImpl
 │
 └── YugiohApplication
```


🧩 Architecture Overview
Controller
- REST API 엔드포인트 제공
- Request DTO → Service 호출 → Response DTO 반환
- 비즈니스 로직 없음


Service
- 핵심 비즈니스 로직 담당
- 트랜잭션 처리 (@Transactional)
- Entity 생성 및 검증 로직 수행


Repository
- Spring Data JPA 기반 데이터 접근
- DB 의존 로직 분리
- Entity 중심 CRUD 처리


Entity
- JPA 매핑 객체
- 실제 DB 테이블 구조를 표현
- 연관관계(@ManyToOne) 설정



🧾 주요 도메인 설명
🃏 Card Entity
- 유희왕 카드 정보 저장
- Member와 N:1 관계
- Base64 이미지 문자열 저장 (@Lob)
```
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "member_id", nullable = false)
private Member member;
```


👤 Member Entity
- 로그인 및 카드 소유자 정보
- 하나의 Member는 여러 Card를 가질 수 있음



📦 DTO 설계 이유
Request DTO
- 클라이언트 요청 데이터만 포함
- Entity 직접 노출 방지


Response DTO
- 필요한 데이터만 선택적으로 반환
- Lazy Loading / 무한 참조 방지


Client → Request DTO → Service → Entity
Entity → Response DTO → Client



🔄 JPA 전환 포인트
- SQL 직접 작성 방식 제거
- Entity 중심 설계로 전환
- Repository 인터페이스 기반 데이터 접근
- 연관관계 매핑을 통한 객체 그래프 관리
- 트랜잭션 단위 명확화



💾 Database
- H2 (File Mode)
- Base64 이미지 포함 카드 데이터 저장
- 개발 및 테스트 용도로 사용
```
spring:
  datasource:
    url: jdbc:h2:tcp://localhost/~/db/ydb
```


## 🔗 API 명세 (API Specification)

본 프로젝트의 백엔드는 React 프론트엔드와 REST API 방식으로 통신하며,
회원(Member)과 카드(Card)를 중심으로 한 API를 제공합니다.

모든 요청/응답은 JSON 형식을 사용합니다.


### 👤 Member API

#### 1️⃣ 회원 가입

Method: POST  
URL: /api/members/register  
설명: 신규 회원 가입

Request Body  
```
memberId: 없음  
loginId: String (중복 불가)  
password: String  
nickname: String (중복 불가)
```

Response  
```
id: Long  
loginId: String  
nickname: String
```


#### 2️⃣ 로그인

Method: POST  
URL: /api/members/login  
설명: 로그인 및 회원 정보 조회

Request Body  
[묶음]
loginId: String  
password: String

Response  
[묶음]
id: Long  
loginId: String  
nickname: String


---

### 🃏 Card API

#### 3️⃣ 카드 등록

Method: POST  
URL: /api/cards  
설명: 카드 생성 및 저장

Request Body  
```
memberId: Long  
yugiohTemplate: String  
yugiohElement: String  
name: String  
artwork: String (Base64 이미지 문자열)  
yugiohLevel: int  
yugiohEffect: String  
yugiohEdition: String  
yugiohCardNumber: String  
yugiohCardType: String  
yugiohAttack: int  
yugiohDefense: int  
yugiohIdentifier: String  
yugiohCopyright: String
```

Response  
```
id: Long  
memberId: Long  
memberNickname: String  
name: String  
artwork: String  
cardType: String  
attack: int  
defense: int
```


#### 4️⃣ 전체 카드 조회

Method: GET  
URL: /api/cards  
설명: 전체 카드 목록 조회

Response  
```
CardResponse 리스트 형태  
각 요소는 다음 정보를 포함  
- id  
- memberId  
- memberNickname  
- name  
- artwork  
- cardType  
- attack  
- defense
```


#### 5️⃣ 내 카드 조회 (회원 기준)

Method: GET  
URL: /api/cards/my?loginId={loginId}  
설명: 로그인한 회원의 카드만 조회

Query Parameter  
- loginId : 회원 로그인 ID

Response  
```
해당 회원이 생성한 CardResponse 리스트
```


#### 6️⃣ 카드 상세 조회

Method: GET  
URL: /api/cards/{id}  
설명: 카드 단건 조회

Response  
```
id: Long  
memberId: Long  
memberNickname: String  
name: String  
artwork: String  
cardType: String  
attack: int  
defense: int
```


#### 7️⃣ 카드 삭제

Method: DELETE  
URL: /api/cards/{id}  
설명: 카드 삭제

Response  
- 성공 시 응답 없음


---

## 📌 API 설계 특징 요약

- RESTful URL 구조 사용
- HTTP Method 의미에 맞게 API 설계
- Entity 직접 노출 ❌ → DTO 기반 응답
- Member–Card 연관관계 기반 API 제공
- React 프론트엔드에서 바로 사용 가능한 응답 구조
- Base64 이미지 문자열을 포함한 카드 데이터 처리



✨ 특징 요약
- JPA 기반 계층 분리 설계
- DTO를 통한 Entity 보호
- Member–Card 연관관계 모델링
- React 프론트엔드와 REST 연동

추후 Like / Comment / Image Entity 확장 가능 구조



🚀 향후 확장 예정
- CardLike (좋아요 기능)
- 이미지 파일 저장 방식 분리
- 카드 검색 / 필터 기능
