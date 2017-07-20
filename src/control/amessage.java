package control;
import register.article;
import register.hostArticle;
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
@WebServlet("/amessage")
public class amessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public amessage() {
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
			
			
		try{
			hostArticle.init(hid,u);
			Cookie c[] = request.getCookies();
			String []userinf = new String[3];
			//System.out.println("what!");
			String type = request.getParameter("tagname");
			if(type==null||type=="mall")
				type="all";
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
			{
request.setAttribute("isIn", "yes");
			}
				request.setAttribute("username", userinf[0]);
				request.setAttribute("isHost", userinf[1]);
				request.setAttribute("newMessage", userinf[2]);
			
			
			int tag = -1;
			if(!type.equals("all")) tag=Integer.parseInt(type.substring(1));
			 ArrayList<article> res = hostArticle.getArticle(tag,u);
			 request.setAttribute("list", res);// this method will not throw exception
		
		   hostArticle.close(u);
		} catch (ClassNotFoundException e) {
			request.setAttribute("list", new ArrayList<article>());
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("host", hid);
	    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
	    	System.out.println("computer");
	    	 request.getRequestDispatcher("/WEB-INF/blog.jsp").forward(request, response);
	    }else{
	    	System.out.println("mobile");
	    request.getRequestDispatcher("/WEB-INF/mblog.jsp").forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		user_add u = new user_add();
		int id = Integer.parseInt(request.getParameter("aid"));
		int acount = Integer.parseInt(request.getParameter("acount"));
		String mess = request.getParameter("message");
		String  res=request.getParameter("response");
		String host = request.getParameter("host");
		int hid = 0;
		if(host!=null&&!host.equals(""))
			hid = Integer.parseInt(host);
		
		ServletConfig config = this.getServletConfig();
		String rootpath = config.getServletContext().getRealPath("/")+"picture"+hid;
		
		request.setAttribute("icount",user_add.countImg(rootpath));
		try
		{
		hostArticle.init(hid,u);
		String []tags = u.getTag();
		Cookie c[] = request.getCookies();
		String []userinf = new String[3];
		//System.out.println("what!");
		String type = request.getParameter("tagname");
		if(type==null||type=="mall")
			type="all";
		request.setAttribute("tagtype",type);
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
		article art = hostArticle.getOne(id,u);
		if(userinf[0] == null)
		{
			request.setAttribute("isIn", "no");
		}
		else
		request.setAttribute("isIn", "yes");
		request.setAttribute("acount", acount);
			request.setAttribute("username", userinf[0]);
			request.setAttribute("isHost", userinf[1]);
			request.setAttribute("newMessage", userinf[2]);
			request.setAttribute("host", hid);
		if(res == null||res == "")
			res = "-1";
		if(userinf[0]!=null&&!userinf[0].equals("")&&mess!=null&&!mess.equals(""))
		{
			System.out.println(userinf[0]);
		hostArticle.addArticleMessage(id, userinf[0], mess, Integer.parseInt(res),u);
		ServletContext application = this.getServletContext();
		Queue<String> queue = (Queue<String>) application.getAttribute("visitorList");
		if(queue == null)
			
			queue = new LinkedList<String>();

		//ServletContext application = this.getServletContext();
		
		 if(userinf[0]!=null&&!userinf[0].equals(""))
		 {
			while(queue.size()>10)
			{
				queue.remove();
			}
			queue.add(userinf[0]+"评论了文章《"+art.getTitle()+"》。时间："+new Date());
		}
		
		
		application.setAttribute("visitorList", queue);
		}
	    ArrayList<message> aMes = hostArticle.getAMessage(id,u);
	    
	    hostArticle.close(u);
	    request.setAttribute("aMes",aMes );
	    request.setAttribute("art", art);
	    for(int i = 0;i!=6;++i)
	    {
	    	request.setAttribute("tag"+(i+1), tags[i]);
	    }
	    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
	    	System.out.println("computer");
	    	 request.getRequestDispatcher("/WEB-INF/article.jsp").forward(request, response);
	    }else{
	    	System.out.println("mobile");
	    request.getRequestDispatcher("/WEB-INF/marticle.jsp").forward(request, response);
	    }
	    
		}catch(Exception e)
		{
			request.setAttribute("error", "服务端出错！");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
}