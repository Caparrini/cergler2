package abd.p1.model.message;

import java.sql.Timestamp;

import abd.p1.model.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "text_message")
public class TextMessage extends Message {

    @Column(nullable = false, length = 500)
    public String content;

    protected TextMessage() {}

    public TextMessage(Timestamp sent, boolean readStatus,
                       User sender, User receiver, String content) {

        super(sent, readStatus, sender, receiver);
        this.content = content;
    }
}
