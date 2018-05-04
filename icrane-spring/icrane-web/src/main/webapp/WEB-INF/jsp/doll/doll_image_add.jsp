<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<link href="lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<link href="static/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="static/resources/css/bootstrap-fileinput.css" rel="stylesheet">
<script src="static/resources/js/bootstrap-fileinput.js"></script>
<div class="page-container">
	<form action="" method="post" class="form form-horizontal" id="uploadForm" enctype='multipart/form-data'>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>娃娃机名称：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="dollId" id="dollId" class="select">
				  <option value="${doll_id==0?0:doll_id }">${name==''?'==请选择==':doll_id==0?'==请选择==':name}</option>
                  <c:forEach items="${dollList}" var="item">
                  	 	<option value="${item.id==doll_id?0:item.id}">${item.id==doll_id?'==请选择==':item.name}</option>
                  </c:forEach>
				</select>
				</span> </div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">缩略图：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<%-- <div class="uploader-thum-container">
					<div id="fileList" class="uploader-list"><img id='picImg' style="width: 100%;height: auto;max-height: 300px;" src=${imgPath=="1"?"static/resources/images/noimage.png":imgPath } alt="" /></div>
					<div id="filePicker">选择图片</div>
					<button id="btn-star" class="btn btn-default btn-uploadstar radius ml-10">开始上传</button>
				</div> --%>
				<div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload" style="margin-top: 30px">
                    <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                        <img id='picImg' style="width: 100%;height: auto;max-height: 300px;" src='static/resources/images/noimage.png' alt="" />
                    </div>
                    <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 300px; max-height: 150px;"></div>
                    <div style="margin-top: 10px">
                        <span class="btn btn-primary btn-file">
                            <span class="fileinput-new">选择文件</span>
                            <span class="fileinput-exists">换一张</span>
                            <input type="file" name="file" id="picID" multiple="multiple" accept="image/gif,image/jpeg,image/x-png"/>
                        </span>
                        <a href="javascript:;" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
                    </div>
                </div>
			</div>
		</div>
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">图片上传：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div class="uploader-list-container">
					<div class="queueList">
						<div id="dndArea" class="placeholder">
							<div id="filePicker-2"></div>
							<p>或将照片拖到这里，单次最多可选300张</p>
						</div>
					</div>
					<div class="statusBar" style="display:none;">
						<div class="progress"> <span class="text">0%</span> <span class="percentage"></span> </div>
						<div class="info"></div>
						<div class="btns">
							<div id="filePicker2"></div>
							<div class="uploadBtn">开始上传</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">详细内容：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<script id="editor" type="text/plain" style="width:100%;height:400px;"></script> 
			</div>
		</div> -->
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="uploadSubmit" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 提交</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">
$(function () {
    //比较简洁，细节可自行完善
    $('#uploadSubmit').click(function () {
        var data = new FormData($('#uploadForm')[0]);
        var dollId = $("#dollId").val();
        if(dollId==0){
        	alert('请选择娃娃机名称!');
        }else{
        $.ajax({
            url: 'dollImageManage/uploadImage?dollId='+dollId,
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
        }
    });
})
</script>
