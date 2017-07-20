<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import = "java.util.*,register.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<link rel = "stylesheet" type = "text/css" href = "./wangEditor-2.1.23/dist/css/wangEditor.min.css">
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
			#change {
				/* These styles have nothing to do with the ribbon */

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
        #editor {
            resize: vertical;
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
		</style>
	</head>
	<body id="change"  >
	<c:if test="${isHost ne 'yes' }">
	<script>alert("你无权发文！");</script>
	</c:if>
	<%String aid = request.getParameter("acount");
	if(aid==null)
		aid=request.getParameter("aid");
	if(aid==null&&((String)request.getAttribute("amend")).equals("no"))
		throw new Exception("无法得到上传图片的位置!");
	%>
		<script >
		
		var time = new Date().getSeconds();
		var back = document.getElementById("change");
		with(back.style)
		{
			background="url(./picture"+${host}+"/"+time%${icount}+".png)";
			backgroundSize="100%";
		}

	</script>
	<script type="text/javascript" src="./wangEditor-2.1.23/dist/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="./wangEditor-2.1.23/dist/js/wangEditor.min.js"></script>
		<div class='ribbon'>
			<a href='/my_evolution/index?host=${host }'><span>首页</span></a>
			<a href='/my_evolution/harticle?host=${host }'><span>博客</span></a>
				<a href='/my_evolution/photo?host=${host }'><span>图片</span></a>
			<a href='/my_evolution/lmessage?host=${host }'><span>留言板</span></a>
			<a href="/my_evolution/DAP?host=${host }"><span>DAP</span></a>
			<a href="/my_evolution/sureToVip?host=${host }"><span>VIP</span></a>
		</div>
		<br><br>
		<div id = "isHost" style = " width:60%;display:none">
	
	<form action = "/my_evolution/harticle?host=${ host}" method = "POST">	
	<input id="achange" style="display:none" type="text" value="-1" name="aid"/>	
	 <input id = "a_title" type=text name="title"  SIZE="100 " height = "30" style="padding:8px 6px;" placeholder = "title..."onmouseover="this.style.borderColor='white';this.style.backgroundColor='plum'"  
    style="width: 106; height: 21"  
    onmouseout="this.style.borderColor='black';this.style.backgroundColor='#ffffff'" style = "border-width:1px;border-color=black" />  
		
		<br>

		<select class ="button black">
		<option value="feel_good"id = "_0" >${tag1 }</option>
  <option value ="packour" id = "_1" >${tag2 }</option>
  <option value ="computer" id = "_2">${tag3 }</option>
  <option value="boring" id = "_3" selected = "selected">${tag4 }</option>
  <option value="feel_good"id = "_4" >${tag5 }</option>
  <option value="feel_good"id = "_5" >${tag6 }</option>
  
</select>
<br>
<c:if test='${amend eq "yes"}'>
<script>document.getElementById("a_title").value='${art.title}';
document.getElementById("_"+"${art.tag}").selected="selected";
document.getElementById("achange").value='<%=aid%>';
</script>
</c:if>
<div id="div1" style="height:300px;" >
<c:if test='${amend eq "yes"}'>
${art.content}
</c:if>
</div>


<script type="text/javascript">
    var editor = new wangEditor('div1');
    editor.config.uploadImgUrl = '/my_evolution/uploadImg?host='+${host}+'&acount='+<%=aid%>;
    editor.create();
   function  getc() {
        // 获取编辑器区域完整html代码
        var html = editor.$txt.html();
        var text = editor.$txt.text().substring(0,20).replace("<","&lt;");
        text = text.replace(">",'&gt;');
        document.getElementById("main").value=html;
       /*
       */
      
       if(document.getElementById("_1").selected)
    	    document.getElementById("tag").value = "1";
       else if(document.getElementById("_2").selected)
   	    document.getElementById("tag").value = "2";
       else if(document.getElementById("_3").selected)
      	    document.getElementById("tag").value = "3";
       else if(document.getElementById("_4").selected )
      	    document.getElementById("tag").value = "4";
       else if(document.getElementById("_5").selected )
     	    document.getElementById("tag").value = "5";
       else if(document.getElementById("_0").selected)
     	    document.getElementById("tag").value = "0";
       document.getElementById("ftext").value=text;
       document.getElementById("sub").click();
     
    };
</script>

<button id = "#btn1" class = "button black"  onclick = "getc()">发表</button>

<div style="display:none">
<textarea name = "content" style = "display:none" id = "main"></textarea>
</div>
<input type = "text" name = "tag" value = "3"  id = "tag" style = "display:none"/>
<input type = "text" name = "ftext" id = "ftext" style= "display:none"/>
<input type = "submit" id = "sub" style="display:none"/>


</form>
</div>
<c:if test='${isHost eq "yes"}'>
<script>
document.getElementById("isHost").style.display="block";
</script>
</c:if>



	</body>
</html>