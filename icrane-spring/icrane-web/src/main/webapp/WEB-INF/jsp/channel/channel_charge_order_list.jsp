<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户管理<span class="c-gray en">&gt;</span> 充值订单列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="${path}/channelManage/listChargeHistory" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<form id="frm" action="channelManage/listChargeHistory" method="post" >
<div class="page-container">
	
	<!-- 筛选功能 div -text-c -->
	<div class="text-c">
	    <span>
			<select class="input-text" id="registerChannel" value="${registerChannel}" name="registerChannel" style="width:150px">
				<option value="">渠道</option>
				<c:forEach items="${memberList}" var="memberList">
					<c:choose>
						<c:when test="${memberList.registerChannel==registerChannel}">
							<option value="${memberList.registerChannel}"  selected>${memberList.registerChannel }</option>
						</c:when>
						<c:when test="${empty memberList.registerChannel}">
							<option value="2" >无渠道号</option>
						</c:when>
						<c:otherwise>
							<option value="${memberList.registerChannel}">${memberList.registerChannel }</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
			<input  name="memberName" id="memberName" value="${memberName}" placeholder="输入用户名" style="width:120px" class="input-text">
			<input  name="memberId" id="memberId" value="${memberId}" placeholder="输入用户id" style="width:120px" class="input-text">
			<select class="input-text" id="chargeName" value="${chargeName}" name="chargeName" style="width:120px">
				<option value="">充值规则</option>
				<c:forEach items="${chargeRules}" var="chargeRules">
					<c:choose>
						<c:when test="${chargeRules.id==chargeName}">
							<option value="${chargeRules.id}"  selected>${chargeRules.chargeName }</option>
						</c:when>
						<c:otherwise>
							<option value="${chargeRules.id}">${chargeRules.chargeName }</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
			<select class="input-text" id="charge_state" value="${charge_state}" name="charge_state" style="width:100px">
				<option value="">订单状态</option>
				<option value="1" <c:if test="${charge_state==1}">selected="selected"</c:if>>已完成</option>
				<option value="0" <c:if test="${charge_state==0}">selected="selected"</c:if>>未完成</option>
			</select>
			<select class="input-text" id="lastLoginFrom" name="lastLoginFrom" style="width:100px">
					<option value="">设备</option>
					<option value="android" <c:if test="${lastLoginFrom=='android'}">selected="selected"</c:if>>android</option>
					<option value="ios" <c:if test="${lastLoginFrom=='ios'}">selected="selected"</c:if>>ios</option>
			</select>
			<input type="text" name="create_date" id="create_date" value="${create_date}"
				   onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})"
				   placeholder="输入开始时间" style="width:120px" class="input-text Wdate">
			<input type="text" name="endtime" id="endtime" value="${endtime}"
				   onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})"
				   placeholder="输入结束时间" style="width:120px" class="input-text Wdate">

			<%--<input type="submit" value="查询数据 "  name="button" class="button">&nbsp;&nbsp;--%>
			<button name="" id="searchs" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
		</span>
		 <%--<span>
		    <button name="" id="inputuser" class="btn btn-success" type="submit">导入/导出会员卡列表</button>
	    </span>--%>

	</div>
	
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><!-- <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> --> </span>
		<span class="l">充值人数：<strong>${allNum }</strong> 人</span>
		<span class="l" style="margin-left: 150px">充值金额（元）：<strong>${empty allPrice?0: allPrice}</strong> 元</span>
		<span class="r">共有数据：<strong>${pageBean.totalCount }</strong> 条</span>
	</div>
	<div class="mt-20">
		<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper no-footer">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th width="40">登录渠道号</th>
					<th width="40">注册渠道号</th>
					<th width="40">id</th>
					<th width="80">订单编号</th>
					<th width="50">充值规则</th>
					<th width="40">充值金额</th>
					<th width="40">用户id</th>
					<th width="50">用户名</th>
					<th width="40">订单状态</th>
					<th width="40">充值前</th>
					<th width="40">充值</th>
					<th width="40">赠送</th>
					<th width="80">充值时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageBean.list}" var="charge_order">
					<tr class="text-c">
						<td>${charge_order.loginChannel }</td>
						<td>${charge_order.registerChannel }</td>
						<td>${charge_order.id }</td>
						<td>${charge_order.orderNo }</td>
						<td>${charge_order.chargeName }</td>
						<td>${charge_order.price }</td>
						<td>${charge_order.memberNum }</td>
						<td>${charge_order.memberName }</td>
						<td>
							<c:if test="${charge_order.chargeState ==0}">未完成</c:if>
							<c:if test="${charge_order.chargeState ==1}">已完成</c:if>
						</td>
						<td>${charge_order.coinsBefore }</td>
						<td>${charge_order.coinsCharge }</td>
						<td>${charge_order.coinsOffer }</td>
						<td><fmt:formatDate value='${charge_order.createDate }' pattern='yyyy-MM-dd HH:mm:ss'/></td>
						<%--<td><fmt:formatDate value='${charge_order.updateDate }' pattern='yyyy-MM-dd HH:mm:ss'/></td>--%>
						<%--<td class="td-status"><span class="label label-success radius">${charge_order.onlineFlg==true?"在线":"离线" }</span></td>--%>
						<%--<td class="f-14 td-manage"><a style="text-decoration:none" class="ml-5" onClick="member_edit('用户编辑','memberManage/toEditMember','${charge_order.id}','','')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> &lt;%&ndash; <a style="text-decoration:none" class="ml-5" onClick="member_del(this,'${member.id}')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a> &ndash;%&gt;</td>--%>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
			    <tr>
					<td colspan="18">
					<jsp:include page= "/WEB-INF/jsp/common/pagination.jsp" flush= "true">
					<jsp:param name= "page_url" value= "channelManage/listChargeHistory"/>
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
