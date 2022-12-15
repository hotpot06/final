import java.time.LocalDateTime;

public class Order {
	private String oID;
	private Dishes dishes;
	private String uID;
	private double oPrice;
	private int oNum;
	private LocalDateTime oTime;
	
	
	public Order() {}
	
	public Order(String oID, Dishes dishes, String uID, double oPrice, int oNum, LocalDateTime oTime) {
		super();
		this.oID = oID;
		this.dishes = dishes;
		this.uID = uID;
		this.oPrice = oPrice;
		this.oNum = oNum;
		this.oTime = oTime;
	}
	
	public void setoID(String oID) {
		this.oID = oID;
	}
	
	public String getoID() {
		return oID;
	}
	
	public void setdishes(Dishes dishes) {
		this.dishes = dishes;
	}
	
	public Dishes getdishes() {
		return dishes;
	}
	
	public void setuID(String uID) {
		this.uID = uID;
	}
	
	public String getuID() {
		return uID;
	}
	
	public void setoPrice(double oPrice) {
		this.oPrice = oPrice;
	}
	
	public double getoPrice() {
		return oPrice;
	}
	
	public void setoNum(int oNum) {
		this.oNum = oNum;
	}
	
	public int getoNum() {
		return oNum;
	}
	
	public void setoTime(LocalDateTime oTime) {
		this.oTime = oTime;
	}
	
	public LocalDateTime getoTime() {
		return oTime;
	}
	
	@Override
	public String toString() {
		return "Order: ID:"+oID+", dishes:"+dishes+", user ID:"+uID+", Price:"+oPrice+", Num:"+oNum+", Order Time:"+oTime;
	}
}
