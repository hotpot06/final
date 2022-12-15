import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.*;

public class viewDishesFrame {
	DefaultListModel<Dishes> model = new DefaultListModel<Dishes>();
	JScrollPane js = new JScrollPane();
	JList<Dishes> result = new JList<Dishes>();
	JFrame view = new JFrame("View Dishes Info");
	JButton submit = new JButton("Back");
	
	public void View(DishesSys ds) {
		result.setModel(model);
		view.setResizable(false);
		view.setLayout(null);
		submit.setBounds(260, 220, 100, 30);
		submit.addActionListener(new submitListener(ds));
		//MyCellRenderer cellRenderer = new MyCellRenderer(100);
		Vector<Dishes> menu = ds.selectAll();
		//result.setCellRenderer(cellRenderer);
		model.removeAllElements();
		for(Dishes str: menu) {
			model.addElement(str);
		}
		
		js.setBounds(10, 10, 400, 200);
		js.setViewportView(result);
		
		view.add(submit);
		view.add(js);
		view.setVisible(true);
		view.setBounds(0, 0, 500, 300);
		

	}
	
	private class submitListener implements ActionListener{

		private DishesSys ds = new DishesSys();
		
		public submitListener(DishesSys ds) {
			this.ds = ds;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			DishesFrame prep2 = new DishesFrame();
			prep2.Dishes(ds);
			view.dispose();
		}
		}
	
	/*class MyCellRenderer extends DefaultListCellRenderer{
		  public static final String HTML_1 = "<html><body style='width: ";
		  public static final String HTML_2 = "px'>";
		  public static final String HTML_3 = "</html>";
		  private int width;
		  
		  public MyCellRenderer(int width) {
			  this.width = width;
		  }
		  
		  @Override
		  public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			  String text = HTML_1 + String.valueOf(width) + HTML_2 + value.toString()
		        + HTML_3;
			  return super.getListCellRendererComponent(list, text, index, isSelected,
		        cellHasFocus);
		  }
	}*/
	
	  
	
}
