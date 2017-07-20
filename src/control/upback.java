package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class upback
 */
@WebServlet("/upback")
public class upback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upback() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String host = request.getParameter("host");

		//request.getContentType();
		String filename = "picture"+host;//"article"+(String)request.getParameter("acount");
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
		String uname = su.getRequest().getParameter("username");
		java.io.File f = new java.io.File (rootpath+filename);
		//System.out.println(f.getAbsolutePath());
		PrintWriter out = response.getWriter();
		if(!f.exists())
			f.mkdir();
		try {
			int count = f.list().length;
			su.getFiles().getFile(0).saveAs(f.getAbsolutePath()+"\\"+count+".png");
			//int count = su.save(f.getAbsolutePath());
			
			System.out.println("保存成功！");
			System.out.println(f.getAbsolutePath()+"\\"+count+".png");
			//response.setContentType("text/text;charset=utf-8");120.25.247.220
			//System.out.println(su.getFiles().getFile(0).getFileName());
			/*这里卡了很久，因为一直刷新的是response的buff而不是out的buf*/
		//	String url = "http://120.25.247.220:8080/my_evolution/picture"+hid+"/"+filename+"/"+count+".png";
			
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


