<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<link rel="stylesheet" type="text/css" href="${path}/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${path}/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${path}/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${path}/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${path}/static/h-ui.admin/css/style.css" />
<title>网搜抓娃娃</title>
<meta name="keywords" content="网搜抓娃娃">
<meta name="description" content="网搜抓娃娃，在线直播抓娃娃">
</head>
<body>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="">网搜抓娃娃Admin</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="">网搜抓娃娃</a>
			<span class="logo navbar-slogan f-l mr-10 hidden-xs">V1.0</span> 
			<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
		<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
			<ul class="cl">
				<li>超级管理员</li>
				<li class="dropDown dropDown_hover">
					<a href="#" class="dropDown_A">${USER.name} <i class="Hui-iconfont">&#xe6d5;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" onClick="myselfinfo()">个人信息</a></li>
						<!-- <li><a href="#">切换账户</a></li> -->
						<li><a href="/icrane/web/logout">退出</a></li>
				</ul>
			</li>
				<!--<li id="Hui-msg"> <a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li>-->
				<li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
						<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
						<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
						<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
						<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
						<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>
</div>
</header>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<dl id="menu-user-">
			<dt><i class="Hui-iconfont">&#xe616;</i> 渠道管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/channelManage/searchList" data-title="渠道管理列表" href="javascript:void(0)">渠道管理列表</a></li>
					<li><a data-href="${pageContext.request.contextPath}/channelManage/deductList" data-title="渠道扣量列表" href="javascript:void(0)">渠道扣量列表</a></li>
					<li><a data-href="${pageContext.request.contextPath}/channelManage/listChargeHistory" data-title="渠道充值列表" href="javascript:void(0)">渠道充值列表</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-user-v">
			<dt><i class="Hui-iconfont">&#xe616;</i> 邀请管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/ShareInviteManage/list" data-title="邀请人列表" href="javascript:void(0)">邀请人列表</a></li>
					<li><a data-href="${pageContext.request.contextPath}/ShareInviteManage/shareInvites" data-title="被邀请人列表" href="javascript:void(0)">被邀请人列表</a></li>
					<%--<li><a data-href="${pageContext.request.contextPath}/channelManage/listChargeHistory" data-title="渠道充值列表" href="javascript:void(0)">渠道充值列表</a></li>--%>
				</ul>
			</dd>
		</dl>
		<dl id="menu-user">
			<dt><i class="Hui-iconfont">&#xe616;</i> 用户管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/memberManage/searchList" data-title="用户列表" href="javascript:void(0)">用户列表</a></li>
					<li><a data-href="${pageContext.request.contextPath}/orderManage/searchList" data-title="用户充值列表" href="javascript:void(0)">用户充值列表</a></li>
					<li><a data-href="${pageContext.request.contextPath}/memberChargeManage/list" data-title="用户交易列表" href="javascript:void(0)">用户交易列表</a></li>
					<li><a data-href="${pageContext.request.contextPath}/memberWhite/list" data-title="用户白名单列表" href="javascript:void(0)">用户白名单列表</a></li>
				</ul>
			</dd>
	</dl>
		<dl id="menu-user-appeal">
			<dt><i class="Hui-iconfont">&#xe616;</i> 申诉管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/memberAppealManage/list" data-title="待处理申诉" href="javascript:void(0)">待处理申诉列表</a></li>
					<li><a data-href="${pageContext.request.contextPath}/memberAppealManage/doneList" data-title="已处理申诉" href="javascript:void(0)">已处理申诉列表</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-user-feedback">
			<dt><i class="Hui-iconfont">&#xe616;</i> 用户报修管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<%--<li><a data-href="${pageContext.request.contextPath}/memberFeedbackManage/list" data-title="用户反馈列表" href="javascript:void(0)">用户反馈列表</a></li>--%>
					<li><a data-href="${pageContext.request.contextPath}/dollRepairsManage/list" data-title="用户报修列表" href="javascript:void(0)">用户报修列表</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-article">
			<dt><i class="Hui-iconfont">&#xe616;</i> 娃娃机管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/dollManage/list" data-title="娃娃机列表" href="javascript:void(0)">娃娃机列表</a></li>
					<li><a data-href="${pageContext.request.contextPath}/dollImageManage/list" data-title="娃娃机背景图片列表" href="javascript:void(0)">娃娃机背景图片列表</a></li>
					<li><a data-href="${pageContext.request.contextPath}/dollTopicManage/list" data-title="娃娃机主题列表" href="javascript:void(0)">娃娃机主题列表</a></li>
					<li><a data-href="${pageContext.request.contextPath}/dollAddressManage/list" data-title="娃娃机地址列表" href="javascript:void(0)">娃娃机地址列表</a></li>
				</ul>
		</dd>
	</dl>
		<dl id="menu-room">
			<dt><i class="Hui-iconfont">&#xe616;</i> 房间管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/roomManage/list" data-title="房间列表" href="javascript:void(0)">房间列表</a></li>
					<li><a data-href="${pageContext.request.contextPath}/roomManage/roomMachineList" data-title="房间机器对应列表" href="javascript:void(0)">房间机器对应列表</a></li>
				</ul>
			</dd>
		</dl>
	<dl id="menu-banner">
		<dt><i class="Hui-iconfont">&#xe616;</i> 广告管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
		<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/bannerManage/list" data-title="广告列表" href="javascript:void(0)">广告列表</a></li>
				</ul>
		 </dd>
	</dl>
	<dl id="menu-product">
			<dt><i class="Hui-iconfont Hui-iconfont-wuliu"></i> 发货管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/goodsManage/list" data-title="待发货列表" href="javascript:void(0)">待发货列表</a></li>
					<li><a data-href="${pageContext.request.contextPath}/goodsManage/outList" data-title="已发货列表" href="javascript:void(0)">已发货列表</a></li>
				</ul>
			</dd>
	</dl>
		<dl id="menu-picture">
			<dt><i class="Hui-iconfont Hui-iconfont-youhuiquan"></i> 规则参数管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${pageContext.request.contextPath}/payManage/list" data-title="规则参数管理" href="javascript:void(0)">充值规则列表</a></li>
					<li><a data-href="${pageContext.request.contextPath}/prefManage/list" data-title="规则参数管理" href="javascript:void(0)">设置参数列表</a></li>
					<li><a data-href="${pageContext.request.contextPath}/complaintProblemManage/list" data-title="规则参数管理" href="javascript:void(0)">设置申诉问题列表</a></li>
					<li><a data-href="${pageContext.request.contextPath}/repairsProblemManage/list" data-title="规则参数管理" href="javascript:void(0)">设置报修问题列表</a></li>
				</ul>
		</dd>
	</dl>
	<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="admin-role.html" data-title="角色管理" href="javascript:void(0)">角色管理</a></li>
					<li><a data-href="admin-permission.html" data-title="权限管理" href="javascript:void(0)">权限管理</a></li>
					<li><a data-href="admin-list.html" data-title="管理员列表" href="javascript:void(0)">管理员列表</a></li>
			</ul>
		</dd>
	</dl>
		<dl id="menu-tongji">
			<dt><i class="Hui-iconfont">&#xe61a;</i> 系统统计<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="charts-1.html" data-title="折线图" href="javascript:void(0)">折线图</a></li>
					<li><a data-href="charts-2.html" data-title="时间轴折线图" href="javascript:void(0)">时间轴折线图</a></li>
					<li><a data-href="charts-3.html" data-title="区域图" href="javascript:void(0)">区域图</a></li>
					<li><a data-href="charts-4.html" data-title="柱状图" href="javascript:void(0)">柱状图</a></li>
					<li><a data-href="charts-5.html" data-title="饼状图" href="javascript:void(0)">饼状图</a></li>
					<li><a data-href="charts-6.html" data-title="3D柱状图" href="javascript:void(0)">3D柱状图</a></li>
					<li><a data-href="charts-7.html" data-title="3D饼状图" href="javascript:void(0)">3D饼状图</a></li>
			</ul>
		</dd>
	</dl>
		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="system-base.html" data-title="系统设置" href="javascript:void(0)">系统设置</a></li>
					<li><a data-href="system-category.html" data-title="栏目管理" href="javascript:void(0)">栏目管理</a></li>
					<!-- <li><a data-href="system-data.html" data-title="数据字典" href="javascript:void(0)">数据字典</a></li>
					<li><a data-href="system-shielding.html" data-title="屏蔽词" href="javascript:void(0)">屏蔽词</a></li>
					<li><a data-href="system-log.html" data-title="系统日志" href="javascript:void(0)">系统日志</a></li> -->
			</ul>
		</dd>
	</dl>
	<dl id="menu-statistics">
		<dt><i class="Hui-iconfont">&#xe61a;</i> 统计管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
		<dd>
			<ul>
				<li><a data-href="${pageContext.request.contextPath}/statisticsManage/list" data-title="新用户日报" href="avascript:void(0)">新用户日报列表</a></li>
				<li><a data-href="${pageContext.request.contextPath}/statisticsManage/list" data-title="累计日报" href="javascript:void(0)">累计日报列表</a></li>
				<li><a data-href="${pageContext.request.contextPath}/dollMachineStatisticsManage/list" data-title="娃娃机统计" href="javascript:void(0)">娃娃机统计列表</a></li>
			</ul>
		</dd>
	</dl>
</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active">
					<span title="我的桌面" data-href="${path}/welcome.html">我的桌面</span>
					<em></em></li>
		</ul>
	</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="welcome.jsp"></iframe>
	</div>
</div>
</section>

<div class="contextMenu" id="Huiadminmenu">
	<ul>
		<li id="closethis">关闭当前 </li>
		<li id="closeall">关闭全部 </li>
</ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${path}/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${path}/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${path}/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${path}/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${path}/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
$(function(){
	/*$("#min_title_list li").contextMenu('Huiadminmenu', {
		bindings: {
			'closethis': function(t) {
				console.log(t);
				if(t.find("i")){
					t.find("i").trigger("click");
				}		
			},
			'closeall': function(t) {
				alert('Trigger was '+t.id+'\nAction was Email');
			},
		}
	});*/
});
/*个人信息*/
function myselfinfo(){
	layer.open({
		type: 1,
		area: ['300px','200px'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: '查看信息',
		content: '<div>管理员信息</div>'
	});
}

/*资讯-添加*/
function article_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*图片-添加*/
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
</script> 
</body>
</html>