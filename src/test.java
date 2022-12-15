

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// set the account
		Admin ad = new Admin();
		ad.setaID("111");
		ad.setaccount("Admin");
		ad.setapwd("password");
		AdminSys as = new AdminSys();
		as.addAdmin(ad);
		
		DishesSys ds = new DishesSys();
		
		AdminFrame testcases = new AdminFrame();
		testcases.Admins(as, ds);
		
		
		//DishesFrame testcase = new DishesFrame();
		//testcase.Dishes(ds);
	}

	
}
