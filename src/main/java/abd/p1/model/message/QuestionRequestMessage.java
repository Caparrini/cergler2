package abd.p1.model.message;

import java.sql.Timestamp;

import abd.p1.model.Pregunta;
import abd.p1.model.User;

public class QuestionRequestMessage extends Message{

    private Pregunta question;

    public QuestionRequestMessage(Timestamp sent, boolean readStatus,
                                  User sender, User receiver, Pregunta question) {

        super(sent, readStatus, sender, receiver);
        this.question = question;
    }
}
