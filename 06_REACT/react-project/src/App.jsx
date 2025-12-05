import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";

// 페이지들
import CardMake from "./pages/CardMake";
import CardDetail from "./pages/CardDetail";
import BoardList from "./pages/BoardList";
import Register from "./pages/Register";
import Login from "./pages/Login";
import NotFound from "./pages/NotFound";
import Layout from "./components/layout/Layout";

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<Layout />}>
          {/* 홈 */}
          <Route path="/" element={<BoardList />} />

          {/* 카드 생성 페이지 */}
          <Route path="/make" element={<CardMake />} />

          {/* 카드 상세보기 */}
          <Route path="/detail/:id" element={<CardDetail />} />
        </Route>

        {/* 로그인 */}
        <Route path="/Login" element={<Login />} />

        {/* 회원가입 */}
        <Route path="/signup" element={<Register />} />

        {/* 404 */}
        <Route path="*" element={<NotFound />} />

      </Routes>
    </BrowserRouter>
  );
};

export default App;
