<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<base href="<%=basePath%>">
		<%@include file="head.jsp"%>
		<%--<link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">--%>
		<%--<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.11.3.min.js"></script>--%>
		<%--<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
		<%--<script src="http://malsup.github.io/jquery.form.js"></script>--%>
		<style>
			h1{
				font-size: 16px;
				padding: 6px 0px;
				text-align: center;
				border: 1px solid #eee;
				margin: 10px 0 0 0;
				background-color: #eee;
				border-radius: 4px;
			}
			.thumbnail{
				margin-right: auto;
				margin-left: auto;
				width: 100%;
				height: 160px;
				background: url("../images/upimg.jpg");
				background-size: contain;
			}
			.thumbnail img{
				height:150px;
			}
			.imgprivew{
				height: 200px;
			}
			.imgprivew img{
				max-width: 1000px;
				max-height: 350px;
			}
		</style>
		<script>
			var listLength = 0;
			function submitForm(id){
				var formSel = "#form"+id;
				var form = $(formSel);
				var options  = {
					url:'<%=basePath%>uploadImage.do',
					type:'post',
					success:function(res)
					{
						var img = "#img"+id;
						$(img).data("imgurl",res.imgUrl);
						$(img).attr("src","<%=basePath%>"+res.imgUrl);
						$(img).attr("imgPath",res.imgUrl);
					}
				};
				form.ajaxSubmit(options);
			}
			$(document).ready(function(){
				$(".thumbnail").click(function(e){
					$(this).next().trigger("click");
				})
				$(".thumbnail").hover(function(){
					var src = $(this).find("img").attr("src");
					$("#imgprivew").attr("src",src);
				})

				$(".save").click(function(){
					var list = [];
					for(var i=0;i<listLength;i++){
						var form = "#form"+(parseInt(i)+1);
						var hrefUrl = $(form).children().find("input[name='hrefUrl']").val();
						var id = $(form).children("[type='hidden']").val();
						var desc = $(form).children().find("input[name='desc']").val();
						var imgUrl = $(form).children().find("img").attr("imgPath");
						list.push({"id":id,"desic":desc,"imgUrl":imgUrl,"hrefUrl":hrefUrl});
					}
					alert("保存成功")
					console.log(JSON.stringify(list));
					$.ajax({
						url: "<%=basePath%>carouselManage/edit.do",
						type: "post",
						dataType: 'json',
						data:JSON.stringify(list),
						contentType:"application/json",
						success: function(res){
						},
						error: function(e){

						}
					});

				})
				$(".cancle").click(function(){
					window.location.href="<%=basePath%>IndexUI/files/carousel.jsp";
				})

				function initPage(){
					$.ajax({
						url: "<%=basePath%>carouselManage/getList.do",
						type: "get",
						dataType: 'json',
						success: function(res){
							listLength = res.length;
							for(var i=0;i<res.length;i++){
								var form = "#form"+(parseInt(i)+1);
								$(form).children("[type='hidden']").val(res[i].id);
								$(form).children().find("input[name='hrefUrl']").val(res[i].hrefUrl);
								$(form).children().find("input[name='desc']").val(res[i].desic);
								$(form).children().find("img").attr("src","<%=basePath%>"+res[i].imgUrl);
								$(form).children().find("img").attr("imgPath",res[i].imgUrl);
							}
						},
						error: function(e){

						}
					});
				}
				initPage();
			});
		</script>
	</head>
	<body>
	<div class="">
		<div class="form-horizontal" id="mainForm" role="form" action="a.jsp">
				<div class="col-sm-3 col-md-3">
					<form id="form1" enctype="multipart/form-data">
						<h1>轮播图1</h1>
						<input id="aid" type="hidden" name="id"/>
						<div class="input-group">
							<span class="input-group-addon" >跳转URL</span>
							<input name="hrefUrl" type="text" class="form-control" placeholder="" >
						</div>
						<div class="input-group">
							<span class="input-group-addon" >描述</span>
							<input name="desc" type="text" class="form-control" placeholder="" >
						</div>
						<a href="javascript:" class="thumbnail">
							<img name="imgUrl"  id="img1" src="http://avatar.csdn.net/C/D/E/1_adenfeng.jpg" alt="请上传">
						</a>
						<input name="files" style="display: none;" type="file" id="inputfile1" onchange="submitForm(1)">
					</form>
				</div>
				<div class="col-sm-3 col-md-3">
					<form id="form2" enctype="multipart/form-data">
						<h1>轮播图2</h1>
						<input type="hidden" name="id"/>
						<div class="input-group">
							<span class="input-group-addon" >跳转URL</span>
							<input name="hrefUrl" type="text" class="form-control" placeholder="" >
						</div>
						<div class="input-group">
							<span class="input-group-addon">描述</span>
							<input name="desc" type="text" name="nn" class="form-control" placeholder="">
						</div>

						<a href="javascript:" class="thumbnail">
							<img name="imgUrl" id="img2" src="" alt="...">
						</a>
						<input name="files" style="display: none;" type="file" id="inputfile2" onchange="submitForm(2)">
					</form>
				</div>
				<div class="col-sm-3 col-md-3">
						<form id="form3" enctype="multipart/form-data">
							<h1>轮播图3</h1>
							<input type="hidden" name="id"/>
							<div class="input-group">
								<span class="input-group-addon" id="basic-addon1">跳转URL</span>
								<input name="hrefUrl" type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
							</div>
							<div class="input-group">
								<span class="input-group-addon" id="basic-addon2">描述</span>
								<input name="desc" type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
							</div>
							<a href="javascript:" class="thumbnail">
								<img name="imgUrl" id="img3" src="" alt="...">
							</a>
							<input name="files" style="display: none;" type="file" id="inputfile3" onchange="submitForm(3)">
						</form>
					</div>
			    <div class="col-sm-3 col-md-3">
						<form id="form4" enctype="multipart/form-data">
							<h1>轮播图4</h1>
							<input type="hidden" name="id"/>
							<div class="input-group">
								<span class="input-group-addon" id="basic-addon1">跳转URL</span>
								<input name="hrefUrl" type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
							</div>
							<div class="input-group">
								<span class="input-group-addon" id="basic-addon2">描述</span>
								<input name="desc" type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
							</div>
							<a href="javascript:" class="thumbnail">
								<img name="imgUrl" id="img4" src="" alt="...">
							</a>
							<input name="files" style="display: none;" type="file" id="inputfile4" onchange="submitForm(4)">
						</form>
					</div>
				<div class="imgprivew col-sm-10 col-md-10">
					<img id="imgprivew" src="">
				</div>
				<div class="col-sm-2 col-md-2">
					<button class="btn btn-primary save">保存</button>
					<button class="btn btn-primary cancle">取消</button>
				</div>
		</div>
	</div>
	</body>
</html>

