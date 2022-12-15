import java.util.Vector;

public interface dishesDAO {
	public boolean IsID(Dishes dishes);
	public boolean IsID(String dID);
	public boolean IsCat(String dCat);
	public void AddDish(Dishes dishes);
	public void ModifyDish(Dishes dishes);
	public void DeleteDish(String dID);
	public void DeleteCat(String dCat);
	public Dishes selectByID(String dID);
	public Vector<Dishes> selectByName(String dName);
	public Vector<Dishes> selectByCat(String dCat);
	public Vector<Dishes> selectAll();
	public boolean updateNum(int dID, int num);
}
