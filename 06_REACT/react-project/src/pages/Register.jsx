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
    userid: "",
    nickname: "",
    password: "",
    password2: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  };

  // 회원가입 처리
  const handleRegister = () => {
    const { userid, nickname, password, password2 } = form;

    if (!userid || !nickname || !password) {
      alert("모든 항목을 입력해주세요.");
      return;
    }

    if (password !== password2) {
      alert("비밀번호가 일치하지 않습니다.");
      return;
    }

    // 기존 유저 목록 가져오기
    const users = JSON.parse(localStorage.getItem("userList") || "[]");

    // 중복 체크
    if (users.some((u) => u.userid === userid)) {
      alert("이미 존재하는 아이디입니다.");
      return;
    }

    if (users.some((u) => u.nickname === nickname)) {
      alert("이미 존재하는 닉네임입니다.");
      return;
    }

    // 저장
    const newUser = { userid, nickname, password };
    users.push(newUser);
    localStorage.setItem("userList", JSON.stringify(users));

    alert("회원가입 완료! 로그인해주세요.");
    navigate("/login");
  };

  return (
    <PageWrapper>
      <AuthBox>
        <Title>회원가입</Title>

        <FormGroup>
          <Label>아이디</Label>
          <Input name="userid" value={form.userid} onChange={handleChange} />
        </FormGroup>

        <FormGroup>
            <Label>닉네임</Label>
            <Input
              name="nickname"
              value={form.nickname}
              onChange={handleChange}
            />
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
