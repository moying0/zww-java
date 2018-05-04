<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 发货管理<span class="c-gray en">&gt;</span> 补全发货信息 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-product-add">
	   	<input type="hidden" name="id" value="${orderId}" id="id">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">快递名称：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="deliverMethod" name="deliverMethod">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">快递单号：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="deliverNumber" name="deliverNumber">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">快递价格：</label>
			<div class="formControls col-xs-8 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="" id="deliverAmount" name="deliverAmount">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="comment" name="comment">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" id="subbtn" type="submit" value="&nbsp;&nbsp;确定&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>
<script type="text/javascript">
	$(function() {
		
		//表单提交并验证
		$("#form-product-add").validate({
			rules:{
				deliverAmount:{
					number:true,
				}
			},
			onkeyup:false,
			focusCleanup:false,
			success:"valid",
			submitHandler:function(form){
			    $.ajax({
	            type : "post",
	            url : "goodsManage/orderUpdate",
	            dataType : "json",
	           	data : $("#form-product-add").serialize(),
	            success : function(data) {
	            	if(data == "1"){
	            	    /* alert(window.name); */
	            		/* alert("添加成功！"); */
	            		$("#subbtn").attr("disabled", true);
						var index = parent.layer.getFrameIndex(window.name);
						alert("发货成功！");
						/* parent.layer.msg('发货成功');  */
						/* parent.layer.msg('发货成功!',{icon:1,time:1000}); */
	    	        	parent.location.reload(); 	//自动刷新父窗口
	    	        	parent.layer.close(index);	//关闭当前弹出层
	    	        	 
	    	        	/* layer.msg('发货成功!',{icon:1,time:1000}); */	
						/* parent.layer.close(index);
				        alert("添加成功！"); */
	            		/* window.location.href="system/getAllMenuList.do"; */
	            	}else if(data == "0"){
	            		layer.msg('发货失败',{time: 5000 });
	            	}else if(data == "2"){
	            		layer.msg('系统故障',{time: 5000 });
	            	}else if(data == "3"){
	            		layer.msg('异常账号',{time: 5000 });
	            	}else{
	            	    layer.msg(''+data.msg,{time: 5000 });
	            	}
	            },
	            error : function(err) {
	                alert("发货失败！");
	            }
	        });  
		   }
		});
		
	});
		
</script>
