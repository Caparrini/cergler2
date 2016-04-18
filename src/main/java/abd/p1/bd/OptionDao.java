package abd.p1.bd;

import abd.p1.model.Opcion;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class OptionDao extends GenericDao<Integer, Opcion> {

    private Session session;

    public OptionDao(Session s) {
        super(s);
        this.session = s;
    }

    @Override
    public Optional<Opcion> find(Integer id) {
        return Optional.ofNullable(session.byId(Opcion.class).load(id));
    }

    @Override
    public List<Opcion> findAll() {
        return session.createCriteria(Opcion.class).list();
    }

    @Override
    public void delete(Opcion option) {
        // TODO
    }

    @Override
    public void deleteById(Integer id) {
        this.delete(session.load(Opcion.class, id));
    }
}
