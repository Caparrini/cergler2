package abd.p1.model.message;

import java.sql.Timestamp;

import abd.p1.model.User;

public abstract class Message {

    private Timestamp sent;
    private boolean readStatus;
    private User sender;
    private User receiver;

    protected Message(Timestamp sent, boolean readStatus, User sender, User receiver) {
        this.sent = sent;
        this.readStatus = readStatus;
        this.sender = sender;
        this.receiver = receiver;
    }
}
