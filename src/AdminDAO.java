
public interface AdminDAO {
	public boolean iscorrect(String acc, String pwd);
	public boolean isexists(String acc);
	public void addAdmin(Admin admin);
}
