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
        font-style: sans-serif;   
    }
    			#change {
				/* These styles have nothing to do with the ribbon */
				background:black;
				background-size:100%;
				padding:35px 0 0;
				margin:auto;
				text-align:left;
			} 
    #login{   
        position: absolute;   
		left:20%;
		top:15%;
		width:60%;
         
          
        height: 300px;   
    }   
    #login h1{   
        color: #fff;   
        text-shadow:0 0 10px;   
        letter-spacing: 1px;   
        text-align: left;   
    }   
    h1{   
        font-size: 2em;   
        margin: 0.67em 0;   
    }   
    input{   
        width: 300px;   
        
        margin-bottom: 10px;   
        outline: none;   
        padding: 10px;   
        font-size: 13px;   
        color: #fff;   
        text-shadow:1px 1px 1px;   
        border-top: 1px solid #312E3D;   
        border-left: 1px solid #312E3D;   
        border-right: 1px solid #312E3D;   
        border-bottom: 1px solid #56536A;   
        border-radius: 4px;   
        background-color: #2D2D3F;   
    }   
    .but{   
        width: 300px;   
        min-height: 20px;   
        display: block;   
        background-color: #4a77d4;   
        border: 1px solid #3762bc;   
        color: #fff;   
        padding: 9px 14px;   
        font-size: 15px;   
        line-height: normal;   
        border-radius: 5px;   
        margin: 0;   
    }  
    	.but:hover{
background-color:white;
color : black;
text-shadow: 1px 1px 1px gray;
}

</style>
<title>升级为vip</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="/my_evolution/ajaxfileupload.js"></script>

</head>
	<body id="change">
		<script >



		function jump()
		{
			   window.location.href="/my_evolution/toVip?host="+${host};
			
		}
	</script>
    <div id="login">  
    <p><input type="file" id = "file1" name=file /></p>
   <input type=button onclick="ajaxFileUpload()" class=but value="上传"/>
   <p><img id = "img1" alt="上传成功！" style="width:100px;height:100px" src=""/></p>
   <script >
   function ajaxFileUpload() {
	  // alert($("#login").html());
       $.ajaxFileUpload
       (
           {
               url: '/my_evolution/uploadImg?avatar=1', //用于文件上传的服务器端请求地址
               secureuri: false, //是否需要安全协议，一般设置为false
               fileElementId: 'file1', //文件上传域的ID
               dataType: 'text', //返回值类型 一般设置为json
               success: function (data, status)  //服务器成功响应处理函数
               {
            	   var index = data.indexOf("http");
            	   $("#img1").attr("src", data.substr(index,data.length-index-6));
                 alert("上传成功！你的头像改变了！");
                 
               },
               error: function (data, status, e)//服务器响应失败处理函数
               {
                   alert(e);
               }
           }
       )
       return false;
   }

   </script>
    <h1>如果你已经是VIP并且想要上传背景图或者修改标签内容，请直接拉到底点击VIP；</h1>
        <h1>你确定要成为VIP吗？</h1>
        <h1>如果你来这个博客只是为了看看，对其内容并没有多大兴趣，请点击 <a href = "/my_evolution/index?host=${host }">回到首页</a>。</h1>
        <h1>VIP名额有限，请不要浪费名额，</h1> 
        <h1>如果你决定要成为VIP，并且会好好对待自己的博客，请仔细阅读下面的关于VIP介绍的文章，再点击成为VIP：</h1> 
<h1><a href = "http://www.wlsdzyzl.top:8080/my_evolution/aInf?host=0&aid=14&tagname=all&acount=0">关于VIP的介绍</a></h1>
         <button class="but"  onclick = "jump()">vip</button>
        
    </div>  
</body>  
</html>   