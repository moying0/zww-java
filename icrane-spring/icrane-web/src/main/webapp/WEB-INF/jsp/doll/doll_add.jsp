<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<!-- <link href="static/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="static/resources/css/bootstrap-fileinput.css" rel="stylesheet"> -->
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 娃娃机管理<span class="c-gray en">&gt;</span> 添加娃娃机 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-product-add">
	   	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">娃娃机编号：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="machineCode" name="machineCode">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>娃娃机名称：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="name" name="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="description" name="description">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>机器类型：</label>
			<div class="formControls col-xs-8 col-sm-2">
				<select class="input-text" id="machineType" value="" name="machineType" style="width:200px">
					<option value="0">普通房</option>
					<option value="1">练习房</option>
					<option value="2">强抓房</option>
				</select>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>机器地址：</label>
			<div class="formControls col-xs-8 col-sm-2">
				<select class="input-text" id="dollAddressId" value="" name="dollAddressId" style="width:200px">
					<c:forEach items="${dollAddress}" var="address" >
						<option value="${address.id}">${address.province}${address.city}${address.county}${address.street}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>娃娃编号：</label>
			<div class="formControls col-xs-8 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="" id="dollID" name="dollID">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>娃娃数量：</label>
			<div class="formControls col-xs-8 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="" id="quantity" name="quantity">
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>价格：</label>
			<div class="formControls col-xs-8 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="" id="price" name="price">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>游戏时间：</label>
			<div class="formControls col-xs-8 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="" id="timeout" name="timeout">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">排序：</label>
			<div class="formControls col-xs-8 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="" id="watchingNumber" name="watchingNumber">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>兑换金币数：</label>
			<div class="formControls col-xs-8 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="" id="redeemCoins" name="redeemCoins">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>设备码：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="machineSerialNum" name="machineSerialNum">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>设备名称：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="machineUrl" name="machineUrl">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>队列名称：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="machineIp" name="machineIp">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Topic名称：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="mnsTopicName" name="mnsTopicName">
			</div>
		</div>
		<!-- <div class="row cl">
                <div class="h4">图片预览</div>
                <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">
                    <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                        <img id='picImg' style="width: 100%;height: auto;max-height: 140px;" src="images/noimage.png" alt="" />
                    </div>
                    <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                    <div align="center">
                        <span class="btn btn-primary btn-file">
                            <span class="fileinput-new">选择文件</span>
                            <span class="fileinput-exists">换一张</span>
                            <input type="file" name="file" id="file" accept="image/gif,image/jpeg,image/x-png"/>
                        </span>
                        <a href="javascript:;" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
                    </div>
                </div>
		</div> -->
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>推牛地址：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="rtmpPushUrl" name="rtmpPushUrl">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>拉牛地址1：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="rtmpUrl1" name="rtmpUrl1">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>拉牛地址2：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="rtmpUrl2" name="rtmpUrl2">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">拉牛地址3：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="rtmpUrl3" name="rtmpUrl3">
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
			    name:{
					required:true,
					rangelength:[1,50],
				},
				quantity:{
					required:true,
					number:true,
				},
                dollID:{
                    required:true,
                },
				price:{
					required:true,
					number:true,
				},
				dollName:{
					required:true,
					number:true,
				},
				redeemCoins:{
					required:true,
					number:true,
				},
				machineSerialNum:{
					required:true,
				},
				machineUrl:{
					required:true,
				},
				machineIp:{
					required:true,
				},
				rtmpUrl1:{
					required:true,
				},
				rtmpUrl2:{
					required:true,
				},
				rtmpPushUrl:{
					required:true,
				},
				mnsTopicName:{
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
	            url : "dollManage/dollInsert",
	            dataType : "json",
	           	data : $("#form-product-add").serialize(),
	            success : function(data) {
	            	if(data == "1"){
	            	    /* alert(window.name); */
	            		/* alert("添加成功！"); */
	            		$("#subbtn").attr("disabled", true);
						var index = parent.layer.getFrameIndex(window.name);
						
						parent.layer.msg('添加成功');
	    	        	parent.location.reload();	//自动刷新父窗口
	    	        	parent.layer.close(index);	//关闭当前弹出层
						
						/* parent.layer.close(index);
				        alert("添加成功！"); */
	            		/* window.location.href="system/getAllMenuList.do"; */
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
