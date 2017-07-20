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
        font-size: 2em;   
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
        line-height: normal;   
        border-radius: 5px;   
        margin:auto;
        
           margin-bottom: 10px;  
    }  
	.but:hover{
background-color:white;
color : black;
text-shadow: 1px 1px 1px gray;
} .error{
background:white;

border-style:groove;

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


		alert("用户名或密码错误！");	
		function jump()
		{
			   window.location.href="/my_evolution/signup?host="+${host};
			
		}
	</script>
    <div id="login">  
        <h1>Login</h1>  
        <form action = "/my_evolution/signin?host=${host }" method="post">  
            <input type="text" placeholder="用户名" name="username"></input>  
            <input type="password" placeholder="密码" name="password"></input>  
            <button class="but" type="submit">登录</button>  
           
        </form>  
         <button class="but"  onclick = "jump()">注册</button>
          <a href = "/my_evolution/index?host=${host }"><font color = white>回到首页</font></a>
        
    </div>  
</body>  
</html>   