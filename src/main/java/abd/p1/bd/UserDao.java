package abd.p1.bd;

import abd.p1.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class UserDao extends GenericDao<String, User> {

    private SessionFactory sessionF;

    public UserDao(SessionFactory sf) {
        super(sf);
        this.sessionF = sf;
    }

    @Override
    public Optional<User> find(String id) {
        Session session = sessionF.openSession();
        Optional<User> res = Optional.ofNullable(session.byId(User.class).load(id));
        session.close();
        return res;
    }

    @Override
    public List<User> findAll() {
        Session session = sessionF.openSession();
        List<User> res = session.createCriteria(User.class).list();
        session.close();
        return res;
    }

    @Override
    protected void deleteById(String id) {
        Session session = sessionF.openSession();
        this.delete(session.load(User.class, id));
        session.close();
    }
}
