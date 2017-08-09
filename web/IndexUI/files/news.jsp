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


</script>

<base href="<%=basePath%>">
<%@include file="head.jsp"%>

</head>
<script>
	$(function(){
		KindEditor.ready(function(K) {
			window.editor = K.create("#content",
			{
				resizeType : 1,
                allowPreviewEmoticons: false,
                allowImageUpload:true,//允许上传图片
                uploadJson:'<%=basePath%>uploadMulti.do', //上传图片的java代码，只不过放在jsp中
                afterUpload: function(){this.sync();}, //图片上传后，将上传内容同步到textarea中
                afterBlur: function(){this.sync();}
			});
		});
		$(".showDetail").on("click",function(){
			var id = $(this).data("id");
			$.ajax({
				url: "<%=basePath%>cpyInst/getDetailById.do",
				type: "get",
				data: {"id":id},
				dataType: 'json',
				//headers:{
				//	"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8",
				//	"TokenCode":token
				//},
				//crossDomain:true,
				success: function(res){
					$("#instType").val(res.instType);
					window.editor.html(res.content);
					$("#id").val(res.id);
					$('#myModal').modal('show');
					$(".modal-footer").hide();
				},
				error: function(e){
					
				}
			});
		})
		$(".edit").on("click",function(){
			var id = $(this).data("id");
			$.ajax({
				url: "<%=basePath%>cpyInst/getDetailById.do",
				type: "get",
				data: {"id":id},
				dataType: 'json',
				//headers:{
				//	"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8",
				//	"TokenCode":token
				//},
				//crossDomain:true,
				success: function(res){
					$("#instType").val(res.instType);
					window.editor.html(res.content);
					$("#id").val(res.id);
					$('#myModal').modal('show');
					$(".modal-footer").show();
				},
				error: function(e){
					
				}
			});
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
					<!--class="pl10">类型：</span></label>-->
			<!--<select class="form-control">-->
				<!--<option>公司简介</option>-->
				<!--<option>企业资质</option>-->
				<!--<option>企业文化</option>-->
				<!--<option>客户资源</option>-->
			<!--</select>-->
		<!--</div>-->
	<!--</div>-->
</form>
	</div>
<table style="font-size: medium;" class="table table-striped table-hover">
	<thead>
	<tr>
		<th>类型</th>
		<th>操作</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="c" items="${cpyList}">    
	 <tr>
		<td>${c.instType }</td>
		<td>
			<button type="button" data-id="${c.id }" class="btn btn-link showDetail">查看</button>
			<button type="button" data-id="${c.id }" class="btn btn-link edit">编辑</button>
		</td>
	 </tr>		            
	</c:forEach>
	
	</tbody>
</table>
<div class="modal fade" data-backdrop="static" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">

				</h4>
			</div>
			<form class="form-horizontal" action="<%=basePath%>cpyInst/edit.do" role="form" method="post">
			<div class="modal-body">
					<div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">类型</label>
						<div class="col-sm-4">
							<input type="text" name="instType" readonly class="form-control" id="instType"
								   placeholder="">
							<input type="hidden" name="id" hidden class="form-control" id="id"
								   placeholder="">
						</div>
					</div>
					<!--<div class="form-group">-->
						<!--<label for="firstname" class="col-sm-2 control-label">文章类型</label>-->
						<!--<div class="col-sm-4">-->
						<!--<select class="form-control">-->
							<!--<option>1</option>-->
							<!--<option>2</option>-->
							<!--<option>3</option>-->
							<!--<option>4</option>-->
							<!--<option>5</option>-->
						<!--</select>-->
						<!--</div>-->
					<!--</div>-->
					<div class="row">
						<div class="col-sm-2"></div>
						<div class="col-sm-10">
							<textarea name="content" class="Detail" style="width: 700px;height: 350px" id="content"></textarea>
						</div>
					</div>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="submit" class="btn btn-primary">
					保存
				</button>
			</div>
			</form>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
</body>
</html>