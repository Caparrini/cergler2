package abd.p1.model.message;

import java.sql.Timestamp;

import abd.p1.model.User;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Timestamp sent;

    @Column(nullable = false)
    private boolean readStatus;

    @OneToOne(optional = false)
    private User sender;

    @OneToOne(optional = false)
    private User receiver;

    protected Message() {}

    protected Message(Timestamp sent, boolean readStatus, User sender, User receiver) {
        this.sent = sent;
        this.readStatus = readStatus;
        this.sender = sender;
        this.receiver = receiver;
    }
}
