import styled from "styled-components";

export const NotFoundWrapper = styled.div`
  width: 100%;
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background: #fff;
  padding: 20px;
  box-sizing: border-box;
  overflow: hidden;
`;

export const NotFoundImage = styled.img`
  max-width: 90vw;
  max-height: 70vh;
  height: auto;
  width: auto;
  object-fit: contain;
  border-radius: 8px;
`;

export const BackButton = styled.button`
  margin-top: 20px;
  padding: 12px 20px;
  font-size: 16px;
  border: none;
  background: #4b7fff;
  color: white;
  border-radius: 6px;
  cursor: pointer;
  transition: 0.2s;

  &:hover {
    background: #3a68db;
  }
`;
