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

import register.signIn;
import register.userInf;
import register.user_add;

/**
 * Servlet implementation class toVip
 */
@WebServlet("/toVip")
public class toVip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toVip() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		user_add u = new user_add();
		Cookie c[] = request.getCookies();
		String []userinf = new String [3];
		userinf[0]=null;
		userinf[1]="no";
		userinf[2]="0";
		String host = request.getParameter("host");
		int hid = 0;
		if(host!=null&&!host.equals(""))
			hid = Integer.parseInt(host);
		ServletConfig config = this.getServletConfig();
		String rootpath = config.getServletContext().getRealPath("/")+"picture"+hid;
		
		request.setAttribute("icount",user_add.countImg(rootpath));
		int ok = 0;
		int id = 0;
	
			request.setAttribute("host", id);
	
		try {
			u.connect(hid);
			
			userinf = signIn.verifiCookie(c,hid,u);
			if(userinf[0]!=null&&!userinf[0].equals(""))
			id = u.selectUserIdNews(userinf[0])[0];
			
			if(!userinf[1].equals("yes")&&userinf[0]!=null&&!userinf[0].equals("")&&u.hcount<=7)
			{
			u.changeToHost(userinf[0]);
			userinf[1]="yes";
			ok=1;
			u.close();
			}else
				if(!userinf[1].equals("yes"))
				{
				    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
				    	response.sendRedirect("verror.html");
				    	}else{
				    		response.sendRedirect("mverror.html");
				    		}	
				//response.sendRedirect("verror.html");
				System.out.println("出错啦！");
				u.close();
				return;
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("verror.html");
			System.out.println("出错啦！");
			
			return;
			
		}finally
		{
			try {
				u.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("关闭连接出错啦！");
			}
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
			if(ok==1)
			{
			while(queue.size()>10)
				{
					queue.remove();
				}
				queue.add(userinf[0]+"进入了超级会员版块！时间："+new Date());
			
			}
			
		}
		application.setAttribute("visitorList", queue);
			request.setAttribute("username", userinf[0]);
			request.setAttribute("isHost", userinf[1]);
			request.setAttribute("newMessage", userinf[2]);
		request.setAttribute("host", id);

		    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
		    	System.out.println("computer");
		    	 request.getRequestDispatcher("/WEB-INF/toVip.jsp").forward(request, response);
		    }else{
		    	System.out.println("mobile");
		    request.getRequestDispatcher("/WEB-INF/mtoVip.jsp").forward(request, response);
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
