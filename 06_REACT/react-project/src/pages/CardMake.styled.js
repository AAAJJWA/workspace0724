import styled from "styled-components";

export const PageContainer = styled.div`
  display: flex;
  width: 100%;
  height: calc(100vh - 60px); /* 상단 바 있다고 가정 */
  background: #f5f5f5;
`;

export const LeftPanel = styled.div`
  width: 380px;
  min-width: 380px;
  background: #fff;
  border-right: 1px solid #ddd;
  padding: 24px;
  overflow-y: auto;
`;

export const PanelTitle = styled.h2`
  font-size: 22px;
  font-weight: 700;
  margin-bottom: 20px;
`;

export const FormGroup = styled.div`
  margin-bottom: 18px;
`;

export const Label = styled.label`
  font-size: 14px;
  font-weight: 600;
  margin-bottom: 6px;
  display: block;
`;

export const Input = styled.input`
  width: 100%;
  padding: 10px 12px;
  border: 1px solid #ccc;
  border-radius: 8px;
`;

export const TextArea = styled.textarea`
  width: 100%;
  height: 80px;
  padding: 10px 12px;
  border: 1px solid #ccc;
  border-radius: 8px;
`;

export const RightPanel = styled.div`
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 40px;
`;

export const CardWrapper = styled.div`
  transform: scale(0.88);
  transform-origin: top center;
`;
