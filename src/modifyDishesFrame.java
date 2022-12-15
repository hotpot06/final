import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;

import javax.swing.*;


public class modifyDishesFrame {
	JFrame modify = new JFrame("Modify Dishes");
	JTextField idtxt = new JTextField();
	JLabel id = new JLabel("DishID");
	JButton submit = new JButton("Submit");
	JButton cancel = new JButton("Cancel");
	
	public void Modify(DishesSys ds) {
		id.setBounds(10, 10, 100, 30);
		idtxt.setBounds(130, 10, 240, 30);
		submit.setBounds(260, 60, 100, 30);
		cancel.setBounds(10, 60, 100, 30);
		submit.addActionListener(new submitListener(idtxt, ds));
		cancel.addActionListener(new cancelListener(ds));
		Font f = new Font("Default",Font.BOLD, 15);
		id.setFont(f);
		
		//add components and set visibility
		modify.add(id);
		modify.add(cancel);
		modify.add(idtxt);
		modify.add(submit);
		modify.setLayout(null);
		modify.setSize(380, 200);
		modify.setVisible(true);
	
	}
	
	private class submitListener implements ActionListener{

		private JTextField did = new JTextField();
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
				JFrame update = new JFrame("Update a Dish");
				JLabel did = new JLabel("DishID");
				JLabel name = new JLabel("Name");
				JLabel price = new JLabel("Price");
				JLabel inventory = new JLabel("Inventory");
				JLabel cat = new JLabel("Category");
				JButton submit1 = new JButton("Submit");
				JButton cancel1 = new JButton("Cancel");
				JTextField didtxt = new JTextField();
				JTextField nametxt = new JTextField();
				JTextField pricetxt = new JTextField();
				JTextField invtxt = new JTextField();
				JTextField cattxt = new JTextField();
				update.setResizable(false);
				update.setLayout(null);
				Font f = new Font("Default",Font.BOLD, 15);
				did.setFont(f);
				did.setBounds(10, 10, 100, 30);
				didtxt.setBounds(130, 10, 240, 30);
				name.setFont(f);
				name.setBounds(10, 50, 100, 30);
				nametxt.setBounds(130, 50, 240, 30);
				price.setFont(f);
				price.setBounds(10, 90, 100, 30);
				pricetxt.setBounds(130, 90, 240, 30);
				inventory.setFont(f);
				inventory.setBounds(10, 130, 100, 30);
				invtxt.setBounds(130, 130, 240, 30);
				cat.setFont(f);
				cat.setBounds(10, 170, 100, 30);
				cattxt.setBounds(130, 170, 240, 30);
				cancel1.setBounds(10, 220, 100, 30);
				submit1.setBounds(260, 220, 100, 30);
				submit.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String dname = nametxt.getText();
						double dprice = Double.parseDouble(pricetxt.getText());
						int dinv = Integer.parseInt(invtxt.getText());
						String dcat = cattxt.getText();
						LocalDate dddate = LocalDate.now();
						if(did.equals("")||e.equals("")||dprice==0||dinv == 0) {
							tip.setText("Fail to add!");
							sure.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									inf.dispose();
								}
								
							});
						}else {
							Dishes dish = new Dishes();
							dish.setdID(id);
							dish.setdName(dname);
							dish.setdCat(dcat);
							dish.setdPrice(dprice);
							dish.setdStock(dinv);
							dish.setdDate(dddate);
							ds.DeleteDish(id);
							ds.AddDish(dish);
							tip.setText("Update Success!");
							sure.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									inf.dispose();
									update.dispose();
									modifyDishesFrame mdf = new modifyDishesFrame();
									mdf.Modify(ds);
								}
								
							});
							}
							inf.add(tip);
							inf.add(sure);
							inf.setVisible(true);
						}
					});
					update.add(did);
					update.add(didtxt);
					update.add(name);
					update.add(nametxt);
					update.add(cat);
					update.add(cattxt);
					update.add(inventory);
					update.add(invtxt);
					update.add(price);
					update.add(pricetxt);
					update.add(submit1);
					update.add(cancel1);
					update.setVisible(true);
					update.setBounds(0, 0, 380, 300);
					update.addWindowListener(new WindowAdapter() {
	                    @Override
	                    public void windowClosing(WindowEvent e) {
	                    	update.dispose();
	                        modifyDishesFrame mdf1 = new modifyDishesFrame();
	                        mdf1.Modify(ds);
	                    }
	                });
					modify.dispose();
				
			}else {
				tip.setText("Please input the right ID!");
				inf.setVisible(true);
			}
			
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
			modify.dispose();
		}
		
	}
}
