<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">


    html{   
        width: 100%;   
        height: 100%;   
   		font-size:3em;
        font-style: sans-serif;   
    }
    			#change {
			
				background:black;
		
		
				margin:auto;
				text-align:center;
			} 
    #login{   
   
       
        text-align:center; 
 	margin:auto;
        width: 60%;   
        height: 60%;   
    }   
    #login h1{   
        color: #fff;   
        text-shadow:0 0 10px;   
        letter-spacing: 1px;   
        text-align: center;   
    }   
    h1{   
        font-size: 1em;   
        margin: 0.67em 0;   
    }   
    input{   
        width: 100%;   
        height: 10%;   
 margin-bottom: 10px;  
        outline: none;   
        padding: 1em;   
        font-size: 1em;   
        color: #fff;   
        border-top: 0.1em solid #312E3D;   
        border-left: 0.1em solid #312E3D;   
        border-right: 0.1em solid #312E3D;   
        border-bottom: 0.1em solid #56536A;   
        border-radius: 0.4em;   
        background-color: #2D2D3F;   
    }   
    .but{   
        width: 100%;      
        height:15%;
      font-size:1em;
        display: block;   
        background-color: #4a77d4;   
        border: 1px solid #3762bc;   
        color: #fff;   
      padding:1em 1em;
       
        line-height: normal;   
        border-radius: 5px;   
        
        
    }  
	.but:hover{
background-color:white;
color : black;
text-shadow: 1px 1px 1px gray;
}
</style>
<title>个性化定制</title>
</head>
	<body id="change">
		<script >
		var time = new Date().getSeconds();
		var back = document.getElementById("change");

		function jump()
		{
			   window.location.href="/my_evolution/signup?host="+${host};
			
		}
			
	</script>
    <div id="login">  
    <h1>恭喜你成功升级为超级会员！</h1>
        <h1>你可以上传几张背景图，当访问你的博客时候会使用它们。目前仅支持一次上传一张</h1>  
      <h1>建议尽量上传黑色背景图，你必须至少上传一张！</h1>
            <input type="file" onchange="up()" name="username" id = "upload"  ></input>  
           <br>
          
     
    <h1>你可以并且必须定义6个标签，作为文章的分类。</h1>
<h1>如果你不这样做，你的博客可能无法正常使用。</h1>
<h1>标签建议两个字，有利于排版。</h1>
<h1>tag4为默认标签。</h1>
    <form action = "/my_evolution/changeTags?host=${host }" method = "POST"> 
     <input type = text placeholder="tag1" name = "tag1"/>
      <input type = text placeholder="tag2" name = "tag2"/>
       <input type = text placeholder="tag3" name = "tag3"/>
     <input type = text placeholder="tag4" name = "tag4"/>
      <input type = text placeholder="tag5" name = "tag5"/>
       <input type = text placeholder="tag6" name = "tag6"/>
       <input type="submit" value="提交标签" class = "but"/>
    </form>
    <a href = "/my_evolution/index?host=${host }"><font color = white>回到我的首页</font></a>
    </div> 
    <%int icount =(Integer)request.getAttribute("host");%>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="./ajaxfileupload.js"></script>
    <script>
    function up() {   
       // alert("haha");  
        $.ajaxFileUpload({   
        	 url : '/my_evolution/upback?host=<%=icount%>',
            secureuri : false,   
            fileElementId : 'upload',   
            success : function(data, status) {
            	if(status!=200)
            		alert(status+"上传成功！");
            },   
            error : function(data, status, e) {
            	alert("上传失败！");
            }   
        });   
     };  
    </script>
</body>  
</html>  