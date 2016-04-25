package abd.p1.controller;

import abd.p1.model.Core;

import java.util.Observer;

public class MainController {
    private Core core;

    public MainController(Core c) {
        this.core = c;
    }

    void init(Observer o) {
        core.addObserver(o);
    }

    void shutdown() {
        core.deleteObservers();
    }

    void loginEvent(String username, String password) {
        if (core.validate(username, password)) {
            // show main panel
            core.login();
        }

        // TODO: Show error message
    }

    void logoutEvent() {
        core.logout();
    }

    void signupDialog(String username, String password) {
        core.signupDialog(username, password);
    }

    void editUsernameEvent(String newUsername) {
        core.editUsername(newUsername);
    }
}
