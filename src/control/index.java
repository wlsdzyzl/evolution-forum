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

import register.signIn;
import register.user_add;
import register.host;

/**
 * Servlet implementation class index
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		user_add u = new user_add();
		Cookie c[] = request.getCookies();
		String []userinf = new String [3];
		userinf[0]=null;
		userinf[1]="no";
		userinf[2]="0";
		String host = request.getParameter("host");
		String hostName = null;

		String avatar = null;
		int hid = 0;
		if(host!=null&&!host.equals(""))
			hid = Integer.parseInt(host);
		
		ServletConfig config = this.getServletConfig();
		String rootpath = config.getServletContext().getRealPath("/")+"picture"+hid;
		request.setAttribute("icount",user_add.countImg(rootpath));
		try {
			u.connect(hid);
			userinf = signIn.verifiCookie(c,hid,u);
			request.setAttribute("hosts", register.host.getAllHost(u));
			hostName = u.getName(hid);
			avatar = u.getAva(hostName);
			u.close();
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
			
			 //queue = (Queue<String>) application.getAttribute("visitorList");

				while(queue.size()>10)
				{
					queue.remove();
				}
				queue.add(userinf[0]+"访问了主页。时间："+new Date());
			
			
			
		}
		application.setAttribute("visitorList", queue);
			request.setAttribute("username", userinf[0]);
			request.setAttribute("hostName", hostName);
			request.setAttribute("avatar", avatar);
			request.setAttribute("isHost", userinf[1]);
			request.setAttribute("newMessage", userinf[2]);
			request.setAttribute("host", hid);

		    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
		    	System.out.println("computer");
		    	 request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		    }else{
		    	System.out.println("mobile");
		    request.getRequestDispatcher("/WEB-INF/mhome.jsp").forward(request, response);
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
