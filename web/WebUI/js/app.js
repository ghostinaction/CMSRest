/**
 * Created by houxingzhang on 2016-06-26.
 *function 注释说明
 * loadComponents(attr)　：组件加载立即执行函数，使用范例：<div data-html='components/header/header.html|js|css'></div>
 * 　　attr 参数为 data-html
 * IsLogin() :判断是否已登录　
 * MmbInfo():　获取已登录会员的信息，
 */
define(['jquery'], function($) {
	var path = window.location.pathname;
	path = path.substr(0, path.lastIndexOf('/'));
	//加载head的内容
	//var loadHeaderContent = function() {
	//	var _headcontent = '';
	//	_headcontent += ' <link rel="shortcut icon" href="' + path + '/images/logo-icon.ico" type="image/x-icon"/>' + //加载浏览器ico
	//		' <link href="' + path + '/css/normalize.css" rel="stylesheet"/>' +
	//		'<script src="' + path + '/js/plugs/modernizr-2.8.3.min.js"></script>' +
	//		'<script src="' + path + '/js/plugs/respond.min.js"></script>'
	//	$('head').prepend(_headcontent);
	//}();

	/*    var loadFooterContent = function () {
	        var _footercontent = '<script src="'+path+'/js/plugs/respond.min.js"></script>';
	           //  _footercontent+='<script src="plugs/html5shiv.min.js"></script>';
	        $('body').append(_footercontent);
	    }();*/

	//加载组件
	var loadComponents = function(attr) {
		$("[" + attr + "]").each(function() {
			if($(this).attr('load') == 'true') return;
			$(this).attr('load', 'true');
			var url = $(this).attr(attr);

			if(url.indexOf('|') == -1) { //参数后不带后缀名，加载单文件
				$(this).load(url);
				return;
			}
			var loadtype = url.substr(url.indexOf('|') + 1);
			url = url.substr(0, url.indexOf('|'));
			//加载组件所需文件
			$(this).load(url); //加载 html
			url = url.substr(0, url.indexOf('.')); //去掉URL后缀，获取路径

			var path = window.location.pathname;
			path = path.substr(0, path.lastIndexOf('/'));
			if(loadtype.indexOf('js') > -1)
				require([path + '/' + url + ".js"]); //加载js
			if(loadtype.indexOf('css') > -1) //加载 css
				$.get(url + ".css", function() {
				$('head').append('<link href="' + path + url + '" rel="stylesheet"/>')

			});
		});
	}("data-html");

});