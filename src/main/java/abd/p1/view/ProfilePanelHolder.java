package abd.p1.view;

import abd.p1.controller.MainController;
import abd.p1.view.res.HintPassField;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.util.Objects;

/**
 * Main User editing panel, constructor takes a 'editingSetting' boolean attribute,
 * when set to true, shows edition section (for editing)
 * when set to false, shows user profile (for viewing)
 *
 * Used inside LoginFrame
 */
class ProfilePanelHolder extends javax.swing.JDialog {

    private ProfilePanelContent viewProfilePanel;

    private java.awt.Button buttonCancel;
    private java.awt.Button buttonChangePassword;
    private java.awt.Button buttonSaveChanges;

    private boolean editingSetting;
    private MainController controller;

    ProfilePanelHolder(java.awt.Frame parent, MainController controller) {
        this(parent, controller, false);
    }

    ProfilePanelHolder(java.awt.Frame parent, MainController controller, boolean _editable) {
        super(parent, _editable);
        this.controller = controller;
        this.editingSetting = _editable;

        initUI();
    }

    private void initUI() {
        initComponents();

        buttonChangePassword.addActionListener(_l -> {
            HintPassField newPassField = new HintPassField("Introduce una nueva contraseña");
            JOptionPane.showMessageDialog(
                null, newPassField,
                "New password", JOptionPane.PLAIN_MESSAGE
            );

            char[] newpass = newPassField.getPassword();
            if (newpass != null) {
                controller.editPassword(String.valueOf(newpass));
            } else {
                JOptionPane.showMessageDialog(this, "Por favor completa los campos");
            }
        });

        buttonSaveChanges.addActionListener(_l -> {
            controller.createNewUserEvent(this.viewProfilePanel.getUsername());
        });

        buttonCancel.addActionListener(_l -> this.dispose());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        viewProfilePanel = new ProfilePanelContent(controller, editingSetting);
        buttonChangePassword = new java.awt.Button();
        buttonCancel = new java.awt.Button();
        buttonSaveChanges = new java.awt.Button();
        buttonCancel.setVisible(editingSetting);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonChangePassword.setLabel("Cambiar Contraseña");
        buttonChangePassword.setVisible(editingSetting);

        buttonCancel.setLabel("Cancelar");
        buttonCancel.setVisible(editingSetting);

        buttonSaveChanges.setLabel("Guardar Cambios");
        buttonSaveChanges.setVisible(editingSetting);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewProfilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(viewProfilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(buttonSaveChanges, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(buttonChangePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>
}

