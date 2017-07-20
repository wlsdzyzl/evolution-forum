package control;
import register.message;
import register.signIn;

import java.sql.*;
import com.mysql.jdbc.Driver;
import java.io.*;
import register.userMessage;
import register.user_add;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cmessage
 */
@WebServlet("/lmessage")
public class cmessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cmessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		user_add u = new user_add();
			String host = request.getParameter("host");
			int hid = 0;
			if(host!=null&&!host.equals(""))
				hid = Integer.parseInt(host);
			
			ServletConfig config = this.getServletConfig();
			String rootpath = config.getServletContext().getRealPath("/")+"picture"+hid;
			
			request.setAttribute("icount",user_add.countImg(rootpath));
			try{	userMessage.init(hid,u);
			Cookie c[] = request.getCookies();
			String []userinf = new String [3];
			userinf[0]=null;
			userinf[1]="no";
			userinf[2]="0";
			try {
				//user_add.connect();
				userinf = signIn.verifiCookie(c,hid,u);
				//user_add.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("what!");
			ServletContext application = this.getServletContext();
			Queue<String> queue = (Queue<String>) application.getAttribute("visitorList");
			if(queue == null)
				
				queue = new LinkedList<String>();
			if(userinf[0] == null)
			{
				request.setAttribute("isIn", "no");
			}
			else
			{
			request.setAttribute("isIn", "yes");
			//ServletContext application = this.getServletContext();
			//Queue<String> queue = (Queue<String>) application.getAttribute("visitorList");
			

				while(queue.size()>10)
				{
					queue.remove();
				}
				queue.add(userinf[0]+"访问了留言板。时间："+new Date());
			}
			application.setAttribute("visitorList", queue);
			
			
				request.setAttribute("username", userinf[0]);
				request.setAttribute("isHost", userinf[1]);
				request.setAttribute("newMessage", userinf[2]);
			
			ArrayList<message> list = userMessage.getAllMessage(u);
			userMessage.close(u);
			request.setAttribute("list", list);
			request.setAttribute("host", hid);
		    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
		    	System.out.println("computer");
		    	 request.getRequestDispatcher("/WEB-INF/saySomething.jsp").forward(request, response);
		    }else{
		    	System.out.println("mobile");
		    request.getRequestDispatcher("/WEB-INF/msaySomething.jsp").forward(request, response);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("host", hid);
			request.setAttribute("error", true);
		    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
		    	System.out.println("computer");
		    	 request.getRequestDispatcher("/WEB-INF/saySomething.jsp").forward(request, response);
		    }else{
		    	System.out.println("mobile");
		    request.getRequestDispatcher("/WEB-INF/msaySomething.jsp").forward(request, response);
		    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		user_add u = new user_add();
		String message = null,name=null;
		String res ;
		String host = request.getParameter("host");
		int hid = 0;
		if(host!=null&&!host.equals(""))
			hid = Integer.parseInt(host);
		
		ServletConfig config = this.getServletConfig();
		String rootpath = config.getServletContext().getRealPath("/")+"picture"+hid;
		
		request.setAttribute("icount",user_add.countImg(rootpath));
		try {
			
			userMessage.init(hid,u);//init the message 
			Cookie c[] = request.getCookies();
			String []userinf = new String [3];
			userinf[0]=null;
			userinf[1]="no";
			userinf[2]="0";
			try {
				//user_add.connect();
				userinf = signIn.verifiCookie(c,hid,u);
				//user_add.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("what!");
			
			if(userinf[0] == null)
			{
				request.setAttribute("isIn", "no");
			}
			else
			
			request.setAttribute("isIn", "yes");
				request.setAttribute("username", userinf[0]);
				name=userinf[0];
				request.setAttribute("isHost", userinf[1]);
				request.setAttribute("newMessage", userinf[2]);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", true);
		}
		try
		{
		 message = request.getParameter("message");
		//message  = new String(message.getBytes("ISO-8859-1"),"UTF-8");
		 
		 res=request.getParameter("response");
		 //System.out.println(name+""+message);
		}catch (Exception e)
		{
			e.printStackTrace();
			message ="";
			name = "";
			res="-1";
			
		}
		System.out.println(message+name);
		if(message == null || name==null||message .equals("")||name.equals(""))
			;
		else 
			{
			if(res==null||res.equals(""))
				res="-1";
			userMessage.addMessage(name, message, Integer.parseInt(res),u);
			request.setAttribute("mssuccess", 1);
			ServletContext application = this.getServletContext();
			Queue<String> queue = (Queue<String>) application.getAttribute("visitorList");
			if(queue == null)
				
				queue = new LinkedList<String>();
			if(name != null&&!name.equals(""))
			{
			//	ServletContext application = this.getServletContext();
				//Queue<String> queue = (Queue<String>) application.getAttribute("visitorList");
				

				
					while(queue.size()>10)
					{
						queue.remove();
					}
					queue.add(name+"在留言板发表了一条留言。时间："+new Date());
				}	
				application.setAttribute("visitorList", queue);
			
			}
			
		try {
			ArrayList<message> list = userMessage.getAllMessage(u);
			userMessage.close(u);
			request.setAttribute("list", list);
			request.setAttribute("host", hid);
		    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
		    	System.out.println("computer");
		    	 request.getRequestDispatcher("/WEB-INF/saySomething.jsp").forward(request, response);
		    }else{
		    	System.out.println("mobile");
		    request.getRequestDispatcher("/WEB-INF/msaySomething.jsp").forward(request, response);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", true);
			request.setAttribute("host", hid);
		    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
		    	System.out.println("computer");
		    	 request.getRequestDispatcher("/WEB-INF/saySomething.jsp").forward(request, response);
		    }else{
		    	System.out.println("mobile");
		    request.getRequestDispatcher("/WEB-INF/msaySomething.jsp").forward(request, response);
		    }
		}
	}

}
