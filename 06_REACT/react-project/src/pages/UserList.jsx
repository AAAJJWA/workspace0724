import { Link } from 'react-router-dom';
import { useUser } from '../components/UserContext';
import { PageContainer } from '../components/styled/LayoutStyled';
import { Button } from '../components/styled/ButtonStyled';
import { UserListWrapper, UserItem } from '../components/styled/UserListStyled';

const UserList = () => {
    const { users } = useUser();

    return (
        <PageContainer>
            <h2>유저 목록</h2>

            <Link to="/user">
                <Button>유저 등록</Button>
            </Link>

            <UserListWrapper>
                {users.map(user => (
                    <Link to={`/user/${user.id}`}>
                        <UserItem key={user.id}>
                            {user.name} ({user.age}세) - {user.isOnline ? "🟢 온라인" : "🔴 오프라인"}
                        </UserItem>
                    </Link>
                ))}
            </UserListWrapper>
        </PageContainer>
    )
}

export default UserList