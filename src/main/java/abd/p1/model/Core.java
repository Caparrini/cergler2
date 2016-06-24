package abd.p1.model;

import abd.p1.bd.UserDao;
import abd.p1.misc.UpdateMessage;
import abd.p1.misc.Watchable;

import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class Core extends Watchable {

    private SessionFactory sessionF;

    private User logedUser;
    private User userToView;
    private Users presentUsers;
    private UserDao udao;

	private DefaultListModel<User> users;


    private String inProcessEmail;
    private String inProcessPassword;

    public Core(SessionFactory _sessionF) {
        this.sessionF = _sessionF;
        this.presentUsers = new Users(sessionF);
        this.udao = new UserDao(sessionF);
    }

    public void login() {
        this.setChanged();
        this.notifyViews(UpdateMessage.composeMessage(UpdateMessage.UpdateEvent.LOGIN, null));
    }

    public void signup(String username) {
        this.logedUser = new User(username, inProcessEmail, inProcessPassword);
        this.presentUsers.addUser(this.logedUser);
        login();
    }

    public void signupProcess(String email, String password) {
        this.inProcessEmail = email;
        this.inProcessPassword = password;
        this.setChanged();
        this.notifyViews(UpdateMessage.composeMessage(UpdateMessage.UpdateEvent.SIGNUP, null));
    }

    public boolean validateEmail(String email) {
        return this.presentUsers.isPresent(email);
    }

    public boolean validateUsername(String username) {
        return this.presentUsers.isUsernamePresent(username);
    }

    public boolean validatePass(String username, String password) {
        Optional<User> u = this.presentUsers.validate(username, password);
        u.ifPresent(e -> this.logedUser = e);
        return u.isPresent();
    }

    public void quit() {
        if (sessionF != null) sessionF.close();
    }

    public void editUsername(String newUsername) {
        this.logedUser.setUsername(newUsername);
    }

    public void editBirthDate(Date date) {
        this.logedUser.setBirthDate(date);
    }

//    public void editDescription(String description) {
//        this.logedUser.setDescription(description);
//    }
//
//    public void addInterest(String i) {
//        this.logedUser.addInterest(i);
//    }
//
//    public void removeInterest(String i) {
//        this.logedUser.removeInterest(i);
//    }
//
//    public void changeGender(String gender) {
//        User.Gender g = null;
//        switch (gender.toLowerCase()) {
//            case "male": g = User.Gender.MALE; break;
//            case "female": g = User.Gender.FEMALE; break;
//            default: // TODO: throw
//        }
//
//        this.logedUser.setGender(g);
//    }
//
//    public void changeGenderPreference(String gender) {
//        User.OtherGender g = User.OtherGender.BOTH;
//        switch (gender.toLowerCase()) {
//            case "male": g = User.OtherGender.MALE; break;
//            case "female": g = User.OtherGender.FEMALE; break;
//            case "both": g = User.OtherGender.BOTH; break;
//            default: // TODO: throw
//        }
//
//        this.logedUser.setGenderPreference(g);
//    }

    public void changePassword(String newpass) {
        this.logedUser.setPassword(newpass);
    }

    public void changeUserPic(byte[] b) {
        this.logedUser.setProfileImage(b);
    }

	public DefaultListModel<User> getUsers() {
		DefaultListModel<User> aux = new DefaultListModel<User>();
		List<User> usersIn = udao.findAllWihoutDuplicaterGender(logedUser.getTasteEnum());
		Iterator<User> it = usersIn.iterator();
		while(it.hasNext()){
			aux.addElement(it.next());
		}
		return aux;
	}

	public void setUser(String email) {
		this.logedUser = udao.find(email).get();
	}

	public User getLogUser() {
		return logedUser;
	}

	public DefaultListModel<User> getUsers(String text) {
		DefaultListModel<User> aux = new DefaultListModel<User>();
		List<User> usersIn = udao.findAllWihoutDuplicaterGender(logedUser.getTasteEnum(),text);
		Iterator<User> it = usersIn.iterator();
		while(it.hasNext()){
			aux.addElement(it.next());
		}
		return aux;
	}

	public void setUserToView(User selectedValue) {
		this.userToView=selectedValue;
	}

	public User getUserToView() {
		return userToView;
	}

	public void modifyLogedUser(User newData) {
		logedUser.setUsername(newData.getUsername());
		logedUser.setDescription(newData.getDesc());
		logedUser.setGender(newData.getSex());
		logedUser.setGenderPreference(newData.getTasteEnum());
		logedUser.setProfileImage(newData.getIcon());
		//logedUser.setPassword();
		udao.update(logedUser);
	}
}
