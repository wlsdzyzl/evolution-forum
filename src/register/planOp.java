package register;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class planOp {

	
	public static ArrayList<plan> getAllplan(String name,user_add u) throws SQLException
	{
				ResultSet result = u.getPlan(name);
				if(result == null)
				{
					return null;
				}
				else
				{
					
					ArrayList<plan> p = new ArrayList<plan>();
					while(result.next())
					{
						p.add(new plan(result.getInt(1),result.getString(2),result.getInt(3),result.getTimestamp(4),result.getTimestamp(5)));
					}
					return p;
				}
					
	}
	public static ArrayList<plan> getAllplan(int name,user_add user_ad) throws SQLException
	{
				ResultSet result = user_ad.getPlan(name);
				if(result == null)
				{
					return null;
				}
				else
				{
					ArrayList<plan> p = new ArrayList<plan>();
					while(result.next())
					{
						p.add(new plan(result.getInt(1),result.getString(2),result.getInt(3),result.getTimestamp(4),result.getTimestamp(5)));
					}
					return p;
				}
					
	}
	public static void downPlan(String name,int pid,String key,user_add user_ad) throws SQLException
	{
		user_ad.downPlan(name,pid,key);
		
	}
	public static void downPlan(int name ,int pid,String key,user_add user_ad) throws SQLException
	{
		user_ad.downPlan(name,pid,key);
		
	}
	public static void addPlanTable(String name,String key,user_add user_ad) throws SQLException
	{
		user_ad.addPlanTable(name, key);
	}
	public static void addPlanTable(int name,String key,user_add user_ad) throws SQLException
	{
		user_ad.addPlanTable(name, key);
	}
	public static void addPlan(int name,String content,user_add user_ad) throws SQLException
	{
		user_ad.addPlan(name, content);
	}
	public static void addPlan(String name,String content,user_add user_ad) throws SQLException
	{
		user_ad.addPlan(name, content);
	}
	public static ArrayList<String []> getUser(user_add user_ad) throws SQLException
	{
		ResultSet result = user_ad.selectAllName();
		ArrayList<String []> res = new ArrayList<String []>();
		while(result.next())
		{
			String []a = {result.getString(1),result.getString(2)};
			res.add(a);
			//System.out.println(a[0]+","+a[1]);
		}
		return res;
	}
	public static String getKey(String name,user_add user_ad) throws SQLException {
		// TODO Auto-generated method stub
		if(name == null)
			return null;
		return user_ad.getKey(name);
	}

}
