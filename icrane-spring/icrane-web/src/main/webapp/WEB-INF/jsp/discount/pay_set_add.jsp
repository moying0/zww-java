<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<!-- <link href="static/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="static/resources/css/bootstrap-fileinput.css" rel="stylesheet"> -->
<article class="page-container">

	<form action="" method="post" class="form form-horizontal" id="form-product-add">
	<div class="row cl">
	<label class="form-label col-xs-3 col-sm-3"><span class="c-red">*</span>为必填：</label>
	</div>
	   <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>充值类型</label>
			<div class="formControls col-xs-8 col-sm-6">
				<select class="input-text" id="chargeType" name="chargeType">
					<option value="0">普通包</option>
					<option value="1">时长包</option>
					<option value="2">周卡</option>
					<option value="3">月卡</option>
					<option value="4">首充</option>
				</select>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>名称</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="" placeholder="" id="chargeName" name="chargeName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>前台排序</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="" placeholder="1排在最前" id="orderby" name="orderby">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>价格（元）</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="" placeholder="" id="chargePrice" name="chargePrice">
			</div>
		</div>
		<div class="row cl type2">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>期限</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="" placeholder="" id="chargeDateLimit" name="chargeDateLimit">
			</div>
		</div>
		<div class="row cl type2">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>折扣</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="" placeholder="" id="discount" name="discount">
			</div>
		</div>
		<div class="row cl type2">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>娃娃币(首次)</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="" placeholder="" id="cionsFirst" name="cionsFirst">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>娃娃币<span id="coinsChargeTxt">(每日)</span></label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="" placeholder="" id="coinsCharge" name="coinsCharge">
			</div>
		</div>
		<div class="row cl type1">
			<label class="form-label col-xs-4 col-sm-3">赠送娃娃币</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="" placeholder="" id="coinsOffer" name="coinsOffer">
			</div>
		</div>
		<div class="row cl type1">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>钻石</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="" placeholder="" id="superTicketCharge" name="superTicketCharge">
			</div>
		</div>
		<%--<div class="row cl type1">--%>
			<%--<label class="form-label col-xs-4 col-sm-3">赠送钻石</label>--%>
			<%--<div class="formControls col-xs-8 col-sm-6">--%>
				<%--<input type="text" class="input-text" value="" placeholder="" id="superTicketOffer" name="superTicketOffer">--%>
			<%--</div>--%>
		<%--</div>--%>
		<div class="row cl type1">
			<label class="form-label col-xs-4 col-sm-3">限购次数</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="" placeholder="" id="chargeTimesLimit" name="chargeTimesLimit">
			</div>
		</div>
	
          <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">说明文字</label>
			<div class="formControls col-xs-8 col-sm-6">
				 <textarea rows="3" cols="55" placeholder="" id="description" name="description"></textarea>
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
                superTicketCharge:{
                    required:true,
                    number:true,
                },
			},
			onkeyup:false,
			focusCleanup:false,
			success:"valid",
			submitHandler:function(form){
				/* var data = new FormData($('#form-product-add')[0]); */
			    $.ajax({
	            type : "post",
	            url : "payManage/payInsert",
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
	                alert("添加失败！");
	            }
	        });  
		   }
		});
        orderby();
		chargeTypeBind();
	});
	//根据充值类型 展示表单元素
	function formtypeLoad(){
		var curChargeType = $("#chargeType").find("option:selected").val();
		if (curChargeType==0 || curChargeType==4) {
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
