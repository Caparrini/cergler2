package abd.p1.controller;

import abd.p1.misc.Watcher;
import abd.p1.model.Core;
import abd.p1.view.LoginFrame;

import java.util.Date;

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

    public void loginEvent(String email, String password) {
        if (core.validatePass(email, password)) {
            core.login();
            // TODO: show main panel
        } else {
            loginFrame.showValidateError();
        }
    }

    public void signupEvent(String email, String password) {
        if (!core.validateEmail(email)) {
            core.signupProcess(email, password);
        } else {
            loginFrame.showUserExistsError();
        }
    }

    public void createNewUserEvent(String username) {
        core.signup(username);
    }

    public void editBirthDate(Date date) {
        core.editBirthDate(date);
    }

    public void editUsername(String newUsername) {
        core.editUsername(newUsername);
    }

    public void editPassword(String newpass) {
        core.changePassword(newpass);
    }
}
