import java.time.LocalDate;


public class Dishes {
	private String dID;
	private String dCat;
	private String dName;
	private double dPrice;
	private int dSales;
	private int dStock;
	private LocalDate dDate;
	
	public Dishes() {}
	
	public Dishes(String dID, String dCat, String dName, double dPrice, int dSales, int dStock, LocalDate dDate) {
		super();
		this.dID = dID;
		this.dCat = dCat;
		this.dName = dName;
		this.dPrice = dPrice;
		this.dSales = dSales;
		this.dStock = dStock;
		this.dDate = dDate;
	}
	
	public String getdID() {
		return dID;
	}
	
	public void setdID(String dID) {
		this.dID = dID;
	}
	
	public String getdCat() {
		return dCat;
	}
	
	public void setdCat(String dCat) {
		this.dCat = dCat;
	}
	
	public String getdName() {
		return dName;
	}
	
	public void setdName(String dName) {
		this.dName = dName;
	}
	
	public double getdPrice() {
		return dPrice;
	}
	
	public void setdPrice(double dPrice) {
		this.dPrice = dPrice;
	}
	
	public int getdSales() {
		return dSales;
	}
	
	public void setdSales(int dSales) {
		this.dSales = dSales;
	}
	
	public int getdStock() {
		return dStock;
	}
	
	public void setdStock(int dStock) {
		this.dStock = dStock;
	}
	
	public LocalDate getdDate() {
		return dDate;
	}
	
	public void setdDate(LocalDate dDate) {
		this.dDate = dDate;
	}
	
	@Override
	public String toString() {
		return "<html><body>Dishes: ID="+dID+", Category="+dCat+",<br>Name:"+dName+", Price="+dPrice+",<br>Stocks="+dStock+", Sales="+dSales+",<br>Date="+dDate+"</body></html";
	}
}
