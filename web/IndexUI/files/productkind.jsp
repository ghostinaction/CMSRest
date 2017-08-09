<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
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
<script>
	$(function(){
		$(".edit").on("click",function(){
			var kindName = $(this).data("kind");
			var id = $(this).data("id");
			$("#kindName").val(kindName);
			$("#id").val(id);
			$('#myModal').modal('show');
		})

		$(".delete").on("click",function(){
			var id = $(this).data("id");
			layer.confirm('确定删除?', {
				btn: ['确定','取消'] //按钮
			}, function(){
				window.location.href='<%=basePath%>productManage/delete.do?id='+id+''
				layer.msg('删除成功');
			}, function(){
				
			});
		})
		$(".addKind").on("click",function(){
			$("#kindName").val("");
			$("#id").val("");
			$('#myModal').modal('show');	
		})
	})
</script>
</head>

<body>
<div style="">
<form class="form-inline">
	<!--<div class="form-group col-xs-4 col-md-3">-->
		<!--<div class="input-group input-group-xs">-->
			<!--<label class="input-group-addon bn"><span-->
					<!--class="pl10">类型：</span></label>-->
			<!--<select class="form-control">-->
				<!--<option>公司简介</option>-->
				<!--<option>企业资质</option>-->
				<!--<option>企业文化</option>-->
				<!--<option>客户资源</option>-->
			<!--</select>-->
		<!--</div>-->
	<!--</div>-->
	<div>
		<button type="button" class="btn btn btn-primary addKind">新增产品分类</button>
	</div>
</form>
	</div>
<table class="table table-striped table-hover" style="width: 600px">
	<thead>
	<tr>
		<th>产品分类</th>
		<th>操作</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="c" items="${productKinds}">
		<tr>
			<td>${c.kindName}</td>
			<td>
				<button type="button" data-kind="${c.kindName}" data-id="${c.id}" class="btn btn-link edit">编辑</button>
				<button type="button" data-kind="${c.kindName}" data-id="${c.id}" class="btn btn-link delete">删除</button>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 500px">
		<div class="modal-content">
		<form class="form-horizontal" role="form" action="<%=basePath%>productManage/edit.do" method="post">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">

				</h4>
			</div>
			<div class="modal-body">
					<div class="form-group">
						<label for="firstname" class="col-sm-3 control-label">产品分类</label>
						<div class="col-sm-8">
							<input type="hidden" name="id" value="" id="id"/>
							<input type="text" name="kindName" class="form-control" id="kindName"
								   placeholder="">
						</div>
					</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="submit" class="btn btn-primary save">
					保存
				</button>
			</div>
			</form>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
</body>
</html>
