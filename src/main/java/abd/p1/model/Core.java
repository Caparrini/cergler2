package abd.p1.model;

import org.hibernate.Session;

import java.util.Date;
import java.util.Observable;
import java.util.Optional;

public class Core extends Observable {

    private Session session;

    private User logedUser;
    private Users presentUsers;

    public Core(Session _session) {
        this.session = _session;
        this.presentUsers = new Users(session);
    }

    public void login() {
        this.setChanged();
        // TODO: send login message
    }

    public boolean validate(String username, String password) {
        Optional<User> u = this.presentUsers.validate(username, password);
        u.ifPresent(e -> this.logedUser = e);
        return u.isPresent();
    }

    public void logout() {
        this.setChanged();
        // TODO: send logout message
    }

    public void signupDialog(String username, String password) {
        this.logedUser = new User(username, password);
        this.setChanged();
        // TODO: send signup message
    }

    public void editUsername(String newUsername) {
        this.logedUser.setUsername(newUsername);
    }

    public void editBirthDate(Date date) {
        this.logedUser.setBirthDate(date);
    }

    public void editDescription(String description) {
        this.logedUser.setDescription(description);
    }

    public void addInterest(String i) {
        this.logedUser.addInterest(i);
    }

    public void removeInterest(String i) {
        this.logedUser.removeInterest(i);
    }

    public void changeGender(String gender) {
        User.Gender g = null;
        switch (gender.toLowerCase()) {
            case "male": g = User.Gender.MALE; break;
            case "female": g = User.Gender.FEMALE; break;
            default: // TODO: throw
        }

        this.logedUser.setGender(g);
    }

    public void changeGenderPreference(String gender) {
        User.OtherGender g = User.OtherGender.BOTH;
        switch (gender.toLowerCase()) {
            case "male": g = User.OtherGender.MALE; break;
            case "female": g = User.OtherGender.FEMALE; break;
            case "both": g = User.OtherGender.BOTH; break;
            default: // TODO: throw
        }

        this.logedUser.setGenderPreference(g);
    }

    public void changePassword(String newpass) {
        this.logedUser.setPassword(newpass);
    }

    public void changeUserPic(byte[] b) {
        this.logedUser.setProfileImage(b);
    }
}
