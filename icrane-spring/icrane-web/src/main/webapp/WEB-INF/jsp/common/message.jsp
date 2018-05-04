<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if (request.getAttribute("message") != null) {
		out.print("<script>layer.alert('" + request.getAttribute("message") + "',-1);</script>");
	}
%>