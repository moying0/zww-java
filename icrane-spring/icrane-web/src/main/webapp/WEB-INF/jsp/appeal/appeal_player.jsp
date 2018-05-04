<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/include.jsp"%>
<base href="<%=basePath%>" />
<%@ include file="../common/js.jsp"%>
<%@ include file="../common/css.jsp"%>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />

<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 申诉管理<span class="c-gray en">&gt;</span> 申诉视频 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<article class="page-container">
		<div class="mt-20">
			<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper no-footer">
				<div class="row cl">
					<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
						<label class="col-xs-4 col-sm-3" style="font-size: 15px;"><strong >视频播放:</strong></label>
					</div>
					<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
						<embed width="300" height="450" src="${players }">
					</div>
				</div>

			</div>
		</div>
</article>

