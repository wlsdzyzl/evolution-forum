<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
						
		background:gray;
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
.welcome
{
        color: #fff;   
        text-shadow:0 0 10px;   
        letter-spacing: 1px;   
        text-align: right;   
        font-size:50px;
}
.picture
{
width:300px;
height:200px;
}
.picture:hover
{
height:50%;
width:50%;
text-align:center;
}

.shake-freeze:hover,
.shake-trigger:hover .shake-freeze, .shake-little:hover,
.shake-trigger:hover .shake-little {
  animation-play-state: running; }

@keyframes shake-little {
  2% {
    transform: translate(1px, 0px) rotate(0.5deg); }
  4% {
    transform: translate(1px, 0px) rotate(0.5deg); }
  6% {
    transform: translate(1px, 1px) rotate(0.5deg); }
  8% {
    transform: translate(0px, 0px) rotate(0.5deg); }
  10% {
    transform: translate(1px, 0px) rotate(0.5deg); }
  12% {
    transform: translate(0px, 0px) rotate(0.5deg); }
  14% {
    transform: translate(1px, 1px) rotate(0.5deg); }
  16% {
    transform: translate(0px, 1px) rotate(0.5deg); }
  18% {
    transform: translate(1px, 0px) rotate(0.5deg); }
  20% {
    transform: translate(0px, 1px) rotate(0.5deg); }
  22% {
    transform: translate(0px, 0px) rotate(0.5deg); }
  24% {
    transform: translate(0px, 0px) rotate(0.5deg); }
  26% {
    transform: translate(1px, 1px) rotate(0.5deg); }
  28% {
    transform: translate(0px, 1px) rotate(0.5deg); }
  30% {
    transform: translate(0px, 0px) rotate(0.5deg); }
  32% {
    transform: translate(1px, 1px) rotate(0.5deg); }
  34% {
    transform: translate(0px, 1px) rotate(0.5deg); }
  36% {
    transform: translate(0px, 1px) rotate(0.5deg); }
  38% {
    transform: translate(0px, 0px) rotate(0.5deg); }
  40% {
    transform: translate(1px, 0px) rotate(0.5deg); }
  42% {
    transform: translate(0px, 1px) rotate(0.5deg); }
  44% {
    transform: translate(0px, 1px) rotate(0.5deg); }
  46% {
    transform: translate(0px, 0px) rotate(0.5deg); }
  48% {
    transform: translate(1px, 0px) rotate(0.5deg); }
  50% {
    transform: translate(1px, 1px) rotate(0.5deg); }
  52% {
    transform: translate(0px, 0px) rotate(0.5deg); }
  54% {
    transform: translate(1px, 1px) rotate(0.5deg); }
  56% {
    transform: translate(0px, 1px) rotate(0.5deg); }
  58% {
    transform: translate(1px, 0px) rotate(0.5deg); }
  60% {
    transform: translate(1px, 1px) rotate(0.5deg); }
  62% {
    transform: translate(0px, 1px) rotate(0.5deg); }
  64% {
    transform: translate(0px, 0px) rotate(0.5deg); }
  66% {
    transform: translate(1px, 0px) rotate(0.5deg); }
  68% {
    transform: translate(0px, 0px) rotate(0.5deg); }
  70% {
    transform: translate(1px, 0px) rotate(0.5deg); }
  72% {
    transform: translate(1px, 1px) rotate(0.5deg); }
  74% {
    transform: translate(1px, 1px) rotate(0.5deg); }
  76% {
    transform: translate(0px, 0px) rotate(0.5deg); }
  78% {
    transform: translate(0px, 0px) rotate(0.5deg); }
  80% {
    transform: translate(1px, 0px) rotate(0.5deg); }
  82% {
    transform: translate(1px, 1px) rotate(0.5deg); }
  84% {
    transform: translate(0px, 1px) rotate(0.5deg); }
  86% {
    transform: translate(1px, 1px) rotate(0.5deg); }
  88% {
    transform: translate(1px, 1px) rotate(0.5deg); }
  90% {
    transform: translate(0px, 1px) rotate(0.5deg); }
  92% {
    transform: translate(1px, 0px) rotate(0.5deg); }
  94% {
    transform: translate(1px, 0px) rotate(0.5deg); }
  96% {
    transform: translate(1px, 0px) rotate(0.5deg); }
  98% {
    transform: translate(1px, 1px) rotate(0.5deg); }
  0%, 100% {
    transform: translate(0, 0) rotate(0); } }

.shake-little {
   color: #fff; 
  display: inline-block;
  transform-origin: center center; 
    animation-play-state: running;
  animation-name: shake-little;
  animation-duration: 100ms;
  animation-timing-function: ease-in-out;
animation-iteration-count: infinite; }
.shake-crazy {
  display: inline-block;
  transform-origin: center center; }


@keyframes shake-crazy {
  10% {
    transform: translate(2px, 3px) rotate(-9deg);
    opacity: 1; }
  20% {
    transform: translate(3px, 3px) rotate(-7deg);
    opacity: 0.71; }
  30% {
    transform: translate(2px, 18px) rotate(5deg);
    opacity: 0.83; }
  40% {
    transform: translate(7px, 18px) rotate(-7deg);
    opacity: 0.2; }
  50% {
    transform: translate(13px, -14px) rotate(10deg);
    opacity: 0.71; }
  60% {
    transform: translate(-14px, 20px) rotate(3deg);
    opacity: 0.42; }
  70% {
    transform: translate(-15px, 17px) rotate(5deg);
    opacity: 0.7; }
  80% {
    transform: translate(-17px, -1px) rotate(-3deg);
    opacity: 0.62; }
  90% {
    transform: translate(-4px, 2px) rotate(8deg);
    opacity: 0.15; }
  0%, 100% {
    transform: translate(0, 0) rotate(0); } }

.shake-little:hover{
  animation-name: shake-crazy;
  animation-duration: 100ms;
  animation-timing-function: ease-in-out;
animation-iteration-count: infinite; }
		</style>
	</head>
	

	<body id="change">
		<script >
			
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
	{out.print("<a href = '/my_evolution/signin?host="+hid+"'><span>登录</span></a>"
			 +"<a href = '/my_evolution/signup?host="+hid+"'><span>注册</span></a></div>");
out.print("<br>	<label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><font color = 'white'>Welcome !</font><label class = 'welcome'>游客！</label>");}
else 
	{
	
	out.print("</div><br><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>	<font color = 'white'>Welcome !</font><label class = 'welcome'>"+(String)request.getAttribute("username")+"</label>");
	int news = Integer.parseInt((String)request.getAttribute("newMessage"));
	if(news > 0)
	{
		out.print("<font color = 'white'>你最近收到了"+news+"条回复！</font>");
	}
	}
	%>
	<br>
<c:forEach var = "string" items="${pList}" varStatus="vast">
<img  src="${string}" class="picture" border="3">
</c:forEach>
	</body>
</html>