package abd.p1.view;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import abd.p1.controller.MainController;
import abd.p1.model.User;

public class UserCellRenderer extends UserPanel implements ListCellRenderer<User>{

	public UserCellRenderer(){
		super();
		this.setOpaque(true);
	}
	@Override
	public Component getListCellRendererComponent(JList<? extends User> list,
			User value, int index, boolean isSelected, boolean cellHasFocus) {
		System.out.println(index);
		this.setAge(3);
		this.setName("Rodri");
        try{
        	this.setIcon(new ImageIcon(value.getIcon()));
        }catch(Exception e){
        	System.err.println("There are no pic");
        }
		if(isSelected){
			this.setBackground(Color.ORANGE);
		}else{
			this.setBackground(Color.WHITE);
		}
		return this;
	}

}
