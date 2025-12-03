import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";

// 페이지들
import CardMake from "./pages/CardMake";
import CardList from "./pages/CardList";
import CardDetail from "./pages/CardDetail";
import Login from "./pages/Login";
import NotFound from "./pages/NotFound";

const App = () => {
  return (
    <BrowserRouter>
      <Routes>

        {/* 홈 */}
        <Route path="/" element={<CardMake />} />

        {/* 카드 생성 페이지 */}
        <Route path="/make" element={<CardMake />} />

        {/* 카드 목록 */}
        <Route path="/list" element={<CardList />} />

        {/* 카드 상세보기 */}
        <Route path="/detail/:id" element={<CardDetail />} />

        {/* 404 */}
        <Route path="*" element={<NotFound />} />

      </Routes>
    </BrowserRouter>
  );
};

export default App;
