package abd.p1.view;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import abd.p1.controller.MainController;
import abd.p1.model.User;

/**
 *
 * @author Capa
 */
public class UserMainPanel extends javax.swing.JPanel {

    /**
     * Creates new form UserMainPanel
     */
    public UserMainPanel(MainController ctrl) {
    	this.ctrl=ctrl;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        textArea1 = new java.awt.TextArea();
        listUsers = new javax.swing.JList<User>();
        checkboxNameFilter = new java.awt.Checkbox();
        checkboxFriendsFilter = new java.awt.Checkbox();
        textFieldNameFilter = new java.awt.TextField();
        jButtonProfileEdit = new javax.swing.JButton();
        jButtonShowProfile = new javax.swing.JButton();

        //listUsers.setCellRenderer(new UserCellRenderer());
        listUsers.setModel(ctrl.getListUserModel());


        jFormattedTextField1.setText("jFormattedTextField1");

        checkboxNameFilter.setLabel("Filtrar por Nombre:");

        checkboxFriendsFilter.setLabel("Mostrar solo Amigos");

        jButtonProfileEdit.setText("Modificar Perfil");

        jButtonShowProfile.setText("Ver Perfil Seleccionado");

        textFieldNameFilter.addActionListener(
        		new AbstractAction()
        		{
        		    @Override
        		    public void actionPerformed(ActionEvent e)
        		    {
                        searchFilterUsers(e);
        		    }
        		}
            );

        jButtonProfileEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProfile(evt);
            }
        });

        jButtonShowProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProfile(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkboxNameFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(textFieldNameFilter, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                    .addComponent(listUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkboxFriendsFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButtonProfileEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonShowProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldNameFilter, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(checkboxNameFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkboxFriendsFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonShowProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jButtonProfileEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>                        


    protected void searchFilterUsers(ActionEvent e) {
        listUsers.setModel(ctrl.getListUserModel(textFieldNameFilter.getText()));
	}

	protected void viewProfile(ActionEvent evt) {
		//int index = listUsers.getSelectedIndex();
		ctrl.setUserToView(listUsers.getSelectedValue());
		new UserProfileFunctionsDialog(null, true,ctrl).setVisible(true);
	}

	protected void editProfile(ActionEvent evt) {
		new UserProfileEdit(null,true,ctrl).setVisible(true);
	}


	// Variables declaration - do not modify                     
    private java.awt.Checkbox checkboxFriendsFilter;
    private java.awt.Checkbox checkboxNameFilter;
    private javax.swing.JButton jButtonProfileEdit;
    private javax.swing.JButton jButtonShowProfile;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JList<User> listUsers;
    private java.awt.TextArea textArea1;
    private java.awt.TextField textFieldNameFilter;
    private MainController ctrl;
    // End of variables declaration                   
}
