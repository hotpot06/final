
public class Admin {
	private String aID;
	private String account;
	private String apwd;
	
	public Admin() {
		
	}
	public Admin(String aID, String account, String apwd) {
		super();
		this.aID = aID;
		this.account = account;
		this.apwd = apwd;
	}
	
	public void setaID(String aID) {
		this.aID = aID;
	}
	
	public String getaID() {
		return aID;
	}
	
	public void setaccount(String account) {
		this.account = account;
	}
	
	public String getaccount() {
		return account;
	}
	
	public void setapwd(String apwd) {
		this.apwd = apwd;
	}
	
	public String getapwd() {
		return apwd;
	}
	
	@Override
	public String toString() {
		return "Admin: aID=" + aID + ", account=" + account +", apwd=" + apwd;
	}
	
}
