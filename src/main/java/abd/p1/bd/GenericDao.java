package abd.p1.bd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class GenericDao<K extends Serializable, V> {

    private SessionFactory sessionF;

    public GenericDao(SessionFactory sf) {
        this.sessionF = sf;
    }

    protected abstract Optional<V> find(K id);
    public abstract List<V> findAll();
    protected abstract void deleteById(K id);

    public K save(V value) {
        Session session = sessionF.openSession();
        K res = (K) session.save(value);
        session.close();
        return res;
    }

    public void update(V value) {
        Session session = sessionF.openSession();
        Transaction tx = session.beginTransaction();
        session.refresh(value);
        tx.commit();
        session.close();
    }

    public void delete(V value) {
        Session session = sessionF.openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.delete(value);
            tx.commit();
        } catch (org.hibernate.ObjectNotFoundException e) {
            // Who cares?
        } finally {
            session.close();
        }
    }
}
