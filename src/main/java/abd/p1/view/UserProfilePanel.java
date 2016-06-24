package abd.p1.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Base64;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import abd.p1.model.Gender;
import abd.p1.model.User;

/**
 *
 * @author Capa
 */
public class UserProfilePanel extends javax.swing.JPanel {

    /**
     * Creates new form UserProfilePanel
     */
    public UserProfilePanel(boolean editable) {
    	this.editable = editable;
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

        userPanel1 = new UserPanel();
        buttonChangeName = new java.awt.Button();
        buttonChangeBirthDate = new java.awt.Button();
        labelDescription = new java.awt.Label();
        textArea1 = new java.awt.TextArea();
        labelHobby = new java.awt.Label();
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
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        buttonChangeName.setLabel("Cambiar Nombre");
        buttonChangeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeNameActionPerformed(evt);
            }
        });
        buttonChangeBirthDate.setLabel("Cambiar Fecha Nacimiento");
        buttonChangeBirthDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeBirthDateActionPerformed(evt);
            }
        });


        labelDescription.setText("Descripción:");

        labelHobby.setText("Aficiones:");

        buttonChangeAvatar.setLabel("Cambiar Avatar");
        buttonChangeAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarAvatarActionPerformed(evt);
            }
        });
        labelSex.setText("Sexo:");

        labelTaste.setText("Busca:");

        buttonAddHobby.setLabel("Añadir Afición");
        buttonAddHobby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHobbyEvent(evt);
            }
        });
        buttonDelHobby.setLabel("Eliminar Af. Seleccionada");
        buttonDelHobby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDelHobbyActionPerformed(evt);
            }
        });

        buttonEditHobby.setLabel("Edita Af. Seleccionada");
        buttonEditHobby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editHobbyActionPerformed(evt);
            }
        });
        buttonChangeSex.setLabel("Cambiar Sexo");
        buttonChangeSex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeSexActionPerformed(evt);
            }
        });

        buttonChangeTaste.setLabel("Cambiar Preferencia");
        buttonChangeTaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeTasteActionPerformed(evt);
            }
        });
        labelUserSex.setText("Masculino");

        labelUserTaste.setText("Mujeres");

        buttonAddHobby.setVisible(editable);
        buttonDelHobby.setVisible(editable);
        buttonEditHobby.setVisible(editable);
        buttonChangeSex.setVisible(editable);
        buttonChangeTaste.setVisible(editable);
        buttonChangeName.setVisible(editable);
        buttonChangeBirthDate.setVisible(editable);
        buttonChangeAvatar.setVisible(editable);
        jDateChooser1.setEnabled(editable);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(textArea1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(buttonChangeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonChangeBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonChangeAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    }// </editor-fold>                        
    protected void buttonChangeNameActionPerformed(ActionEvent evt) {
    	String name = JOptionPane.showInputDialog("Cambiar nombre");
    	userPanel1.setName(name);
	}

	protected void changeTasteActionPerformed(ActionEvent evt) {
    	String[] options = new String[] {"Hombres","Mujeres","Hombres/Mujeres"};
        int response = JOptionPane.showOptionDialog(null, "Cambia gusto", "Cambio",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, options[2]);
        switch(response){
        	case 0:labelUserTaste.setText(options[response]);break;
        	case 1:labelUserTaste.setText(options[response]);break;
        	case 2:labelUserTaste.setText(options[response]);break;
        	default:break;
        }
	}

	protected void changeSexActionPerformed(ActionEvent evt) {
    	String[] options = new String[] {"Hombre","Mujer"};
        int response = JOptionPane.showOptionDialog(null, "Cambia sexo", "Cambio",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, options[1]);
        switch(response){
        	case 0:labelUserSex.setText(options[response]);break;
        	case 1:labelUserSex.setText(options[response]);break;
        	default:break;
        }
	}

	protected void editHobbyActionPerformed(ActionEvent evt) {
    	int index = list1.getSelectedIndex();
    	String hobby = JOptionPane.showInputDialog("Edita hobby");
    	list1.replaceItem(hobby, index);
	}

	protected void addHobbyEvent(ActionEvent evt) {
    	String hobby = JOptionPane.showInputDialog("Introduce hobby");
    	list1.add(hobby);

	}

	protected void cambiarAvatarActionPerformed(ActionEvent evt) {
		JFileChooser a = new JFileChooser();
		Component paintingChild = null;
		int returnVal = a.showOpenDialog(paintingChild);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = a.getSelectedFile();
	        try{
	        	userPanel1.setIcon(new ImageIcon(file.toString()));
	        }catch(Exception e){
	        	System.err.println("There are no pic");
	        }

        }
	}

	public void setUser(User u){
    	//Cambiar foto TODO
    	userPanel1.setName(u.getUsername());
    	userPanel1.setAge(u.getAge());
    	
        textArea1.setText(u.getDesc());
        List<String> intereses = u.getIntereses();
        for(int i=0; i<intereses.size(); i++){
        	list1.add(intereses.get(i));
        }
        
        labelUserSex.setText(u.getSex());

        labelUserTaste.setText(u.getTaste());
        jDateChooser1.setDate(u.getBirthDate());
        try{
        	userPanel1.setIcon(new ImageIcon(u.getIcon()));
        }catch(Exception e){
        	System.err.println("There are no pic");
        }
    }

    private void buttonDelHobbyActionPerformed(java.awt.event.ActionEvent evt) {                                               
    	int index = list1.getSelectedIndex();
    	list1.remove(index);
    }                                              

    private void buttonChangeBirthDateActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     
	public User getUserData() {
		User aux = new User();
		aux.setBirthDate(jDateChooser1.getDate());
		aux.setDescription(textArea1.getText());
		aux.setGender(labelSex.getText());
		aux.setGenderPreference(labelTaste.getText());
		aux.setUsername(userPanel1.getUserName());
		aux.setProfileImage(userPanel1.getIcon());
		//aux.setPassword(p);
		return aux;
	}

    // Variables declaration - do not modify                     
    private java.awt.Button buttonAddHobby;
    private java.awt.Button buttonChangeAvatar;
    private java.awt.Button buttonChangeBirthDate;
    private java.awt.Button buttonChangeName;
    private java.awt.Button buttonChangeSex;
    private java.awt.Button buttonChangeTaste;
    private java.awt.Button buttonDelHobby;
    private java.awt.Button buttonEditHobby;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private java.awt.Label labelDescription;
    private java.awt.Label labelHobby;
    private java.awt.Label labelSex;
    private java.awt.Label labelTaste;
    private java.awt.Label labelUserSex;
    private java.awt.Label labelUserTaste;
    private java.awt.List list1;
    private java.awt.TextArea textArea1;
    private UserPanel userPanel1;
    private boolean editable;
    // End of variables declaration                   

}
