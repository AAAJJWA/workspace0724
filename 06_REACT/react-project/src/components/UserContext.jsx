import React from 'react';
import { useContext, useState } from 'react'

const UserContext = React.createContext();

export const UserProvider = ({ children }) => {

    const [users, setUsers] = useState([
        { id: 1, name: "홍길동", age: 25, isOnline: true },
        { id: 2, name: "김영희", age: 30, isOnline: false },
        { id: 3, name: "이철수", age: 22, isOnline: true },
    ]);

    const addUser = (user) => {
        setUsers([...users, user]);
    };

    const deleteUser = (id) => {
        setUsers(users.filter(u => u.id !== id));
    };

    const value = {
        users,
        addUser,
        deleteUser,
    };

    return (
        <UserContext.Provider value={value}>
        {children}
        </UserContext.Provider>
    );
};

export const useUser = () => {
    return useContext(UserContext);
};