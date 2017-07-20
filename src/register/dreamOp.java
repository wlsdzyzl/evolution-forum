package register;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class dreamOp {
	
	public static ArrayList<plan> getAllDream(String name,user_add u) throws SQLException
	{
				ResultSet result = u.getDream(name);
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
	public static ArrayList<plan> getAllDream(int name,user_add u) throws SQLException
	{
				ResultSet result = u.getDream(name);
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
	public static void downDream(String name,int pid,user_add u) throws SQLException
	{
		u.downDream(name,pid);
		
	}
	public static void downDream(int name ,int pid,user_add u) throws SQLException
	{
		u.downDream(name,pid);
		
	}
	public static void addDream(int name,String content,user_add u) throws SQLException
	{
		u.addDream(name, content);
	}
	public static void addDream(String name,String content,user_add u) throws SQLException
	{
		u.addDream(name, content);
	}
}
