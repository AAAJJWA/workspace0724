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
          <Route path="/" element={<UserList />} />
          <Route path="/user/:id" element={<UserDetail />} />
          <Route path="/user" element={<UserRegistration />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </BrowserRouter>
    </UserProvider>
  );
}

export default App;
