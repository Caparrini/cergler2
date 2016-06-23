package abd.p1.view;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;
import abd.p1.model.User;

public class UserCellRenderer extends UserPanel implements ListCellRenderer<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<? extends User> list,
			User value, int index, boolean isSelected, boolean cellHasFocus) {
		this.setAge(3);
		this.setName("Rodri");
		this.setOpaque(true);;
		if(isSelected){
			this.setBackground(Color.ORANGE);
		}else{
			this.setBackground(Color.WHITE);
		}
		return this;
	}

}
