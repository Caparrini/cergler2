package abd.p1.bd;

import abd.p1.model.Pregunta;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class QuestionDao extends GenericDao<Integer, Pregunta> {

    private Session session;

    public QuestionDao(Session s) {
        super(s);
        this.session = s;
    }

    @Override
    public Optional<Pregunta> find(Integer id) {
        return Optional.ofNullable(session.byId(Pregunta.class).load(id));
    }

    @Override
    public List<Pregunta> findAll() {
        return session.createCriteria(Pregunta.class).list();
    }

    @Override
    public Integer save(Pregunta question) {
        Transaction tx = session.beginTransaction();
        Integer id = (Integer) session.save(question);
        tx.commit();
        return id;
    }

    @Override
    public void deleteById(Integer id) {
        this.delete(session.load(Pregunta.class, id));
    }
}
