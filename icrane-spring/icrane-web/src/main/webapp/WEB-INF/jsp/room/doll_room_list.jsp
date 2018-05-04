<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 广告管理<span class="c-gray en">&gt;</span> 广告列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="${path}/roomManage/list" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<form id="frm" action="roomManage/list" method="post" >
<div class="page-container">
	
	<!-- 筛选功能 div -text-c -->
	<div class="text-c"> 
	    <%-- <span>
			<input type="text" name="name" id="name" value="${name}" placeholder="输入娃娃机名称" style="width:250px" class="input-text">
			<!-- <input type="submit" value="查询数据 "  name="button" class="button">&nbsp;&nbsp; -->
			<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
		</span> --%>
		<!-- <span> 
		    <button name="" id="" class="btn btn-success" type="submit">导入/导出会员卡列表</button>
	    </span> -->
	</div>
	
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
		<%--<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>--%>
		<a class="btn btn-primary radius" data-title="添加房间" data-href="javascript:;" onclick="banner_add('添加房间','roomManage/roomToAdd','','')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加房间</a></span>
		<span class="r">共有数据：<strong>${pageBean.totalCount }</strong> 条</span> </div>
	<div class="mt-20">
		<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper no-footer">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<%--<th width="20"><input type="checkbox" name="" value=""></th>--%>
					<th width="30" >ID</th>
					<th width="80">房间编号</th>
					<th width="80">房间名称</th>
					<th width="80">娃娃序号</th>
					<th width="80">娃娃名称</th>
					<th width="80">娃娃编号</th>
					<th width="60">创建时间</th>
					<th width="60">修改时间</th>
					<th width="40">添加机器</th>
					<th width="40">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageBean.list}" var="room">
					<tr class="text-c">
						<%--<td><input type="checkbox" value="" name=""></td>--%>
						<td>${room.id }</td>
						<td>${room.roomNo }</td>
						<td>${room.roomName }</td>
						<td>${room.dollId }</td>
						<td>${room.dollName }</td>
						<td>${room.dollNo }</td>
						<td><fmt:formatDate value='${room.createdDate }' pattern='yyyy-MM-dd HH:mm:ss'/></td>
						<td><fmt:formatDate value='${room.modifiedDate }' pattern='yyyy-MM-dd HH:mm:ss'/></td>
						<td><a class="btn btn-primary radius" data-title="添加机器" data-href="javascript:;" onclick="charge_query('添加机器','roomManage/roomItemToAdd','${room.id}','','')" href="javascript:;">添加</a></td>
						<td class="f-14 td-manage"><a style="text-decoration:none" class="ml-5" onClick="doll_edit('房间编辑','roomManage/toEditRoom','${room.id}','','')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="doll_del(this,'${room.id}')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
			    <tr>
					<td colspan="18">
					<jsp:include page= "/WEB-INF/jsp/common/pagination.jsp" flush= "true">
					<jsp:param name= "page_url" value= "roomManage/list"/>
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
<script type="text/javascript">


/*房间-添加*/
function banner_add(title,url,w,h){
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.iframeAuto(index);
	layer_show(title,url,w,h);
}



/*编辑*/
function doll_edit(title,url,id,w,h){
	 url = url+"?id="+id;
	layer_show(title,url,w,h);
}
/*删除*/
function doll_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: 'roomManage/roomDel',
			dataType: 'json',
			data:{roomId:id},
			success: function(data){
				if(data==1){
					$(obj).parents("tr").remove();
					layer.msg('已删除!',{icon:1,time:1000});
				}else{
					alert('删除失败！')
				}
				
			},
			error:function(data) {
				alert('删除失败!');
			},
		});		
	});
}



/*下架*/
function article_stop(obj,id){
	layer.confirm('确认要下架吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
		$(obj).remove();
		layer.msg('已下架!',{icon: 5,time:1000});
	});
}

//添加机器
function charge_query(title,url,id,w,h){
        url = url+"?id="+id;
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.iframeAuto(index);
        layer_show(title,url,w,h);
        /*var index = layer.open({
            type: 2,
            title: title,
            area: [650+'px', 420 +'px'],
            content: url
        });
        parent.layer.iframeAuto(index);
        */
    }
</script> 
