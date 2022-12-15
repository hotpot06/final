import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DishesFrame {
	JFrame dishes = new JFrame("Dishes Management");
	JButton addDishes = new JButton("Add Dishes");
	JButton deleteDishes = new JButton("Delete Dishes");
	JButton deleteCat = new JButton("Delete a Category");
	JButton modifyDishes = new JButton("Modify Dishes");
	JButton viewDishes = new JButton("View the List of Dishes");
	JButton selectByID = new JButton("View Dishes by ID");
	JButton selectByCat = new JButton("View Dishes By Category");
	//JButton viewOrders = new JButton("View All Orders");
	
	public void Dishes(DishesSys ds) {
		dishes.setResizable(false);
		dishes.setLayout(null);
		addDishes.setBounds(10, 10, 450, 30);
		addDishes.addActionListener(new addListener(ds));
		deleteDishes.setBounds(10, 50, 450, 30);
		deleteDishes.addActionListener(new deleteListener(ds));
		deleteCat.setBounds(10, 90, 450, 30);
		deleteCat.addActionListener(new deleteCListener(ds));
		modifyDishes.setBounds(10, 130, 450, 30);
		modifyDishes.addActionListener(new modifyListener(ds));
		viewDishes.setBounds(10, 170, 450, 30);
		viewDishes.addActionListener(new viewListener(ds));
		//viewOrders.setBounds(10, 210, 450, 30);
		//viewOrders.addActionListener(new viewOListener());
		
		//add components
		dishes.add(addDishes);
		dishes.add(deleteDishes);
		dishes.add(deleteCat);
		dishes.add(modifyDishes);
		dishes.add(viewDishes);
		//dishes.add(viewOrders);
		
		//set size and visibility
		dishes.setVisible(true);
		dishes.setSize(470, 300);
		dishes.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	private class addListener implements ActionListener
	{

		private DishesSys ds = new DishesSys();
		public addListener(DishesSys ds) {
			this.ds = ds;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			addDishesFrame prep1 =new addDishesFrame();
			prep1.Add(ds);
			dishes.dispose();
		}
		
	}
	
	private class deleteListener implements ActionListener
	{

		private DishesSys ds = new DishesSys();
		public deleteListener(DishesSys ds) {
			this.ds = ds;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			deleteDishesFrame prep2 = new deleteDishesFrame();
			prep2.Delete(ds);
			dishes.dispose();
		}
		
	}
	
	private class deleteCListener implements ActionListener
	{
		private DishesSys ds = new DishesSys();
		public deleteCListener(DishesSys ds) {
			this.ds = ds;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			deleteCatFrame prep2 = new deleteCatFrame();
			prep2.DeleteCat(ds);
			dishes.dispose();
		}
		
	}
	
	private class modifyListener implements ActionListener
	{
		private DishesSys ds = new DishesSys();
		public modifyListener(DishesSys ds) {
			this.ds = ds;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			modifyDishesFrame prep3 = new modifyDishesFrame();
			prep3.Modify(ds);
			dishes.dispose();
		}
		
	}
	
	private class viewListener implements ActionListener
	{
		private DishesSys ds = new DishesSys();
		public viewListener(DishesSys ds) {
			this.ds = ds;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			viewDishesFrame prep4 = new viewDishesFrame();
			prep4.View(ds);
			dishes.dispose();
		}
		
	}
	
	/*private class viewOListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}*/
}
