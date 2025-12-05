import styled from "styled-components";

export const PageContainer = styled.div`
  display: flex;
  width: 100%;
  min-height: 100vh;
  padding: 40px;
  gap: 40px;
  background: #f5f6fa;
  box-sizing: border-box;
`;

export const LeftPanel = styled.div`
  width: 420px;
  padding: 24px 28px;
  background: #ffffff;
  border-radius: 16px;
  box-shadow: 0 4px 18px rgba(0, 0, 0, 0.08);
  display: flex;
  flex-direction: column;
  gap: 20px;

  overflow-y: auto;
  max-height: calc(100vh - 80px);

  /* 스크롤바 스타일 */
  &::-webkit-scrollbar {
    width: 8px;
  }
  &::-webkit-scrollbar-thumb {
    background: #cfcfcf;
    border-radius: 6px;
  }
  &::-webkit-scrollbar-track {
    background: transparent;
  }

  /* CardMake.jsx 내 모든 select */
  select {
    width: 330px;
    padding: 10px 14px;
    border-radius: 10px;
    border: 1px solid #cccccc;
    background: white;
    font-size: 14px;
    outline: none;
    transition: all 0.15s;

    &:focus {
      border-color: #5c7cfa;
      box-shadow: 0 0 0 2px rgba(92, 124, 250, 0.25);
    }
  }

  /* number, text, file input */
  input {
    width: 300px;
    padding: 10px 14px;
    border-radius: 10px;
    border: 1px solid #cccccc;
    font-size: 14px;
    outline: none;
    transition: all 0.15s;

    &:focus {
      border-color: #5c7cfa;
      box-shadow: 0 0 0 2px rgba(92, 124, 250, 0.25);
    }
  }

  /* file input */
  input[type="file"] {
    padding: 6px;
    background: #fafafa;
  }

  /* range 슬라이더 */
  input[type="range"] {
    height: 6px;
    padding: 0;
    cursor: pointer;
    background: transparent;

    &::-webkit-slider-thumb {
      appearance: none;
      width: 18px;
      height: 18px;
      background: #5c7cfa;
      border-radius: 50%;
      border: none;
      margin-top: -6px;
    }

    &::-webkit-slider-runnable-track {
      height: 6px;
      background: #dedede;
      border-radius: 4px;
    }
  }

  /* textarea */
  textarea {
    width: 300px;
    padding: 12px 14px;
    border-radius: 10px;
    border: 1px solid #cccccc;
    font-size: 14px;
    resize: vertical;

    &:focus {
      border-color: #5c7cfa;
      box-shadow: 0 0 0 2px rgba(92, 124, 250, 0.25);
    }
  }

  /* dice 버튼 */
  button {
    background: #ececec;
    border: 1px solid #bbbbbb;
    border-radius: 8px;
    font-size: 16px;
    cursor: pointer;
    padding: 6px 8px;
    transition: 0.15s;

    &:hover {
      background: #dcdcdc;
    }
  }
`;

/* 제목 */
export const PanelTitle = styled.h2`
  font-size: 22px;
  font-weight: 700;
  color: #222;
  margin-bottom: 6px;
`;

export const FormGroup = styled.div`
  display: flex;
  flex-direction: column;
  gap: 6px;
`;

export const Label = styled.label`
  font-size: 14px;
  font-weight: 600;
  color: #444;
`;

export const Input = styled.input``;
export const TextArea = styled.textarea``;

export const LevelGroup = styled.div`
  display: flex;
  flex-direction: column;
  width: 310px;       /* 슬라이더 + 숫자 width 통일 */
  gap: 6px;
`;

export const LevelLabels = styled.div`
  display: grid;
  grid-template-columns: repeat(13, 1fr);
  font-size: 12px;
  color: #444;
  user-select: none;
  margin-top: -2px;
  padding-left: 6px;
`;

export const LevelRange = styled.input`
  width: 100%;
  height: 6px;
  background: transparent;
  cursor: pointer;

  &::-webkit-slider-runnable-track {
    height: 6px;
    background: #dedede;
    border-radius: 4px;
  }  
`;

export const Dice = styled.button`
  width: "40px",
  background: "#eee",
  border: "1px solid #ccc",
  cursor: "pointer",
  borderRadius: "6px",
`

export const Button = styled.button`
  width: 100%;
  padding: 12px;
  margin-top: 20px;
  
  background: #4dabf7;
  border: 1px solid #4dabf7;
  border-radius: 6px;
  cursor: pointer;

  color: #000000ff;
  font-size: 15px;
  font-weight: bold;

  transition: 0.15s ease;

  &:hover {
    background: #339af0;
  }

  &:active {
    background: #1c7ed6;
  }
`;

export const RightPanel = styled.div`
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: start;
  padding-top: 20px;
`;

export const CardWrapper = styled.div`
  background: #ffffff;
  padding: 20px;
  border-radius: 20px;
  box-shadow: 0 4px 18px rgba(0, 0, 0, 0.08);
`;
