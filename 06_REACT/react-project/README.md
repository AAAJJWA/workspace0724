![header](https://capsule-render.vercel.app/api?type=soft&color=0:7F7FD5,100:86A8E7&height=180&text=YuGiOh%20Card%20Maker&fontSize=45&fontColor=ffffff)

# 🚀 YuGiOh Card Maker
React 기반으로 구현된 **유희왕 스타일 TCG 카드 생성 웹 애플리케이션**입니다.  
사용자는 카드 정보를 입력하고, 실시간 미리보기를 통해 완성된 카드를 확인할 수 있으며  
카드를 이미지로 저장하거나 리스트에서 관리할 수 있습니다.

---

## 📘 개요 (Overview)
이 프로젝트는 **React + Styled-components** 기반으로 제작된 TCG 카드 생성기입니다.  

- 로그인 / 회원가입  
- 카드 생성(Canvas 렌더링)  
- 전체 카드 목록 / 내 카드 보기  
- 카드 상세 조회, 삭제  
- 로컬스토리지(LocalStorage) 기반 데이터 저장  

을 포함한 프론엔드 SPA 프로젝트입니다.

---

## 🧱 기술 스택 (Tech Stack)

| 구분 | 사용 기술 |
|------|-----------|
| Frontend | React, JavaScript, Styled-components |
| State & Storage | LocalStorage |
| Routing | React Router |
| Rendering | Canvas API |
| Tools | Vite, Git, GitHub |

---

## 🔖 대표 기술

![React](https://img.shields.io/badge/React-61DAFB?style=flat-square&logo=react&logoColor=black)
![Styled-components](https://img.shields.io/badge/Styled--components-DB7093?style=flat-square&logo=styled-components&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=javascript&logoColor=black)
![Vite](https://img.shields.io/badge/Vite-646CFF?style=flat-square&logo=vite&logoColor=white)

---
## 📂 프로젝트 구조 (Directory Structure)
```
react-project/
├── src/
│ ├── components/
│ │ ├── TopNav.jsx # 네비게이션 바
│ │ └── Layout.jsx # 전체 페이지 레이아웃
│ ├── pages/
│ │ ├── Register.jsx # 회원가입 페이지
│ │ ├── Login.jsx # 로그인 페이지
│ │ ├── BoardList.jsx # 카드 목록 페이지
│ │ ├── CardMake.jsx # 카드 생성 페이지
│ │ └── CardDetail.jsx # 카드 상세보기
│ ├── assets/ # 기본 리소스
│ ├── App.jsx
│ └── main.jsx
├── public/ # 정적 데이터
│ └── yugioh/ # 카드 이미지, 아이콘 이미지 
└── README.md
```

## 🌟 주요 기능 (Key Features)

### ✔ TopNav (전역 네비게이션)
- 로그인 여부에 따라 메뉴 변경  
- "카드 생성하기" 버튼 제공  
- localStorage.loggedInUser 기반 상태 유지  

### ✔ 회원가입 (Register)
- 아이디 / 닉네임 / 비밀번호 입력  
- 아이디 & 닉네임 중복 검사  
- 회원 정보 localStorage.userList에 저장  

### ✔ 로그인 (Login)
- 사용자 정보 검증  
- 로그인 성공 시 loggedInUser 저장  
- 모든 페이지 공통 로그인 상태 유지  

### ✔ BoardList (메인 카드 리스트)
- 전체 카드 & 내 카드만 보기 토글  
- 최신순 카드 나열  
- 카드 클릭 시 상세 페이지 이동  
- styled-components 기반 Grid UI  

### ✔ CardMake (카드 생성)
- Canvas 기반 유희왕 카드 실시간 렌더링  
- 텍스트/타입/레벨/이미지 업로드 등 다양한 입력값 지원  
- 카드 이미지 다운로드(PNG)  
- 카드 등록(localStorage 저장)  

### ✔ CardDetail (상세 페이지)
- 전체 카드 이미지 표시  
- 다운로드  
- 자신의 카드일 경우 삭제 가능  

---

## 💡 전체 구현 기술 정리
| 기능 | 기술 |
|------|------|
| 페이지 이동 | React Router |
| 입력값 관리 | useState |
| 카드 데이터 저장 | LocalStorage(JSON) |
| 로그인 유지 | LocalStorage |
| 카드 렌더링 | Canvas API |
| 카드 썸네일 생성 | canvas.toDataURL() |
| 스타일 | Styled-components |

---

## 🛠 설치 및 실행 (Installation & Run)

### 1. 프로젝트 클론
git clone https://github.com/AAAJJWA/workspace0724/tree/react-board-project01

### 2. 프로젝트 폴더 이동
cd react-project

### 3. 패키지 설치
npm install

### 4. 개발 서버 실행
npm run dev

---

## 📸 화면 미리보기 (Preview)
<img width="1802" height="856" alt="ex-page" src="https://github.com/user-attachments/assets/4cd2eaf9-af64-4d26-be5d-4bb9bcee5cf5" />

---

## 🎯 학습 포인트 (Learning Points)
- React로 SPA 구조 설계하기  
- Canvas로 실시간 카드 UI 렌더링 구현  
- LocalStorage 기반 CRUD 설계  
- Styled-components로 컴포넌트 스타일링  
- 사용자 인증 흐름(회원가입 → 로그인 → 권한 기능) 구현

## 📚 참고 자료
- https://github.com/johnuberbacher/react-card-builder
- https://tcgbuilder.netlify.app/
