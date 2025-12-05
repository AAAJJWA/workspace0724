import styled from "styled-components";

export const PageWrapper = styled.div`
  width: 100%;
  min-height: 100vh;
  background: #f5f6fa;

  display: flex;
  justify-content: center;
  align-items: center;
`;

export const AuthBox = styled.div`
  width: 420px;
  background: #fff;
  padding: 40px;
  border-radius: 12px;
  box-shadow: 0 4px 20px rgba(0,0,0,0.1);
`;

export const Title = styled.h2`
  text-align: center;
  margin-bottom: 30px;
  font-size: 26px;
`;

export const FormGroup = styled.div`
  margin-bottom: 18px;
`;

export const Label = styled.div`
  font-size: 14px;
  margin-bottom: 6px;
`;

export const Input = styled.input`
  width: 100%;
  padding: 10px 12px;
  border: 1px solid #ccc;
  border-radius: 6px;
  font-size: 15px;
`;

export const Button = styled.button`
  width: 100%;
  padding: 12px;
  margin-top: 6px;
  background: #4b7fff;
  color: #fff;
  border: none;
  border-radius: 6px;
  font-size: 15px;
  cursor: pointer;

  &:hover {
    background: #3c6ae8;
  }
`;

export const BottomText = styled.div`
  margin-top: 18px;
  text-align: center;
  font-size: 14px;
  color: #555;

  span {
    color: #4b7fff;
    cursor: pointer;
    margin-left: 6px;

    &:hover {
      text-decoration: underline;
    }
  }
`;
