package control;

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

import register.article;
import register.hostArticle;
import register.message;
import register.signIn;
import register.user_add;

/**
 * Servlet implementation class change
 */
@WebServlet("/change")
public class change extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public change() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		user_add u = new user_add();
				int id = Integer.parseInt(request.getParameter("aid"));

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
			   
			    article art = hostArticle.getOne(id,u);
				String type = request.getParameter("tagname");
				if(type==null||type=="mall")
					type="all";
				request.setAttribute("tagtype",type);
				Cookie c[] = request.getCookies();
				String []userinf = new String [3];
				String []tags = u.getTag();
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
					request.setAttribute("username", userinf[0]);
					request.setAttribute("isHost", userinf[1]);
					request.setAttribute("newMessage", userinf[2]);
				
			    hostArticle.close(u);
			
			    request.setAttribute("art", art);
			    request.setAttribute("host", hid);
			    request.setAttribute("amend", "yes");
			    for(int i = 0;i!=6;++i)
			    {
			    	request.setAttribute("tag"+(i+1), tags[i]);
			    }
			    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
			    //	System.out.println("computer");
			    	 request.getRequestDispatcher("/WEB-INF/editor.jsp").forward(request, response);
			    }else{
			    
			    request.getRequestDispatcher("/WEB-INF/meditor.jsp").forward(request, response);
			    }
				}catch(Exception e)
				{
					request.setAttribute("error", "服务端出错！");
					request.getRequestDispatcher("error.jsp").forward(request, response);
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
