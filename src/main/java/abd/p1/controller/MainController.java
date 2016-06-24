package abd.p1.controller;

import abd.p1.misc.Watcher;
import abd.p1.model.Core;
import abd.p1.model.User;
import abd.p1.view.LoginFrame;

import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class MainController {
    private Core core;
    private LoginFrame loginFrame;

    public MainController(Core c) {
        this.core = c;
    }

    public void addLoginView(LoginFrame f) {
        this.loginFrame = f;
    }

    public void init(Watcher w) {
        core.addWatcher(w);
    }

    public void shutdown() {
        core.deleteWatchers();
        core.quit();
    }

    public boolean loginEvent(String email, String password) {
        if (core.validatePass(email, password)) {
            core.login();
            return true;
        } else {
            loginFrame.showValidateError();
            return false;
        }
    }

    public void signupEvent(String email, String password) {
        if (!core.validateEmail(email)) {
            core.signupProcess(email, password);
        } else {
            loginFrame.showEmailExistsError();
        }
    }

    public void createNewUserEvent(String username) {
        if (!core.validateUsername(username)) {
            core.signup(username);
        } else {
            loginFrame.showUsernameExistsError();
        }
    }

    public void editBirthDate(Date date) {
        core.editBirthDate(date);
    }

    public void editUsername(String newUsername) {
        if (!core.validateUsername(newUsername)) {
            core.editUsername(newUsername);
        } else {
            loginFrame.showUsernameExistsError();
        }
    }

    public void editPassword(String newpass) {
        core.changePassword(newpass);
    }

	public DefaultListModel<User> getListUserModel() {
		return core.getUsers();

	}

	public void setSesion(String email) {
		core.setUser(email);
	}

	public User getLogUser() {
		return core.getLogUser();
	}

	public DefaultListModel<User> getListUserModel(String text) {
		return core.getUsers(text);
	}

	public void setUserToView(User selectedValue) {
		core.setUserToView(selectedValue);
	}

	public User getUserToView() {
		return core.getUserToView();
	}

	public void modifyLogedUser(User newData) {
		core.modifyLogedUser(newData);
	}
}
