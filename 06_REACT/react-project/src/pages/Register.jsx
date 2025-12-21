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

const Register = () => {
  const navigate = useNavigate();
  const [form, setForm] = useState({
    loginId: "",
    nickname: "",
    password: "",
    password2: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  };

  const handleRegister = async () => {
    const { loginId, nickname, password, password2 } = form;

    if (!loginId || !nickname || !password) {
      alert("모든 항목을 입력해주세요.");
      return;
    }

    if (password !== password2) {
      alert("비밀번호가 일치하지 않습니다.");
      return;
    }

    try {
      const response = await fetch("/api/members", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          loginId,
          password,
          nickname,
        }),
      });

      if (!response.ok) {
        const errorText = await response.text();
        alert(errorText);
        return;
      }

      alert("회원가입 완료! 로그인해주세요.");
      navigate("/login");
    } catch (error) {
      console.error(error);
      alert("서버와 통신 중 오류가 발생했습니다.");
    }
  };

  return (
    <PageWrapper>
      <AuthBox>
        <Title>회원가입</Title>

        <FormGroup>
          <Label>아이디</Label>
          <Input name="loginId" value={form.loginId} onChange={handleChange} />
        </FormGroup>

        <FormGroup>
          <Label>닉네임</Label>
          <Input name="nickname" value={form.nickname} onChange={handleChange} />
        </FormGroup>

        <FormGroup>
          <Label>비밀번호</Label>
          <Input
            type="password"
            name="password"
            value={form.password}
            onChange={handleChange}
          />
        </FormGroup>

        <FormGroup>
          <Label>비밀번호 확인</Label>
          <Input
            type="password"
            name="password2"
            value={form.password2}
            onChange={handleChange}
          />
        </FormGroup>

        <Button onClick={handleRegister}>회원가입</Button>

        <BottomText>
          이미 계정이 있으신가요?{" "}
          <span onClick={() => navigate("/login")}>로그인</span>
        </BottomText>
      </AuthBox>
    </PageWrapper>
  );
};

export default Register;
