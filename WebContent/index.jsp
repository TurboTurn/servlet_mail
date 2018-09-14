<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>主页</title>
<style type="text/css">
    frameset {border:0px;}
    frame {border:0px;}
</style>
</head>

 <frameset rows="120,*,100" framespacing="0" frameborder="NO" border="0" marginwidth=”0″ marginheight=”0″>
        <frame name=topFrame noresize="noresize" scrolling="no" 
                            src=top.jsp marginheight="20">
        <frameset cols="280,*" framespacing="0" frameborder="NO" border="0">
            <frame src="left.html" name="leftFrame" scrolling="auto" noresize="noresize">
            <frame src="sendmail.jsp" name="mainFrame" scrolling="auto">
        </frameset>
        <frame name=bottomFrame noresize="noresize" scrolling="no" 
                            src=foot.jsp marginheight="0">
        <noframes>
            <body>
                <h1>不支持Frame</h1>
            </body>
        </noframes>
    </frameset>

</html>