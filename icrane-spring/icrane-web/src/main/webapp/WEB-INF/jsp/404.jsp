<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>404</title>
<style>
*{margin:0; padding:0}
body{font-family:"微软雅黑"; background:#DAD9D7; font-size:0.6666666em;}
img{border:none; margin-top:3%;}
</style>
</head>
<body>
  <center>
    <img alt="页面出错...." src="<%=path%>/static/images/404.png">
    <p>页面出错.....</p>
  </center>
</body>
</html>