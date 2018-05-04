<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<link href="lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<link href="static/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="static/resources/css/bootstrap-fileinput.css" rel="stylesheet">
<script src="static/resources/js/bootstrap-fileinput.js"></script>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="pay-detail-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-4">图片</label>
			<div class="formControls col-xs-8 col-sm-6">
				<div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload" style="margin-top: 30px">
                    <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:350px;">
                        <img id='picImg' style="width: 100%;height: auto;max-height: 300px;" src='static/resources/images/noimage.png' alt="" />
                    </div>
                    <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 300px; max-height: 350px;"></div>
                    <div style="margin-top: 10px">
                        <span class="btn btn-primary btn-file">
                            <span class="fileinput-new">选择文件</span>
                            <span class="fileinput-exists">换一张</span>
                            <input type="file" name="file" id="picID" accept="image/gif,image/jpeg,image/x-png"/>
                        </span>
                        <a href="javascript:;" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
                    </div>
                </div>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-4">
				<button id="uploadSubmit" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 提交</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</article>
<script type="text/javascript">
$(function () {
    //比较简洁，细节可自行完善
    $('#uploadSubmit').click(function () {
        var data = new FormData($('#pay-detail-add')[0]);
        $.ajax({
            url: 'payManage/uploadImage',
            type: 'POST',
            data: data,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
               if(data=="1"){
            	   var index = parent.layer.getFrameIndex(window.name);
					parent.layer.msg('上传成功！');
    	        	parent.location.reload();	//自动刷新父窗口
    	        	parent.layer.close(index);	//关闭当前弹出层
               }else{
            	   alert('上传失败!');
               }
            },
            error: function (data) {
            	alert("上传失败！");
            }
        });
        
    });
})
</script>
