package abd.p1.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class AvatarPanel extends javax.swing.JPanel {
    private static final int ICON_SIZE = 64;
    private ImageIcon icon;
    private Image rescaledIcon;

    public AvatarPanel(){
        try {
            ImageIcon defaultIcon = new ImageIcon(getClass().getClassLoader().getResource("default.png"));
            this.setPreferredSize(new Dimension(ICON_SIZE, ICON_SIZE));
            this.icon = defaultIcon;
            this.rescaledIcon = defaultIcon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_DEFAULT);
        } catch (NullPointerException npe) {
            System.err.println("Icon not found");
        }
    }

    public AvatarPanel(ImageIcon icon) {
        this.setPreferredSize(new Dimension(ICON_SIZE, ICON_SIZE));
        this.icon = icon;
        this.rescaledIcon = icon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_DEFAULT);
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
        this.rescaledIcon = icon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_DEFAULT);
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(rescaledIcon,0,0,this);
    }

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
}
