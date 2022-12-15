import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;

public class DishesSys implements dishesDAO {

	static Map<String, Dishes> dishesmap = new HashMap<>();
	Set<String> keys = dishesmap.keySet();
	
	@Override
	public void AddDish(Dishes dishes) {
		// TODO Auto-generated method stub
		dishesmap.put(dishes.getdID(), dishes);
			
	}

	@Override
	public void ModifyDish(Dishes dishes) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void DeleteDish(String dID) {
		// TODO Auto-generated method stub
		dishesmap.remove(dID);
	}

	@Override
	public Dishes selectByID(String dID) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Vector<Dishes> selectByName(String dName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Dishes> selectByCat(String dCat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Dishes> selectAll() {
		// TODO Auto-generated method stub
		Vector<Dishes> menu = new Vector<>();
		for (String str: keys) {
			menu.add(dishesmap.get(str));
			//Dishes tmp = dishesmap.get(str);
			//String result = tmp.getdID()+" "+tmp.getdName()+" "+tmp.getdCat()+" "+tmp.getdPrice()+" "+tmp.getdStock()+" "+tmp.getdSales()+" "+tmp.getdDate()+"/n";
			//menu.add(result);
		}
		return menu;
	}

	@Override
	public boolean updateNum(int dID, int num) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean IsID(Dishes dishes) {
		// TODO Auto-generated method stub
		if(dishesmap.containsKey(dishes.getdID())) {
			return true;}
		else {
			return false;
		}
	}

	@Override
	public boolean IsID(String dID) {
		// TODO Auto-generated method stub
		if(dishesmap.containsKey(dID)) {
			return true;}
		else {
			return false;
		}
	}

	@Override
	public boolean IsCat(String dCat) {
		// TODO Auto-generated method stub
		for(String str: keys) {
			Dishes tmp = new Dishes();
			tmp = dishesmap.get(str);
			//String tcat = tmp.getdCat();
			if(Objects.equals(tmp.getdCat(), dCat)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void DeleteCat(String dCat) {
		// TODO Auto-generated method stub
		for(String str: keys) {
			Dishes tmp = dishesmap.get(str);
			if(Objects.equals(tmp.getdCat(), dCat)) {
				tmp.setdCat("");
			}
		}
	}

}
