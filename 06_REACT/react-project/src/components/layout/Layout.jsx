import React from "react";
import TopNav from "./TopNav";
import styled from "styled-components";
import { Outlet } from "react-router-dom";

const LayoutWrapper = styled.div`
  width: 100%;
  min-height: 100vh;
  background: #f5f6fa;
`;

const Layout = () => {
  return (
    <LayoutWrapper>
      <TopNav />
      <Outlet />
    </LayoutWrapper>
  );
};

export default Layout;
