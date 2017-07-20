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

import register.*;

/**
 * Servlet implementation class aInf
 */
@WebServlet("/aInf")
public class aInf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public aInf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		user_add u = new user_add();
				int id = Integer.parseInt(request.getParameter("aid"));
				int acount = Integer.parseInt(request.getParameter("acount"));
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
			    ArrayList<message> aMes = hostArticle.getAMessage(id,u);
			    article art = hostArticle.getOne(id,u);
				String type = request.getParameter("tagname");
				if(type==null||type=="mall")
					type="all";
				request.setAttribute("tagtype",type);
				request.setAttribute("acount", acount);
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
	
				ServletContext application = this.getServletContext();
				Queue<String>  queue = (Queue<String>) application.getAttribute("visitorList");
				if(queue == null)
					
					queue = new LinkedList<String>();
				if(userinf[0] == null)
				{
					request.setAttribute("isIn", "no");
				}
				else
				{
				request.setAttribute("isIn", "yes");
		
					while(queue.size()>10)
					{
						queue.remove();
					}
					queue.add(userinf[0]+"阅读了文章《"+art.getTitle()+"》。时间："+new Date());
				}
				application.setAttribute("visitorList", queue);
				
					request.setAttribute("username", userinf[0]);
					request.setAttribute("isHost", userinf[1]);
					request.setAttribute("newMessage", userinf[2]);
				
			    hostArticle.close(u);
			    request.setAttribute("aMes",aMes );
			    request.setAttribute("art", art);
			    request.setAttribute("host", hid);
			    for(int i = 0;i!=6;++i)
			    {
			    	request.setAttribute("tag"+(i+1), tags[i]);
			    }
			    if(request.getHeader("user-agent").indexOf("Mobile")==-1){
			    //	System.out.println("computer");
			    	 request.getRequestDispatcher("/WEB-INF/article.jsp").forward(request, response);
			    }else{
			    
			    request.getRequestDispatcher("/WEB-INF/marticle.jsp").forward(request, response);
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
