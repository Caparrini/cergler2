package abd.p1.model;

import abd.p1.bd.UserDao;
import org.hibernate.Session;

import java.util.Optional;

public class Users {
    private UserDao dao = null;

    public Users(Session _session) {
        this.dao = new UserDao(_session);
    }

    public void addUser(User u) {
        dao.save(u);
    }

    public void removeUser(User u) {
        dao.delete(u);
    }

    public Optional<User> validate(String email, String password) {
        return dao
                .find(email)
                .filter(e -> e.checkPass(password));
    }
}
