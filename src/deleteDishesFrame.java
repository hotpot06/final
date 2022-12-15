import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class deleteDishesFrame {
	JFrame delete = new JFrame("Delete Dishes");
	JTextField idtxt = new JTextField();
	JLabel id = new JLabel("DishID");
	JButton submit = new JButton("Submit");
	JButton cancel = new JButton("Cancel");
	
	public void Delete(DishesSys ds) {
		id.setBounds(10, 10, 100, 30);
		idtxt.setBounds(130, 10, 240, 30);
		submit.setBounds(260, 60, 100, 30);
		cancel.setBounds(10, 60, 100, 30);
		submit.addActionListener(new submitListener(idtxt, ds));
		cancel.addActionListener(new cancelListener(ds));
		Font f = new Font("Default",Font.BOLD, 15);
		id.setFont(f);
		
		//add components and set visibility
		delete.add(id);
		delete.add(cancel);
		delete.add(idtxt);
		delete.add(submit);
		delete.setLayout(null);
		delete.setSize(380, 200);
		delete.setVisible(true);
	}
	
	private class submitListener implements ActionListener{

		JTextField did = new JTextField();
		private DishesSys ds = new DishesSys();
		
		public submitListener(JTextField did, DishesSys ds) {
			this.did = did;
			this.ds = ds;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JDialog inf = new JDialog();
			JButton sure = new JButton("Yes");
			JLabel tip = new JLabel();
			sure.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					inf.dispose();
					deleteDishesFrame prep4 = new deleteDishesFrame();
					prep4.Delete(ds);
					delete.dispose();
				}
				
			});
			
			//set Tip box
			sure.setBounds(80,150,100,30);
			tip.setFont(new Font("Default",Font.BOLD, 15));
			tip.setBounds(10, 10, 400, 120);
			inf.setLayout(null);
			//inf.setResizable(false);
			inf.setBounds(10, 100, 400, 200);
			inf.add(tip);
			inf.add(sure);
			
			String id = did.getText();
			//find out the specific dish
			if(ds.IsID(id)) {
				ds.DeleteDish(id);
				tip.setText("Success!");
			}else {
				tip.setText("Please input the right ID!");
			}
			inf.setVisible(true);
		}
		
	}
	
	private class cancelListener implements ActionListener{

		private DishesSys ds = new DishesSys();
		public cancelListener(DishesSys ds) {
			this.ds = ds;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DishesFrame prep2 = new DishesFrame();
			prep2.Dishes(ds);
			delete.dispose();
		}
		
	}
}
