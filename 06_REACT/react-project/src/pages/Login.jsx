import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  PageWrapper,
  AuthBox,
  Title,
  FormGroup,
  Label,
  Input,
  Button,
  BottomText,
} from "./Register.styled";

const Login = () => {
  const navigate = useNavigate();
  const [form, setForm] = useState({
    userid: "",
    password: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  };

  const handleLogin = () => {
    const { userid, password } = form;

    const users = JSON.parse(localStorage.getItem("userList") || "[]");

    const found = users.find((u) => u.userid === userid);

    if (!found || found.password !== password) {
      alert("아이디 또는 비밀번호가 잘못되었습니다.");
      return;
    }

    localStorage.setItem("loggedInUser", JSON.stringify(found));

    alert("로그인 성공!");
    navigate("/");
  };

  return (
    <PageWrapper>
      <AuthBox>
        <Title>로그인</Title>

        <FormGroup>
          <Label>아이디</Label>
          <Input name="userid" onChange={handleChange} />
        </FormGroup>

        <FormGroup>
          <Label>비밀번호</Label>
          <Input type="password" name="password" onChange={handleChange} />
        </FormGroup>

        <Button onClick={handleLogin}>로그인</Button>

        <BottomText>
          계정이 없으신가요?{" "}
          <span onClick={() => navigate("/register")}>회원가입</span>
        </BottomText>
      </AuthBox>
    </PageWrapper>
  );
};

export default Login;
