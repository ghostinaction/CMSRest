<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目管理系统 by www.865171.cn</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}

#table .btn{
	padding: 0px 0px;
}

html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>


<base href="<%=basePath%>">
<%@include file="head.jsp"%>
</head>
<script>
	$(function(){
		$(".delete").on("click",function(){
			var id = $(this).data("id")
			layer.confirm('确定删除?', {
				btn: ['确定','取消'] //按钮
			}, function(){
				window.location.href='<%=basePath%>msgManage/deleteMsg.do?id='+id+''
				layer.msg('删除成功');
			}, function(){
			});
		})
	})
</script>

<body>
<!--<div style="text-align: right;padding-right: 50px;margin-bottom: 50px" >-->
	<!--<button type="submit" class="btn btn-xs btn btn-primary">搜索</button>-->
<!--</div>-->
<div style="margin-bottom: 50px">
	<form class="form-inline">
		<!--<div class="form-group col-xs-4 col-md-3">-->
			<!--<div class="input-group input-group-xs">-->
				<!--<label class="input-group-addon bn"><span-->
						<!--class="pl10">类型�?</span></label>-->
				<!--<select class="form-control">-->
					<!--<option>公司�?�?</option>-->
					<!--<option>企业资质</option>-->
					<!--<option>企业文化</option>-->
					<!--<option>客户资源</option>-->
				<!--</select>-->
			<!--</div>-->
		<!--</div>-->
	</form>
</div>
<table class="table table-striped table-hover table-bordered">
	<thead>
	<tr>
		<th>序号</th>
		<th>称呼</th>
		<th>联系电话</th>
		<th>邮箱</th>
		<th>企业名称</th>
		<th>公司地址</th>
		<th>标题</th>
		<th>内容</th>
		<th>留言时间</th>
		<th>操作</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="c" items="${msgs}" varStatus="status">
		<tr>
			<td>${status.index + 1}</td>
			<td>${c.nickName }</td>
			<td>${c.phone }</td>
			<td>${c.email }</td>
			<td>${c.companyName }</td>
			<td>${c.companyAddress }</td>
			<td>${c.title }</td>
			<td style="width: 300px;">${c.content }</td>
			<td style="width: 150px;"><fmt:formatDate value="${c.leaveTime }" pattern="yyyy年MM月dd日  HH:mm:ss" /></td>
			<td>
				<button type="button" data-id="${c.id }" class="btn btn-link delete">删除</button>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

</body>
</html>
