package abd.p1.bd;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class GenericDao<K extends Serializable, V> {

    private Session session;

    public GenericDao(Session s) {
        this.session = s;
    }

    protected abstract Optional<V> find(K id);
    public abstract List<V> findAll();
    protected abstract void deleteById(K id);

    public K save(V value) {
        return (K) session.save(value);
    }

    public void update(V value) {
        Transaction tx = session.beginTransaction();
        session.refresh(value);
        tx.commit();
    }

    public void delete(V value) {
        try {
            Transaction tx = session.beginTransaction();
            session.delete(value);
            tx.commit();
        } catch (org.hibernate.ObjectNotFoundException e) {
            // Who cares?
        }
    }


}
