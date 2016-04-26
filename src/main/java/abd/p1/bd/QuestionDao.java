package abd.p1.bd;

import abd.p1.model.Pregunta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class QuestionDao extends GenericDao<Integer, Pregunta> {

    private SessionFactory sessionF;

    public QuestionDao(SessionFactory sf) {
        super(sf);
        this.sessionF = sf;
    }

    @Override
    public Optional<Pregunta> find(Integer id) {
        Session session = sessionF.openSession();
        Optional<Pregunta> res = Optional.ofNullable(session.byId(Pregunta.class).load(id));
        session.close();
        return res;
    }

    @Override
    public List<Pregunta> findAll() {
        Session session = sessionF.openSession();
        List<Pregunta> res = session.createCriteria(Pregunta.class).list();
        session.close();
        return res;
    }

    @Override
    public Integer save(Pregunta question) {
        Session session = sessionF.openSession();
        Transaction tx = session.beginTransaction();
        Integer id = (Integer) session.save(question);
        tx.commit();
        session.close();

        return id;
    }

    @Override
    public void deleteById(Integer id) {
        Session session = sessionF.openSession();
        this.delete(session.load(Pregunta.class, id));
        session.close();
    }
}
