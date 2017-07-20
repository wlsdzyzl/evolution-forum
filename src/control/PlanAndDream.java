package control;

import java.io.IOException;
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

import register.crypt;
import register.dreamOp;
import register.hostArticle;
import register.planOp;
import register.signIn;
import register.user_add;

/**
 * Servlet implementation class PlanAndDream
 */
@WebServlet("/PlanAndDream")
public class PlanAndDream extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanAndDream() {
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
		try{	hostArticle.init(hid,u);
			//System.out.println("what!");

			//request.setAttribute("tagtype",type);
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
			//System.out.println(userinf[2]);
				request.setAttribute("isIn", "yes");
				//ServletContext application = this.getServletContext();
				//Queue<String> queue = (Queue<String>) application.getAttribute("visitorList");
					while(queue.size()>10)
					{
						queue.remove();
					}
					queue.add(userinf[0]+"查看了某个用户的DAP。时间："+new Date());
				}
				application.setAttribute("visitorList", queue);
				
			
			String key =  planOp.getKey(userinf[0],u);
				request.setAttribute("username", userinf[0]);
				request.setAttribute("isHost", userinf[1]);
				request.setAttribute("newMessage", userinf[2]);
				request.setAttribute("key",key);
				//System.out.println("key:"+ planOp.getKey(userinf[0]));
				String ui = request.getParameter("uid");
		    int uid = -1;
		    if(ui!=null) uid = Integer.parseInt(ui);
		    
		    
			
			//int tag = -1;
			//if(!type.equals("all")) tag=Integer.parseInt(type.substring(1));
			// ArrayList<article> res = hostArticle.getArticle(tag);
		//	 request.setAttribute("list", res);// this method will not throw exception
		    if(uid!=-1)
		    {
				request.setAttribute("plans", planOp.getAllplan(uid,u));
				request.setAttribute("dreams", dreamOp.getAllDream(uid,u));
				request.setAttribute("dapname", u.getName(uid));
		    }
			else if(key!=null)
				{
					request.setAttribute("plans", planOp.getAllplan(userinf[0],u));
					request.setAttribute("dreams", dreamOp.getAllDream(userinf[0],u));
					request.setAttribute("dapname", userinf[0]);
				}
			else
			{
				request.setAttribute("plans", new ArrayList());
				request.setAttribute("dreams", new ArrayList());
				request.setAttribute("dapname", userinf[0]);	
			}
		
		   hostArticle.close(u);
		} catch (ClassNotFoundException e) {
			request.setAttribute("plans", new ArrayList());
			request.setAttribute("dreams", new ArrayList());
			request.setAttribute("dapname", null);
			request.setAttribute("key", null);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("plans", new ArrayList());
			request.setAttribute("dreams", new ArrayList());
			request.setAttribute("dapname", null);
			request.setAttribute("key", null);
		}
		request.setAttribute("host", hid);
	    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
	    	System.out.println("computer");
	    	 request.getRequestDispatcher("/WEB-INF/dap.jsp").forward(request, response);
	    }else{
	    	System.out.println("mobile");
	    request.getRequestDispatcher("/WEB-INF/mdap.jsp").forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		user_add u = new user_add();
		String host = request.getParameter("host");
		int hid = 0;
		if(host!=null&&!host.equals(""))
			hid = Integer.parseInt(host);
		ServletConfig config = this.getServletConfig();
		String rootpath = config.getServletContext().getRealPath("/")+"picture"+hid;
		
		request.setAttribute("icount",user_add.countImg(rootpath));
		try {
			hostArticle.init(hid,u);
			//System.out.println("what!");

			//request.setAttribute("tagtype",type);
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
			if(userinf[0] == null)//should not happen
			{
				request.setAttribute("isIn", "no");
			}
			else
			{
			//System.out.println(userinf[2]);
				request.setAttribute("isIn", "yes");
				//ServletContext application = this.getServletContext();
				//Queue<String> queue = (Queue<String>) application.getAttribute("visitorList");
	
					while(queue.size()>10)
					{
						queue.remove();
					}
					queue.add(userinf[0]+"的DAP有更新。时间："+new Date());
				}
				application.setAttribute("visitorList", queue);
				
			
			String key = request.getParameter("key");
			String tag = request.getParameter("tag");
			String content = request.getParameter("content");
		
			if(key != null)
			{
				planOp.addPlanTable(userinf[0], key,u);
			}
			else
			{
				key = planOp.getKey(userinf[0],u);
				System.out.println(tag);
				System.out.println(content);
				if(!content.equals(""))
				{
					if (tag.equals("plan"))
				
					planOp.addPlan(userinf[0],crypt.encrypt(content, key),u);
				else if(tag.equals("dream"))
					dreamOp.addDream(userinf[0], content,u);
				}
				}
				request.setAttribute("username", userinf[0]);
				request.setAttribute("isHost", userinf[1]);
				request.setAttribute("newMessage", userinf[2]);
				request.setAttribute("key", key);
				System.out.println(userinf[1]);
				
		    
			
			//int tag = -1;
			//if(!type.equals("all")) tag=Integer.parseInt(type.substring(1));
			// ArrayList<article> res = hostArticle.getArticle(tag);
		//	 request.setAttribute("list", res);// this method will not throw exception
				request.setAttribute("plans", planOp.getAllplan(userinf[0],u));
				request.setAttribute("dreams", dreamOp.getAllDream(userinf[0],u));
				request.setAttribute("dapname",userinf[0]);
		
		
		   hostArticle.close(u);
		} catch (ClassNotFoundException e) {
			request.setAttribute("plans", new ArrayList());
			request.setAttribute("dreams", new ArrayList());
			request.setAttribute("dapname", null);
			request.setAttribute("key", null);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("plans", new ArrayList());
			request.setAttribute("dreams", new ArrayList());
			request.setAttribute("dapname", null);
			request.setAttribute("key", null);
		}
		request.setAttribute("host", hid);
	    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
	    	System.out.println("computer");
	    	 request.getRequestDispatcher("/WEB-INF/dap.jsp").forward(request, response);
	    }else{
	    	System.out.println("mobile");
	    request.getRequestDispatcher("/WEB-INF/mdap.jsp").forward(request, response);
	    }
	}

}
