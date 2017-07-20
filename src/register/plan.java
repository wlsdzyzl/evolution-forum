package register;
import java.sql.Timestamp;
public class plan {
    private int id;
    private String Content;
    private int isDown;
    private Timestamp startTime ;
    private Timestamp endTime ;
    
    public int getId()
    {
    	return id;
    }
    public String getContent()
    {
    	return Content;
    }
    public String getStartTime()
    {
    	return startTime.toString();
    }
    public String getEndTime()
    {
    	return endTime.toString();
    }
    public int getDown()
    {
    	return isDown;
    }

    public plan()
    {
    	
    }
    public plan(int id,String content,int isDown,Timestamp st,Timestamp et)
    {
    	this.id = id;
    	Content = content;
    	this.isDown = isDown;
    	startTime=st;
    	if(isDown == 1)
    		endTime = et;
    	else endTime = null;
    }
}
