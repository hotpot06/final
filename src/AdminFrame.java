import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AdminFrame {
	JFrame admins = new JFrame("Input your account number and password");
	JLabel acc = new JLabel("Account");
	JLabel pwd = new JLabel("Passwords");
	JTextField acctxt = new JTextField();
	JTextField pwdtxt = new JTextField();
	JButton submit = new JButton("Login");
	
	public void Admins(AdminSys as, DishesSys ds) {
		acc.setBounds(10, 10, 100, 30);
		acctxt.setBounds(130, 10, 240, 30);
		pwd.setBounds(10, 50, 100, 30);
		pwdtxt.setBounds(130, 50, 240, 30);
		submit.setBounds(260, 90, 100, 30);
		submit.addActionListener(new submitListener(acctxt, pwdtxt, as, ds));
		Font f = new Font("Default",Font.BOLD, 15);
		acc.setFont(f);
		pwd.setFont(f);
		
		//add components and set visibility
		admins.add(acc);
		admins.add(pwd);
		admins.add(acctxt);
		admins.add(pwdtxt);
		admins.add(submit);
		admins.setLayout(null);
		admins.setSize(380, 200);
		admins.setVisible(true);
	}
	
	private class submitListener implements ActionListener{

		JTextField tacc = new JTextField();
		JTextField tpwd = new JTextField();
		private AdminSys as = new AdminSys();
		private DishesSys ds = new DishesSys();
		
		public submitListener(JTextField tacc, JTextField tpwd, AdminSys as, DishesSys ds) {
			this.tacc = tacc;
			this.tpwd = tpwd;
			this.as = as; 
			this.ds = ds;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JDialog inf = new JDialog();
			JButton sure = new JButton("Yes");
			JLabel tip = new JLabel();
			/*sure.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					inf.dispose();
					DishesFrame prep = new DishesFrame();
					prep.Dishes(ds);
					admins.dispose();
				}
				
			});*/
			
			//set Tip box
			sure.setBounds(80,150,100,30);
			tip.setFont(new Font("Default",Font.BOLD, 15));
			tip.setBounds(10, 10, 400, 120);
			inf.setLayout(null);
			//inf.setResizable(false);
			inf.setBounds(10, 100, 400, 200);
			inf.add(tip);
			inf.add(sure);
			
			String account = tacc.getText();
			String passwords = tpwd.getText();
			//find out the specific dish
			if(as.iscorrect(account, passwords)) {
				tip.setText("Success!");
				sure.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						inf.dispose();
						DishesFrame prep = new DishesFrame();
						prep.Dishes(ds);
						admins.dispose();
					}
					
				});
			}else {
				tip.setText("Please input the right ID!");
				sure.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						inf.dispose();
						AdminFrame prep1 = new AdminFrame();
						prep1.Admins(as, ds);
						admins.dispose();
					}
					
				});
			}
			inf.setVisible(true);
		}}
}
