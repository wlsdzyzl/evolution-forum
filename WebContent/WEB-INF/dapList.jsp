<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import = "java.util.*,register.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset='utf-8'/>
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
		<title>无聊时的自娱自乐</title>
		<style>
			* { 
				/* Basic CSS reset */

				margin:0; 
				padding:0;
			}
.visitor
{
overflow-x:hidden;
background:white;
border-radius:5px;
position:fixed;
left:800px;
top:100px;
width:250px;
max-height:600px;
}
.visitor:hover
{
text-shadow: 1px 1px 1px gray;
}
			#change{
				/* These styles have nothing to do with the ribbon */
								background:url(./picture/8.jpg);
				background-size:100% ;
				padding:35px 0 0;
				margin:auto;
				text-align:left;
			}

			.ribbon {
				display:inline-block;
			}

			.ribbon:after, .ribbon:before {
				margin-top:0.5em;
				content: "";
				float:left;
				border:1.5em solid #fff;
			}

			.ribbon:after {
				border-right-color:transparent;
			}

			.ribbon:before {
				border-left-color:transparent;
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

.menu{
    
    position: relative;
    left: 30px;
    background-color: gray;
    padding: 10px;
    color:white;
    margin-top: 10px;
    word-wrap: break-word;
}
 
.menu:hover{
    text-shadow: 1px 1px 1px gray;
    background-color:white;
    color:black;
    
}
 
.menu:after{
   
    display: block;
    position:absolute;
    top:15px;
    left: -20px;
    width: 0;
    height: 0;
    border-style: solid;
    border-width: 10px 20px 10px 0px;
    border-color: black;
}
.content{
    max-width: 500px;
    position: relative;
    left: 30px;
    background-color: white;
    border-radius: 20px;
    padding: 10px;
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
	
		</style>
	</head>
	

	<body id="change">
		<script >
		
		var time = new Date().getSeconds();
		var back = document.getElementById("change");
		with(back.style)
		{
			background="url(./picture"+${host}+"/"+time%${icount}+".png)";
			backgroundSize="100%";
		}

			
	</script>
	<%!String []tagArray = new String [6];%>
	<%tagArray[0]="资源" ;tagArray[1]="跑酷";tagArray[2]="计算机";tagArray[3]="灌水";tagArray[4]="有成就感的事";tagArray[5]="想法";%> 
	<%request.setAttribute("tagArray", tagArray); %>
<label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
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
	 +"<a href = '/my_evolution/signup?host="+hid+"'><span>注册</span></a></div><script>alert('游客身份不能使用DAP板块！请登录或者注册！')</script>");
else 
	{
	out.print("</div><br>	<label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><font color = 'white'>Welcome !</font><label class = 'welcome'>"+(String)request.getAttribute("username")+"</label>");
	int news = Integer.parseInt((String)request.getAttribute("newMessage"));
	if(news > 0)
	{
		out.print("<font color = 'white'>你最近收到了"+news+"条回复！</font>");
	}
	}
	%>

<div class = content><a href = "http://www.wlsdzyzl.top:8080/my_evolution/aInf?host=0&aid=11&tagname=all&acount=0">关于DAP模块</a></div>
<%if(request.getAttribute("isIn") == "yes") {%>
<div class = content>
<a href = "/my_evolution/PlanAndDream"><font color = red><strong>My Dream's And Plans</strong></font></a>
</div>
<%} %>

<div class = "visitor">
	最近访客：<br><br>
	<% Queue<String> queue = (Queue<String>)application.getAttribute("visitorList");
	for(String i : queue)
		out.append("<marquee >"+i+"</marquee><br><br>");
	%></div>
<c:forEach var = "user" items="${userlist}" varStatus="vast">

<c:if test="${user[1]!=null }">
<div class = content>
<a href = "/my_evolution/PlanAndDream?host=${host}&uid=${vast.index}">●${user[0]} 's Dreams and Plans</a>
</div>
</c:if>

</c:forEach>

	</body>
</html>