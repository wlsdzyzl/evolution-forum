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
import register.message;
import register.signIn;
import register.user_add;
import register.hostArticle;/**
 * Servlet implementation class carticle
 */
@WebServlet("/harticle")
public class carticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public carticle() {
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
			
			String []tags = null;
			try{	hostArticle.init(hid,u);
			//System.out.println("what!");
			String type = request.getParameter("tagname");
			if(type==null||type=="mall")
				type="all";
			request.setAttribute("tagtype",type);
			Cookie c[] = request.getCookies();
			String []userinf = new String [3];
			 tags = u.getTag();
			userinf[0]=null;
			userinf[1]="no";
			userinf[2]="0";
			try {
				//user_add.connect();
				userinf = signIn.verifiCookie(c,hid,u);
				System.out.print(userinf[1]);
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

		
				while(queue.size()>10)
				{
					queue.remove();
				}
				queue.add(userinf[0]+"访问了博客。时间："+new Date());
			}
			application.setAttribute("visitorList", queue);
			
			
				request.setAttribute("username", userinf[0]);
				request.setAttribute("isHost", userinf[1]);
				request.setAttribute("newMessage", userinf[2]);
			
			request.setAttribute("acount", u.articlecount);
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
	    for(int i = 0;i!=6;++i)
	    {
	    	request.setAttribute("tag"+(i+1), tags[i]);
	    }
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		user_add u = new user_add();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String tag = request.getParameter("tag");
		String ftext = request.getParameter("ftext")+"...";
		int aid = Integer.parseInt( request.getParameter("aid"));
		System.out.println("title:"+title);
		System.out.println("content:"+content);
		System.out.println("tag:"+tag);
		System.out.println("format text:"+ftext);
		String host = request.getParameter("host");
		int hid = 0;
		if(host!=null&&!host.equals(""))
			hid = Integer.parseInt(host);
		
		ServletConfig config = this.getServletConfig();
		String rootpath = config.getServletContext().getRealPath("/")+"picture"+hid;
		
		request.setAttribute("icount",user_add.countImg(rootpath));
		if(title == null || title.equals("") || content.equals("") || content == null)
		      ;
		else
		{
			try {
				hostArticle.init(hid,u);
				//System.out.println("what!");
				request.setAttribute("tagtype","all");
				Cookie c[] = request.getCookies();
				String []userinf = new String [3];
				userinf[0]=null;
				userinf[1]="no";
				userinf[2]="0";
				String []tags = u.getTag();
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

				
					while(queue.size()>10)
					{
						queue.remove();
					}
					if(aid==-1)
					queue.add(userinf[0]+"发表了文章《"+title+"》。时间："+new Date());
					else
						queue.add(userinf[0]+"更新了文章《"+title+"》。时间："+new Date());
				}
				application.setAttribute("visitorList", queue);
				
					request.setAttribute("username", userinf[0]);
					request.setAttribute("isHost", userinf[1]);
					request.setAttribute("newMessage", userinf[2]);
				
		     if(hostArticle.addArticle(title, content, ftext,Integer.parseInt(tag),u,aid))
		     {
		    	 request.setAttribute("asuccess", 1);
		     }
		    
			 ArrayList<article> res = hostArticle.getArticle(-1,u);
			 
			 request.setAttribute("list", res);// this method will not throw exception
			 request.setAttribute("acount", u.articlecount);
			    for(int i = 0;i!=6;++i)
			    {
			    	request.setAttribute("tag"+(i+1), tags[i]);
			    }
		     hostArticle.close(u);
			}
			catch(ClassNotFoundException e)
			{ request.setAttribute("list", new ArrayList<article>());
				e.printStackTrace();
			}
			catch(Exception e)
			
			{
				request.setAttribute("asuccess", -1);
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
	}

}
