<%@page import="java.awt.Window"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.cms.config.WebInfo" %>
<%@ page import="com.cms.entity.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user = (User)request.getSession().getAttribute(WebInfo.USER_BEAN);
String userName = "";
if(user == null){
}else{
	userName = user.getUserName();
}
%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/htmll; charset=utf-8" />
<title>项目管理系统 by www.865171.cn</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(../images/left.gif);
}
-->
</style>
<base href="<%=basePath%>">
<%@include file="head.jsp"%>
<link href="IndexUI/css/css.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
function tupian(idt){
    var nametu="xiaotu"+idt;
    var tp = document.getElementById(nametu);
    tp.src="IndexUI/images/ico05.gif";//图片ico04为白色的正方形
	
	for(var i=1;i<30;i++)
	{
	  
	  var nametu2="xiaotu"+i;
	  if(i!=idt*1)
	  {
	    var tp2=document.getElementById('xiaotu'+i);
		if(tp2!=undefined)
	    {tp2.src="IndexUI/images/ico06.gif";}//图片ico06为蓝色的正方形
	  }
	}
}

function list(idstr){
	var name1="subtree"+idstr;
	var name2="img"+idstr;
	var objectobj=document.all(name1);
	var imgobj=document.all(name2);
	
	
	//alert(imgobj);
	
	if(objectobj.style.display=="none"){
		for(i=1;i<10;i++){
			var name3="img"+i;
			var name="subtree"+i;
			var o=document.all(name);
			if(o!=undefined){
				o.style.display="none";
				var image=document.all(name3);
				//alert(image);
				image.src="IndexUI/images/ico04.gif";
			}
		}
		objectobj.style.display="";
		imgobj.src="IndexUI/images/ico03.gif";
	}
	else{
		objectobj.style.display="none";
		imgobj.src="IndexUI/images/ico04.gif";
	}
}
$(function(){
	$("#updatePsw").click(function(){
		$("[name='oldPsw']").val("");
		$("[name='newPsw']").val("");
		$("[name='againPsw']").val("");
		$("#myModal").modal("show");
	})
	$("form").submit(function(e){
		var oldPsw = $("[name='oldPsw']").val();	
		var newPsw = $("[name='newPsw']").val();	
		var againPsw = $("[name='againPsw']").val();	
		if(newPsw!=againPsw){
			alert("两次密码输入不一致");
		}else{
			$.ajax({
				url: "<%=basePath%>updatePsw.do",
				type: "post",
				data:{"newPsw":newPsw,"oldPsw":oldPsw},
				dataType: 'json',
				success: function(res){
					if(res.status == 'S'){
						alert("修改成功,请刷新当前页面重新登录");
						$.ajax({
							url: "<%=basePath%>logout.do",
							type: "get",
							dataType: 'json',
							success: function(res){

							},
							error: function(e){
					
							}
						});
					}else{
						alert("修改失败");
					}
				},
				error: function(e){
		
				}
			});
			$("#myModal").modal("hide");
		}
		return false;
	})
})

</SCRIPT>

<body>
<table width="198" border="0" cellpadding="0" cellspacing="0" class="left-table01">
  <tr>
    <TD>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="207" height="55" background="IndexUI/images/nav01.gif">
				<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
				  <tr>
					<td width="25%" rowspan="2"><img src="IndexUI/images/ico02.gif" width="35" height="35" /></td>
					<td width="75%" height="22" class="left-font01">您好，<span class="left-font02"><%=userName%></span></td>
				  </tr>
				  <tr>
					<td height="22" class="left-font01">
						[&nbsp;<a href="<%=basePath%>logout.do" target="_top" class="left-font01">退出</a>&nbsp;]<span id="updatePsw" style="cursor:pointer">[修改密码]</span></td>
				  </tr>
				</table>
			</td>
		  </tr>
		</table>

		<!--  新闻模块    -->
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
			<tr>
				<td height="29">
					<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td width="8%"><img name="img8" id="img8" src="IndexUI/images/ico04.gif" width="8" height="11" /></td>
							<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('8');" >公司简介模块</a></td>
						</tr>
					</table>
				</td>
			</tr>
		</TABLE>
		<table id="subtree8" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0"
			   cellspacing="0" class="left-table02">
			<tr>
				<td width="9%" height="21" ><img id="xiaotu21" src="IndexUI/images/ico06.gif" width="8" height="12" /></td>
				<td width="91%"><a href="cpyInst/list.do" target="mainFrame" class="left-font03" onClick="tupian('21');">公司简介列表</a></td>
			</tr>
		</table>

		<!--  新闻模块    -->
<!--		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
			<tr>
				<td height="29">
					<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td width="8%"><img name="img8" id="img9" src="../images/ico04.gif" width="8" height="11" /></td>
							<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('9');" >新闻模块</a></td>
						</tr>
					</table>
				</td>
			</tr>
		</TABLE>
		<table id="subtree9" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0"
			   cellspacing="0" class="left-table02">
			<tr>
				<td width="9%" height="21" ><img id="xiaotu22" src="../images/ico06.gif" width="8" height="12" /></td>
				<td width="91%"><a href="articleList.html" target="mainFrame" class="left-font03" onClick="tupian('22');">新闻列表</a></td>
			</tr>
		</table>-->


		<!--  产品管理模块    -->
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
			<tr>
				<td height="29">
					<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td width="8%"><img name="img7" id="img7" src="IndexUI/images/ico04.gif" width="8" height="11" /></td>
							<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('7');" >产品管理</a></td>
						</tr>
					</table>
				</td>
			</tr>
		</TABLE>
		<table id="subtree7" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0"
			   cellspacing="0" class="left-table02">
			<tr>
				<td width="9%" height="20" ><img id="xiaotu17" src="IndexUI/images/ico06.gif" width="8" height="12" /></td>
				<td width="91%">
					<a href="productManage/getProductKind.do" target="mainFrame" class="left-font03" onClick="tupian('17');">分类管理</a></td>
			</tr>
			<tr>
				<td width="9%" height="20" ><img id="xiaotu18" src="IndexUI/images/ico06.gif" width="8" height="12" /></td>
				<td width="91%">
					<a href="productManage/listProduct.do" target="mainFrame" class="left-font03" onClick="tupian('18');">产品管理</a></td>
			</tr>
		</table>

		<!--  留言管理    -->
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%" height="12"><img name="img2" id="img2" src="IndexUI/images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('2');" >留言管理</a></td>
                </tr>
            </table></td>
          </tr>
      </table>
	  
	  <table id="subtree2" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
        
		<tr>
          <td width="9%" height="20" ><img id="xiaotu7" src="IndexUI/images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="msgManage/list.do" target="mainFrame" class="left-font03" onClick="tupian('7');">留言信息查看</a></td>
        </tr>
      </table>

		<!--  联系方式    -->
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%" height="12"><img name="img3" id="img3" src="IndexUI/images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('3');" >联系方式管理</a></td>
                </tr>
            </table></td>
          </tr>
      </table>
	  
	  <table id="subtree3" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
        <tr>
          <td width="9%" height="20" ><img id="xiaotu8" src="IndexUI/images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="cpyInfo/getInfo.do" target="mainFrame" class="left-font03" onClick="tupian('8');">联系方式</a></td>
        </tr>
      </table>

		<!--  轮播图   -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%"><img name="img5" id="img5" src="IndexUI/images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('5');">轮播图管理</a></td>
                </tr>
            </table></td>
          </tr>
      </table>

	  <table id="subtree5" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
        <tr>
          <td width="9%" height="20"><img id="xiaotu13" src="IndexUI/images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="IndexUI/files/carousel.jsp" target="mainFrame" class="left-font03" onClick="tupian('13');">轮播图</a></td>
        </tr>
      </table>

	  </TD>
  </tr>
  
</table>

<div class="modal fade" id="myModal" tabindex="-1" data-backdrop role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				修改密码
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
			</div>
			<form>
			<div class="modal-body">
				<div class="form-group">
						<div class="col-sm-10">
							<input required type="password" name="oldPsw" class="form-control" 
								   placeholder="原密码">
						</div>
						<div class="col-sm-10">
							<input required type="password" name="newPsw" class="form-control" 
								   placeholder="新密码">
						</div>
						<div class="col-sm-10">
							<input required type="password" name="againPsw" class="form-control" 
								   placeholder="确认密码">
						</div>
					</div>
					
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<input type="submit" class="btn btn-primary edit" value="修改">			
			</div>
			</form>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</body>
</html>
