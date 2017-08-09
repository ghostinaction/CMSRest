/**
 * Created by houxingzhang on 2016-06-12.
 * 公共js库
 *
 * function 说明注释
 *
 * Base64() 用于加密与解密，返回两个方法　　decode()为解密，encode()为加密
 *
 * 若需要添加新function请在此处添加注释及说明
 *
 * AutoSetFormValues(json, area)   自动设置表单，一般使用在编辑表单
 * json参数为 json对象, area 设置的区域如 id或class
 *
 * GetUrlParam（name） 获取浏览器参数，name为 你要获取的参数名
 * 将数值四舍五入(保留2位小数)后格式化成金额形式
 */
define(['jquery'], function($) {
	return {
		/*
		 * 获取url中的参数
		 */
		GetUrlParam: function(name) {

			var url = window.location.search; //获取url中"?"符后的字串
			var theRequest = "";
			if(url.indexOf("?") != -1) {
				var str = url.substr(1, url.length).split("&")
				for(var i = 0; i < str.length; i++) {
					if(str[i].split("=")[0] == name) {
						theRequest = decodeURI(str[i].split("=")[1]);
					}
				}
			}
			return theRequest;
		},

		getData:function(url, method, params, suc, err){
			//var token = localStorage.TokenCode;
			$.ajax({
					url: url,
					type: method,
					data: params,
					dataType: 'json',
					//headers:{
					//	"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8",
					//	"TokenCode":token
					//},
					//crossDomain:true,
					success: function(res){
						suc(res);
					},
					error: function(e){
						err(e);
					}
				});
			},
		testCommLib:function(){
			alert("success call commLib");
		},
		getSearchString:function(key) {
			// 获取URL中?之后的字符
			var str = location.search;
			str = str.substring(1,str.length);

			// 以&分隔字符串，获得类似name=xiaoli这样的元素数组
			var arr = str.split("&");
			var obj = new Object();

			// 将每一个数组元素以=分隔并赋给obj对象
			for(var i = 0; i < arr.length; i++) {
				var tmp_arr = arr[i].split("=");
				obj[decodeURIComponent(tmp_arr[0])] = decodeURIComponent(tmp_arr[1]);
			}
			return obj[key];
		}

}

});