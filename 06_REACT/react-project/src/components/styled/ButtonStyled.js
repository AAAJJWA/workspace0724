import styled from 'styled-components';

export const Button = styled.button`
  padding: 10px 18px;
  background: #4b7bec;
  border: none;
  border-radius: 8px;
  color: white;
  font-size: 15px;
  cursor: pointer;
  margin-right: 10px;
  transition: 0.2s;

  &:hover {
    background: #3867d6;
  }
`;

export const DangerButton = styled(Button)`
  background: #fc5c65;

  &:hover {
    background: #eb3b5a;
  }
`;
