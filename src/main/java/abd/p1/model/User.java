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

    enum Gender {
        MALE,
        FEMALE
    }

    enum OtherGender {
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

    @OneToMany(mappedBy = "rater", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Rating> ratings;

    @Transient private ArrayList<Message> received;
    @Transient private ArrayList<Message> sent;

    protected User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean checkPass(String password) {
        return this.password.equals(password);
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public void setBirthDate(Date date) {
        this.birthDate = date;
    }

    public void setDescription(String text) {
        this.description = text;
    }

    public void addInterest(String i) {
        this.interests.add(i);
    }

    public void removeInterest(String i) {
        this.interests.remove(i);
    }

    public void setGender(Gender g) {
        this.gender = g;
    }

    public void setGenderPreference(OtherGender g) {
        this.otherGender = g;
    }

    public void setPassword(String p) {
        this.password = p;
    }

    public void setProfileImage(byte[] b) {
        this.profileImage = b;
    }
}
