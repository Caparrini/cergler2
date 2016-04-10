package abd.p1.model;

import java.util.Date;
import java.util.ArrayList;

import abd.p1.model.message.Message;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    private enum Gender {
        MALE,
        FEMALE
    }

    private enum OtherGender {
        MALE,
        FEMALE,
        BOTH
    }

    @Id
    private String email;

    @Column(nullable = false, length = 162)
    private String password;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OtherGender otherGender;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Lob
    private byte[] profileImage;

    private float latidue;
    private float longitude;

    @Column(length = 500)
    private String description;

    @Transient private ArrayList<String> interests;

    @Transient private ArrayList<User> friends;

    @Transient private ArrayList<Message> received;
    @Transient private ArrayList<Message> sended;

    protected User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
