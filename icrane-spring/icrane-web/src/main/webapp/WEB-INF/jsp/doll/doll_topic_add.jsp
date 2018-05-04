<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<!-- <link href="static/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="static/resources/css/bootstrap-fileinput.css" rel="stylesheet"> -->
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理娃娃机<span class="c-gray en">&gt;</span> 添加主题 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-product-add">

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">娃娃机名称：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<select class="input-text" id="dollId" name="dollId" style="width:250px">
					<c:forEach items="${dollList}" var="doll">
						<option value="${doll.id}">${doll.name}--${doll.machineCode}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>房间类型：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="例：1,2……" id="roomType" name="roomType">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>主题名称：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="topicName" name="topicName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>房间分组：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<select class="input-text" id="groupid" name="groupid" style="width:250px">
					<option value="1">首页不显示</option>
					<option value="0">首页显示</option>
				</select>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" id="subbtn" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>
<script src="static/resources/js/bootstrap-fileinput.js"></script>
<script type="text/javascript">
	$(function() {
		
		//表单提交并验证
		$("#form-product-add").validate({
			rules:{
                roomType:{
					 required:true,//表单不能为空校验
				},
                topicName:{
                    required:true,
                }

			},
			onkeyup:false,
			focusCleanup:false,
			success:"valid",
			submitHandler:function(form){
				/* var data = new FormData($('#form-product-add')[0]); */
			    $.ajax({
	            type : "post",
	            url : "dollTopicManage/dollTopicAdd",
	            dataType : "json",
	           	data : $("#form-product-add").serialize(),
	            success : function(data) {
                    if(data == "1"){
	            		$("#subbtn").attr("disabled", true);
						var index = parent.layer.getFrameIndex(window.name);
						
						parent.layer.msg('添加成功');
	    	        	parent.location.reload();	//自动刷新父窗口
	    	        	parent.layer.close(index);	//关闭当前弹出层
						

	            	}else if(data == "0"){
	            		layer.msg('添加失败',{time: 5000 });
	            	}else if(data == "2"){
	            		layer.msg('系统故障',{time: 5000 });
	            	}else if(data == "3"){
	            		layer.msg('异常账号',{time: 5000 });
	            	}else{
	            	    layer.msg(''+data.msg,{time: 5000 });
	            	}
	            },
	            error : function(err) {
	                alert("失败！");
	            }
	        });  
		   }
		});
		
	});
		
</script>
