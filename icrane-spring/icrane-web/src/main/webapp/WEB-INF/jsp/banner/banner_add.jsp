<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<!-- <link href="static/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="static/resources/css/bootstrap-fileinput.css" rel="stylesheet"> -->
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 广告管理<span class="c-gray en">&gt;</span> 添加广告 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-product-add">
	   <div class="row cl">
	   			<%-- <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>图片预览：</label>
                <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload" style="margin-top: 30px">
                    <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                        <img id='picImg' style="width: 100%;height: auto;max-height: 300px;" src=${imgPath=="1"?"static/resources/images/noimage.png":imgPath } alt="" />
                    </div>
                    <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 300px; max-height: 150px;"></div>
                    <div style="margin-top: 10px">
                        <span class="btn btn-primary btn-file">
                            <span class="fileinput-new">选择文件</span>
                            <span class="fileinput-exists">换一张</span>
                            <input type="file" name="file" id="picID" accept="image/gif,image/jpeg,image/x-png"/>
                        </span>
                        <a href="javascript:;" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
                    </div>
                </div> --%>
		</div>
		 <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>描述：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="description" name="description">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">banner类型：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<select class="input-text" id="type" name="type" style="width:200px">
					<option value="0" >banner</option>
					<option value="1" >悬浮窗</option>
					<option value="2" >启动页</option>
					<option value="3" >广告弹窗</option>
				</select>

			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>超链接：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="" id="hyperlink" name="hyperlink">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">超链接类型：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<select class="input-text" id="linkType" name="linkType" style="width:200px">
					<option value="0" >跳转链接</option>
					<option value="1" >跳转支付页</option>
					<option value="2" >跳转分享</option>
					<option value="3" >跳转支付套餐</option>
					<option value="4" >身份验证</option>
					<option value="5" >QQ群</option>
				</select>

			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">支付第几个套餐：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<select class="input-text" id="payIndex" name="payIndex" style="width:200px">
					<option value="0">充值规则</option>
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
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>排序：</label>
			<div class="formControls col-xs-8 col-sm-8">
				<input type="text" class="input-text" value="" placeholder="例：1" id="sorts" name="sorts">
			</div>
		</div>
		 <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>过期开始时间：</label>
			<div class="formControls col-xs-8 col-sm-4">
			<input id="validStartDate" name="validStartDate" class="input-text Wdate"
          onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})" value="" />
			</div>	
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>过期结束时间：</label>
			<div class="formControls col-xs-8 col-sm-4">
				<input type="text" class="input-text Wdate" value="" placeholder="" id="validEndDate" name="validEndDate"
					   onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})" value=""/>
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
				description:{
					 required:true,//表单不能为空校验
				}
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
	            url : "bannerManage/bannerAdd",
	            dataType : "json",
	           	data : $("#form-product-add").serialize(),
	            success : function(data) {
                    /*alert("添加成功！");*/
                    if(data == "1"){
	            	    /* alert(window.name); */
	            		 /*alert("添加成功！"); */
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
