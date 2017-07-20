<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import = "java.util.*,register.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset='utf-8'/>
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
	
		<title>无聊时的自娱自乐</title>
		 <link rel="stylesheet" type="text/css" href="./wangEditor-mobile-0.0.3.1/dist/css/wangEditor-mobile.css">		
		<style>

			#change{
				/* These styles have nothing to do with the ribbon */
				background:url(./picture/8.jpg);
				background-size:100% ;
				margin:auto;
				padding:20px 0 0;
				text-align:left;
			}
			.back{
		 	margin:auto;
        width: 100%;   
        height: 90%;  
 
			}  
			.ribbon {
				display:inline-block;
				font-size:0.79em;
				top:20px;
			}


			.ribbon a:link, .ribbon a:visited { 
				color:#000;
				text-decoration:none;
			    float:left;
			    height:3.5em;
				overflow:hidden;
			}

			.ribbon span {
				background:#fff;
				display:inline-block;
				line-height:3em;
				padding:0 1em;
				margin-top:0.5em;
				position:relative;
				
				-webkit-transition: background-color 0.2s, margin-top 0.2s;  /* Saf3.2+, Chrome */
				-moz-transition: background-color 0.2s, margin-top 0.2s;  /* FF4+ */
				-ms-transition: background-color 0.2s, margin-top 0.2s;  /* IE10 */
				-o-transition: background-color 0.2s, margin-top 0.2s;  /* Opera 10.5+ */
				transition: background-color 0.2s, margin-top 0.2s;
			}

			.ribbon a:hover span {
				background:#FFD204;
				margin-top:0;
			}

			.ribbon span:before {
				content: "";
				position:absolute;
				top:3em;
				left:0;
				border-right:0.5em solid #9B8651;
				border-bottom:0.5em solid #fff;
			}

			.ribbon span:after {
				content: "";
				position:absolute;
				top:3em;
				right:0;
				border-left:0.5em solid #9B8651;
				border-bottom:0.5em solid #fff;
			}

.button{
width: 20%;
height:3em;
font-size:0.5em;
text-align: center;
font-weight: bold;
color: #fff;
text-shadow:1px 1px 1px #333;
border-radius: 5px;
margin:auto;
position: relative;
}
.button.black{
border:1px solid #333;
box-shadow: 0 1px 2px #8b8b8b inset,0 -1px 0 #3d3d3d inset,0 -2px 3px #8b8b8b inset;
background: -webkit-linear-gradient(top,#656565,#4c4c4c);
background: -moz-linear-gradient(top,#656565,#4a4a4a);
background: linear-gradient(top,#656565,#4a4a4a);
}
.black:hover{
background: -webkit-linear-gradient(top,#818181,#575757);
background: -moz-linear-gradient(top,#818181,#575757);
background: linear-gradient(top,#818181,#575757);
}

.content{
    width: 100%;
    position: relative;
	min-height:4em;
    background-color: white;
    border-radius: 5px;
 	
    margin-top: 10px;
    word-wrap: break-word;
}
 
.content:hover{
    text-shadow: 1px 1px 1px gray;
}
 
.content:after{
   
    display: block;
    position:absolute;
    top:15px;
    left: -20px;
    width: 0;
    height: 0;
    border-style: solid;
    border-width: 10px 20px 10px 0px;
    border-color: transparent #e2eff9 transparent transparent;
}
.welcome
{
        color: #fff;   
        text-shadow:0 0 10px;   
        letter-spacing: 1px;   
        text-align: right;   
}
.white
{
color:white;
}
	.resp{
width:15%;
font-size:0.5em;
line-height:25px;
color: #fff;
background:#8b8b8b;
text-shadow:1px 1px 1px #333;
border-radius: 5px;
margin:0 20px 20px 0;
position: relative;
overflow: hidden;
}
.resp:hover
{
background: -webkit-linear-gradient(top,#818181,#575757);
background: -moz-linear-gradient(top,#818181,#575757);
background: linear-gradient(top,#818181,#575757);}
		</style>
	</head>

	<body id="change">
<script type="text/javascript" src="./wangEditor-mobile-0.0.3.1/dist/js/lib/zepto.js"></script>
<script type="text/javascript" src="./wangEditor-mobile-0.0.3.1/dist/js/lib/zepto.touch.js"></script>
 <script type="text/javascript" src="./wangEditor-mobile-0.0.3.1/dist/js/wangEditor-mobile.js"></script>

	<div class = "back">
		<script >
		
		var time = new Date().getSeconds();
		var back = document.getElementById("change");
		with(back.style)
		{
			background="url(./picture"+${host}+"/"+time%${icount}+".png)";
			backgroundSize="100%";
		}
			
	</script>

		<div class='ribbon'>
			<a href='/my_evolution/index?host=${host }'><span>首页</span></a>
			<a href='/my_evolution/harticle?host=${host }'><span>博客</span></a>
					<a href='/my_evolution/photo?host=${host }'><span>图片</span></a>
			<a href='/my_evolution/lmessage?host=${host }'><span>留言板</span></a>

		<a href="/my_evolution/DAP?host=${host }"><span>DAP</span></a>
		<a href="/my_evolution/sureToVip?host=${host }"><span>VIP</span></a>
<% 
int hid = (Integer)request.getAttribute("host");
if(request.getAttribute("isIn") == "no")
	out.print("<a href = '/my_evolution/signin?host="+hid+"'><span>登录</span></a>"
			 +"<a href = '/my_evolution/signup?host="+hid+"'><span>注册</span></a></div>");
else 
	{
	out.print("</div><br><font color = 'white'>Welcome !</font><label class = 'welcome'>"+(String)request.getAttribute("username")+"</label>");
	int news = Integer.parseInt((String)request.getAttribute("newMessage"));
	if(news > 0)
	{
		out.print("<font color = 'white'>你最近收到了"+news+"条回复！</font>");
	}
	}
	%>
<div id = "noSignUp" >
<div style="background:white;" >
<div id="res" style="color:#ccc;">@null</div>
<textarea id="textarea1" style="width:100%;height:100%;" >
<p></p>
</textarea>
</div>
<script type="text/javascript">
    // ___E 三个下划线
    var editor = new ___E('textarea1');
    editor.config.uploadImgUrl = '/my_evolution/uploadImg?host='+${host}+"&message=1&mobile=1";
    editor.init();

   function  getc() {
        // 获取编辑器区域完整html代码
        var html = editor.$txt.html();
        var text=editor.$txt.text();
        
        var res = document.getElementById("res").innerHTML;
        if(res!=="@null")
        	res+="<br>";
        	else res="";
        if(text!==""||html.indexOf("img")!=-1)
        document.getElementById("mess").value=res+html;
        document.getElementById("subm").submit();
   }</script>
<form id="subm" action = "/my_evolution/lmessage?host=${host }" method = "POST">
<textarea name = "message"  style="display:none" id = "mess"></textarea>

 <input type = "text" id = "resp" name = "response" style = "display:none"/>
<input type = "button" value = "留言" class = "button black" onclick="getc()"/> 

<input type = "button" value = "取消" class = "button black" onclick = "back()"/>
</form>

</div>

<script>

function back()
{
	
	var a = document.getElementsByClassName("wangEditor-mobile-txt")[0];
	a.innerHTML="";
	a.focus();
	document.getElementById("res").innerHTML="@null";
	document.getElementById("resp").value="-1";
	
	}
function respon(id,name)
{
	var  temp = document.getElementById("res");
	temp.innerHTML="@"+name;
	var a = document.getElementsByClassName("wangEditor-mobile-txt")[0];
	a.focus();
	document.getElementById("resp").value=id;
	
	}
</script>


			
</br>
<font class = white>当前共有<%=((ArrayList<message>) request.getAttribute("list")).size() %>条留言...</font></br>
<c:forEach var = "message" items="${list}" varStatus="vast">
<div class = "content" >
<div style="width:4em;float:left" > 
<img src='${message.avatar }'id = "resp${message.id }" onclick='respon(${message.id},"${message.name}")' border=2px style="width:3em;height:3em;"/>
<font size=1em color=gray>${message.name}</font>

</div>
<font color = "black">${message.content }</font>
<br>
<font size=0.5px> ————————————————${message.datetime}</font>
</div>
</c:forEach>
		<% if (((String)request.getAttribute("isIn")).equals("yes"))
			;
		else {
			
			out.print("<script>alert(\"游客身份不能留言！请登录或者注册！\");</script>");
		}
			%>
			</div>
			<script type="text/javascript">	var a = document.getElementsByClassName("wangEditor-mobile-txt")[0];
			a.style.height="5em";</script>
	</body>
</html>