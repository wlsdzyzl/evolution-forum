<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset='utf-8'/>
		<title>无聊时的自娱自乐</title>
		<style>
			#change{
				/* These styles have nothing to do with the ribbon */
				background:url(./picture/8.jpg);
				background-size:100% ;
				padding:3em 0 0;
				margin:auto;
				text-align:left;
			}
			.back{
		 	margin:auto;
        width: 100%;   
        height: 90%;  
        font-size:3em; 
			} 
		.text{
			height:9em;
			width:100%;
     border-radius:3px;
    
	
			}
			.ribbon {
				display:inline-block;
				font-size:0.82em;
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
.menu{
    height:3em;
    width:14%;
    position: relative;

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
    width: 100%;
    position: relative;

    background-color: white;
    border-radius: 20px;
 	
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
		.content{
    width: 90%;
    position: relative;

    background-color: gray;
    border-radius: 20px;
 	text-align:center;
    margin-top: 10px;
    word-wrap: break-word;
}
 
.content:hover{
    text-shadow: 1px 1px 1px gray;
    backgrount-color:white;
}
 
.content:after{
   
    display: block;
    position:absolute;
    top:10px;
    left: -20px;
    width: 0;
    height: 0;
    border-style: solid;
    border-width: 10px 20px 10px 0px;
    border-color: transparent #e2eff9 transparent transparent;
}</style>
	</head>
	

	<body id="change">
	<div class="back">
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
	<p class = "shake-little" style="padding:0 30px" >欢迎进入ChatRoom!
<a href = 'http://120.25.247.220:3000/'><img src='http://120.25.247.220:8080/my_evolution/picture0/article24/3.png' style = "width:2em;height:2em;border-radius:50%"/></a></p>
	
	<img src="${avatar }" style="width:15em;height:15em;border:0.2em solid black;margin-left:30px"/>
	<br>
<p class = "shake-little" style="padding:0 30px" ><font>这里是${hostName}</font>的博客！<br><br></p>
<c:forEach var = "ho" items="${hosts}" varStatus="vast">
<c:if test="${ho.hid eq host}"><div class = content style="background:white"><p class = "shake-little" ><font color="black">${ho.name }的博客</font></p></div><br></c:if>
<c:if test="${ho.hid ne host }"><div class = content><p class = "shake-little"><a href = "/my_evolution/index?host=${ho.hid }">${ho.name }的博客</a></p></div><br></c:if>
</c:forEach>
<p class = "shake-little"><label>&nbsp;</label><label>&nbsp;</label><font size = 7px>谢谢你来！</font></p>

		<div style="width:700px;margin:10px auto 20px auto;padding:0 0 0 380px;overflow:hidden">
</div>
</div>
	</body>
</html>