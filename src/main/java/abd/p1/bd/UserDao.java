package abd.p1.bd;

import abd.p1.model.User;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class UserDao extends GenericDao<String, User> {

    private Session session;

    public UserDao(Session s) {
        super(s);
        this.session = s;
    }

    @Override
    public Optional<User> find(String id) {
        return Optional.ofNullable(session.byId(User.class).load(id));
    }

    @Override
    public List<User> findAll() {
        return session.createCriteria(User.class).list();
    }

    @Override
    protected void deleteById(String id) {
        this.delete(session.load(User.class, id));
    }
}
