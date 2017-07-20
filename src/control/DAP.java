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

import register.article;
import register.hostArticle;
import register.planOp;
import register.signIn;
import register.user_add;

/**
 * Servlet implementation class DAP
 */
@WebServlet("/DAP")
public class DAP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DAP() {
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
	
				request.setAttribute("isIn", "yes");
				//ServletContext application = this.getServletContext();

					while(queue.size()>10)
					{
						queue.remove();
					}
					queue.add(userinf[0]+"访问了DAP页面。时间："+new Date());
				}
				application.setAttribute("visitorList", queue);
				
			
				request.setAttribute("username", userinf[0]);
				request.setAttribute("isHost", userinf[1]);
				request.setAttribute("newMessage", userinf[2]);
			
				System.out.println(userinf[1]);
			
			
			//int tag = -1;
			//if(!type.equals("all")) tag=Integer.parseInt(type.substring(1));
			// ArrayList<article> res = hostArticle.getArticle(tag);
		//	 request.setAttribute("list", res);// this method will not throw exception
				request.setAttribute("userlist", planOp.getUser(u));
		
		   hostArticle.close(u);
		} catch (ClassNotFoundException e) {
			request.setAttribute("userlist", new ArrayList<String[]>());
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("userlist", new ArrayList<String[]>());
		}
		request.setAttribute("host", hid);
	    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
	    	System.out.println("computer");
	    	 request.getRequestDispatcher("/WEB-INF/dapList.jsp").forward(request, response);
	    }else{
	    	System.out.println("mobile");
	    request.getRequestDispatcher("/WEB-INF/mdapList.jsp").forward(request, response);
	    }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
