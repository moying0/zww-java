<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 被邀请人查询 <span class="c-gray en">&gt;</span> 邀请管理<span class="c-gray en">&gt;</span> 被邀请人查询 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="${path}/ShareInviteManage/shareInvite?id=${id}" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<form id="frm" action="ShareInviteManage/shareInvite?id=${id}" method="post" >
<div class="page-container">
	
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><!-- <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> --> </span>
		<span class="l">充值人数：<strong>${total }</strong> 人</span>
		<%--<span class="l" style="margin-left: 100px">充值总金额：<strong>${pageBean.totalCount }</strong> 条</span>--%>
		<%--<span class="l" style="margin-left: 100px">邀请获得币数：<strong>${pageBean.totalCount }</strong> 条</span>--%>
		<span class="r">共有数据：<strong>${pageBean.totalCount }</strong> 条</span>
	</div>
	<div class="mt-20">
		<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper no-footer">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th width="50" >id</th>
					<th width="80">用户id</th>
					<th width="80">用户序号</th>
					<th width="80">用户名</th>
					<%--<th width="80">充值规则</th>--%>
					<%--<th width="80">充值金额</th>--%>
					<th width="80">被邀请时间</th>
					<%--<th width="80">充值时间</th>--%>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageBean.list}" var="catchs">
					<tr class="text-c">
						<td>${catchs.id }</td>
						<td>${catchs.memberID }</td>
						<td>${catchs.invitedId }</td>
						<td>${catchs.name }</td>
						<%--<td>${catchs.name }</td>--%>
						<%--<td>${catchs.name }</td>--%>
						<td><fmt:formatDate value="${catchs.createDate }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
						<%--<td><fmt:formatDate value="${catchs.createDate }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>--%>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
			    <tr>
					<td colspan="18">
					<jsp:include page= "/WEB-INF/jsp/common/pagination.jsp" flush= "true">
					<jsp:param name="page_url" value= "ShareInviteManage/shareInvite?id=${id}" />
					</jsp:include>
					</td>
			    </tr>
			</tfoot>
		</table>
			<!-- <div class="dataTables_info" id="DataTables_Table_0_info" role="status" aria-live="polite">显示 1 到 1 ，共 1 条</div> --> 
			<!-- <div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate"><a class="paginate_button previous disabled" aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0" id="DataTables_Table_0_previous">上一页</a><span><a class="paginate_button current" aria-controls="DataTables_Table_0" data-dt-idx="1" tabindex="0">1</a></span><a class="paginate_button next disabled" aria-controls="DataTables_Table_0" data-dt-idx="2" tabindex="0" id="DataTables_Table_0_next">下一页</a></div> -->
		</div>
	</div>
</div>
</form>