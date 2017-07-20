<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import = "java.util.*,register.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset='utf-8'/>
		<title>无聊时的自娱自乐</title>
		<style>
			* { 
				/* Basic CSS reset */

				margin:0; 
				padding:0;
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
    width: 600px;
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
	<%tagArray[0]=(String)request.getAttribute("tag1") ;tagArray[1]=(String)request.getAttribute("tag2") ;tagArray[2]=(String)request.getAttribute("tag3") ;tagArray[3]=(String)request.getAttribute("tag4") ;tagArray[4]=(String)request.getAttribute("tag5") ;tagArray[5]=(String)request.getAttribute("tag6") ;%> 
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
			 +"<a href = '/my_evolution/signup?host="+hid+"'><span>注册</span></a></div>");
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
	<div class = "visitor">
	最近访客：<br><br>
	<% Queue<String> queue = (Queue<String>)application.getAttribute("visitorList");
	for(String i : queue)
		out.append("<marquee >"+i+"</marquee><br><br>");
	%></div>
	<%! int acount = 0, nacount=0;%>
	<% acount = (Integer) request.getAttribute("acount"); 
    nacount = ((ArrayList<article>)request.getAttribute("list")).size();	
	%>
			<script>
			function jump()
			{
				   window.location.href="/my_evolution/editor?host="+${host}+"&acount="+${acount};
				
			}	
		function changeBorder()
		{
			document.getElementById("m5").style="border-top-right-radius:1em;border-bottom-right-radius:2em;";
		}
		function gototag(tagtype)
		{	
			window.location.href="/my_evolution/harticle?host="+${host}+"&tagname="+tagtype;
			
		}
		</script>
		<menu>
		<button class = "menu" style = "border-top-left-radius:1em;border-bottom-left-radius:2em;" id = "all" onclick = "gototag('all')">全部</button><button class = 
		"menu" id = "m0" onclick = "gototag('m0')">${tag1 }</button><button class = 
		"menu" id = "m1" onclick = "gototag('m1')">${tag2 }</button><button class = "menu" id= "m2" onclick = "gototag('m2')">${tag3 }</button><button class = "menu" id="m3" onclick = "gototag('m3')">${tag4 }</button><button class = 
		"menu" id="m4" onclick = "gototag('m4')">${tag5 }</button><button class = 
		"menu" id = "m5" onclick = "gototag('m5')">${tag6 }</button><% if (((String)request.getAttribute("isIn")).equals("yes")&&((String)request.getAttribute("isHost")).equals("yes"))
			out.print("<button class = \"menu\" onclick = \"jump()\"style = \"border-top-right-radius:1em;border-bottom-right-radius:2em;\">写博客</button>");
		else {
			
			out.print("<script>changeBorder();</script>");
		}
			%>
		
		</menu>

<script>

var i = '<%=request.getAttribute("tagtype")%>';
var j = '<%=request.getAttribute("isHost")%>';
var sele = document.getElementById(i);
sele.style="    text-shadow: 1px 1px 1px gray;background-color:white;color:black;";
if(i == "all")
	sele.style="text-shadow: 1px 1px 1px gray;background-color:white;color:black;border-top-left-radius:1em;border-bottom-left-radius:2em;";
	else if(i == "m5"&&j=="no")
		sele.style="text-shadow: 1px 1px 1px gray;background-color:white;color:black;border-top-right-radius:1em;border-bottom-right-radius:2em;";

</script>
		<label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><font color = white>&nbsp;当前共有<%=nacount %>篇文章...</font></br>	
<c:forEach var = "article" items="${list}" varStatus="vast">
<div class = "content">
<a href = "/my_evolution/aInf?host=${host }&aid=${article.id }&tagname=${tagtype}&acount=<%=acount%>"><strong><font size = 5px>${article.title}</font></strong></a>
<div style = "text-align:right">
<a href = "/my_evolution/harticle?host=${host }&tagname=m${article.tag}"  >tag:${tagArray[article.tag]}</a>
</div>
<font size=1px> ————————————————————————————————————————————${article.datetime}<br></font>${article.ftext}</div>
</c:forEach>
	</body>
</html>