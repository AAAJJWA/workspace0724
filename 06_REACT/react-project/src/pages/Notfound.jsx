import React from "react";
import { useNavigate } from "react-router-dom";
import {
  NotFoundWrapper,
  NotFoundImage,
  BackButton,
} from "./Notfound.styled";

const NotFound = () => {
  const navigate = useNavigate();

  return (
    <NotFoundWrapper>
      <NotFoundImage src="/NotFound.png" alt="404 Not Found" />
      <BackButton onClick={() => navigate("/")}>메인 페이지로 돌아가기</BackButton>
    </NotFoundWrapper>
  );
};

export default NotFound;
