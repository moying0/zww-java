<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link href="static/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="static/resources/css/bootstrap-fileinput.css" rel="stylesheet">
<div class="container">
    <div class="page-header" align="center">
        <h3>娃娃机头像上传</h3>
            <form class="form-group" id="uploadForm" enctype='multipart/form-data'>
                <div class="h4" >图片预览</div>
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
                </div>
            </form>
            <div><button type="button" id="uploadSubmit" class="btn btn-info">提交</button></div>
    </div>
</div>
<script src="static/resources/js/bootstrap-fileinput.js"></script>
<script type="text/javascript">
    $(function () {
        //比较简洁，细节可自行完善
        $('#uploadSubmit').click(function () {
            var data = new FormData($('#uploadForm')[0]);
            
            $.ajax({
                url: 'dollImageManage/upload?id=${imageId}&imgRealPath=${imagePath}',
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
                	   layer.msg('上传失败',{time: 5000 });
                   }
                },
                error: function (data) {
                	alert("上传失败！");
                }
            });
        });

    })
</script>