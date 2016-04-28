package abd.p1.view;

import abd.p1.controller.MainController;
import abd.p1.view.res.HintTextField;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Used inside UserProfileEdit
 */
class ProfilePanelContent extends javax.swing.JPanel {

	private boolean editable;
    private MainController controller;

    private java.awt.Button buttonAddHobby;
    private java.awt.Button buttonDelHobby;
    private java.awt.Button buttonEditHobby;

    private java.awt.Label labelDescription;
    private java.awt.TextArea descriptionArea;

    private java.awt.Button buttonChangeAvatar;

    private java.awt.Button buttonChangeName;
    private java.awt.Button buttonChangeSex;
    private java.awt.Button buttonChangeTaste;

    private java.awt.Button buttonChangeBirthDate;
    private com.toedter.calendar.JDateChooser birthDateChooser;


    private java.awt.Label labelSex;
    private java.awt.Label labelTaste;
    private java.awt.Label labelUserSex;
    private java.awt.Label labelUserTaste;
    private java.awt.List list1;

    private ProfileHeaderPanel userDetailsPanel;

	ProfilePanelContent(MainController controller) {
        this(controller, false);
	}

	 ProfilePanelContent(MainController controller, boolean editable) {
        this.controller = controller;
		this.editable = editable;
        initUI();
	}

    private int yearsBetween(Date first, Date second) {
        Calendar a = Calendar.getInstance(Locale.US);
        Calendar b = Calendar.getInstance(Locale.US);

        a.setTime(first);
        b.setTime(second);

        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        boolean asMonthIsLarger = a.get(Calendar.MONTH) > b.get(Calendar.MONTH);
        boolean asDaysIsLarger = (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) &&
                a.get(Calendar.DATE) > b.get(Calendar.DATE));

        if (asMonthIsLarger || asDaysIsLarger) {
            diff--;
        }
        return  diff;
    }

    private void initUI() {
        initComponents();

        buttonChangeName.addActionListener(_l -> {
            HintTextField usernamePopup = new HintTextField("Nuevo usuario");
            JOptionPane.showMessageDialog(null, usernamePopup, "Nuevo usuario", JOptionPane.PLAIN_MESSAGE);
            String newUsername = usernamePopup.getText();
            if (!newUsername.isEmpty()) {
                controller.editUsername(newUsername);
                this.userDetailsPanel.setUsername(newUsername);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor completa los campos");
            }
        });

        buttonChangeBirthDate.addActionListener(_l -> {
            Date birthDate = birthDateChooser.getDate();
            if (birthDate != null) {
                controller.editBirthDate(birthDate);
                userDetailsPanel.setAge(yearsBetween(birthDate, new Date()));
            } else {
                JOptionPane.showMessageDialog(this, "Debes introducir una fecha");
            }
        });

        buttonChangeAvatar.addActionListener(_l -> {
            // TODO
        });
    }

    private void buttonDelHobbyActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void buttonChangeBirthDateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        userDetailsPanel = new ProfileHeaderPanel();
        buttonChangeName = new java.awt.Button();
        buttonChangeBirthDate = new java.awt.Button();
        labelDescription = new java.awt.Label();
        descriptionArea = new java.awt.TextArea();
        java.awt.Label labelHobby = new java.awt.Label();
        buttonChangeAvatar = new java.awt.Button();
        labelSex = new java.awt.Label();
        list1 = new java.awt.List();
        labelTaste = new java.awt.Label();
        buttonAddHobby = new java.awt.Button();
        buttonDelHobby = new java.awt.Button();
        buttonEditHobby = new java.awt.Button();
        buttonChangeSex = new java.awt.Button();
        buttonChangeTaste = new java.awt.Button();
        labelUserSex = new java.awt.Label();
        labelUserTaste = new java.awt.Label();
        birthDateChooser = new com.toedter.calendar.JDateChooser();

        buttonChangeName.setLabel("Cambiar Nombre");

        buttonChangeBirthDate.setLabel("Cambiar Fecha Nacimiento");
        buttonChangeBirthDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeBirthDateActionPerformed(evt);
            }
        });

        labelDescription.setText("Descripción:");

        labelHobby.setText("Aficiones:");

        buttonChangeAvatar.setLabel("Cambiar Avatar");

        labelSex.setText("Sexo:");

        labelTaste.setText("Busca:");

        buttonAddHobby.setLabel("Añadir Afición");

        buttonDelHobby.setLabel("Eliminar Af. Seleccionada");
        buttonDelHobby.addActionListener(evt -> buttonDelHobbyActionPerformed(evt));

        buttonEditHobby.setLabel("Edita Af. Seleccionada");

        buttonChangeSex.setLabel("Cambiar Sexo");

        buttonChangeTaste.setLabel("Cambiar Preferencia");

        labelUserSex.setText("Masculino");

        labelUserTaste.setText("Mujeres");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(birthDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelHobby, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonChangeBirthDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonChangeName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonChangeAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelSex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelTaste, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelUserSex, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(labelUserTaste, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonAddHobby, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonDelHobby, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(buttonEditHobby, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonChangeSex, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonChangeTaste, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(descriptionArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(birthDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(buttonChangeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonChangeBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonChangeAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionArea, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelHobby, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAddHobby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDelHobby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEditHobby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonChangeSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUserSex, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUserTaste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTaste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonChangeTaste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonAddHobby.setVisible(editable);
        buttonChangeAvatar.setVisible(editable);
        buttonChangeBirthDate.setVisible(editable);
        buttonChangeName.setVisible(editable);
        buttonChangeSex.setVisible(editable);
        buttonChangeTaste.setVisible(editable);
        buttonDelHobby.setVisible(editable);
        buttonEditHobby.setVisible(editable);
    }// </editor-fold>
}
