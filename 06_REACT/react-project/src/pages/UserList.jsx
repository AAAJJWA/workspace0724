import { Link } from 'react-router-dom';
import { useUser } from '../components/UserContext';

const UserList = () => {
    const { users } = useUser();

    return (
        <div>
            <h2>유저 목록</h2>

            <Link to="/user">
                <button>유저 등록</button>
            </Link>

            <ul>
                {users.map(user => (
                <li key={user.id}>
                    <Link to={`/user/${user.id}`}>
                    {user.name} ({user.age}세) - {user.isOnline ? "🟢 온라인" : "🔴 오프라인"}
                    </Link>
                </li>
                ))}
            </ul>
        </div>
    )
}

export default UserList