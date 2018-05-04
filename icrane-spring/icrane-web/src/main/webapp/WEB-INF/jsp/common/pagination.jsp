<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function goPage(url,pageindex,totalPages){//跳转到输入页数
	if(pageindex>totalPages||pageindex<1){
		alert("你输入的页码不正确");
	}else{
		document.forms[0].action = url.indexOf("?")>0?(url+"&page="+pageindex):(url+"?page="+pageindex);
		document.forms[0].submit();
	}
}
function pagination(url,pageindex){
	if($("#frm").attr('method')=='get'||$("#frm").attr('method')=='GET'){
		location.href=url.indexOf("?")>0?(url+"&page="+pageindex):(url+"?page="+pageindex);
	}else{
		document.forms[0].action = url.indexOf("?")>0?(url+"&page="+pageindex):(url+"?page="+pageindex);
		document.forms[0].submit();
	}
}
</script>
<div class="pagination">
	<a><div class="dataTables_info" role="status" aria-live="polite">共有 <b>${pageBean.totalCount}条/${pageBean.totalPage}页</b></div> </a>
	<div class="dataTables_paginate paging_simple_numbers">
	<a class="paginate_button" href="javascript:pagination('<%=request.getParameter("page_url")%>',1);">首页</a>
	<a class="paginate_button" <c:if test="${1 lt pageBean.page}">href="javascript:pagination('<%=request.getParameter("page_url")%>',${pageBean.page-1});"</c:if>>上一页</a>
    <!-- 分页游标 -->
	<c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1" var="i">
		<c:if test="${i eq pageBean.page}">
			<a class="paginate_button current">${i}</a>
		</c:if>
		<c:if test="${i ne pageBean.page}">
			<a class="paginate_button" href="javascript:pagination('<%=request.getParameter("page_url")%>',${i});">${i}</a>
		</c:if>
	</c:forEach>
	
	<a class="paginate_button"
		<c:if test="${pageBean.page lt pageBean.totalPage}">href="javascript:pagination('<%=request.getParameter("page_url")%>',${pageBean.page+1});"</c:if>>下一页</a>
	<a class="paginate_button" href="javascript:pagination('<%=request.getParameter("page_url")%>',${pageBean.totalPage});">尾页</a>
	<input type="text" size="3" value="${page.page}" id="pageindex">
	<input type="button" class="paginate_button" value="跳 转" onclick="javascrpt:goPage('<%=request.getParameter("page_url")%>',document.getElementById('pageindex').value,${page.totalPages});">
	</div>
</div> 