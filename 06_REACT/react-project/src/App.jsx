import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import UserList from './pages/UserList';
import UserDetail from './pages/UserDetail';
import UserRegistration from './pages/UserRegistration';
import NotFound from './pages/NotFound';
import { UserProvider } from './components/UserContext';

function App() {
  return (
    <UserProvider>
      <BrowserRouter>
        <Routes>
          {/* 유저 목록 */}
          <Route path="/" element={<UserList />} />

          {/* 유저 상세 */}
          <Route path="/user/:id" element={<UserDetail />} />

          {/* 유저 등록 */}
          <Route path="/user" element={<UserRegistration />} />

          {/* 404 */}
          <Route path="*" element={<NotFound />} />
        </Routes>
      </BrowserRouter>
    </UserProvider>
  );
}

export default App;
