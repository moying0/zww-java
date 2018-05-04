<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户申诉管理<span class="c-gray en">&gt;</span> 用户列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="${path}/memberAppealManage/doneList" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<form id="frm" action="memberAppealManage/doneList" method="post" >
<div class="page-container">
	
	<!-- 筛选功能 div -text-c -->
	<div class="text-c"> 
	    <span>
			<input type="text" name="MemberId" id="MemberId" value="${MemberId}" placeholder="输入用户id" style="width:200px" class="input-text">
			<%--<input type="text" name="name" id="name" value="${name}" placeholder="输入用户名" style="width:200px" class="input-text">--%>
			<%--<input type="text" name="registerDate" id="registerDate"--%>
				   <%--value="${registerDate}"--%>
				   <%--onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})" placeholder="输入注册时间" style="width:200px"  class="input-text Wdate">--%>
			<%--<select class="input-text" id="lastLoginFrom" name="lastLoginFrom" style="width:200px">--%>
					<%--<option value="">设备</option>--%>
					<%--<option value="android" <c:if test="${lastLoginFrom=='android'}">selected="selected"</c:if>>android</option>--%>
					<%--<option value="ios" <c:if test="${lastLoginFrom=='ios'}">selected="selected"</c:if>>ios</option>--%>
			<%--</select>--%>
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
					<th width="30" >id</th>
					<th width="60">游戏编号</th>
					<%--<th width="80">用户id</th>--%>
					<th width="60">用户id</th>
					<th width="50">用户昵称</th>
					<%--<th width="50">用户手机</th>--%>
					<%--<th width="50">娃娃机id</th>--%>
					<th width="70">娃娃机头像</th>
					<th width="80">娃娃机名称</th>
					<th width="50">消耗金币</th>
					<%--<th width="50">抓取记录id</th>--%>
					<th width="55">抓取时间</th>
					<th width="50">抓取结果</th>
					<th width="50">申诉原因</th>
					<th width="50">审核状态</th>
					<th width="50">审核原因</th>
					<th width="55">申诉时间</th>
					<th width="55">处理时间</th>
					<%--<th width="40">审核</th>--%>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageBean.list}" var="member"> 
					<tr class="text-c">
						<td>${member.id }</td>
						<td>${member.gameNum }</td>
						<%--<td>${member.memberId }</td>--%>
						<td>${member.memberNum}</td>
						<td>${member.memberName }</td>
						<%--<td>${member.memberPhone }</td>--%>
						<%--<td>${member.dollId }</td>--%>
						<td><img width="80" class="picture-thumb" src="${member.dollImg }"></td>
						<td>${member.dollName }</td>
						<td>${member.dollCions }</td>
						<%--<td>${member.memberCatchId }</td>--%>
						<td><fmt:formatDate value="${member.memberCatchDate }" pattern="yy-MM-dd HH:mm:ss"></fmt:formatDate></td>
						<td>${member.memberCatchResult }</td>
						<td>${member.complaintReason }</td>
						<td>
							<c:if test="${member.checkState==-1 }">驳回</c:if>
							<c:if test="${member.checkState==1 }">返娃娃币</c:if>
							<c:if test="${member.checkState==2 }">补发娃娃</c:if>
						</td>
						<td>${member.checkReason }</td>
						<td><fmt:formatDate value="${member.creatDate }" pattern="yy-MM-dd HH:mm:ss"></fmt:formatDate></td>
						<td><fmt:formatDate value="${member.modifyDate }" pattern="yy-MM-dd HH:mm:ss"></fmt:formatDate></td>


					<%--<td>--%>
							<%--<a class="btn btn-primary radius"  data-title="待处理申诉" data-href="javascript:;" onclick="charge_query('申诉处理','memberAppealManage/appealPass','${member.id}',1,'','')" href="javascript:;">通过</a>--%>
							<%--<a class="btn btn-danger radius" style="margin-top: 5px" data-title="待处理申诉" data-href="javascript:;" onclick="charge_query('申诉处理','memberAppealManage/appealPass','${member.id}',-1,'','')" href="javascript:;">驳回</a>--%>
						<%--</td>--%>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
			    <tr>
					<td colspan="18">
					<jsp:include page= "/WEB-INF/jsp/common/pagination.jsp" flush= "true">
					<jsp:param name= "page_url" value= "memberAppealManage/doneList"/>
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

function charge_query(title,url,id,state,w,h){
	url = url+"?id="+id+"&state="+state;
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
