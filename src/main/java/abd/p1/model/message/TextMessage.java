package abd.p1.model.message;

import java.sql.Timestamp;

import abd.p1.model.User;

public class TextMessage extends Message{

    public String content;

    public TextMessage(Timestamp sent, boolean readStatus,
                       User sender, User receiver, String content) {

        super(sent, readStatus, sender, receiver);
        this.content = content;
    }
}
