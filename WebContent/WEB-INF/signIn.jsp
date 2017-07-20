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
        overflow: hidden;   
        font-style: sans-serif;   
    }
    			#change {
			
				background-size:100%;
				padding:35px 0 0;
				margin:auto;
				text-align:left;
			} 
    #login{   
        position: absolute;   
        top: 50%;   
        left:50%;   
        margin: -150px 0 0 -150px;   
        width: 300px;   
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
<title>登录</title>
</head>
	<body id="change">
		<script >
		var time = new Date().getSeconds();
		var back = document.getElementById("change");
		with(back.style)
		{
			background="url(./picture0/"+time%10+".png)";
			backgroundSize="100%";
		}
		function jump()
		{
			   window.location.href="/my_evolution/signup?host="+${host};
			
		}
			
	</script>
    <div id="login">  
        <h1>Login</h1>  
        <form action = "/my_evolution/signin?host=${host }" method="post">  
            <input type="text" placeholder="用户名" name="username"></input>  
            <input type="password" placeholder="密码" name="password"></input>  
            <button class="but" type="submit">登录</button>  
           
        </form>  
         <button class="but"  onclick = "jump()">注册</button>
          <a href = "/my_evolution/index?host=${host }"><font color = white>回到首页</font></a>
    </div>  
</body>  
</html>   