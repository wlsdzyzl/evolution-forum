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
		.error{
		max-width:300px;
		left:20px;
background:white;

border-style:groove;

}
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
				font-size:0.81em;
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
    max-width: 100%;
    position: relative;
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
h1
{
        color: #fff;   
        text-shadow:0 0 10px;   
        letter-spacing: 1px;   
   	
}

.notshow{
display:none;
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
        .littlebutton{
width: 70px;
line-height: 25px;
text-align: center;
font-weight: bold;
color: #fff;

text-shadow:1px 1px 1px #333;
border-radius: 5px;
margin:0 20px 20px 0;
position: relative;
overflow: hidden;
}
.button.black,.littlebutton.black{
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
.checkkey
{
    left: 30px;
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
<script>

function sub(key)
{

	if(document.getElementById("plan").selected)
		{
		document.getElementById("tag").value = "plan";
		}
	else 
		{
		document.getElementById("tag").value = "dream";
		}
	
	document.getElementById("formid").submit();
	}
function check()
{
	
	var password1 = document.getElementById("p1").value;
	var password2 = document.getElementById("p2").value;
	//alert(password1);
	var format  = /^[A-Za-z0-9]+$/;
	var haha = 0;
	   if(password1 != password2) 
		   {
		   haha=1;
		   document.getElementById("e3").style.display="block";
		   }
	   else
		   {
		   document.getElementById("e3").style.display="none";
		   }
	   if(password2.length>25||password2.length<6)
	   {
		   haha=1;
		   document.getElementById("e1").style.display="block";
		   }
	   else
		   {
		   document.getElementById("e1").style.display="none";
		   }
	 
	   if(!format.test(password2)) 
	   {
	   haha=1;
	   document.getElementById("e2").style.display="block";
	   }
   else
	   {
	   document.getElementById("e2").style.display="none";
	   }
	   if(haha==0)
		   document.getElementById("formid").submit();
}
</script>
<div class = "checkkey">
<c:if test = "${username eq dapname}" >
<c:if test="${key != null}">
<form id = "formid" action = "/my_evolution/PlanAndDream?host=${host }" method = "POST">
<select class = "button black" > 
<option id = "plan" selected = "selected">plan</option>
<option id = "dream" >dream</option>
</select>
<br>
<textarea placeholder = "input your dreams or plan" name = "content" id = "content" style="height:150px; width:100%"></textarea>
<br><br>
<input type = text id = "tag" style = "display:none" name = "tag"/>
<button  onclick = 'sub("${key}")' class = "button black" >提交</button>

</form>
</c:if>

<c:if test="${key == null}">

<br><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><font color = white>你还没有注册一个密钥，无法为你的计划加密！</font>

<br>
<form action="/my_evolution/PlanAndDream?host=${host }" method = "POST" id = "formid">
<label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
	 <input type=password  id = "p1" SIZE="50 " height = "30" style="padding:8px 6px;" placeholder = "在这里输入密钥（英文字母和数字）"onmouseover="this.style.borderColor='white';this.style.backgroundColor='plum'"  
    style="width: 106; height: 21" onmouseout="this.style.borderColor='black';this.style.backgroundColor='#ffffff'" style = "border-width:1px;border-color=black" />  
    	 <br><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
    	<input type=password name="key" id = "p2"  SIZE="50 " height = "30" style="padding:8px 6px;" placeholder = "重复密钥（英文字母和数字）"onmouseover="this.style.borderColor='white';this.style.backgroundColor='plum'"  
    style="width:106;  height:21" onmouseout="this.style.borderColor='black';this.style.backgroundColor='#ffffff'" style = "border-width:1px;border-color=black" />  
<div style="display:none " id = "e1"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label ><font color = "red"><strong>*密钥长度过长或者过短（6-25）！</strong></font> </label></div>
<div style="display:none" id = "e2"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label ><font color = "red"><strong>*含有不支持的字符！ </strong></font> </label> </div>
  <div  style="display:none" id = "e3"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label><font color = "red"><strong>*两次密钥不一致！  </strong></font> </label> </div>     
<br><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><input type = "button" class = "button black" onclick = "check()" value = "注册密钥">
<br>
</form>
</c:if>

</c:if>
</div>
<h1 >${dapname}'s dreams</h1>
<div class = content>
<c:forEach var = "dream" items="${dreams}" varStatus="vast">
●${dream.content}<br>
</c:forEach>
</div>

<h1 >${dapname}'s plans</h1>
<script>
function achieve( i)
{
document.getElementById("show"+i).style.display="block";
	}
</script>

<div class = content id ="plans">
<%  
ArrayList<plan> plans = (ArrayList<plan>)request.getAttribute("plans");
String username = (String)request.getAttribute("username");
String dapname = (String)request.getAttribute("dapname");
String key = (String)request.getAttribute("key");
if(dapname.equals(username))
{
	int index = 0;
for(plan i :plans){%>
	●<%=i.getContent()%><br>
	<% if(i.getDown() == 0){%>
		○<u><%= crypt.decrypt(i.getContent(),key)%></u>
	
		<button onclick = 'achieve(<%=index %>)' class = "littlebutton black " >achieve</button>
		<div  class = "notshow" id = 'show<%=index %>'><form action="/my_evolution/achieve?host=${host }&pid=<%=index %>" method = "POST"><input type = "text" placeholder = "输入你的密钥" name = "key" /><input type = submit value="完成这个计划！"></form></div>
		<br>
<%}else
{%>★Flashed At <%=i.getStartTime() %><br>
   ★Achieved At <%=i.getEndTime() %><br>
	<% }
	index++; } 

}

else
{
	
int isdown = 0;
	for (plan i :plans){
		
	isdown = i.getDown();
	if(isdown == 0){%>●
	<%=i.getContent()%>
<br>
	<%}else {%>
		○
	<%=i.getContent()%><br>
	★Flashed At <%=i.getStartTime() %><br>
   ★Achieved At <%=i.getEndTime() %><br>
<%}}}%>

</div>

	</body>
</html>