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

    @Override
	public String toString() {
		return "Nombre=" + name + ", birthDate=" + birthDate + ".";
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

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "interests")
    private List<String> interests;

    @OneToMany
    private Set<User> friends;

    @OneToMany(mappedBy = "rater", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Rating> ratings;

    @Transient private ArrayList<Message> received;
    @Transient private ArrayList<Message> sent;

    public User() {}

    public User(String username, String email, String password) {
        this.name = username;
        this.email = email;
        this.password = password;
    }

    public boolean checkPass(String password) {
        return this.password.equals(password);
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public String getUsername() {
        return this.name;
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

	public int getAge() {
		Date a = new Date();
		return -birthDate.getYear()+a.getYear();
	}

	public String getDesc() {
		return description;
	}

	public String getSex() {
		if(gender.equals(Gender.MALE)){
			return "Hombre";
		}else{
			return "Mujer";
		}
	}

	public String getTaste() {
		if(otherGender.equals(OtherGender.MALE)){
			return "Hombres";
		}else if (otherGender.equals(OtherGender.FEMALE)){
			return "Mujeres";
		}else{
			return "Hombres/Mujeres";
		}
	}
	public OtherGender getTasteEnum(){
		return otherGender;
	}
	public List<String> getIntereses() {
		return interests;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public byte[] getIcon() {
		// TODO Auto-generated method stub
		return profileImage;
	}

	public void setGender(String text) {
		if(text.equalsIgnoreCase(Gender.MALE.toString())){
			gender = Gender.MALE;
		}else{
			gender = Gender.FEMALE;
		}
	}

	public void setGenderPreference(String text) {
		if(text.equalsIgnoreCase(OtherGender.MALE.toString())){
			otherGender = OtherGender.MALE;
		}else if (text.equalsIgnoreCase(OtherGender.FEMALE.toString())){
			otherGender = OtherGender.FEMALE;
		}else{
			otherGender = OtherGender.BOTH;
		}
	}
}
