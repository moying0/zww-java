<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<article class="page-container" id="pageContainer" style="visibility: none;">
	<form action="" method="post" class="form form-horizontal" id="form-product-add">
	<input type="hidden" name="id" value="${chargeRules.id }" id="id">
	<div class="row cl">
	<label class="form-label col-xs-3 col-sm-3"><span class="c-red">*</span>为必填：</label>
	</div>
	   <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>充值类型</label>
			<div class="formControls col-xs-8 col-sm-6">
				<select class="input-text" id="chargeType" name="chargeType" >
					<option value="0" <c:if test="${chargeRules.chargeType == 0 }">selected="selected"</c:if>>普通包</option>
					<option value="1" <c:if test="${chargeRules.chargeType == 1 }">selected="selected"</c:if>>时长包</option>
					<option value="2" <c:if test="${chargeRules.chargeType == 2 }">selected="selected"</c:if>>周卡</option>
					<option value="3" <c:if test="${chargeRules.chargeType == 3 }">selected="selected"</c:if>>月卡</option>
					<option value="4" <c:if test="${chargeRules.chargeType == 4 }">selected="selected"</c:if>>首充</option>
				</select>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>规则状态</label>
			<div class="formControls col-xs-8 col-sm-6">
				<select class="input-text" id="rulesStatus" name="rulesStatus" >
					<option value="1" <c:if test="${chargeRules.rulesStatus == 1 }">selected="selected"</c:if>>上架</option>
					<option value="0" <c:if test="${chargeRules.rulesStatus == 0 }">selected="selected"</c:if>>下架</option>
				</select>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>名称</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="${chargeRules.chargeName }" placeholder="" id="chargeName" name="chargeName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>前台排序</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="${chargeRules.orderby }" placeholder="1排在最前" id="orderby" name="orderby">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>价格（元）</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="${chargeRules.chargePrice }"  placeholder="" id="chargePrice" name="chargePrice">
			</div>
		</div>
		<div class="row cl type2">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>期限</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="${chargeRules.chargeDateLimit }" placeholder="" id="chargeDateLimit" name="chargeDateLimit">
			</div>
		</div>
		<div class="row cl type2">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>折扣</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="${chargeRules.discount}" placeholder="" id="discount" name="discount">
			</div>
		</div>
		<div class="row cl type2">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>娃娃币(首次)</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="${chargeRules.cionsFirst }" placeholder="" id="cionsFirst" name="cionsFirst">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>娃娃币<span id="coinsChargeTxt">(每日)</span></label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="${chargeRules.coinsCharge }" placeholder="" id="coinsCharge" name="coinsCharge">
			</div>
		</div>
		<div class="row cl type1">
			<label class="form-label col-xs-4 col-sm-3">赠送娃娃币</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="${chargeRules.coinsOffer }" placeholder="" id="coinsOffer" name="coinsOffer">
			</div>
		</div>
		<div class="row cl type1">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>钻石</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="${chargeRules.superTicketCharge}" placeholder="" id="superTicketCharge" name="superTicketCharge">
			</div>
		</div>
		<%--<div class="row cl type1">--%>
			<%--<label class="form-label col-xs-4 col-sm-3">赠送钻石</label>--%>
			<%--<div class="formControls col-xs-8 col-sm-6">--%>
				<%--<input type="text" class="input-text" value="${chargeRules.superTicketOffer}" placeholder="" id="superTicketOffer" name="superTicketOffer">--%>
			<%--</div>--%>
		<%--</div>--%>
		<div class="row cl type1">
			<label class="form-label col-xs-4 col-sm-3">限购次数</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="${chargeRules.chargeTimesLimit }" placeholder="" id="chargeTimesLimit" name="chargeTimesLimit">
			</div>
		</div>
	
          <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">说明文字</label>
			<div class="formControls col-xs-8 col-sm-6">
				 <textarea  rows="3" cols="55"  placeholder="" id="description" name="description">${chargeRules.description }</textarea>
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
				chargeName:{
					required:true
				},
				orderby:{
					required:true
				},
				chargePrice:{
					required:true,
					number:true,
				},
				coinsCharge:{
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
	            url : "payManage/ruleUpdate",
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

		formtypeLoad();
		chargeTypeBind();
	});
	
	//根据充值类型 展示表单元素
	function formtypeLoad(){
		var curChargeType = $("#chargeType").find("option:selected").val();
		if (curChargeType==0 ||curChargeType==4) {
			//时长包隐藏
			chargeTypeShow("type1");
			chargeTypeHide("type2");
			//每日两个字显示
			$("#coinsChargeTxt").hide();
			//
			$("#chargeDateLimit").val(0);
			$("#cionsFirst").val(0);
		}  else {
			//普通包隐藏
			chargeTypeShow("type2");
			chargeTypeHide("type1");
			$("#coinsChargeTxt").show();
			$("#chargeTimesLimit").val(0);
			$("#coinsOffer").val(0);
		}
	}
	//切换充值类型包绑定
	function chargeTypeBind(){
		$("#chargeType").change(function(){
			formtypeLoad();
		});
	}
	
	function chargeTypeShow(type){
		$("div[class='row cl "+type+"']").each(function(n,o){
			$(o).show();
		});
	}
	
	function chargeTypeHide(type){
		$("div[class='row cl "+type+"']").each(function(n,o){
			$(o).hide();
		});
	}
		
</script>
