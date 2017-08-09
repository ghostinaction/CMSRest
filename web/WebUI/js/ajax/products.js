/**
 * Created by Administrator on 2017/2/22.
 */

require(['../config'], function(config) {
    require.config(config.js);
    require(['jquery','common', 'app','bootstrap'],function($,common,app){

        var getProductKind = function(){
            common.getData(
                config.URLAPI.getProductKind,
                "GET",
                "",
                function(res){
                    if(res.status == 'S'){
                        var html = '<li><a class="kindTitle" data-kindid="-1" href="products.html?kindId=-1&&pageNo=1">全部</a></li>';
                        for(var i=0; i < res.data.length;i++){
                            html += '<li><a class="kindTitle" data-kindid="'+res.data[i].id+'" href="products.html?kindId='+res.data[i].id+'&&pageNo=1">'+res.data[i].kindName+'</a></li>';
                        }
                        $(".menu .part").empty();
                        $(".menu .part").append(html)
                        initPage();
                    }
                },
                function(err){

                })
        }
        getProductKind();

        //当点击分类菜单的时候显示分类对应下的产品
//        $('.menu .part').on('click','a',function(){
//            var productListParam = {};
//            productListParam.kindId = kindId;
//            productListParam.currentPage = 1;
//            productListParam.pageSize = 4;
//            getProductList(productListParam);
//        });
        //
        var getProductList = function(productListParam) {
            common.getData(
                config.URLAPI.getProductList + "?kindId=" + productListParam.kindId,
                "GET",
                {
                    	'pageNo':productListParam.currentPage,
                    	'pageSize':productListParam.pageSize
                },
                function (res) {
                    if (res.status == 'S') {
                        var html = "";
                        if(res.data.length == 0){
                            html = "<h1 style='text-align: center;font-size: 20px;padding-top: 20px;'>没有数据</h1>"
                        }else{
                            for (var i = 0; i < res.data.length; i++) {
                                html += '<div class="col-sm-6 col-md-4">' +
                                    '<a style="margin-bottom: 0px" href="product_detail.html?productId='+res.data[i].id+'" class="thumbnail">' +
                                    '<img style="height: 150px;max-width: 210px;" src="'+config.URLAPI._baseUrl+res.data[i].mainUrl+'"' +
                                    'alt="通用的占位符缩略图">' +
                                    '</a>' +
                                    '<p style="text-align:center">' + res.data[i].productName + '</p>' +
                                    '</div>'
                            }
                            createPag(res);
                        }

                        $(".product-list").empty();
                        $(".product-list").append(html);

                    }
                },
                function (err) {

                })
        }

        var createPag = function (res){
            //还是动态转为int型靠谱
            var kindId = common.getSearchString("kindId");
            var pageNo = Number(common.getSearchString("pageNo"));
            if(!pageNo){
                pageNo = 1;
            }
            //alert("pageNo"+pageNo);
            var pre = pageNo-1 == 0 ?1 : pageNo-1;
            var nxt = pageNo + 1;
            if(nxt >= res.pageTotal){
                nxt = res.pageTotal;
            }

            var html = "";
            html = '<a href="products.html?kindId='+kindId+'&&pageNo=1">首页</a>'+
                       '<a href="products.html?kindId='+kindId+'&&pageNo='+pre+'">上一页</a>';
            for(var i=1;i<=res.pageTotal;i++){
                if(pageNo == i){
                    html += '<a id="pageclicked" href="products.html?kindId='+kindId+'&&pageNo='+i+'">'+i+'</a>';
                }else{
                    html += '<a href="products.html?kindId='+kindId+'&&pageNo='+i+'">'+i+'</a>';
                }
            }
            html += '<a href="products.html?kindId='+kindId+'&&pageNo='+Number(pageNo+1)+'">下一页</a>';+
                     '<a href="products.html?kindId='+kindId+'&&pageNo='+res.pageTotal+'">尾页</a>';
            $('#pagerMain').empty();
            $('#pagerMain').append(html);

        }

        var initPage = function(){
                var kindId = common.getSearchString("kindId");
                var pageNo = common.getSearchString("pageNo");
                if(!kindId){
                    kindId = -1;
                }
                if(!pageNo){
                    pageNo = 1;
                }

                var title = $('[data-kindid="'+kindId+'"]').text();
                $('#menuTitle').text(title);
                var positionTitle = '您的位置：<a href="index.html">首页&nbsp;></a>'+title+'';
                $('#positionName').html(positionTitle);
                var productListParam = {};
                productListParam.kindId = kindId;
                productListParam.currentPage = pageNo;
                productListParam.pageSize = 4;
                getProductList(productListParam);
        };
    })
})
