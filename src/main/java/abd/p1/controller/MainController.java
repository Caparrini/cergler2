package abd.p1.controller;

import abd.p1.model.Core;
import abd.p1.view.LoginFrame;

import java.util.Observer;

public class MainController {
    private Core core;
    private LoginFrame loginFrame;

    public MainController(Core c) {
        this.core = c;
    }

    public void addLoginView(LoginFrame f) {
        this.loginFrame = f;
    }

    void init(Observer o) {
        core.addObserver(o);
    }

    public void shutdown() {
        core.deleteObservers();
        core.quit();
    }

    public void loginEvent(String username, String password) {
        if (core.validate(username, password)) {
            core.login();
            // TODO: show main panel
        } else {
            loginFrame.showValidateError();
        }
    }

    void signupDialog(String username, String password) {
        core.signupDialog(username, password);
    }

    public void signupEvent(String username, String password) {

        // TODO: show edit panel
    }

    void logoutEvent() {
        core.logout();
    }

    void editUsernameEvent(String newUsername) {
        core.editUsername(newUsername);
    }
}
