package abd.p1.model.message;

import java.sql.Timestamp;

import abd.p1.model.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "friendreq_message")
public class FriendRequestMessage extends Message {

    @Column(nullable = false)
    private boolean accepted;

    protected FriendRequestMessage () {}

    public FriendRequestMessage(Timestamp sent, boolean readStatus, User sender, User receiver) {
        super(sent, readStatus, sender, receiver);
    }

    public void accept(){
        this.accepted = true;
    }

    public void deny(){
        this.accepted = false;
    }

    public boolean isAccepted(){
        return accepted;
    }
}
