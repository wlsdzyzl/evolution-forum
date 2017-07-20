package register;

import java.sql.SQLException;

public class signUp {

	public static void init(int hid,user_add user_ad) throws ClassNotFoundException, SQLException
	{
		user_ad.connect(hid);
	}
	public static void close(user_add user_ad) throws SQLException
	{
		user_ad.close();
	}
	
	public static userInf subinf(String username,String password,String email,user_add user_ad) throws SQLException
	{
		int status = user_ad.addUser(username, email, password);
		 if(status != 1)
			 return null;
	    return signIn.signin(username, password,user_ad);
		
	}
}
