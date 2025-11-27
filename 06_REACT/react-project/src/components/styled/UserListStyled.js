import styled from 'styled-components';

export const UserListWrapper = styled.ul`
  list-style: none;
  padding: 0;
  margin-top: 20px;
`;

export const UserItem = styled.li`
  padding: 14px 18px;
  border: 1px solid #e6e6e6;
  border-radius: 10px;
  margin-bottom: 12px;
  transition: 0.2s;
  cursor: pointer;
  background: #fafafa;

  &:hover {
    background: #f0f4ff;
    border-color: #4b7bec;
  }

  a {
    text-decoration: none;
    color: #2d3436;
    font-weight: 500;
  }
`;
