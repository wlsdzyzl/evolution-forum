<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import = "java.util.*,register.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset='utf-8'/>
		<title>无聊时的自娱自乐</title>
		    <link href="http://apps.bdimg.com/libs/highlight.js/9.1.0/styles/default.min.css" rel="stylesheet">
	<script type="text/javascript" src="./wangEditor.js"></script>	
		<style>
		
			* { 
				/* Basic CSS reset */

				margin:0; 
				padding:0;
			}

			#change{
				/* These styles have nothing to do with the ribbon */
				background:black;
								
				background-size:100% ;
				padding:35px 0 0;
				margin:auto;
				text-align:left;
			}
						.text{
			height:100px;
			width:450px;
     border-radius:3px;
    
	
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
.button{
width: 140px;
line-height: 38px;
text-align: center;
font-weight: bold;
color: #fff;
text-shadow:1px 1px 1px #333;
border-radius: 5px;
margin:0 20px 20px 0;
position: relative;
overflow: hidden;
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
    min-height:160px;
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
.white
{
color:white;
}
	.resp{
width:50px;
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
		</style>
	</head>
	

	<body id="change">
	    <script src="http://apps.bdimg.com/libs/highlight.js/9.1.0/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
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
function change()
{
	window.location.href="/my_evolution/change?host="+${host}+"&aid="+<%=request.getParameter("aid")%>;
	}
var i = '<%=request.getAttribute("tagtype")%>';

var sele = document.getElementById(i);
sele.style="    text-shadow: 1px 1px 1px gray;background-color:white;color:black;";
if(i == "all")
	sele.style="text-shadow: 1px 1px 1px gray;background-color:white;color:black;border-top-left-radius:1em;border-bottom-left-radius:2em;";
	else if(i == "5"&&"${isHost} "== no)
		sele.style="text-shadow: 1px 1px 1px gray;background-color:white;color:black;border-top-right-radius:1em;border-bottom-right-radius:2em;";

</script>
<div class = "content">
<font size="5px">${art.title}</font><div style = "text-align:right">

<a href = "/my_evolution/harticle?tagname=m${art.tag}"  >tag:${tagArray[art.tag]}</a>
</div>
____________________________________________${art.datetime}
</div>

<div class = "content">
${art.content}</div>
<br>
<c:if test='${isHost eq "yes" }'>
<button class = "button black" onclick = "change()" style="margin-left:30px">修改文章</button>
</c:if>
<div id = "noSignUp" >
	<div id = "div3" style="margin-left:30px;padding:5px;color:#ccc"></div>
	<div id = "div1"  style="margin-left:30px;width:500px;background:white">
<!--  <div id="div2" class="tool"></div>

<div id = "div1" class="text"></div>
-->
</div>
<script type="text/javascript">

    var E = window.wangEditor;
    var editor = new E("#div1")
	editor.customConfig.uploadImgShowBase64=true;
    editor.customConfig.menus=['head','bold','italic','underline','strikeThrough',
                               'foreColor','backColor','link','image','undo','redo'];

    editor.customConfig.uploadImgServer = '/my_evolution/uploadImg?host='+${host}+'&message=1';
// = true;
    editor.create();
    function  getc() {
        // 获取编辑器区域完整html代码
        var html = editor.txt.html();
        var r = document.getElementById("div3").innerText;
        var text=editor.txt.text();
        if(r !== "")
        	r+="<br>";
        	if(text!==""||html.indexOf("img")!=-1)
        document.getElementById("main").value=r+html;
      
       document.getElementById("amess").submit();
     
    };
</script>
<form id = "amess" action = "/my_evolution/amessage?host=${host }&acount=${acount}" method = "POST">
</br>
<label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
<textarea name = "message" placeholder = "输入你想说的话..." style="display:none" id = "main"></textarea>
<label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
<input type = "text" value = "${art.id }" style= "display:none" name="aid"/>
<input type = "button" value = "评论" class = "button black" onclick ="getc()"/> 
<input type = "text"  style="display:none" name="response" id = "resp"> 
<input type = "button" value = "取消" class = "button black" onclick = "back()"/>
</form>

</div>

<script>
function changeDisplay()
{
document.getElementById("noSignUp").style.display="block";
}
function back()
{
	var a = document.getElementById("div1");
	//alert(a.innerHTML);
	//a.innerHTML='<div style="background-color:#f1f1f1; border:1px solid #ccc;" class="w-e-toolbar"><div class="w-e-menu" style="z-index:10001;"><i class="w-e-icon-header"><i></i></i></div><div class="w-e-menu" style="z-index:10001;"><i class="w-e-icon-bold"><i></i></i></div><div class="w-e-menu" style="z-index:10001;"><i class="w-e-icon-italic"><i></i></i></div><div class="w-e-menu" style="z-index:10001;"><i class="w-e-icon-underline"><i></i></i></div><div class="w-e-menu" style="z-index:10001;"><i class="w-e-icon-strikethrough"><i></i></i></div><div class="w-e-menu" style="z-index:10001;"><i class="w-e-icon-pencil2"><i></i></i></div><div class="w-e-menu" style="z-index:10001;"><i class="w-e-icon-paint-brush"><i></i></i></div><div class="w-e-menu" style="z-index:10001;"><i class="w-e-icon-link"><i></i></i></div><div class="w-e-menu" style="z-index:10001;"><i class="w-e-icon-image"><i></i></i></div><div class="w-e-menu" style="z-index:10001;"><i class="w-e-icon-undo"><i></i></i></div><div class="w-e-menu" style="z-index:10001;"><i class="w-e-icon-redo"><i></i></i></div></div><div style="border:1px solid #ccc; border-top:none; height:300px; z-index:10000;" class="w-e-text-container"><div id="div4"style="width:100%; height:100%;" class="w-e-text" contenteditable="true"><p><br></p></div></div>';
	document.getElementById("resp").value="-1";
	document.getElementById("div3").innerText="";
	document.getElementsByClassName("w-e-text")[0].focus();
}
function respon(id,name)
{
	var  temp = document.getElementById("div1");
	
	document.getElementById("div3").innerHTML="@"+name;
	document.getElementById("resp").value=id;
	document.getElementsByClassName("w-e-text")[0].focus();
	}

</script>
<label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
<font color = white>当前共有<%=((ArrayList<message>) request.getAttribute("aMes")).size() %>条评论...</font></br>
<c:forEach var = "message" items="${aMes}" varStatus="vast">
<div class = "content">
<div style="width:120px;float:left;" >
<img src='${message.avatar }' border=2px style="width:100px;height:100px"/>
<label >${message.name}<br></label>
<button id = "resp${message.id }" class="resp" onclick='respon(${message.id},"${message.name}")' >回复</button>
<font size=2px>${message.id}楼</font>
</div>
<div style="width:600px;">
${message.content}

—————————————————————<font size=1px>${message.datetime}</font>
</div>

</div>
</c:forEach>


		<% if (((String)request.getAttribute("isIn")).equals("yes"))
			;
		else {
			
			out.print("<script>alert(\"游客身份不能评论！请登录或者注册！\");</script>");
		}
			%>
	</body>
	</body>
</html>