import styled from "styled-components";

/* 전체 화면 최대 폭 */
export const HomeContainer = styled.div`
  max-width: 1200px;
  margin: 0 auto;
  padding: 40px 20px;
`;

/* 내부 콘텐츠 공통 폭 */
export const ContentBox = styled.div`
  max-width: 760px;
  margin: 0 auto;
`;

export const Title = styled.h1`
  font-size: 46px;
  font-weight: 700;
  text-align: center;
  margin-bottom: 48px;
  color: #333;
`;

/* ===== 통계 카드 ===== */
export const StatsWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  gap: 24px;
  margin-bottom: 40px;
`;

export const StatCard = styled.div`
  background: #fff;
  flex: 1;                     /* <-- 중요: 3개 카드 균등 폭 */
  padding: 28px 20px;
  border-radius: 14px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.06);
  text-align: center;
  border: 1px solid #e5e5e5;
`;

export const StatNumber = styled.div`
  font-size: 40px;
  font-weight: 700;
  color: #4b6cff;
`;

export const StatLabel = styled.div`
  margin-top: 8px;
  font-size: 14px;
  color: #555;
`;

/* ===== 카테고리 박스 ===== */
export const CategoryWrapper = styled.div`
  background: #fff;
  padding: 26px 28px;
  border-radius: 14px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.06);
  border: 1px solid #e5e5e5;
`;

export const CategoryTitle = styled.div`
  text-align: center;
  font-size: 18px;
  font-weight: 600;
  margin-bottom: 24px;
  color: #444;
`;

export const CategoryList = styled.div`
  display: flex;
  flex-direction: column;
  gap: 14px;
`;

export const CategoryItem = styled.div`
  background: #f5f8ff;
  padding: 14px 18px;
  border-radius: 10px;
  display: flex;
  justify-content: space-between;
  border: 1px solid #dce4ff;
`;

export const CategoryName = styled.span`
  font-size: 16px;
  color: #333;
  font-weight: 500;
`;

export const CategoryCount = styled.span`
  background: #4b6cff;
  color: #fff;
  width: 28px;
  height: 28px;
  border-radius: 50%;
  font-size: 14px;
  font-weight: bold;
  display: flex;
  align-items: center;
  justify-content: center;
`;
