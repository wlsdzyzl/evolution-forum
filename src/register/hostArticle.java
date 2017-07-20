package register;



import java.sql.*;
import com.mysql.jdbc.Driver;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class hostArticle {
	 public static void init(int hid,user_add u) throws SQLException, ClassNotFoundException
	 {
		 u.connect(hid);
	 }
     public static ArrayList<article> getArticle(int tag,user_add u)
     {
    	 ArrayList<article> res = new ArrayList<article>();
     
    	 try{
    	 ResultSet allarticle = u.getArticle();
    	 while(allarticle.next())
    	 {
    		 if(tag == -1 || allarticle.getInt(6)==tag)
    		 res.add(new article (allarticle.getInt(1),allarticle.getString(2),allarticle.getString(3),allarticle.getString(4),allarticle.getTimestamp(5),allarticle.getInt(6)));
    	   }
    	 Collections.reverse(res);
    	 }catch(SQLException e)
    	 {
    		 e.printStackTrace();
    	 }
    	 
    	 return res;
     }
     public static article getOne(int id,user_add u)
     {
    	 try
    	 {
    	 ResultSet res = u.getOneArticle(id);
    	 if(res.next())
    		 return new article(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getTimestamp(5),res.getInt(6));
    	 return null;
    	 }
    	 catch (Exception e)
    	 {
    		 return null;
    	 }
     }
     public static ArrayList<message> getAMessage(int id,user_add u) 
     {
    	 ArrayList<message> res = new ArrayList<message>();
    	 try{
    	 
    	 ResultSet result = u.getArticleMessage(id);
    	 
    	
    	 String url = null;
    	 String name = null;
    	 int idd=-1;
    	 String content = null;
    	 Timestamp time = null;
    	 int resp = -1;
    	 while(result.next())
    	 {
    		 idd = result.getInt(1);
    		name = result.getString(2); 
    		content = result.getString(3);
    		time = result.getTimestamp(4);
    		resp = result.getInt(5);
    		res.add(new message (idd,name,content,time,resp,url));
    	 }
    	 for(message m:res)
    	 {
    		 m.setAvatar(u.getAva(m.getName()));
    	 }
    	 Collections.reverse(res);
    	 }
    	 catch(SQLException e)
    	 {
    		 e.printStackTrace();
    	 }
    	 return res;
     }
     public static boolean addArticle(String title,String content, String ftext ,int tag,user_add u,int aid)
     {
    	 try{
    		 u.addArticle(title, content,ftext, tag,aid);
    		 return true;
    	 }catch (SQLException e)
    	  {
    		 e.printStackTrace();
    		
    		 return false;
    	 }
     }
     
    public static boolean addArticleMessage(int id,String name,String content,int response ,user_add u)
    {
    	try{
    		u.addArticleMessage(id, name, content, response);
    		return true;
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		return false;
    	}
    }
    public static void close(user_add u) throws SQLException
    {
    	u.close();
    }
}
