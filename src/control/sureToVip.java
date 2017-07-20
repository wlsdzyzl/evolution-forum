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
import register.user_add;

/**
 * Servlet implementation class sureToVip
 */
@WebServlet("/sureToVip")
public class sureToVip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sureToVip() {
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
		int hid = 0;
		if(host!=null&&!host.equals(""))
			hid = Integer.parseInt(host);	
		try {
			u.connect(hid);
			
			userinf = signIn.verifiCookie(c,hid,u);
			
			u.close();
			if(userinf[0]==null||userinf[0].equals("")||u.hcount>7)
			{

			    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
			    	response.sendRedirect("verror.html");
			    	}else{
			    		response.sendRedirect("mverror.html");
			    		}	
			    return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("verror.html");
			System.out.println("出错啦！");
			
			return;
			
		}
		//System.out.println("what!");
		request.setAttribute("host", hid);

		    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
		    	System.out.println("computer");
		    	 request.getRequestDispatcher("/WEB-INF/sureToVip.jsp").forward(request, response);
		    }else{
		    	System.out.println("mobile");
		    request.getRequestDispatcher("/WEB-INF/msureToVip.jsp").forward(request, response);
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
