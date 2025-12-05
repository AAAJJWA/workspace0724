import styled from "styled-components";

/* ===== 카드 전체 컨테이너 ===== */
export const CardContainer = styled.div`
  width: 360px;           /* 원하는 크기 */
  aspect-ratio: 725 / 1040;
  position: relative;
  margin-top: 0;          /* 내려가는 문제 제거 */
  transform: none;        /* scale 제거 */
`;

/* ===== 중앙 artwork 이미지 ===== */
export const Artwork = styled.div`
  position: absolute;
  top: 125px;
  left: 85px;
  width: 290px;
  height: 285px;
  border-radius: 2px;
  background-size: cover;
  background-position: center;
`;

/* ===== 카드 템플릿 PNG ===== */
export const TemplateImage = styled.img`
  position: absolute;
  inset: 0;
  width: 100%;
  height: 100%;
`;

/* ===== 속성 아이콘 ===== */
export const AttributeIcon = styled.img`
  position: absolute; 
  top: 22px;
  right: 22px;
  width: 34px;
  height: 34px;
`;

/* ===== 카드 이름 ===== */
export const CardName = styled.div`
  position: absolute;
  top: 16px;
  left: 22px;
  font-size: 36px;
  line-height: 42px;
  font-family: "ygo-matrix-sc-2";
  user-select: none;
`;

/* ===== 레벨 컨테이너 ===== */
export const LevelContainer = styled.div`
  position: absolute;
  top: 59px;
  right: 34px;
  display: flex;
  gap: 4px;
`;

/* ===== 레벨 아이콘 ===== */
export const LevelStar = styled.div`
  width: 28px;
  height: 28px;
  background-size: cover;
  background-position: center;
`;

/* ===== Spell / Trap 타입 텍스트 ===== */
export const SpellTrapText = styled.div`
  position: absolute;
  top: 56.5px;
  right: 34px;
  font-size: 21px;
  font-family: "ygo-stone-serif-sc-bold", serif;
`;

/* ===== 카드 타입 (Monster/Effect 등) ===== */
export const CardTypeText = styled.div`
  position: absolute;
  top: 386px;
  left: 25px;
  font-size: 18px;
  font-family: "ygo-stone-serif-sc-bold", serif;
`;

/* ===== Edition 텍스트 ===== */
export const EditionText = styled.div`
  position: absolute;
  bottom: 132px;
  left: 41px;
  font-size: 12px;
  font-family: "ygo-matrix-sc-2", serif;
`;

/* ===== 카드 번호 텍스트 ===== */
export const CardNumberText = styled.div`
  position: absolute;
  bottom: 132px;
  right: 41px;
  font-size: 12px;
  font-family: "ygo-matrix-sc-2", serif;
`;

/* ===== 카드 효과 텍스트 ===== */
export const EffectText = styled.div`
  position: absolute;
  bottom: 88px;
  left: 26px;
  right: 28px;
  font-size: 12px;
  line-height: 18px;
  font-family: "ygo-matrix-book", serif;
`;

/* ===== ATK 텍스트 ===== */
export const AtkText = styled.div`
  position: absolute;
  bottom: 29px;
  right: 100px;
  font-size: 15px;
  font-family: "ygo-stone-serif-sc-bold", serif;
  text-align: right;
`;

/* ===== DEF 텍스트 ===== */
export const DefText = styled.div`
  position: absolute;
  bottom: 29px;
  right: 28px;
  font-size: 15px;
  font-family: "ygo-stone-serif-sc-bold", serif;
  text-align: right;
`;

/* ===== Identifier 번호 ===== */
export const IdentifierText = styled.div`
  position: absolute;
  bottom: 10px;
  left: 18px;
  right: 158px;
  font-size: 12px;
  font-family: "ygo-matrix-sc-2", serif;
  white-space: nowrap;
  overflow: hidden;
`;

/* ===== Copyright ===== */
export const CopyrightText = styled.div`
  position: absolute;
  bottom: 10px;
  right: 30px;
  left: 158px;
  text-align: right;
  font-size: 12px;
  font-family: "ygo-matrix-sc-2", serif;
  display: flex;
  justify-content: end;
  align-items: center;
  gap: 4px;
`;
