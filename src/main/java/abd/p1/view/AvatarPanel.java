/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Capa
 */
public class AvatarPanel extends javax.swing.JPanel {
    private static final ImageIcon defaultIcon =
            new ImageIcon(AvatarPanel.class.getResource("default.png"));
    private static final int SIZE = 64;

    private ImageIcon icon;
    private Image rescaledIcon;



    public AvatarPanel(){
        this(defaultIcon);
    }
    /**
     * Creates new form AvatarPanel
     */
    public AvatarPanel(ImageIcon icon) {
        this.setPreferredSize(new Dimension(SIZE, SIZE));
        this.icon = icon;
        this.rescaledIcon = icon.getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT);
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
        this.rescaledIcon = icon.getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT);
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(rescaledIcon,0,0,this);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    // End of variables declaration                   
}