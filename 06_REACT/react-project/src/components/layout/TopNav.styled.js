import styled from "styled-components";

export const TopNavBox = styled.div`
  width: 100%;
  height: 70px;
  background: #ffffff;
  border-bottom: 1px solid #ddd;

  display: flex;
  justify-content: space-between;
  align-items: center;

  position: sticky;
  top: 0;
  z-index: 10;

  padding: 0 40px;
`;

export const Logo = styled.div`
  font-size: 28px;
  font-weight: 900;
  color: #3c40c6;
  cursor: pointer;
`;

export const NavRight = styled.div`
  display: flex;
  align-items: center;
  gap: 14px;
`;

export const NavButton = styled.button`
  padding: 8px 16px;
  border-radius: 6px;
  font-size: 14px;
  cursor: pointer;

  border: ${(p) => (p.primary ? "none" : "1px solid #ccc")};
  background: ${(p) => (p.primary ? "#4b7fff" : "#fff")};
  color: ${(p) => (p.primary ? "white" : "#333")};

  &:hover {
    background: ${(p) => (p.primary ? "#3c6ae8" : "rgba(0,0,0,0.05)")};
  }
`;
