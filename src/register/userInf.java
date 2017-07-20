package register;

import java.sql.Timestamp;

public class userInf {
	private int id;
	private int news;
	private String username;
	private String email;
	public userInf()
	{
		
	}
	public int getId()
	{
		return id;
	}
	public int getNews()
	{
		return news;
	}
	public String getName()
	{
		return username;
	}
	public String getEmail()
	{
		return email;
	}
	public userInf(int id,String username,String email,int news)
	{
		this.id = id;
		this.news = news;
		this.username = username;
		this.email = email;
	}
}
