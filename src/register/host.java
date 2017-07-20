package register;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class host {
int hid;
String name;
public int getHid()
{
	return hid;
}
public String getName()
{
	return name;
}
public host(int id,String Name)
{
	hid = id;
	name = Name;
}
public static ArrayList<host> getAllHost(user_add u) throws SQLException
{
	ArrayList<host> hosts = new ArrayList();
	ResultSet result = u.getAllHost();
	while(result.next())
	{
		hosts.add(new host(result.getInt(1),result.getString(2)));
	}
	return hosts;
}
}
