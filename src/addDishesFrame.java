import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.*;

public class addDishesFrame {
	JFrame add = new JFrame("Add a Dish");
	JLabel id = new JLabel("DishID");
	JLabel name = new JLabel("Name");
	JLabel price = new JLabel("Price");
	JLabel inventory = new JLabel("Inventory");
	JLabel cat = new JLabel("Category");
	JButton submit = new JButton("Submit");
	JButton cancel = new JButton("Cancel");
	JTextField idtxt = new JTextField();
	JTextField nametxt = new JTextField();
	JTextField pricetxt = new JTextField();
	JTextField invtxt = new JTextField();
	JTextField cattxt = new JTextField();
	
	public void Add(DishesSys ds) {
		add.setResizable(false);
		add.setLayout(null);
		Font f = new Font("Default",Font.BOLD, 15);
		id.setFont(f);
		id.setBounds(10, 10, 100, 30);
		idtxt.setBounds(130, 10, 240, 30);
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
		cancel.setBounds(10, 220, 100, 30);
		submit.setBounds(260, 220, 100, 30);
		cancel.addActionListener(new cancelListener(ds));
		submit.addActionListener(new submitListener(idtxt, nametxt, pricetxt, invtxt, cattxt, ds));
		
		//add components
		add.add(id);
		add.add(idtxt);
		add.add(name);
		add.add(nametxt);
		add.add(price);
		add.add(pricetxt);
		add.add(inventory);
		add.add(invtxt);
		add.add(cat);
		add.add(cattxt);
		add.add(cancel);
		add.add(submit);
		
		//set statue
		add.setVisible(true);
		add.setSize(380, 300);
	
	}
	
	private class submitListener implements ActionListener{

		private JTextField did = new JTextField();
		private JTextField dname = new JTextField();
		private JTextField dprice = new JTextField();
		private JTextField dinv = new JTextField();
		private JTextField dcat = new JTextField();
		private DishesSys ds = new DishesSys();
		
		public submitListener(JTextField did, JTextField dname, JTextField dprice, JTextField dinv, JTextField dcat, DishesSys ds) {
			this.did = did;
			this.dname = dname;
			this.dprice = dprice;
			this.dinv = dinv;
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
					addDishesFrame prep3 = new addDishesFrame();
					prep3.Add(ds);
					add.dispose();
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
			
			//get info from JTextfields
			String id = did.getText();
			String name = dname.getText();
			double price = Double.parseDouble(dprice.getText());
			int inv = Integer.parseInt(dinv.getText());
			String cat = dcat.getText();
			LocalDate dddate = LocalDate.now();
			
			if(id.equals("")||name.equals("")||price==0||inv == 0) {
				tip.setText("Fail to add!");
			}else {
				Dishes dish = new Dishes();
				dish.setdID(id);
				dish.setdName(name);
				dish.setdCat(cat);
				dish.setdPrice(price);
				dish.setdStock(inv);
				dish.setdDate(dddate);
				if(ds.IsID(dish)) {
					tip.setText("Fail to add!");
				}else {
					ds.AddDish(dish);
					tip.setText(dish.toString());
				}
				
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
			add.dispose();
		}
		
	}
}
