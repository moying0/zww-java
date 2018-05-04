<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户管理<span class="c-gray en">&gt;</span> 编辑用户 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-product-add">
	   	<input type="hidden" name="id" value="${member.id }" id="id">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">用户名：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<%-- <input type="text" class="input-text" value="${member.name }" placeholder="" id="name" name="name"> --%>
				<span>${member.name }</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">用户金币数：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="${member.coins }" placeholder="" id="coins" name="coins">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">用户强爪券数：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="${member.account.superTicket }" placeholder="" id="superTicket" name="superTicket">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" id="subbtn" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>
<script type="text/javascript">
	$(function() {
		
		//表单提交并验证
		$("#form-product-add").validate({
			rules:{
				coins:{
					required:true,
					number:true,
				},
			},
			onkeyup:false,
			focusCleanup:false,
			success:"valid",
			submitHandler:function(form){
			    
			    $.ajax({
	            type : "post",
	            url : "memberManage/memberUpdate",
	            dataType : "json",
	           	data : $("#form-product-add").serialize(),
	            success : function(data) {
	            	if(data == "1"){
	            	    /* alert(window.name); */
	            		/* alert("添加成功！"); */
	            		$("#subbtn").attr("disabled", true);
						var index = parent.layer.getFrameIndex(window.name);
						
						parent.layer.msg('保存成功'); 
	    	        	parent.location.reload();	//自动刷新父窗口
	    	        	parent.layer.close(index);	//关闭当前弹出层
						
						/* parent.layer.close(index);
				        alert("添加成功！"); */
	            		/* window.location.href="system/getAllMenuList.do"; */
	            	}else if(data == "0"){
	            		layer.msg('保存失败',{time: 5000 });
	            	}else if(data == "2"){
	            		layer.msg('系统故障',{time: 5000 });
	            	}else if(data == "3"){
	            		layer.msg('异常账号',{time: 5000 });
	            	}else{
	            	    layer.msg(''+data.msg,{time: 5000 });
	            	}
	            },
	            error : function(err) {
	                alert("保存失败！");
	            }
	        });  
		   }
		});
		
	});
		
</script>
