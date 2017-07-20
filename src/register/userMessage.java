package register;


import java.sql.*;
import com.mysql.jdbc.Driver;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class userMessage {
	 public static void init(int hid,user_add user_ad) throws SQLException, ClassNotFoundException
	 {
		 user_ad.connect(hid);
	 }
     public static ArrayList<message> getAllMessage(user_add user_ad) 
     {
    	 ArrayList<message> res = new ArrayList<message>();
    	 try{
    	 
    	 ResultSet result = user_ad.getMessage();
    	 String url = null;
    	 String name = null;
    	 int id=-1;
    	 String content = null;
    	 Timestamp time = null;
    	 int resp = -1;
    	 while(result.next())
    	 {
    		 id = result.getInt(1);
    		name = result.getString(2); 
    		content = result.getString(3);
    		time = result.getTimestamp(4);
    		resp = result.getInt(5);
    		res.add(new message (id,name,content,time,resp,url));
    	 }
    	 for(message m:res)
    	 {
    		 m.setAvatar(user_ad.getAva(m.getName()));
    	 }
    	 Collections.reverse(res);
    	 }
    	 catch(SQLException e)
    	 {
    		 e.printStackTrace();
    	 }
    	 return res;
     }
     
     public static boolean addMessage(String name,String content, int response,user_add user_ad) throws UnsupportedEncodingException
     {
    	 try{
    		 user_ad.message(name, content, response);
    		 System.out.println(name+" say:草泥马");
    		 System.out.println(content);
    		 return true;
    	 }catch (SQLException e)
    	  {
    		 e.printStackTrace();
    		 System.out.println("failed to leave a message!\n");
    		 return false;
    	 }
     }
     public static void main(String []args) throws ClassNotFoundException, SQLException, UnsupportedEncodingException
     {
    	 //init(0);
    	 //addMessage("my_evolution","i love you",-1);
    	 //getAllMessage();
     }
     public static void close(user_add user_ad) throws SQLException
     {
    	 user_ad.close();
     }
    /* public static void clearMessage() throws SQLException
     {
    	 user_add.createMessage();
    	 System.out.println("clear all the message!\n");
     }*/
}
