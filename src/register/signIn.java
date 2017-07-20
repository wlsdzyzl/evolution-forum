package register;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class signIn {

	public static void init(int hid,user_add user_ad) throws ClassNotFoundException, SQLException
	{
		user_ad.connect(hid);
	}
	public static void close(user_add user_ad) throws SQLException
	{
		user_ad.close();
	}
   public static String[] verifiCookie(Cookie c[],int hid,user_add user_ad) 
	{
		String []res = new String [3];
		res[0] = null;
		res[1] = "no";
		res[2]= null;
		if(c == null)
			return res;
		try{
		
		for(int i = 0;i<c.length;i++)
		{
			Cookie cookie = c[i];
			if(cookie.getName().equals("myevolutionUsername"))
			{
				String username = cookie.getValue();
				int id[] = null;
				if((id = user_ad.selectUserIdNews(username))!=null)
				{
				res[0] =username;
				if(id[0] == hid)
					res[1] = "yes";
				else res[1] = "no";
				res[2] = id[1]+"";
				System.out.println("回复+"+res[2]);
				user_ad.clearNews(id[0]);
				break;
				}
			}
		
		}

		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return res;
	}
	public static userInf signin(String username,String password,user_add user_ad) throws SQLException
	{
		System.out.printf("username:%s\npassword:%s\n",username,password);
		ResultSet res = user_ad.selectUser(username);
		
		if(res.next()&&res.getString(4).equals(password))
		{
			userInf useinf = new userInf(res.getInt(1),username,res.getString(3),res.getInt(5));
			user_ad.clearNews(res.getInt(1));
			
			return useinf;
		}
		return null;
	}
}
