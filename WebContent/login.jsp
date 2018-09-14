<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>登录邮箱</title>
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
<script type="text/javascript">
	function validate(f){
		var value=f.value;
		if(!/^\w+@\w+.\w+$/.test(value)){
		document.getElementById("msg").innerHTML="email格式不正确！";
		f.focus();
		f.select();
		}else{
		document.getElementById("msg").innerHTML="";
		}
	}
</script>
</head>

<body style="width: 100%;height: 100%;background-image: url(2.jpg);background-size:100%;overflow: hidden" >
<form id="form1" name="form1" method="post" action="login.do" >
<div  style="width: 100%;height: 100%; ">
<h1 align="center" style="margin-top: 150px;color: #333300" >欢迎登陆邮件收发系统</h1>
<div style="width:300px;height:300px; margin: 0 auto;margin-top: 50px">
  <p>账&nbsp;&nbsp;&nbsp;户:
    <input style="width: 200px;height: 25px" type="text" name="userName" onblur="validate(this)"/><span id="msg"></span>
  </p>
  <p>密&nbsp;&nbsp;&nbsp;码:
    <input style="width: 200px;height: 25px" type="password" name="password" />
  </p>
  <p>验证码:
    <input style="width: 150px;height: 25px" name="code" type="text" size="8" />
	<a href="javascript:changeCode();">
	<img  title="点击更换" id="code" src="ValidateCode.do" border="0"/>
	</a>
	
  </p>
  <p>
    <input style="width: 70px;height: 35px;font-size: 16px" type="submit" name="Submit" value="登录" />&nbsp;
    <input style="width: 70px;height: 35px;font-size: 16px" type="reset" value="重置"/>&nbsp;&nbsp;&nbsp;
    <a href="regist.jsp">注册账号</a>
</p>
</div>
</div>
</form>

</body>
</html>
<script>
	function changeCode()
	{
		var timenow = new Date().getTime(); 
		document.getElementById("code").src="ValidateCode.do?t="+timenow;
	}
</script>
