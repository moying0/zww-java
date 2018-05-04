<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 广告管理<span class="c-gray en">&gt;</span> 广告列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="${path}/bannerManage/list" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<form id="frm" action="dollManage/list" method="post" >
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
	
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
		<a class="btn btn-primary radius" data-title="添加广告" data-href="javascript:;" onclick="banner_add('添加广告','bannerManage/bannerToAdd','','')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加广告</a></span>
		<span class="r">共有数据：<strong>${pageBean.totalCount }</strong> 条</span> </div>
	<div class="mt-20">
		<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper no-footer">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th width="20"><input type="checkbox" name="" value=""></th>
					<th width="30" >ID</th>
					<th width="60">图片</th>
					<th width="80">描述</th>
					<th width="30">banner类型</th>
					<th width="150">超链接</th>
					<th width="30">超链接类型</th>
					<th width="40">支付第几个套餐</th>
					<th width="30">排序</th>
					<th width="60">过期开始时间</th>
					<th width="60">过期结束时间</th>
					<th width="40">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageBean.list}" var="banner"> 
					<tr class="text-c">
						<td><input type="checkbox" value="" name=""></td>
						<td>${banner.id }</td>
						<td><a class="maincolor" href="javascript:;" onclick="banner_upload('广告头像','bannerManage/toUpload','${banner.id}','','')"><img width="80" class="picture-thumb" src="${banner.imageUrl }"></a></td>
						<td>${banner.description }</td>
						<td>
							<c:if test="${banner.type == '0'}">banner</c:if>
							<c:if test="${banner.type == '1'}">悬浮窗</c:if>
						</td>
						<td>${banner.hyperlink }</td>
						<td>
							<c:if test="${banner.linkType == 0}">跳转链接</c:if>
							<c:if test="${banner.linkType == 1}">跳转支付页</c:if>
							<c:if test="${banner.linkType == 2}">跳转分享</c:if>
							<c:if test="${banner.linkType == 3}">跳转支付套餐</c:if>
							<c:if test="${banner.linkType == 4}">身份认证</c:if>
						</td>
						<td>${banner.payIndex }</td>
						<td>${banner.sorts }</td>
						<td><fmt:formatDate value='${banner.validStartDate }' pattern='yyyy-MM-dd HH:mm:ss'/></td>
						<td><fmt:formatDate value='${banner.validEndDate }' pattern='yyyy-MM-dd HH:mm:ss'/></td>
						<td class="f-14 td-manage"><a style="text-decoration:none" class="ml-5" onClick="doll_edit('广告编辑','bannerManage/toEditbanner','${banner.id}','','')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="doll_del(this,'${banner.id}')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
			    <tr>
					<td colspan="18">
					<jsp:include page= "/WEB-INF/jsp/common/pagination.jsp" flush= "true">
					<jsp:param name= "page_url" value= "bannerManage/list"/>
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

/*广告-添加*/
function banner_add(title,url,w,h){
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.iframeAuto(index);
	layer_show(title,url,w,h);
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
function banner_upload(title,url,id,w,h){
	url = url+"?id="+id;
	layer_show(title,url,w,h);
}

function bannerImage_edit(title,url,name,id,w,h){
	 url = url+"?name="+name+"&doll_id="+id;
	/* layer_show(title,url,w,h); */
	 window.location.href=url;
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
			url: 'bannerManage/bannerDel',
			dataType: 'json',
			data:{bannerId:id},
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
