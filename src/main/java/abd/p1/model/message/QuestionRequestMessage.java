package abd.p1.model.message;

import java.sql.Timestamp;

import abd.p1.model.Pregunta;
import abd.p1.model.User;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "questionreq_message")
public class QuestionRequestMessage extends Message {

    @ManyToOne(optional = false)
    @JoinColumn(name = "questionId", foreignKey = @ForeignKey(name = "MESSAGE_QUESTION_ID_FK"))
    private Pregunta question;

    protected QuestionRequestMessage() {}

    public QuestionRequestMessage(Timestamp sent, boolean readStatus,
                                  User sender, User receiver, Pregunta question) {

        super(sent, readStatus, sender, receiver);
        this.question = question;
    }
}
