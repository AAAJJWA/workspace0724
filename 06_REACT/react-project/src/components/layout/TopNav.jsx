import React from "react";
import { useNavigate } from "react-router-dom";
import { TopNavBox, Logo, NavRight, NavButton } from "./TopNav.styled";

const TopNav = () => {
  const navigate = useNavigate();
  const logged = JSON.parse(localStorage.getItem("loggedInUser") || "null");

  const handleLogout = () => {
    localStorage.removeItem("loggedInUser");
    alert("로그아웃 되었습니다.");
    navigate("/");
  };

  return (
    <TopNavBox>
      <Logo onClick={() => navigate("/")}>YuGiOhMaker</Logo>

      <NavRight>
        {logged ? (
          <>
            <span style={{ fontSize: "15px", marginRight: "10px" }}>
              {logged.nickname} 님
            </span>
            <NavButton onClick={handleLogout}>로그아웃</NavButton>
            <NavButton primary onClick={() => navigate("/make")}>
              카드 생성하기
            </NavButton>
          </>
        ) : (
          <>
            <NavButton onClick={() => navigate("/login")}>로그인</NavButton>
            <NavButton onClick={() => navigate("/signup")}>회원가입</NavButton>
            <NavButton primary onClick={() => navigate("/make")}>
              카드 생성하기
            </NavButton>
          </>
        )}
      </NavRight>
    </TopNavBox>
  );
};

export default TopNav;
