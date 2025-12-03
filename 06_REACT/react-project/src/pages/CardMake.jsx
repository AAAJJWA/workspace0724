import React, { useState, useRef } from "react";
import {
  PageContainer,
  LeftPanel,
  RightPanel,
  PanelTitle,
  FormGroup,
  Label,
  Input,
  TextArea,
  CardWrapper,
} from "./CardMake.styled";
import YugiohCard from "../components/yugioh/YugiohCard";

const CardMake = () => {
  const cardRef = useRef(null);

  const [inputValues, setInputValues] = useState({
    yugiohTemplate: "normal",
    yugiohElement: "dark",
    name: "새 카드",
    artwork: "",
    yugiohLevel: 4,
    yugiohEffect: "효과를 입력하세요",
    yugiohEdition: "1st Edition",
    yugiohCardNumber: "JU25-EN004",
    yugiohCardType: "몬스터/효과",
    yugiohAttack: 2000,
    yugiohDefense: 1500,
    yugiohIdentifier: "1234567890",
    yugiohCopyright: "2025 KONAMI",
  });

  // 일반 입력 처리
  const handleChange = (e) => {
    const { name, value } = e.target;
    setInputValues((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  // 파일 업로드
  const handleFile = (e) => {
    const file = e.target.files[0];
    if (!file) return;

    const url = URL.createObjectURL(file);
    setInputValues((prev) => ({
      ...prev,
      artwork: url,
    }));
  };

  // 식별번호 랜덤 생성
  const setRandomIdentifier = () => {
    const rand = Math.floor(Math.random() * 9000000000) + 1000000000;
    setInputValues((prev) => ({
      ...prev,
      yugiohIdentifier: rand.toString(),
    }));
  };

  return (
    <PageContainer>
      <LeftPanel>
        <PanelTitle>카드 생성</PanelTitle>

        {/* 카드 템플릿 선택 */}
        <FormGroup>
          <Label>카드 템플릿:</Label>
          <select
            name="yugiohTemplate"
            value={inputValues.yugiohTemplate}
            onChange={handleChange}
            className="custom-select"
          >
            <option value="normal">일반</option>
            <option value="effect">효과</option>
            <option value="trap">함정</option>
            <option value="spell">마법</option>
            <option value="fusion">융합</option>
            <option value="ritual">의식</option>
            <option value="token">토큰</option>
            <option value="synchro">싱크로</option>
            <option value="dark-synchro">다크 싱크로</option>
          </select>
        </FormGroup>

        {/* 카드 이름 */}
        <FormGroup>
          <Label>카드 이름</Label>
          <Input name="name" value={inputValues.name} onChange={handleChange} />
        </FormGroup>

        {/* 속성 */}
        <FormGroup>
          <Label>속성:</Label>
          <select
            name="yugiohElement"
            value={inputValues.yugiohElement}
            onChange={handleChange}
            className="custom-select"
          >
            <option value="dark">어둠</option>
            <option value="light">빛</option>
            <option value="fire">화염</option>
            <option value="earth">땅</option>
            <option value="water">물</option>
            <option value="wind">바람</option>
            <option value="laugh">웃음</option>
            <option value="divine">신</option>
          </select>
        </FormGroup>

        {/* 레벨 */}
        <FormGroup>
          <Label>레벨:</Label>
          <Input
            type="range"
            min="0"
            max="12"
            name="yugiohLevel"
            value={inputValues.yugiohLevel}
            onChange={handleChange}
          />
          <div style={{ fontSize: "12px", marginTop: "4px" }}>
            {Array.from({ length: 13 }, (_, i) => (
              <span key={i} style={{ marginRight: "6px" }}>
                {i}
              </span>
            ))}
          </div>
        </FormGroup>

        {/* 이미지 업로드 */}
        <FormGroup>
          <Label>이미지 업로드</Label>
          <Input type="file" accept="image/*" onChange={handleFile} />
        </FormGroup>

        {/* 효과 */}
        <FormGroup>
          <Label>카드 효과</Label>
          <TextArea
            name="yugiohEffect"
            value={inputValues.yugiohEffect}
            onChange={handleChange}
          />
        </FormGroup>

        {/* 에디션 */}
        <FormGroup>
          <Label>에디션</Label>
          <Input
            name="yugiohEdition"
            value={inputValues.yugiohEdition}
            onChange={handleChange}
          />
        </FormGroup>

        {/* 카드 번호 */}
        <FormGroup>
          <Label>카드/세트 번호</Label>
          <Input
            name="yugiohCardNumber"
            value={inputValues.yugiohCardNumber}
            onChange={handleChange}
          />
        </FormGroup>

        {/* 카드 종류 */}
        <FormGroup>
          <Label>카드 종류</Label>
          <Input
            name="yugiohCardType"
            value={inputValues.yugiohCardType}
            onChange={handleChange}
          />
        </FormGroup>

        {/* 공격력 */}
        <FormGroup>
          <Label>공격력 (ATK)</Label>
          <Input
            type="number"
            name="yugiohAttack"
            value={inputValues.yugiohAttack}
            onChange={handleChange}
          />
        </FormGroup>

        {/* 수비력 */}
        <FormGroup>
          <Label>수비력 (DEF)</Label>
          <Input
            type="number"
            name="yugiohDefense"
            value={inputValues.yugiohDefense}
            onChange={handleChange}
          />
        </FormGroup>

        {/* 식별번호 */}
        <FormGroup>
          <Label>식별번호</Label>
          <div style={{ display: "flex", gap: "6px" }}>
            <Input
              name="yugiohIdentifier"
              value={inputValues.yugiohIdentifier}
              onChange={handleChange}
            />
            <button
              onClick={setRandomIdentifier}
              style={{
                width: "40px",
                background: "#eee",
                border: "1px solid #ccc",
                cursor: "pointer",
                borderRadius: "6px",
              }}
            >
              🎲
            </button>
          </div>
        </FormGroup>

        {/* 저작권 */}
        <FormGroup>
          <Label>저작권</Label>
          <Input
            name="yugiohCopyright"
            value={inputValues.yugiohCopyright}
            onChange={handleChange}
          />
        </FormGroup>
      </LeftPanel>

      {/* 미리보기 */}
      <RightPanel>
        <CardWrapper>
          <YugiohCard ref={cardRef} inputValues={inputValues} />
        </CardWrapper>
      </RightPanel>
    </PageContainer>
  );
};

export default CardMake;
