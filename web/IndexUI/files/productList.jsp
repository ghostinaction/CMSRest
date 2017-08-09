
<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
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

.font051 {
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}

.font201 {
	font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}

#table .btn {
	padding: 0px 0px;
}

html {
	overflow-x: auto;
	overflow-y: auto;
	border: 0;
}
-->
</style>

<base href="<%=basePath%>">
	<%@include file="head.jsp"%>
	<script src="IndexUI/js/jquery.form.js"></script>
</head>
<script>
		function submitForm(flag){
			var formSel = "#form"+flag;
			var form = $(formSel);
			var options  = {
				url:'<%=basePath%>uploadImage.do',
				type:'post',
				success:function(res)
				{
					var img = "#img"+flag;
					if(flag == 1){
						$("[name='mainUrl']").val(res.imgUrl);
						$(img).attr("src","<%=basePath%>"+res.imgUrl);
					}else{
						$("[name='detailUrl']").val(res.imgUrl);
						$(img).attr("src","<%=basePath%>"+res.imgUrl);	
					}
				}
			};
			form.ajaxSubmit(options);
		}
		$(function(){
			var allOption = [];
			allOption.push($("<option>").val("").text(""))

			$("#img1").click(function(){
				$("#form1").children().trigger("click");
			})
			$("#img2").click(function(){
				$("#form2").children().trigger("click");
			})
			
			function initOption(){
				$.ajax({
					url: "<%=basePath%>productManage/getProductKindJSON.do",
					type: "get",
					dataType: 'json',
					success: function(res){
						for(var i=0;i<res.length;i++){
							$("<option>").val(res.id).text(res.kindName);
							allOption.push($("<option>").val(res[i].id).text(res[i].kindName));
						}
					},
					error: function(e){
			
					}
				});
			}

		initOption();

		KindEditor.ready(function(K) {
			window.editor = K.create('#editor_id',
			{
				resizeType : 1,
				allowPreviewEmoticons: false,
				allowImageUpload:true,//允许上传图片
				uploadJson:'<%=basePath%>uploadMulti.do', //上传图片的java代码，只不过放在jsp中
				afterUpload: function(){this.sync();}, //图片上传后，将上传内容同步到textarea中
				afterBlur: function(){this.sync();}
			})

			window.editor1 = K.create('#editor_id1',{
				items:[
			        'justifyleft', 'justifycenter', 'justifyright',
			        'justifyfull','formatblock', 'fontname', 'fontsize', 'forecolor', 'hilitecolor', 'bold',
			        'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat','fullscreen']
			});
		})	
		$(".showDetail").on("click",function(){
			var id = $(this).data("id");
			var kindName = $(this).data("kindName");
			$.ajax({
				url: "<%=basePath%>productManage/getProductDetailJSON.do",
				type: "get",
				data: {"id":id},
				dataType: 'json',
				//headers:{
				//	"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8",
				//	"TokenCode":token
				//},
				//crossDomain:true,
				success: function(res){
					$("#productName").val(res.productName);
					$("#id").val(id);
					$("#kindName").empty();
					var option;
					if(res.kindName == null){
						option="";
					}else{
						option = $("<option>").val(res.kindId).text(res.kindName);
					}
					$("#kindName").append(option);
					if(res.productDetail == null){
						window.editor.html("");
					}else{
						window.editor.html(res.productDetail);
					}
					$('#myModal').modal('show');
					$(".modal-footer").hide();
				},
				error: function(e){
		
				}
			});
			$('#myModal').modal('show');
		})
		$(".edit").on("click",function(){
			var id = $(this).data("id");
			var kindName = $(this).data("kindName");
			$.ajax({
				url: "<%=basePath%>productManage/getProductDetailJSON.do",
				type: "get",
				dataType: 'json',
				data: {"id":id},
				success: function(res){
					$("#productName").val(res.productName);
					$("#id").val(id);
					$("#kindName").empty();
					$("#kindName").append(allOption);
			
					$("#kindName").val(res.kindId);
					if(res.productDetail == null){
						window.editor.html("");
					}else{
						window.editor.html(res.productDetail);
					}
					if(res.productInfo == null){
						window.editor1.html("");
					}else{
						window.editor1.html(res.productInfo);	
					}
					if(res.mainUrl == null){
						
					}else{
						$("#img1").attr("src",res.mainUrl);
						$("[name='mainUrl']").val(res.mainUrl)
					}
					if(res.detailUrl == null){
						
					}else{
						$("#img2").attr("src",res.detailUrl);
						$("[name='detailUrl']").val(res.detailUrl)
					}
					
					$('#myModal').modal('show');
					$(".modal-footer").show();
				},
				error: function(e){
		
				}
				});
		})

		$(".delete").on("click",function(){
		var id = $(this).data("id");
			layer.confirm('确定删除?', {
			btn: ['确定','取消'] //按钮
			}, function(){
			window.location.href='<%=basePath%>productManage/deleteProduct.do?productId='+ id + ''
													layer.msg('删除成功');
												}, function() {
												});
						})

		$(".addKind").on("click", function() {
			$("input").val();
 			$("#productName").val(""); 
 			$("#img1").attr("src","");
 			$("#img2").attr("src","");
 			$("[name='mainUrl']").val("")
 			$("[name='detailUrl']").val("")
			window.editor.html('');
			window.editor1.html('');
 			$("#kindName").empty();
			$("#kindName").append(allOption);
			$("#kindName").val('')
			$("#id").val("");
			$('#myModal').modal('show');
		})
	})
</script>

<body>
	<!--<div style="text-align: right;padding-right: 50px;margin-bottom: 50px" >-->
	<!--<button type="submit" class="btn btn-xs btn btn-primary">搜索</button>-->
	<!--</div>-->
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
		</form>
	</div>
	<div>
		<button type="button" class="btn btn btn-primary addKind">新增产品</button>
	</div>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>产品名称</th>
				<th>产品分类</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${products}">
				<tr>
					<td>${c.productName}</td>
					<td>${c.kindName}</td>
					<td>
						<%-- <button type="button" data-kindName="${c.kindName}"
							data-id="${c.id}" class="btn btn-link showDetail">查看</button> --%>
						<button type="button" data-kindName="${c.kindName}"
							data-id="${c.id}" class="btn btn-link edit">编辑</button>
						<button type="button" data-kindName="${c.kindName}"
							data-id="${c.id}" class="btn btn-link delete">删除</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form id="form1">
		<input name="files" style="display: none;" type="file" id="inputfile1" onchange="submitForm(1)">
	</form>
	<form id="form2">
		<input name="files" style="display: none;" type="file" id="inputfile2" onchange="submitForm(2)">
	</form>
	<div class="modal fade" data-backdrop="static" id="myModal"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
		<div class="modal-dialog" style="width: 1000px">
			<form class="form-horizontal" role="form" action="<%=basePath%>productManage/editProduct.do" method="post">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel"></h4>
					</div>
					<div class="modal-body">
						<div class="">
							<label for="firstname" class="col-sm-2 control-label">产品名称</label>
							<div class="col-sm-4">
								<input type="hidden" name="id" id="id" /> 
								<input type="text" name="productName" class="form-control" id="productName"
									placeholder="">
							</div>
						</div>
							<div class="">
								<label for="firstname" class="col-sm-2 control-label">产品分类</label>
								<div class="col-sm-4">
									<select name="kindId" id="kindName" class="form-control">
									</select>
								</div>
							</div>
							<div class="">
									<label for="firstname" class="col-sm-2 control-label">产品主图(推荐220*150像素)</label>
									<div class="col-sm-4">
										<img id="img1" style="width: 100%;height: 150px;margin-top: 12px;" src=""/>
									</div>
									<input type="hidden" name="mainUrl" />
							</div>
							<div class="">
										<label for="firstname" class="col-sm-2 control-label">详情主图</label>
										<div class="col-sm-4">
											<img id="img2" style="width: 100%;height: 150px;margin-top: 12px;" src=""/>
										</div>
										<input type="hidden" name="detailUrl" />
							</div>
							<div style="margin-top: 100px" class="">
										<label for="firstname" class="col-sm-2 control-label">产品介绍</label>
										<div class="col-sm-10">
											<textarea name="productInfo"
												style="width: 300px; height: 100px" id="editor_id1"></textarea>
										</div>
										
							</div>
									<div style="margin-top: 100px" class="">
										<label for="firstname" class="col-sm-2 control-label">产品详情</label>
										<div class="col-sm-10">
											<textarea name="productDetail"
												style="width: 700px; height: 300px" id="editor_id"></textarea>
										</div>
									</div>
								</div>
					<div class="modal-footer" style="border-top:none">
						<button type="button" class="btn btn-default"
							data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">保存</button>
					</div>
				</div>
			</div>
							<!-- /.modal-content -->
			</form>
		</div>
		<!-- /.modal -->
	</div>
</body>
</html>
