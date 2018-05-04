<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<!-- <link href="static/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="static/resources/css/bootstrap-fileinput.css" rel="stylesheet"> -->
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 发货管理<span class="c-gray en">&gt;</span> 订单详情 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="mt-20">
		<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper no-footer">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<!-- <th width="50"><input type="checkbox" name="" value=""></th> -->
					<th width="50" >ID</th>
					<th width="80">娃娃名称</th>
					<th width="80">发货数量</th>
					<th width="80">娃娃编号</th>
					<th width="80">娃娃头像</th>
					<!-- <th width="80"></th>
					<th width="80">操作</th> -->
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itemList}" var="item"> 
					<tr class="text-c">
						<td>${item.id }</td>
						<td>${item.doll.name}</td>
						<td>${item.quantity}</td>
						<td>${item.dollCode}</td>
						<td><img width="80" class="picture-thumb" src="${item.doll.tbimgRealPath }"></td>
					</tr>
				</c:forEach>
			</tbody>
			<%-- <tfoot>
			    <tr>
					<td colspan="18">
					<jsp:include page= "/WEB-INF/jsp/common/pagination.jsp" flush= "true">
					<jsp:param name= "page_url" value= "goodsManage/list"/>
					</jsp:include>
					</td>
			    </tr>
			</tfoot> --%>
		</table>
			<!-- <div class="dataTables_info" id="DataTables_Table_0_info" role="status" aria-live="polite">显示 1 到 1 ，共 1 条</div> --> 
			<!-- <div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate"><a class="paginate_button previous disabled" aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0" id="DataTables_Table_0_previous">上一页</a><span><a class="paginate_button current" aria-controls="DataTables_Table_0" data-dt-idx="1" tabindex="0">1</a></span><a class="paginate_button next disabled" aria-controls="DataTables_Table_0" data-dt-idx="2" tabindex="0" id="DataTables_Table_0_next">下一页</a></div> -->
		</div>
	</div>
</div>
<script src="static/resources/js/bootstrap-fileinput.js"></script>
<script type="text/javascript">
	
</script>
