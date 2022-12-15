import java.time.LocalDateTime;

public class Users {
	private String uID;
	private String upwd;
	private String LastName;
	private String uName;
	private String uPhone;
	private LocalDateTime uTime;
	
	public Users() {}
	
	public Users(String uID, String upwd, String uName, String LastName, String uPhone, LocalDateTime uTime) {
		super();
		this.uID = uID;
		this.upwd = upwd;
		this.uName = uName;
		this.LastName = LastName;
		this.uPhone = uPhone;
		this.uTime= uTime;
	}
	
	public void setuID(String uID) {
		this.uID = uID;
	}
	
	public String getuID() {
		return uID;
	}
	
	public void setupwd(String upwd) {
		this.upwd = upwd;
	}
	
	public String getupwd() {
		return upwd;
	}
	
	public void setuName(String uName) {
		this.uName = uName;
	}
	
	public String getuName() {
		return uName;
	}
	
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	
	public String getLastName() {
		return LastName;
	}
	
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	} 
	
	public String getuPhone() {
		return uPhone;
	}
	
	public void setuTime(LocalDateTime uTime) {
		this.uTime = uTime;
	}
	
	@Override
	public String toString() {
		return "User: ID="+uID+", User Password="+upwd+", User Name="+uName+", LastName="+uName+"  Phone="+uPhone+", Time="+uTime;
	}
	
}
