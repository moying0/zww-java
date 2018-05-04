<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户管理<span class="c-gray en">&gt;</span> 用户交易记录列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="${path}/memberChargeManage/list" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<form id="frm" action="memberChargeManage/list" method="post" >
<div class="page-container">
	
	<!-- 筛选功能 div -text-c -->
	<div class="text-c"> 
	    <span>
			<input type="text" name="memberId" id="memberId" value="${memberId}" placeholder="输入用户id" style="width:250px" class="input-text">
			<!-- <input type="submit" value="查询数据 "  name="button" class="button">&nbsp;&nbsp; -->
			<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
		</span>
		<!-- <span> 
		    <button name="" id="" class="btn btn-success" type="submit">导入/导出会员卡列表</button>
	    </span> -->
	</div>
	
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><!-- <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> --> </span> <span class="r">共有数据：<strong>${pageBean.totalCount }</strong> 条</span> </div>
	<div class="mt-20">
		<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper no-footer">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th width="40" >id</th>
					<th width="40">用户id</th>
					<th width="40">充值金额</th>
					<th width="40">金币数</th>
					<th width="50">充值类型</th>
					<th width="80">获取金币方式</th>
					<th width="40">房间号</th>
					<th width="50">加(减)币前金币</th>
					<th width="50">加(减)币后金币</th>
					<th width="80">充值时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageBean.list}" var="charge_order">
					<tr class="text-c">
						<td>${charge_order.id }</td>
						<td>${charge_order.memberId }</td>
						<td>${charge_order.prepaidAmt }</td>
						<td>${charge_order.coins }</td>
						<td>${charge_order.type }</td>
						<td>${charge_order.chargeMethod }</td>
						<td>${charge_order.dollId}</td>
						<td>${charge_order.coinsBefore }</td>
						<td>${charge_order.coinsAfter }</td>
						<td>${charge_order.chargeDate }</td>
						</tr>
				</c:forEach>
			</tbody>
			<tfoot>
			    <tr>
					<td colspan="18">
					<jsp:include page= "/WEB-INF/jsp/common/pagination.jsp" flush= "true">
					<jsp:param name= "page_url" value= "memberChargeManage/list"/>
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
    /* $('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"pading":false,
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0]}// 不参与排序的列
	],
	"sAjaxSource" :"/dollManage/list",
	"serverSide": true
});   */  

/*用户-添加*/
function doll_add(title,url,w,h){
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.iframeAuto(index);
	layer_show(title,url,w,h);
}

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

/*添加*/
/* function article_add(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
} */
/*上传图片*/
function doll_upload(title,url,id,w,h){
	url = url+"?id="+id;
	layer_show(title,url,w,h);
}

function dollImage_edit(title,url,name,id,w,h){
	 url = url+"?name="+name+"&doll_id="+id;
	/* layer_show(title,url,w,h); */
	 window.location.href=url;
}

/*编辑*/
function member_edit(title,url,id,w,h){
	 url = url+"?id="+id;
	layer_show(title,url,w,h);
}
/*删除*/
function doll_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: 'dollManage/dollDel',
			dataType: 'json',
			data:{id:id},
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

/*资讯-发布*/
function article_start(obj,id){
	layer.confirm('确认要发布吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布!',{icon: 6,time:1000});
	});
}
/*资讯-申请上线*/
function article_shenqing(obj,id){
	$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
	$(obj).parents("tr").find(".td-manage").html("");
	layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
}

/*头像图片编辑*/
function picture_edit(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
</script> 
