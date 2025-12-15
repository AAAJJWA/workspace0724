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

  const handleLogin = async () => {
    const { userid, password } = form;

//     const users = JSON.parse(localStorage.getItem("userList") || "[]");
//
//     const found = users.find((u) => u.userid === userid);
//
//     if (!found || found.password !== password) {
//       alert("아이디 또는 비밀번호가 잘못되었습니다.");
//       return;
//     }

    if (!userid || !password) {
      alert("아이디와 비밀번호를 입력해주세요.");
      return;
    }

    try {
      const response = await fetch("/api/members/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          loginId: userid,
          password,
        }),
      });

      if (!response.ok) {
        const errorText = await response.text();
        alert(errorText);
        return;
      }

      const loginUser = await response.json();

      localStorage.setItem("loggedInUser", JSON.stringify(loginUser));

      alert("로그인 성공!");
      navigate("/");
      } catch (error) {
        console.error(error);
        alert("서버와 통신 중 오류가 발생했습니다.");
      }
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
