/**
 * Created by houxingzhang on 2016-06-12.
 * 网站基础配置
 * js{}　为requireJs使用的路径配置
 * URLAPI{} 为前端与服务层交互的URL
 */
define(function() {
	var _jquery;

	//用来获取主机名 localhost:8080用于后面的拼路径 主要是图片路径  因为服务器返回的是 image/1.jpg 这样的路径
	//拼起来就是localhost:8080/image/1.jpg 如果是有项目名的就是
	//base+项目名+image

	var base = window.location.host;
	var _url = "http://"+ base + "/CMSRest"

	return {
		js: {
			baseUrl: 'js/',
			paths: {
				"app": "app",
				"common": "common",
				"jquery": ['plugs/jquery-3.1.1.min', 'https://code.jquery.com/jquery-1.12.0.min'],
				"bootstrap": "plugs/bootstrap.2.3.2.min"
			},
			shim: {
				"bootstrap": ["jquery"],
			}
		},
		URLAPI: {
			//配置图片存放的地址
			//因为我是放在主机对应根目录的image下 而数据库返回的是 image/1.jpg
			//所以我只要配成 _baseUrl:'http://' + base + '/'
			//_baseUrl: 'http://' + base + 项目名 + "/image",

			_baseUrl:'http://' + base + '/CMSRest/',
			Name: "text",
			UpFileLoad: " js/json/upload.json",
			getProductKind: _url + "/rest/CmsService/getProductKind",
			getProductList: _url + "/rest/CmsService/getProducts",
			getProductDetail: _url + "/rest/CmsService/getProductDetail",
			getCompanyInfo: _url + "/rest/CmsService/getInfo",
			getArticle:"js/json/",
			getCpyInst:_url + "/rest/CmsService/getCpyIns",
			getShortInfo:_url + "/rest/CmsService/getShortInfo",
			getCpyInsDetail:_url + "/rest/CmsService/getCpyInsDetail",
			getCarousel:_url + "/rest/CmsService/getCarouses",
			getImageCode:_url +"/ImageCodeServlet",
			checkCode:_url + "/msgManage/captcha.do",
			insertMsg:_url + "/msgManage/insertMsg.do"
		}
	}
})