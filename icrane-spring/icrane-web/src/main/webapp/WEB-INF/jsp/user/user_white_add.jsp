<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<!-- <link href="static/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="static/resources/css/bootstrap-fileinput.css" rel="stylesheet"> -->
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管用户理<span class="c-gray en">&gt;</span> 添加白名单 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-product-add">
		 <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户序号：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="userId" name="userId">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">用户id：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="memberId" name="memberId">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="userName" name="userName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户IP：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="192.168.2.1" id="userIP" name="userIP">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户状态：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="例：1" id="states" name="states">
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
	            url : "memberWhite/memberWhiteAdd",
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
