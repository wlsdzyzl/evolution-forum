package register;
import java.sql.*;
import com.mysql.jdbc.Driver;
import java.io.*;
import java.util.Date;

import javax.servlet.http.Cookie;

import org.apache.tomcat.util.http.Cookies;
public class user_add {

	  public static final String url= "jdbc:mysql://127.0.0.1:3306/my_evolution";
	  
	  public static final String driver = "com.mysql.jdbc.Driver";
	  
	  public static final String user = "root";
	  
	  public static final String password = "zgq19961001";
	  
	  public  Connection conn;
	  
	  public  Statement state;
	  
	  public  int count;
	  public  int messagecount;
	  
	  public  int articlecount;
	  public  int hcount;
	  public  int hid;
	  public  String messageTableName;
	  public  String articleTableName;
	  public  String responses;
	  public  Connection getConnect()
	  {
		  return conn;
	  }
	  public  void firstOpen() throws SQLException, ClassNotFoundException
	  {
		  System.out.println("connect to the datebase...");
		  Class.forName(driver);
		  conn = DriverManager.getConnection(url,user,password);
		  state = conn.createStatement();
		  setCommit(false);
		  createUserList();
		  createMessage(hid);
		  createArticleList(hid);
		   ResultSet result = state.executeQuery("select count(id) from article");
		   
		   if(result.next())
			   articlecount=result.getInt(1);
		  for (int i = 0;i!=articlecount;++i)
			  state.executeUpdate("drop table _"+i);
		  conn.close();
	  }
	  public  void connect(int hi) throws SQLException, ClassNotFoundException
	  {
		  System.out.println("connect to the datebase...");
		  Class.forName(driver);
		  conn = DriverManager.getConnection(url,user,password);
		  state = conn.createStatement();
		  //createUserList();
		  hid = hi;
		  ResultSet result = state.executeQuery("select count(*) from hosts where id = "+hid);
		  if(result.next())
			  if(result.getInt(1) != 1)
			  {
				  conn.close();
				  return;
			  }
		   result = state.executeQuery("select count(id) from user_inf");
		  if(result.next())
		  count = result.getInt(1);
		  else count = 0;
		   result = state.executeQuery("select count(id) from hosts");
		  if(result.next())
		  hcount = result.getInt(1);
		  else hcount = 0;
		  setCommit(false);
		  //createMessage();
		   if(hid == 0)
		   { 
			   messageTableName = "message";
		     articleTableName = "article";
		     }
		   else {
			   articleTableName = "article"+hid;
			   messageTableName = "message"+hid;
		   }
		   responses = "message"+hid;
		   if(hid == 0) responses = "message";
		   result = state.executeQuery("select count(id) from "+messageTableName);
		  
		   if(result.next())
			   messagecount = result.getInt(1);
		   else messagecount = 0;
		   try
		   {
			  //createArticleList();
		   result = state.executeQuery("select count(id) from "+articleTableName);
		   
		   if(result.next())
			   articlecount=result.getInt(1);
		   else articlecount=0;
		   }catch (Exception e)
		   {
			   createArticleList(hid);
			   articlecount=0;
		   }
		   
		   System.out.println("user:"+count+"\nmessage:"+messagecount+"\narticle:"+articlecount+"\nhostId:"+hid+"\nhosts:"+hcount);
	  }
	  public  void commit() throws SQLException
	  {
		  conn.commit();
	  }
	  public  void setCommit(boolean b)throws SQLException
	  {
		  conn.setAutoCommit(b);
	  }
	  public void close() throws SQLException
	  {
			conn.close();
	  }
	  public ResultSet getOneArticle(int id) throws SQLException
	  {
		  return state.executeQuery("select * from "+articleTableName+" where id = "+id);
	  }
	  public  void createUserList() throws SQLException
	  {
		  state.executeUpdate("drop table user_inf");
		  state.executeUpdate("create table user_inf(id int(6) not null primary key, name char(25) not null,email char (25) not null,"
		  		+ "password char (25) not null,message int not null)");
	  }
	  public  int addUser(String user,String email,String password) 
	  {
		  try
		  {
		  if(selectUserIdNews(user)!=null)
		  {
			  System.out.println("the UserName is already exist!\n");
			  return 0;
	      }
		  String sql = "insert into user_inf values("+count+",'"+user+"','"+email+"','"+password+"',0,null,'http://120.25.247.220:8080/my_evolution/avatar/1.png'";
		  for(int i = 1;i<hcount;++i)
			  sql+=",0";
		  sql+=")";
		   state.executeUpdate(sql);
		   
			   count++;
			   //conn.commit();
			   System.out.println("Insert Successfully!");	   
			   
			   return 1;
		  }catch( SQLException e)
		  {
			   e.printStackTrace();
			   System.out.println("Unknown Error!");
			   return -1;
		  }

		   
	  }
	  protected  ResultSet selectUser(String user) throws SQLException 
	  {
		 

			return state.executeQuery("select * from user_inf where name = '"+user+"'");

	  }
	  public  int[] selectUserIdNews(String user) throws SQLException 
	  {
		  ResultSet result;

			result = state.executeQuery("select id,"+responses+" from user_inf where name = '"+user+"'");
			  if(!result.next())
				  return null;
			  int []a = new int[2];
			  a[0] = result.getInt(1);
			  a[1] = result.getInt(2);
			  return a;
	  }
	  public  boolean changePass(String user ,String oldp,String newp) 
	  {
		  String thepass = null;
		try {
			ResultSet res = selectUser(user);
			if(res.next())
			thepass = res.getString(4);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		  if(thepass == null)
		  {
			  System.out.println("The username doesn't exist!");
			  return false;
		  }
		  if(!thepass.equals(oldp))
		  {
			  System.out.println("The old password is not correct!\n");
			  return false;
		  }
		  try
		  {
		 state.executeUpdate("update user_inf set password = '"+newp+"' where name = '"+user+"'");
		 System.out.println("password has been updated!");
		 return true;
		  }catch(SQLException e)
		  {
			  e.printStackTrace();
			  return false;
		  }
	  }
	  public  void selectAll() throws SQLException
	  {
		  ResultSet result = state.executeQuery("select * from user_inf");
		  System.out.println("id     name                 password");
		  while(result.next())
		  {
			  System.out.printf("%-6d %-20s %-30s %-20s\n",result.getInt(1),result.getString(2),result.getString(3),result.getString(4));
		  }
	  }
	  public void selectAllMessage() throws SQLException
	  {
		  ResultSet result = state.executeQuery("select * from message");
		  System.out.println("id     name                 message                   date                  response");
		  while(result.next())
		  {
			  System.out.printf("%-6d %-20s %-25s %-20s %-6d\n",result.getInt(1),result.getString(2),result.getString(3).substring(0,10)+"...",result.getTimestamp(4).toString(),result.getInt(5));
		  }  
	  }
	  public void createMessage(int id) throws SQLException
	  {
		 //state.executeUpdate("drop table "+messageTableName);
		  String tablename = "message"+id;
		  state.executeUpdate("create table "+tablename+" (id int(6) not null primary key, name char(20) not null , content text not null ,  thetime datetime not null ,"
		  		+ " response int  not null)");
		  commit();
	  }
	  public void message(String username,String message,int response) throws SQLException
	  {
		 try
		 {
			 String sql = " insert into "+messageTableName+" values (?,?,?,?,?)";
		 
		  PreparedStatement ps = conn.prepareStatement(sql);
		  ps.setInt(1, messagecount);
		  ps.setString(2, username);
		  ps.setString(3, message);
		  
		  ps.setTimestamp(4, new Timestamp(new Date().getTime()));
		  ps.setInt(5, response);
		ps.executeUpdate();
		if(response!=-1)
		{
			String toname = "";
			ResultSet res = state.executeQuery("select name from "+messageTableName+" where id = "+response);
			if(res.next()) toname=res.getString(1);
			int news = 0,to = 0;

			 res = state.executeQuery("select id,"+responses+" from user_inf where name = '"+toname+"'");
			 if(res.next())
			 {
				 to = res.getInt(1);
				 news = res.getInt(2);
			 }
			 news+=1;
			state.executeUpdate("update user_inf set "+responses+" = "+news+" where id = "+to);
			System.out.println(toname + "received a new message !" );
		
		}
		else
		{
			
			 ResultSet res = state.executeQuery("select "+responses+" from user_inf where id = "+hid);
			 int news = 0;
			 if(res.next())
				 news = res.getInt(1);
			 news+=1;
			 state.executeUpdate("update user_inf set "+responses+" = "+news+" where id =  "+hid);
			 
		}
		System.out.println("You leave a message! in block "+hid);
		
		commit();
		messagecount++;
		
		
		 }
		 catch (SQLException e)
		 {
		     System.out.println("Fail to leave a message!");
		     throw e;
		 }
		
	  }
	  public ResultSet getMessage() throws SQLException
	  {
		  //message("my_evolution","Hello,world!",-1);
		  System.out.println("message Table name:"+messageTableName);
		  return state.executeQuery("select * from "+messageTableName);
	  }
	  public void createArticleList(int id) throws SQLException
	  {
		  
			String tablename = "article"+id;
		  state.executeUpdate("create table "+tablename+" (id int(6) not null,title text not null ,content text not null ,ftext text not null, time datetime not null ,tag int not null )");
		  commit();
	  }
	  public  void addArticle(String title,String content,String ftext,int tag,int aid) throws SQLException
	  {
		  String sql = " insert into "+articleTableName+" values (?,?,?,?,?,?)";
		  if(aid!=-1)
		sql="update "+articleTableName+" set id = ?,title = ?,content=?,ftext=?,time=?,tag=? where id = "+aid;
		  try {
			PreparedStatement ps = conn.prepareStatement(sql);
			if(aid==-1)
			ps.setInt(1, articlecount);
			else ps.setInt(1, aid);
			ps.setString(2, title);
			ps.setString(3, content);
			ps.setString(4, ftext);
			ps.setTimestamp(5, new Timestamp(new Date().getTime()));
			ps.setInt(6, tag);
			ps.executeUpdate();
			if(aid!=-1)
			{
			String tablename = "_"+hid+"_"+articlecount;
			
			if(hid == 0)
				tablename = "_"+articlecount;
			state.executeUpdate("create table "+tablename+" (id int(6) not null primary key,name char(20) not null,content text not null ,"
					+ "time datetime not null ,response int not null)");
			articlecount++; 
			System.out.println("You pulish an article!");
			}
			commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("fail to pulish an article!");
			e.printStackTrace();
			throw e;
		}
	  }
	  public ResultSet getArticle() throws SQLException
	  {
		  return state.executeQuery("select * from "+articleTableName);
	  }
	  public  ResultSet getArticleMessage(int id) throws SQLException
	  {
		  System.out.println("hid:"+hid);
			String tablename = "_"+hid+"_"+id;
			if(hid == 0)
				tablename = "_"+id;
			//System.out.println("hid:"+htablename);
		  return state.executeQuery("select * from "+tablename);
	  }
	  public  void addArticleMessage(int id,String name ,String content,int response) throws SQLException
	  {
			 try
			 {
					String tablename = "_"+hid+"_"+id;
					if(hid == 0)
						tablename = "_"+id;
				 String sql = " insert into "+tablename+" values (?,?,?,?,?)";
				 int amcount = 0;
			  ResultSet res = state.executeQuery("select count(id) from "+tablename);
			  if(res.next())
				  amcount = res.getInt(1);
			  PreparedStatement ps = conn.prepareStatement(sql);
			  ps.setInt(1, amcount);
			  ps.setString(2, name);
			  ps.setString(3, content);
			  
			  ps.setTimestamp(4, new Timestamp(new Date().getTime()));
			  ps.setInt(5, response);
			 
			ps.executeUpdate();
			if(response!=-1)
			{
				String toname = "";
				res = state.executeQuery("select name from "+tablename+" where id = "+response);//文章标题
				if(res.next()) toname=res.getString(1);
				int news = 0,to = 0;
				if(toname.equals(""))
					return;
 				//if(hid != 0)
				 res = state.executeQuery("select id,"+responses+" from user_inf where name = '"+toname+"'");
				 if(res.next())
				 {
					 to = res.getInt(1);
					 news = res.getInt(2);
				 }
				 news+=1;
				state.executeUpdate("update user_inf set "+responses+" = "+news+" where id = "+to);
				System.out.println(toname + "received a new message ! in block "+hid );
				
			}
			else
			{
				  res = state.executeQuery("select "+responses+" from user_inf where id = "+hid);
				 int news = 0;
				 if(res.next())
					 news = res.getInt(1);
				 news+=1;
				 state.executeUpdate("update user_inf set "+responses+" = "+news+" where id = "+hid);
				 
			}
			System.out.println("You leave a article message! in block "+hid);
			commit();
			 }
			 catch (SQLException e)
			 {
			     System.out.println("Fail to leave a message!");
			     throw e;
			 }
		  
	  }
	  public  void clearNews(int id)
	  {
		  try {
			state.executeUpdate("update user_inf set "+responses+" = 0 where id = "+id);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  public  void deleteLastArticle() throws SQLException
	  {
			String tablename = "_"+hid+"_"+(articlecount-1);
			if(hid == 0)
				tablename = "_"+(articlecount-1);
		  state.executeUpdate("delete from "+articleTableName+" where id = "+(articlecount-1));
		  state.executeUpdate("drop table "+tablename);
		  articlecount--;
		  conn.commit();
	  }
	  public static void main(String []args) throws SQLException, ClassNotFoundException
	  {
		 //firstOpen();
		  user_add u = new user_add();
		 u.connect(1);
		/* selectAll();
		 deleteUser(9);
		 deleteUser(9);
		 deleteUser(9);
		// */
				u.state.executeUpdate("update user_inf set message1 = 0 ");
				
		 u.commit();
		 //CreateHosts();
		 System.out.println("down");
		 //deleteLastDream(2);
		 u.close();
		  
	  }
	  public  void deleteUser(int id) throws SQLException
	  {
		  state.executeUpdate("delete from user_inf where id = "+id);
		  for(int i = id+1;i<count;++i)
		  {
			 state.executeUpdate("update user_inf set id = "+(i-1)+" where id = " +i);
			  
		  }
		 
		  commit();
	  }
	  public  ResultSet getPlan(int id) throws SQLException
	  {
			ResultSet	result = state.executeQuery("select dkey from user_inf where id = "+id);
			if(result.next())
				{
				if(result.getString(1) == null)
				
					return null;
			//	else System.out.println("key:"+result.getString(1));
				}
			else return null;
			String tablename = "plan"+id;
			 result = state.executeQuery("select * from "+tablename);
			return result;
	  }
	  public  ResultSet getPlan(String name) throws SQLException
	  {
		ResultSet	result = state.executeQuery("select id,dkey from user_inf where name = '"+name+"'");
		int id = -1;
		String key = null;
		if(result.next())
		{
			id = result.getInt(1);
		key = result.getString(2);
		}
		if(id == -1||key == null)
			return null;
		System.out.println("key:"+key);
		String tablename = "plan"+id;
		result = state.executeQuery("select * from "+tablename);
		return result;
	  }
	  public  void downPlan(int id,int pid,String key) throws SQLException
	  {
			String tablename = "plan"+id;
			ResultSet result = state.executeQuery("select content from "+tablename+" where id = "+pid);
			String content = "";
			if(result.next())
				content = crypt.decrypt(result.getString(1),key);
			if(content.equals(""))
				return;
			state.executeUpdate("update "+tablename+" set content = '"+content+"' ,is_down = 1,endTime = now() where id = "+pid);
			conn.commit();
	  }
	  public  void downPlan(String name,int pid,String key) throws SQLException
	  {
			ResultSet	result = state.executeQuery("select id from user_inf where name = '"+name+"'");
			
			int id = -1;
			if(result.next())
				id = result.getInt(1);
			String tablename = "plan"+id;
			result = state.executeQuery("select content from "+tablename+" where id = "+pid);
			String content = "";
			if(result.next())
				content = crypt.decrypt(result.getString(1),key);
			if(content.equals(""))
				return;
			state.executeUpdate("update "+tablename+" set content = '"+content+"' ,is_down = 1,endTime = now() where id = "+pid);
			conn.commit();
			
	  }
	  public  void addPlanTable(int id,String dkey) throws SQLException
	  {
		  state.executeUpdate(" update user_inf set dkey = '"+dkey+"' where id = "+id);
	       String tablename = "plan"+id;
	       //state.execute("drop table "+tablename);
			state.executeUpdate("create table "+tablename+"(id int(6) not null primary key,content text not null , is_down int not null,startTime datetime,endTime datetime)");
			tablename = "dream"+id;
			//state.execute("drop table "+tablename);
			state.executeUpdate("create table "+tablename+"(id int(6) not null primary key,content text not null , is_down int not null,startTime datetime,endTime datetime)");
			commit();
			System.out.println("用户编号"+id+"成功建立了一张计划表！");
	  }
	  public  void addPlanTable(String name ,String dkey) throws SQLException
	  {
			ResultSet	result = state.executeQuery("select id from user_inf where name = '"+name+"'");
			int id = -1;
			if(result.next())
				id = result.getInt(1);
			if(id == -1)
				return ;
			state.executeUpdate(" update user_inf set dkey = '"+dkey+"' where id = "+id);
			String tablename = "plan"+id;
			state.executeUpdate("create table "+tablename+"(id int(6) not null primary key,content text not null , is_down int not null,startTime datetime,endTime datetime)");
			tablename = "dream"+id;
			state.executeUpdate("create table "+tablename+"(id int(6) not null primary key,content text not null , is_down int not null,startTime datetime,endTime datetime)");
			commit();
			System.out.println(name+"成功建立了一张计划表！");
	  }
	  public  void addPlan(int id,String content) throws SQLException
	  {
		  String tablename = "plan"+id; 
			int pcount = -1;
			ResultSet result = state.executeQuery("select count(id) from "+tablename);
			if(result .next())
				pcount = result.getInt(1);
			if(pcount == -1)
				return;
			
			  String sql = " insert into "+tablename+" values (?,?,?,?,?)";
			  try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, pcount);
				ps.setString(2, content);
				ps.setInt(3, 0);
				ps.setTimestamp(4, new Timestamp(new Date().getTime()));
				ps.setTimestamp(5, null);
				ps.executeUpdate();
				System.out.println("add a plan!");
				commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("fail to add a plan!");
				e.printStackTrace();
				throw e;
			}
	  }
	  public void addPlan(String name,String content) throws SQLException
	  {
			ResultSet	result = state.executeQuery("select id from user_inf where name = '"+name+"'");
			int id = -1;
			if(result.next())
				id = result.getInt(1);
			if(id == -1)
				return;
			String tablename = "plan"+id; 
			int pcount = -1;
			result = state.executeQuery("select count(id) from "+tablename);
			if(result .next())
				pcount = result.getInt(1);
			if(pcount == -1)
				return;
			
			  String sql = " insert into "+tablename+" values (?,?,?,?,?)";
			  try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, pcount);
				ps.setString(2, content);
				ps.setInt(3, 0);
				ps.setTimestamp(4, new Timestamp(new Date().getTime()));
				ps.setTimestamp(5, null);
				ps.executeUpdate();
				System.out.println("add a plan!");
				commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("fail to add a plan!");
				e.printStackTrace();
				throw e;
			}
	  }
	  public ResultSet selectAllName() throws SQLException
	  {
		  return state.executeQuery("select name,dkey from user_inf");
	  }
	  public  ResultSet getDream(int id) throws SQLException
	  {
			ResultSet	result = state.executeQuery("select dkey from user_inf where id = "+id);
			if(result.next())
				{
				if(result.getString(1) == null)
				
					return null;
				}
			else return null;
			String tablename = "dream"+id;
			 result = state.executeQuery("select * from "+tablename);
			return result;
	  }
	  public ResultSet getDream(String name) throws SQLException
	  {
		ResultSet	result = state.executeQuery("select id,dkey from user_inf where name = '"+name+"'");
		int id = -1;
		String key = null;
		if(result.next())
		{
			id = result.getInt(1);
		key = result.getString(2);
		}
		if(id == -1||key == null)
			return null;
		String tablename = "dream"+id;
		result = state.executeQuery("select * from "+tablename);
		return result;
	  }
	  public void downDream(int id,int pid) throws SQLException
	  {
			String tablename = "dream"+id;
			state.executeUpdate("update "+tablename+" set is_down = 1,endTime = now() where pid = "+pid);
			conn.commit();
	  }
	  public void downDream(String name,int pid) throws SQLException
	  {
			ResultSet	result = state.executeQuery("select id from user_inf where name = '"+name+"'");
			int id = -1;
			if(result.next())
				id = result.getInt(1);
			String tablename = "dream"+id;
			state.executeUpdate("update "+tablename+" set is_down = 1,endTime = now() where pid = "+pid);
			conn.commit();
			
	  }

	  public  void addDream(int id,String content) throws SQLException
	  {
		  String tablename = "dream"+id; 
			int pcount = -1;
			ResultSet result = state.executeQuery("select count(id) from "+tablename);
			if(result .next())
				pcount = result.getInt(1);
			if(pcount == -1)
				return;
			
			  String sql = " insert into "+tablename+" values (?,?,?,?,?)";
			  try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, pcount);
				ps.setString(2, content);
				ps.setInt(3, 0);
				ps.setTimestamp(4, new Timestamp(new Date().getTime()));
				ps.setTimestamp(5, null);
				ps.executeUpdate();
				System.out.println("add a dream!");
				commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("fail to add a dream!");
				e.printStackTrace();
				throw e;
			}
	  }
	  public void addDream(String name,String content) throws SQLException
	  {
			ResultSet	result = state.executeQuery("select id from user_inf where name = '"+name+"'");
			int id = -1;
			if(result.next())
				id = result.getInt(1);
			if(id == -1)
				return;
			String tablename = "dream"+id; 
			int pcount = -1;
			result = state.executeQuery("select count(id) from "+tablename);
			if(result .next())
				pcount = result.getInt(1);
			if(pcount == -1)
				return;
			
			  String sql = " insert into "+tablename+" values (?,?,?,?,?)";
			  try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, pcount);
				ps.setString(2, content);
				ps.setInt(3, 0);
				ps.setTimestamp(4, new Timestamp(new Date().getTime()));
				ps.setTimestamp(5, null);
				ps.executeUpdate();
				System.out.println("add a dream!");
				commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("fail to dream a plan!");
				e.printStackTrace();
				throw e;
			}
	  }
	public String getName(int uid) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet res= state.executeQuery("select name from user_inf where id = "+uid);
		if(res.next())
			return res.getString(1);
		return null;
	}
	public String getKey(String name) throws SQLException {
		// TODO Auto-generated method stub
		//System.out.println("name:"+name);
		ResultSet res = state.executeQuery("select dkey from user_inf where name = '"+name+"'");
		if(res.next())
		{
			System.out.println(res.getString(1));
			return res.getString(1);
		}
		return null;
	}
	public void deleteLastPlan(int id) throws SQLException
	{
		  String tablename = "plan"+id; 
			int pcount = -1;
			ResultSet result = state.executeQuery("select count(id) from "+tablename);
			if(result .next())
				pcount = result.getInt(1);
			if(pcount == -1)
				return;
			state.executeUpdate("delete from "+tablename+" where id = "+(pcount-1));
		commit();
	}
	public void deleteLastDream(int id) throws SQLException
	{
		  String tablename = "dream"+id; 
			int pcount = -1;
			ResultSet result = state.executeQuery("select count(id) from "+tablename);
			if(result .next())
				pcount = result.getInt(1);
			if(pcount == -1)
				return;
			state.executeUpdate("delete from "+tablename+" where id = "+(pcount-1));
		commit();
	}
	public boolean isHost(int id) throws SQLException
	{
		ResultSet res = state.executeQuery("select name from hosts where id ="+id);
		return res.next();
	}
	public void changeToHost(String name) throws SQLException
	{
		try {
			int id = selectUserIdNews(name)[0];
			if(isHost(id))
			{
				System.out.println("已经是会员啦！");
				return;
			}
			state.executeUpdate("insert into hosts values("+id+",'"+name+"',null,null,null,null,null,null)");
			state.executeUpdate("alter table user_inf add column message"+id+" int");
			state.executeUpdate("update user_inf set message"+id+" =0");
			createMessage(id);
			createArticleList(id);
			System.out.println("A new user become VIP!");
			hcount++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("一起注册产生竞争啦！");
			throw e;
		}
	}
	public void CreateHosts() throws SQLException, ClassNotFoundException
	{
		  System.out.println("connect to the datebase...");
		  Class.forName(driver);
		  conn = DriverManager.getConnection(url,user,password);
		  state = conn.createStatement();
		state.executeUpdate("create table hosts(id int(6) not null primary key,name char(25) not null)");
		state.executeUpdate("insert into hosts values("+0+",'MyEvolution')");
		
	}
	public static int countImg(String filename)
	{
		int imgcount = 0;
		File f = new File(filename);
		String name = null;
		for(File i:f.listFiles())
		{
			name = i.getName();
			String bname = name.substring(name.lastIndexOf(".")+1);
			//System.out.println(i.getAbsolutePath());
			if(bname.equals("png"))
			++imgcount;
		}
		return imgcount;
	}
	public ResultSet getAllHost() throws SQLException
	{
			return state.executeQuery("select * from hosts");

	}
	public void changeTag(String []tags) throws SQLException
	{
		for (int i = 1;i<=6;++i)
		{
				state.executeUpdate("update hosts set tag"+i+" = '"+tags[i-1]+"' where id = "+hid );
		//System.out.println("tag"+i+":"+tags[i-1]);
		}
		commit();
	}
	public String []getTag() throws SQLException
	{
		ResultSet res = state.executeQuery("select tag1,tag2,tag3,tag4,tag5,tag6 from hosts where id = "+hid);
		String []tags = new String[6];
		if(res.next())
		for(int i = 0;i!=6;++i)
		{
				tags[i] = res.getString(i+1);
		//	System.out.println(tags[i]);
		}
		return tags;
	}
	public void upvator(String url,Cookie []c)
	{
		try{
			
			for(int i = 0;i<c.length;i++)
			{
				Cookie cookie = c[i];
				if(cookie.getName().equals("myevolutionUsername"))
				{
					String username = cookie.getValue();
					int id[] = null;
					if((id = selectUserIdNews(username))!=null)
					{
					state.executeUpdate("update user_inf set avatar = '"+url+"' where id = "+id[0]);
					}
					break;
				}
			}
	}catch(Exception e)
		{
		e.printStackTrace();
		}
}
public String getAva(String name) throws SQLException
{
	ResultSet res = state.executeQuery("select avatar from user_inf where name = '"+name+"'");
	if(res.next())
		return res.getString(1);
	return null;
}
}

