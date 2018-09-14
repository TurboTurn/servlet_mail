<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>账户注册</title>
<script language="javascript">
		var xmlHttp ;
		var flag = false ;
		function createXMLHttp(){
			if(window.XMLHttpRequest){
				xmlHttp = new XMLHttpRequest() ;
			} else {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP") ;
			}
		}
		function checkUserid(userid){
			createXMLHttp() ;
			xmlHttp.open("POST","CheckServlet?userid="+userid) ;
			xmlHttp.onreadystatechange = checkUseridCallback ;
			xmlHttp.send(null) ;
			document.getElementById("msg").innerHTML = "正在验证..." ;
		}
		function checkUseridCallback(){
			if(xmlHttp.readyState == 4){
				if(xmlHttp.status == 200){
					
					var text = xmlHttp.responseText ;
					if(text == "true"){	// 用户id已经存在了
						document.getElementById("msg").innerHTML = "用户ID重复，无法使用！" ;
						flag = false ;
					} else {
						document.getElementById("msg").innerHTML = "此用户ID可以注册！" ;
						flag = true ;
					}
				}
			}
		}
		function checkForm(){
			return flag ;
		}
	</script>
	<style type="text/css">
	a{
	text-decoration: none;
	color: #ff0033;
	}
	input,p{
	font-family: "微软雅黑";
	font-size: 18px;
	
	}
	span{
	color: red;
	font-size: 14px;
	}
</style>
</head>
<body style="width: 100%;height: 100%;background-image: url(2.jpg);background-size:100%;overflow: hidden" >
<form action="regist" method="post" onsubmit="return checkForm()">
<div align="left" style="width:300px;height:300px; margin: 0 auto;margin-top: 150px">
		<p>用&nbsp;户&nbsp;&nbsp;名：<input style="width: 200px;height: 25px" type="text" name="username" 
		value="请输入用户名" onclick="if(this.value==this.defaultValue){this.value=''}" 
		onblur="if(this.value==''){this.value=this.defaultValue};checkUserid(this.value)" />
		<br></br><span id="msg"></span></p>
		<p>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" /></p>
		<p>确认密码：<input type="password" name="verifypass" /></p>
		<p>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：<input type="text" name="nickname" /></p>
		<p align="left">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<input type="radio" name="sex" value="男" checked/>男
				<input type="radio" name="sex" value="女"/>女</p>
		<p>出生年月：<input type="date" name="birth"/></p>
		
		<p>
			<input type="submit" value="注册"/>&nbsp;&nbsp;
			<input type="reset" value="重置"/>
		</p>
		</div>
	</form>
</body>
</html>