package control;

import java.io.*;
import register.picture;
import register.signIn;
import register.user_add;

import java.io.IOException;
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
 * Servlet implementation class getPhoto
 */
@WebServlet("/photo")
public class getPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getPhoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String host = request.getParameter("host");
		int hid = 0;
		if(host!=null&&!host.equals(""))
			hid = Integer.parseInt(host);
		user_add u = new user_add();

		ServletConfig config = this.getServletConfig();
		String path = config.getServletContext().getRealPath("/")+"picture"+hid;
		
		request.setAttribute("icount",user_add.countImg(path));
		System.out.println(new File(path));
		ArrayList<String> uri = new ArrayList<String>();
		picture.readfile(path,uri);
		request.setAttribute("pList", uri);
		Cookie c[] = request.getCookies();
		String []userinf = new String [3];
		userinf[0]=null;
		userinf[1]="no";
		userinf[2]="0";
		try {
			u.connect(hid);
			userinf = signIn.verifiCookie(c,hid,u);
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
		request.setAttribute("isIn", "yes");
		//ServletContext application = this.getServletContext();
		//Queue<String> queue = (Queue<String>) application.getAttribute("visitorList");

			while(queue.size()>10)
			{
				queue.remove();
			}
			queue.add(userinf[0]+"访问了图片。时间："+new Date());
		}
		application.setAttribute("visitorList", queue);
	
		
			request.setAttribute("username", userinf[0]);
			request.setAttribute("isHost", userinf[1]);
			request.setAttribute("newMessage", userinf[2]);
			request.setAttribute("host", hid);
		    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
		    	System.out.println("computer");
		    	 request.getRequestDispatcher("/WEB-INF/photo.jsp").forward(request, response);
		    }else{
		    	System.out.println("mobile");
		    request.getRequestDispatcher("/WEB-INF/mphoto.jsp").forward(request, response);
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
