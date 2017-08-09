/**
 * Created by Administrator on 2017/3/30.
 */
require(['../config'], function(config) {
    require.config(config.js);
    require(['jquery','common','app','bootstrap'],function($,common){

        var productId = common.getSearchString("productId");

        //获取产品详情
        (function(productId){
            common.getData(
                config.URLAPI.getProductDetail,
                "GET",
                {"productId":productId},
                function(res){
                    $(".title").text(res.data.productName);
                    $(".intro").html(res.data.productInfo);
                    $(".products").html(res.data.productDetail);
                    $("#menuTitle").text(res.data.productName);
                    $("#aImg").attr("href",config.URLAPI._baseUrl+res.data.detailUrl);
                    $("#img").attr("src",config.URLAPI._baseUrl+res.data.detailUrl);
                    var positionTitle = '您的位置：<a href="index.html">首页&nbsp;></a>'+res.data.kindName+''
                    $('#positionName').html(positionTitle);
                },
                function(err){

                })
        })(productId);

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
                    }
                },
                function(err){

                })
        }
        getProductKind();
    })
})