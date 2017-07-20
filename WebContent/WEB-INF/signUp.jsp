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
			
				background:url(./picture/1.jpg) 0 0 repeat;
				background-size:100%;
				padding:35px 0 0;
				margin:auto;
				text-align:left;
			} 
    #sign_up{   
        position: absolute;   
        top: 50%;   
        left:50%;   
        margin: -150px 0 0 -150px;   
        width: 300px;   
        height: 300px;   
    }   
    #sign_up h1{   
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
    font-size:1em;
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
} .error{
background:white;

border-style:groove;

}
</style>
<title>注册</title>
</head>
	<body id="change">
		<script>
		
		var time = new Date().getSeconds();
		var back = document.getElementById("change");
		with(back.style)
		{
			background="url(./picture0/"+time%10+".png)";
			backgroundSize="100%";
		}
		function jump()
		{
			   window.location.href="/my_evolution/signin?host="+${host};
			
		}
</script>
    <div id="sign_up">  
        <h1>Sign Up</h1>  
        <form action="/my_evolution/signup?host=${host }" method="post">  
            <input type="text" placeholder="输入你的用户名" id="username" name="username" onkeydown="if(event.keyCode==13){return false;}">  
             <label class="error" style="display:none" id="e5"><font color="red"><strong>*用户名不能为空！</strong></font></label>
               <label class="error" style="display:none" id="e6"><font color="red"><strong>*用户名包含非法字符！</strong></font></label>
            <input type="password" placeholder="输入你的密码" id="p1" onkeydown="if(event.keyCode==13){return false;}">  
            <input type="password" placeholder="重复密码" id="p2" name="password" onkeydown="if(event.keyCode==13){return false;}">
            <div class="error" style="display:none" id="e1"><font color="red"><strong>*两次密码不一致！</strong></font></div>
            <div class="error" style="display:none" id="e3"><font color="red"><strong>*密码长度不符（6-25）</strong></font></div>
                <label class="error" style="display:none" id="e7"><font color="red"><strong>*密码可能包含非法字符！</strong></font></label>
               <input type="text" placeholder="输入你的邮箱" id="email" name="email" onkeydown="if(event.keyCode==13){return false;}">
             <div class="error" style="display:none" id="e4"><font color="red"><strong>*邮箱不能为空！</strong></font></div>
              <div class="error" style="display:none" id="e2"><font color="red"><strong>*邮箱格式错误！</strong></font></div>

            <input type="submit" style="display:none" id="sub" onkeydown="if(event.keyCode==13){return false;}">
           
        </form>  
        <script type="text/javascript">
		
		function check()
		{
			
			var password1 = document.getElementById("p1").value;
			var password2 = document.getElementById("p2").value;
			var email = document.getElementById("email").value;
			var username = document.getElementById("username").value;
			//alert(username);
			
			var filter  = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
			var format =   /^[a-zA-Z_0-9][a-zA-Z0-9\s]*$/;
			var haha = 0;
			 if(password1 != password2) 
			   {
			   haha=1;
			   document.getElementById("e1").style.display="block";
			   }
		   else
			   {
			   document.getElementById("e1").style.display="none";
			   }
		   if(password2.length>25||password2.length<6)
		   {
			   haha=1;
			   document.getElementById("e3").style.display="block";
			   }
		   else
			   {
			   document.getElementById("e3").style.display="none";
			   }
		   if(!format.test(username)) 
		   {
		   haha=1;
		   document.getElementById("e6").style.display="block";
		   }
	   else
		   {
		   document.getElementById("e6").style.display="none";
		   }
		   if(!format.test(password2)) 
		   {
		   haha=1;
		   document.getElementById("e7").style.display="block";
		   }
	   else
		   {
		   document.getElementById("e7").style.display="none";
		   }
		   if(email == "")
		   {
			   haha=1;
			   document.getElementById("e4").style.display="block";
			   }
		   else
			   {
			   document.getElementById("e4").style.display="none";
			   }
		   if(username == "")
		   {
			   haha=1;
			   document.getElementById("e5").style.display="block";
			   }
		   else
			   {
			   document.getElementById("e5").style.display="none";
			   }
		   if(!filter.test(email))
		      {
			   haha=1;
			   document.getElementById("e2").style.display="block";
			   }
		   else
			   {
			   document.getElementById("e2").style.display="none";
			   }
			   if(haha==0)
				   document.getElementById("sub").click();
			   
		}
        </script>
             <button class="but" onclick="check()" onkeydown="if(event.keyCode==13){gosubmit();}">注册</button>  
               <button class="but" onclick="jump()" onkeydown="if(event.keyCode==13){gosubmit();}">登录</button>  
          <a href="/my_evolution/index?host=${host }"><font color="white">回到首页</font></a>
    </div>  
</body>  
</html>   