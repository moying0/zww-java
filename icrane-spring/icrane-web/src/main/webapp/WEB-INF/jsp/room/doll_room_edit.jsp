<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<!-- <link href="static/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="static/resources/css/bootstrap-fileinput.css" rel="stylesheet"> -->
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理房间<span class="c-gray en">&gt;</span> 修改房间 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-product-add">

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>房间编号：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="${dollRoomNew.roomNo}" placeholder="" id="roomNo" name="roomNo">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>房间名称：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="hidden" class="input-text" value="${dollRoomNew.id}" placeholder="" id="id" name="id">
				<input type="text" class="input-text" value="${dollRoomNew.roomName}" placeholder="" id="roomName" name="roomName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">娃娃名称：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<select class="input-text" id="dollId" name="dollId" style="width:250px">
					<c:forEach items="${dollInfo}" var="doll">
						<c:choose>
							<c:when test="${doll.id==dollRoomNew.dollId}">
								<option value="${doll.id}"  selected>${doll.dollName}--${doll.dollCode}</option>
							</c:when>
							<c:otherwise>
								<option value="${doll.id}">${doll.dollName}--${doll.dollCode}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
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
//				description:{
//					 required:true,//表单不能为空校验
//				}
               /* hyperlink:{
                    required:true,
                },
                validStartDate:{
                    required:true,
                },
                validEndDate:{
                    required:true,
                }*/

			},
			onkeyup:false,
			focusCleanup:false,
			success:"valid",
			submitHandler:function(form){
				/* var data = new FormData($('#form-product-add')[0]); */
			    $.ajax({
	            type : "post",
	            url : "roomManage/roomUpdate",
	            dataType : "json",
	           	data : $("#form-product-add").serialize(),
	            success : function(data) {
                    if(data == "1"){
	            		$("#subbtn").attr("disabled", true);
						var index = parent.layer.getFrameIndex(window.name);
						
						parent.layer.msg('修改成功');
	    	        	parent.location.reload();	//自动刷新父窗口
	    	        	parent.layer.close(index);	//关闭当前弹出层
						

	            	}else if(data == "0"){
	            		layer.msg('修改失败',{time: 5000 });
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
