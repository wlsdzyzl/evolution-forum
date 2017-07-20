package register;

import java.sql.Timestamp;

public class article
{
	private int id;
	private int tag;
	private String title;
	private String content;
	private Timestamp datetime;
	private String ftext;
	
	public  article()
	{
	}
	public int getId()
	{
		return this.id;
	}
	public String getTitle()
	{
		return this.title;
	}
	public String getFtext()
	{
		return this.ftext;
	}
	public String getDatetime()
	{
		return this.datetime.toString();
	}
	public String getContent()
	{
		return this.content;
	}
	public int getTag()
	{
		return this.tag;
	}
	public  article(int id,String title,String content,String ftext,Timestamp date,int tag)
	{
		this.id = id;
		this.title = title;
		this.ftext = ftext;
		this.tag = tag;
		this.datetime = date;
		this.content = content;
	}	
}