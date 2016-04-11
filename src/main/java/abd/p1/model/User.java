package abd.p1.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    @Column(length = 250)
    private String email;

    @Column(nullable = false, length = 162)
    private String password;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OtherGender otherGender;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Lob
    private byte[] profileImage;

    @Column(nullable = true)
    private float latidue;

    @Column(nullable = true)
    private float longitude;

    @Column(length = 500)
    private String description;

    @ElementCollection
    @CollectionTable(name = "interests")
    private List<String> interests;

    @OneToMany
    private Set<User> friends;

    @Transient private ArrayList<Message> received;
    @Transient private ArrayList<Message> sent;

    protected User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
