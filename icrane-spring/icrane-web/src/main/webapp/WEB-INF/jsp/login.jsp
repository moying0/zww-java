<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="${path }/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="${path }/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="${path }/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="${path }/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<title>365抓娃娃后台登录</title>
<meta name="keywords" content="365抓娃娃后台管理系统">
<meta name="description" content="365抓娃娃后台管理系统">
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<!-- <div class="header"></div> -->
<div class="loginWraper">
  <div id="loginform1" class="loginBox">
    <form class="form form-horizontal" action="login" method="post" name="loginForm" id="loginForm">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input type="text"  name="loginname" id="loginname"  value="${loginname }" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input name="password" id="password" value="${password }" type="password"  class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input name="code" id="code" class="input-text size-L" type="text"  value="" style="width:150px;">
          <img id="codeImg" alt="点击更换" title="点击更换" src=""> <!-- <a id="kanbuq" href="javascript:;">看不清，换一张</a> --></div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <label for="online">
            <input type="checkbox" id="autologin" name="autologin" class="autologin" value="">
            使我保持登录状态</label>
            <input type="hidden" id="autologinch" name="autologinch"  class="autologinch" value=""/>
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input name="" type="button" class="btn btn-success radius size-L" onclick="login()" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">Copyright 365抓娃娃 2015-2017</div>
<script type="text/javascript" src="${path }/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${path }/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript">
 	var msg='${message}';
 	if(msg!=''){
 		alert(msg); 
 	}
	$(document).ready(function(){
		
		changeCode();
		$("#codeImg").bind("click",changeCode);
		$("#loginname").focus();
	});
	
	function genTimestamp(){
		var time = new Date();
		return time.getTime();
	}
	
	function changeCode(){
		$("#codeImg").attr("src","${path }/code?t="+genTimestamp());
	}
	
	function check(){
		if($("#loginname").val()==""){
			alert("用户名不能为空！");
			$("#loginname").focus();
			return false;
		}
		if($("#password").val()==""){
			alert("密码不能为空！");
			$("#password").focus();
			return false;
		}
		if($("#code").val()==""){
			alert("验证码不能为空！");
			$("#code").focus();
			return false;
		}
		if($(".autologin").is(":checked")){
	    	$(".autologinch").val("Y");
	    }
		return true;
	}
	
	function login(){
		var rs=check();
		if(rs){
			document.loginForm.submit(); 
		}
			
	}    
</script>
</body>
</html>