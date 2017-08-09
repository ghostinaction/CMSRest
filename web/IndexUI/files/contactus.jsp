<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<base href="<%=basePath%>">
<script type="text/javascript" src="IndexUI/js/jquery.min.js"></script>
<link rel="stylesheet" href="IndexUI/css/bootstrap.min.css">
<script type="text/JavaScript">
	$(function(){
		$(".edit").click(function(){
			$("input[type=text]").removeAttr("readonly");
		});
		$(".cancle").click(function(){
			$("input[type=text]").attr("readonly","readonly");
		})
	});
</script>
</head>
<body>
<div">
    <div style="width: 500px;margin: 0 auto;margin-top: 80px">
    <form action="<%=basePath%>cpyInfo/edit.do" method="post">
    	<input type="hidden" name="id" value="${companyInfo.id }">
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon">地　址</div>
                <input type="text" name="address" readonly value="${companyInfo.address}" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon">电　话</div>
                <input type="text" name="phone" readonly value="${companyInfo.phone}" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon">传　真</div>
                <input type="text" name="chuanzheng" readonly value="${companyInfo.chuanzheng}" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon">联系人</div>
                <input type="text" name="people" readonly value="${companyInfo.people}" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon">业务邮箱</div>
                <input type="text" name="busEmail" readonly value="${companyInfo.busEmail}" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon">技术邮箱</div>
                <input type="text" name="techEmail" readonly value="${companyInfo.techEmail}" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon">主页</div>
                <input type="text" name="page" readonly value="${companyInfo.page}" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon">主营</div>
                <input type="text" name="business" readonly value="${companyInfo.business}" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon">咨询QQ</div>
                <input type="text" name="qqChat" readonly value="${companyInfo.qqChat}" class="form-control">
            </div>
        </div>
        <div style="text-align: center">
            <button type="button" class="btn btn-default edit">修改</button>
            <button type="submit" class="btn btn-default save">保存</button>
            <button type="reset" class="btn btn-default cancle" >取消</button>
        </div>
    </form>
    </div>
</div>
</body>
</html>