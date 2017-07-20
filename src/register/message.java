package register;

import java.sql.Timestamp;

public class message
{
	private int id;
	private int response;
	private String name;
	private String content;
	private Timestamp datetime;
	private String avatar;
	
	public  message()
	{
	}
	public int getId()
	{
		return this.id;
	}
	public String getName()
	{
		return this.name;
	}
	public String getDatetime()
	{
		return this.datetime.toString();
	}
	public String getContent()
	{
		return this.content;
	}
	public int getResponse()
	{
		return this.response;
	}
	public String getAvatar()
	{
		return this.avatar;
	}
	public void setAvatar(String url)
	{
		this.avatar=url;
	}
	public  message(int id,String name,String content,Timestamp date,int response,String avatar)
	{
		this.id = id;
		this.name = name;
		this.response = response;
		this.datetime = date;
		this.content = content;
		this.avatar = avatar;
	}	
}