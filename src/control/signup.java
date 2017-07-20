package control;

import java.io.IOException;
import java.sql.SQLException;
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
import register.userInf;
import register.user_add;
import register.signIn;
import register.signUp;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		user_add u = new user_add();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String host = request.getParameter("host");
		int hid = 0;
		if(host!=null&&!host.equals(""))
			hid = Integer.parseInt(host);
		request.setAttribute("host", hid);
		  if(request.getHeader("user-agent").indexOf("Mobile")==-1){
		    	System.out.println("computer");
		    	 request.getRequestDispatcher("/WEB-INF/signUp.jsp").forward(request, response);
		    }else{
		    	System.out.println("mobile");
		    request.getRequestDispatcher("/WEB-INF/msignUp.jsp").forward(request, response);
		    }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		user_add u = new user_add();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String host = request.getParameter("host");
		int hid = 0;
		if(host!=null&&!host.equals(""))
			hid = Integer.parseInt(host);
		
		ServletConfig config = this.getServletConfig();
		String rootpath = config.getServletContext().getRealPath("/")+"picture"+hid;
		
		request.setAttribute("icount",user_add.countImg(rootpath));
		
		String hostName = null;
		String avatar = null;
		try {
			signIn.init(hid,u);
			userInf userinf = signUp.subinf(username,password,email,u);
			request.setAttribute("hosts", register.host.getAllHost(u));
			if(userinf == null)
			{	
				request.setAttribute("host", hid);
			    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
			    	//System.out.println("computer");
			    	 request.getRequestDispatcher("/WEB-INF/failsignUp.jsp").forward(request, response);
			    }else{
			    	//System.out.println("mobile");
			    request.getRequestDispatcher("/WEB-INF/mfailsignUp.jsp").forward(request, response);
			    }
			}
			else
			{
				
				try
				{
				Cookie uname = new Cookie("myevolutionUsername",userinf.getName());
				response.addCookie(uname);
				u.commit();
				}catch(Exception e)
				{
					request.setAttribute("host", hid);
				    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
				    	//System.out.println("computer");
				    	 request.getRequestDispatcher("/WEB-INF/failsignUp.jsp").forward(request, response);
				    }else{
				    	//System.out.println("mobile");
				    request.getRequestDispatcher("/WEB-INF/mfailsignUp.jsp").forward(request, response);
				    }
					return;
				}finally{
					hostName = u.getName(hid);
					avatar = u.getAva(hostName);
					u.close();
					
				}
				ServletContext application = this.getServletContext();
				Queue<String> queue = (Queue<String>) application.getAttribute("visitorList");
				if(queue == null)
				{
					queue = new LinkedList<String>();
					queue.add("欢迎新朋友"+username+"!时间："+new Date());
				}
				else
				{
					while(queue.size()>10)
					{
						queue.remove();
					}
					queue.add("欢迎新朋友"+username+"!时间："+new Date());
				}
				application.setAttribute("visitorList", queue);
				request.setAttribute("isIn", "yes");
				request.setAttribute("username", username);
				if(userinf.getId() == 0)
				request.setAttribute("isHost","yes" );
				else request.setAttribute("isHost", "no");
				request.setAttribute("newMessage", "0");
				request.setAttribute("host", hid);
				request.setAttribute("hostName", hostName);
				request.setAttribute("avatar", avatar);
			    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
			    	System.out.println("computer");
			    	 request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
			    }else{
			    	System.out.println("mobile");
			    request.getRequestDispatcher("/WEB-INF/mhome.jsp").forward(request, response);
			    }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("host", hid);
		    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
		    	//System.out.println("computer");
		    	 request.getRequestDispatcher("/WEB-INF/failsignUp.jsp").forward(request, response);
		    }else{
		    	//System.out.println("mobile");
		    request.getRequestDispatcher("/WEB-INF/mfailsignUp.jsp").forward(request, response);
		    }
		}
		
	}
}
