<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>�˻�ע��</title>
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
			document.getElementById("msg").innerHTML = "������֤..." ;
		}
		function checkUseridCallback(){
			if(xmlHttp.readyState == 4){
				if(xmlHttp.status == 200){
					
					var text = xmlHttp.responseText ;
					if(text == "true"){	// �û�id�Ѿ�������
						document.getElementById("msg").innerHTML = "�û�ID�ظ����޷�ʹ�ã�" ;
						flag = false ;
					} else {
						document.getElementById("msg").innerHTML = "���û�ID����ע�ᣡ" ;
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
	font-family: "΢���ź�";
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
		<p>��&nbsp;��&nbsp;&nbsp;����<input style="width: 200px;height: 25px" type="text" name="username" 
		value="�������û���" onclick="if(this.value==this.defaultValue){this.value=''}" 
		onblur="if(this.value==''){this.value=this.defaultValue};checkUserid(this.value)" />
		<br></br><span id="msg"></span></p>
		<p>��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�룺<input type="password" name="password" /></p>
		<p>ȷ�����룺<input type="password" name="verifypass" /></p>
		<p>��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�ƣ�<input type="text" name="nickname" /></p>
		<p align="left">��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��<input type="radio" name="sex" value="��" checked/>��
				<input type="radio" name="sex" value="Ů"/>Ů</p>
		<p>�������£�<input type="date" name="birth"/></p>
		
		<p>
			<input type="submit" value="ע��"/>&nbsp;&nbsp;
			<input type="reset" value="����"/>
		</p>
		</div>
	</form>
</body>
</html>