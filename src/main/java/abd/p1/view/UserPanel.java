package abd.p1.view;

import javax.swing.ImageIcon;

/**
 *
 * @author Capa
 */
public class UserPanel extends javax.swing.JPanel {

    /**
     * Creates new form userPanel
     */
    public UserPanel() {
        initComponents();
    }
    public void setName(String n){
        labelNameUser.setText(n);
    }
    public void setAge(int a){
        labelAge.setText(""+a);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        avatarPanel1 = new AvatarPanel();
        labelNameUser = new java.awt.Label();
        labelAge = new java.awt.Label();

        javax.swing.GroupLayout avatarPanel1Layout = new javax.swing.GroupLayout(avatarPanel1);
        avatarPanel1.setLayout(avatarPanel1Layout);
        avatarPanel1Layout.setHorizontalGroup(
            avatarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        avatarPanel1Layout.setVerticalGroup(
            avatarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        labelNameUser.setFont(new java.awt.Font("Malayalam MN", 1, 18)); // NOI18N
        labelNameUser.setText("UserName");

        labelAge.setText("Age");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(avatarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNameUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(avatarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>                        
    // Variables declaration - do not modify                     
    private AvatarPanel avatarPanel1;
    private java.awt.Label labelAge;
    private java.awt.Label labelNameUser;
    // End of variables declaration                   
	public void setIcon(ImageIcon imageIcon) {
		avatarPanel1.setIcon(imageIcon);
	}
	public byte[] getIcon() {
		return avatarPanel1.getIcon();
	}
	public String getUserName() {
		return labelNameUser.getText();
	}
}

