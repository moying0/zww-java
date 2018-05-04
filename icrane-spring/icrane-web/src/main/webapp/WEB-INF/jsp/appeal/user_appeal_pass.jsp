<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<!-- <link href="static/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="static/resources/css/bootstrap-fileinput.css" rel="stylesheet"> -->
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 申诉管理<span class="c-gray en">&gt;</span> 通过申诉 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-product-add">
		<div class="page-container">
			<div class="mt-20">
				<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper no-footer">
					<div class="row cl">
						<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
							<label class="col-xs-4 col-sm-3" style="font-size: 15px;"><strong >通过理由:</strong></label>
						</div>
						<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
							<textarea style="margin:20px auto" rows="6" cols="55" placeholder="" id="checkReason" name="checkReason"></textarea>
						</div>
					</div>
					<div class="row cl">
						<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3" >
							<input class="btn btn-primary radius" id="subbtn" type="submit" onclick="check()" value="&nbsp;&nbsp;补发娃娃&nbsp;&nbsp;">
							<input class="btn btn-primary radius" id="subbtns" style="margin-left: 40px" onclick="checks()" type="submit" value="&nbsp;&nbsp;返币,钻&nbsp;&nbsp;">
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</article>
<script src="static/resources/js/bootstrap-fileinput.js"></script>
<script>
    function check() {
        $("#form-product-add").attr("action", "memberAppealManage/upPass?id=${id}&state=2");
//        $("#form-product-add").submit();
        parent.layer.msg('补发娃娃成功');
        parent.location.reload();	//自动刷新父窗口
        <%--$.ajax({--%>
            <%--type : "post",--%>
            <%--url : "memberAppealManage/upPass?id=${id}&state=2",--%>
            <%--dataType : "json",--%>
            <%--data : $("#form-product-add").serialize(),--%>
            <%--success : function(data) {--%>
                <%--if(data == "1"){--%>
                    <%--/* alert(window.name); */--%>
                    <%--/* alert("添加成功！"); */--%>
                    <%--$("#subbtn").attr("disabled", true);--%>
                    <%--var index = parent.layer.getFrameIndex(window.name);--%>

                    <%--parent.layer.msg('添加成功');--%>
                    <%--parent.location.reload();	//自动刷新父窗口--%>
                    <%--parent.layer.close(index);	//关闭当前弹出层--%>

                    <%--/* parent.layer.close(index);--%>
                    <%--alert("添加成功！"); */--%>
                    <%--/* window.location.href="system/getAllMenuList.do"; */--%>
                <%--}else if(data == "0"){--%>
                    <%--layer.msg('添加失败',{time: 5000 });--%>
                <%--}else if(data == "2"){--%>
                    <%--layer.msg('系统故障',{time: 5000 });--%>
                <%--}else if(data == "3"){--%>
                    <%--layer.msg('异常账号',{time: 5000 });--%>
                <%--}else{--%>
                    <%--layer.msg(''+data.msg,{time: 5000 });--%>
                <%--}--%>
            <%--},--%>
            <%--error : function(err) {--%>
                <%--alert("失败！");--%>
            <%--}--%>
        <%--});--%>
    }

    function checks() {
        $("#form-product-add").attr("action", "memberAppealManage/upPass?id=${id}&state=1");
//        $("#form-product-add").submit();
        parent.layer.msg('返币成功');
        parent.location.reload();	//自动刷新父窗口
        <%--$.ajax({--%>
            <%--type : "post",--%>
            <%--url : "memberAppealManage/upPass?id=${id}&state=1",--%>
            <%--dataType : "json",--%>
            <%--data : $("#form-product-add").serialize(),--%>
            <%--success : function(data) {--%>
                <%--if(data == "1"){--%>
                    <%--/* alert(window.name); */--%>
                    <%--/* alert("添加成功！"); */--%>
                    <%--$("#subbtn").attr("disabled", true);--%>
                    <%--var index = parent.layer.getFrameIndex(window.name);--%>

                    <%--parent.layer.msg('添加成功');--%>
                    <%--parent.location.reload();	//自动刷新父窗口--%>
                    <%--parent.layer.close(index);	//关闭当前弹出层--%>

                    <%--/* parent.layer.close(index);--%>
                    <%--alert("添加成功！"); */--%>
                    <%--/* window.location.href="system/getAllMenuList.do"; */--%>
                <%--}else if(data == "0"){--%>
                    <%--layer.msg('添加失败',{time: 5000 });--%>
                <%--}else if(data == "2"){--%>
                    <%--layer.msg('系统故障',{time: 5000 });--%>
                <%--}else if(data == "3"){--%>
                    <%--layer.msg('异常账号',{time: 5000 });--%>
                <%--}else{--%>
                    <%--layer.msg(''+data.msg,{time: 5000 });--%>
                <%--}--%>
            <%--},--%>
            <%--error : function(err) {--%>
                <%--alert("失败！");--%>
            <%--}--%>
        <%--});--%>
    }
</script>
