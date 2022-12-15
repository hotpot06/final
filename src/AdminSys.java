import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class AdminSys implements AdminDAO{
	static Map<String, Admin> adminsmap = new HashMap<>();
	Set<String> keys = adminsmap.keySet();

	@Override
	public boolean iscorrect(String acc, String pwd) {
		// TODO Auto-generated method stub
		for(String account: keys) {
			if(Objects.equals(account, acc)) {
				if(Objects.equals(adminsmap.get(account).getapwd(), pwd)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminsmap.put(admin.getaccount(), admin);
	}

	@Override
	public boolean isexists(String acc) {
		// TODO Auto-generated method stub
		if(adminsmap.containsKey(acc)) {
			return true;
		}
		return false;
	}

}
