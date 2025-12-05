import styled from "styled-components";

/* 앨범 컬렉션 배경 */
export const PageWrapper = styled.div`
  width: 100%;
  min-height: 100vh;
  background: #e3e7ef;
  padding: 40px 0;
`;

/* 앨범 페이지 */
export const Container = styled.div`
  max-width: 1500px;
  margin: auto;
  background: #f4f5f7;
  padding: 40px;
  border-radius: 20px;
  border: 4px solid #c8ccd6;
  box-shadow: 0 0 20px rgba(0,0,0,0.15);
`;

/* 제목 | 토글 */
export const SectionTitleRow = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 25px;
`;

export const SectionTitle = styled.h2`
  font-size: 28px;
  font-weight: 900;
  color: #2f3542;
`;

/* 도감 스타일 버튼 */
export const ToggleButton = styled.button`
  padding: 8px 18px;
  border-radius: 8px;
  cursor: pointer;
  font-size: 14px;
  background: ${(p) => (p.active ? "#4b7fff" : "#fff")};
  color: ${(p) => (p.active ? "#fff" : "#333")};
  border: ${(p) => (p.active ? "none" : "2px solid #c8ccd6")};
  font-weight: 700;

  &:hover {
    background: ${(p) => (p.active ? "#3a6ee8" : "#eceef2")};
  }
`;

/* 슬롯형 카드 그리드 */
export const CardGrid = styled.div`
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(240px, 1fr));
  gap: 26px;
`;

export const CardItem = styled.div`
  background: #ffffff;
  border-radius: 12px;
  border: 2px solid #d1d5df;
  padding: 12px;
  cursor: pointer;
  transition: 0.25s;

  &:hover {
    transform: translateY(-6px);
    border-color: #4b7fff;
    box-shadow: 0 8px 14px rgba(0,0,0,0.12);
  }
`;

export const CardThumb = styled.img`
  width: 100%;
  border-radius: 6px;
  background: #f2f3f5;
  object-fit: contain;
`;

export const CardInfo = styled.div`
  text-align: center;
  margin-top: 10px;

  h3 {
    font-weight: 700;
    font-size: 16px;
    color: #2d3648;
  }

  p {
    margin-top: 4px;
    color: #6b7280;
  }
`;
