import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class deleteCatFrame {
	JFrame deletecat = new JFrame("Delete Category");
	JTextField cattxt = new JTextField();
	JLabel cat = new JLabel("Category");
	JButton submit = new JButton("Submit");
	JButton cancel = new JButton("Cancel");
	
	public void DeleteCat(DishesSys ds) {
		cat.setBounds(10, 10, 100, 30);
		cattxt.setBounds(130, 10, 240, 30);
		submit.setBounds(260, 60, 100, 30);
		cancel.setBounds(10, 60, 100, 30);
		submit.addActionListener(new submitListener(cattxt, ds));
		cancel.addActionListener(new cancelListener(ds));
		Font f = new Font("Default",Font.BOLD, 15);
		cat.setFont(f);
		
		//add components and set visibility
		deletecat.add(cat);
		deletecat.add(cancel);
		deletecat.add(cattxt);
		deletecat.add(submit);
		deletecat.setLayout(null);
		deletecat.setSize(380, 200);
		deletecat.setVisible(true);
	}
	
	private class submitListener implements ActionListener{

		JTextField dcat = new JTextField();
		private DishesSys ds = new DishesSys();
		
		public submitListener(JTextField dcat, DishesSys ds) {
			this.dcat = dcat;
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
					deleteCatFrame prep4 = new deleteCatFrame();
					prep4.DeleteCat(ds);
					deletecat.dispose();
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
			
			String ddcat = dcat.getText();
			//find out the specific dish
			if(ds.IsCat(ddcat)) {
				ds.DeleteCat(ddcat);
				tip.setText("Success!");
			}else {
				tip.setText("Please input the right Category!");
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
			deletecat.dispose();
		}
		
	}
}
