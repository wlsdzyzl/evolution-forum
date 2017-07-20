package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import register.user_add;

/**
 * Servlet implementation class uploadImg
 */
@WebServlet("/uploadImg")
public class uploadImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadImg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String host = request.getParameter("host");
		String message = request.getParameter("message");
		String mobile = request.getParameter("mobile");
		String avatar = request.getParameter("avatar");
		int hid = 0;
		if(host!=null&&!host.equals(""))
			hid = Integer.parseInt(host);
		//request.getContentType();
		String filename ="./";
		if(avatar!=null&&avatar.equals("1"))
		{
			filename="avatar";
		}
		else if(message!=null&&message.equals("1"))
			filename="message";
		else
		filename= "article"+request.getParameter("acount");
		ServletConfig config = this.getServletConfig();
		SmartUpload su = new SmartUpload();
		su.initialize(config,request,response);
	
		try {
			su.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String rootpath = config.getServletContext().getRealPath("/");
		java.io.File f  = null;
		if(avatar!=null&&avatar.equals("1"))
			f = new java.io.File (rootpath+"/"+filename);
		else
	     f= new java.io.File (rootpath+"picture"+hid+"/"+filename);
		//System.out.println(f.getAbsolutePath());
		PrintWriter out = response.getWriter();
		if(!f.exists())
			f.mkdir();
		try {
			int count = f.list().length;
			su.getFiles().getFile(0).saveAs(f.getAbsolutePath()+"/"+count+".png");
			//int count = su.save(f.getAbsolutePath());
			
			System.out.println("保存成功！");
			if(avatar!=null&&avatar.equals("1"))
			{
			Cookie c[] = request.getCookies();
			user_add u = new user_add();
			try{
			u.connect(0);
			//System.out.println("http://120.25.247.220:8080/my_evolution/avatar/"+count+".png");
			u.upvator("http://120.25.247.220:8080/my_evolution/avatar/"+count+".png",c);
			u.commit();
			u.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			} 
			//response.setContentType("text/text;charset=utf-8");120.25.247.220
			//System.out.println(su.getFiles().getFile(0).getFileName());
			/*这里卡了很久，因为一直刷新的是response的buff而不是out的buf*/
			String url = "http://120.25.247.220:8080/my_evolution/picture"+hid+"/"+filename+"/"+count+".png";
			if(avatar!=null&&avatar.equals("1"))
				url="http://120.25.247.220:8080/my_evolution/avatar/"+count+".png";
			if(message!=null&&message.equals("1")&&(mobile==null||mobile.equals("")))
			{ 
			out.print("{\"errno\":0,\"data\":[\""+url+"\"]}");
			out.flush();
			out.close();}
			else
			{
				out.print(url);
				out.flush();
				out.close();			
			}
			//System.out.println("{errno:0,data:['"+url+"']}");
			
			
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("保存失败！");
			out.print("服务端出错！请勿上传两张相同的照片！");
			out.flush();
			out.close();
		}
	}

}
