package abd.p1.model.message;

import java.sql.Timestamp;

import abd.p1.model.Pregunta;
import abd.p1.model.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "questionreq_message")
public class QuestionRequestMessage extends Message {

    @Column(nullable = false)
    private int questionId;

    @Transient private Pregunta question;

    protected QuestionRequestMessage() {}

    public QuestionRequestMessage(Timestamp sent, boolean readStatus,
                                  User sender, User receiver, Pregunta question) {

        super(sent, readStatus, sender, receiver);
        this.question = question;
    }
}
