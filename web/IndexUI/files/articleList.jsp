<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
<script>
	$(function(){
		$('#table').dataTable({
			"ordering": false,
			"info":     false
		} );
		$(".showDetail").on("click",function(){
			$('#myModal').modal('show');
		})
		$(".edit").on("click",function(){
			$('#myModal').modal('show');
		})

		$(".delete").on("click",function(){
			layer.confirm('确定删除?', {
				btn: ['确定','取消'] //按钮
			}, function(){
				window.location.href="kehu.htm"
				layer.msg('删除成功');
			}, function(){
			});
		})
		KindEditor.ready(function(K) {
			window.editor = K.create('#editor_id');
		});
		function a(){}

	})
</script>
<body>
<hr>
<div style="text-align: right;padding-right: 50px;margin-bottom: 50px" >
	<button type="submit" class="btn btn-xs btn btn-primary">搜索</button>
	<button type="submit" class="btn btn-xs btn btn-primary">新增</button>
</div>
<div style="margin-bottom: 100px">
<form class="form-inline">
	<div class="form-group col-xs-4 col-md-3">
		<div class="input-group input-group-xs">
			<label class="input-group-addon bn"><span
			class="pl10">类型：</span></label>
			<select class="form-control">
				<option>公司简介</option>
				<option>企业资质</option>
				<option>企业文化</option>
				<option>客户资源</option>
			</select>
		</div>
	</div>
</form>
	</div>
<hr>
<table class="table table-striped table-hover">
	<thead>
	<tr>
		<th>新闻标题</th>
		<th>类别</th>
		<th>发布时间</th>
		<th>操作</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>Uma</td>
		<td>Pune</td>
		<td>411027</td>
		<td>
			<button type="button" class="btn btn-link showDetail">查看</button>
			<button type="button" class="btn btn-link edit">编辑</button>
			<button type="button" class="btn btn-link delete">删除</button>
		</td>
	</tr>
	<tr>
		<td>Uma</td>
		<td>Pune</td>
		<td>411027</td>
		<td>
			<button type="button" class="btn btn-link showDetail" >查看</button>
			<button type="button" class="btn btn-link edit">编辑</button>
			<button type="button" class="btn btn-link delete">删除</button>
		</td>
	</tr>
	<tr>
		<td>Uma</td>
		<td>Pune</td>
		<td>411027</td>
		<td>
			<button type="button" class="btn btn-link showDetail">查看</button>
			<button type="button" class="btn btn-link edit">编辑</button>
			<button type="button" class="btn btn-link delete">删除</button>
		</td>
	</tr>
	</tbody>
</table>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">

				</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">文章标题</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="firstname" placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">文章类型</label>
						<div class="col-sm-4">
						<select class="form-control">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2"></div>
						<div class="col-sm-10">
							<textarea name="content" style="width: 700px;height: 200px" id="editor_id"></textarea>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">
					提交
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
</body>
</html>
