package abd.p1.view;

import abd.p1.controller.MainController;
import abd.p1.misc.UpdateMessage;
import abd.p1.misc.Watchable;
import abd.p1.misc.Watcher;
import abd.p1.view.res.HintPassField;
import abd.p1.view.res.HintTextField;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrame extends javax.swing.JFrame implements Watcher {

    private MainController controller;

    private java.awt.Button loginButton;
    private java.awt.Button signupButton;

    private HintTextField emailField;
    private HintPassField passwordField;


    public LoginFrame(MainController _controller) {
        this.controller = _controller;
        initUI();
    }

    public void init() {
        this.controller.init(this);
        this.setEnabled(true);
        this.setVisible(true);
    }

    private void initUI() {
        initComponents();

        emailField.addActionListener(submitFields("login"));
        passwordField.addActionListener(submitFields("login"));

        loginButton.addActionListener(submitFields("login"));
        signupButton.addActionListener(submitFields("signup"));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controller.shutdown();
                e.getWindow().dispose();
            }
        });
    }

    public void showValidateError() {
        JOptionPane.showMessageDialog(this, "Email y / o contraseña incorrectos");
    }

    public void showEmailExistsError() {
        JOptionPane.showMessageDialog(this, "El correo introducido ya existe");
    }

    public void showUsernameExistsError() {
        JOptionPane.showMessageDialog(this, "El usuario introducido ya existe");
    }

    @Override
    public void update(Watchable w, UpdateMessage arg) {
        switch (arg.getEvent()) {

            case LOGIN:
                // TODO open main window or open a new frame
                break;

            case SIGNUP:
                ProfilePanelHolder newUserDialog = new ProfilePanelHolder(this, this.controller, true);
                newUserDialog.setLocationRelativeTo(null);
                newUserDialog.setVisible(true);
                // TODO controller.createNewUserEvent();
                this.setVisible(false);
                break;
        }
    }

    private ActionListener submitFields(String action) {
        return e -> {
            String email = emailField.getText();
            char[] bytes = passwordField.getPassword();

            if (email.isEmpty() || bytes == null) {
                JOptionPane.showMessageDialog(this, "Por favor completa los campos");
            } else {
                // Java please support void method references
                String pass = String.valueOf(bytes);
                switch (action) {

                    case "login":
                        controller.loginEvent(email, pass);
                        emailField.setText(null);
                        passwordField.setText(null);
                        break;

                    case "signup":
                        controller.signupEvent(email, pass);
                        break;
                }
            }
        };
    }

    private void initComponents() {

        java.awt.Label labelMail = new java.awt.Label();
        java.awt.Label labelPassword = new java.awt.Label();

        emailField = new HintTextField("email");
        passwordField = new HintPassField("Password");

        loginButton = new java.awt.Button();
        signupButton = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelMail.setText("Dirección de correo:");
        labelPassword.setText("Contraseña:");

        loginButton.setLabel("Aceptar");
        signupButton.setLabel("Nuevo Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelMail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(signupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 151, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                        .addComponent(labelMail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                        .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signupButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }
}
