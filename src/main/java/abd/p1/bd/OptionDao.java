package abd.p1.bd;

import abd.p1.model.Opcion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class OptionDao extends GenericDao<Integer, Opcion> {

    private SessionFactory sessionF;

    public OptionDao(SessionFactory sf) {
        super(sf);
        this.sessionF = sf;
    }

    @Override
    public Optional<Opcion> find(Integer id) {
        Session session = sessionF.openSession();
        Optional<Opcion> res = Optional.ofNullable(session.byId(Opcion.class).load(id));
        session.close();
        return res;
    }

    @Override
    public List<Opcion> findAll() {
        Session session = sessionF.openSession();
        List<Opcion> res = session.createCriteria(Opcion.class).list();
        session.close();
        return res;
    }

    @Override
    public void delete(Opcion option) {
        // TODO
    }

    @Override
    public void deleteById(Integer id) {
        Session session = sessionF.openSession();
        this.delete(session.load(Opcion.class, id));
        session.close();
    }
}
