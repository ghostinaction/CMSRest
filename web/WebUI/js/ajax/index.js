/**
 * Created by Administrator on 2017/2/22.
 */
require(['../config'], function(config) {
    require.config(config.js);
    require(['jquery', 'app','bootstrap','common'],function($,app,bootstrap,common){
        $('.carousel').carousel();
        function getUserInfo(){
            common.getData(config.URLAPI.getCompanyInfo,"get",
                {},
                function(res){
                    localStorage.setItem("userInfo",JSON.stringify(res.data))
                },
                function(err){

                })
        }
        getUserInfo();
        
        function getShortInfo(){
        	 common.getData(config.URLAPI.getShortInfo,"get",
                     {},
                     function(res){
                    	 $(".info").html(res.data.content);
                     },
                     function(err){

                     })
        }
        getShortInfo()
        
        function initCarousel(){
            common.getData(config.URLAPI.getCarousel,"get",
                {},
                function(res){
                    var html = "";
                    for(var i=0;i<res.data.length-1;i++){
                        html += ['<div class="item">',
                            '                            <img style="width: 1000px;height:325px;" src="'+config.URLAPI._baseUrl+res.data[i].imgUrl+'" alt="'+res.data[i].desic+'">',
                            '                            </div>'].join("");
                    }
                    html += ['<div class="item active">',
                        '                            <img style="width: 1000px;height:325px;" src="'+config.URLAPI._baseUrl+res.data[i].imgUrl+'" alt="'+res.data[i].desic+'">',
                        '                            </div>'].join("");
                    $(".carousel-inner").empty();
                    $(".carousel-inner").append(html);
                },
                function(err){
                })
        }
        initCarousel();

        function intiProduct(){
            $(".product-list").empty();

            common.getData(
                config.URLAPI.getProductList + "?kindId=-1",
                "GET",
                {
                    'pageNo':1,
                    'pageSize':4
                },
                function (res) {
                    if (res.status == 'S') {
                        var html = "";
                        for(var i=0;i<res.data.length;i++){
                            html +=' <div class="col-sm-6 col-md-3">'+
                                '<a href="product_detail.html?productId='+res.data[i].id+'" class="thumbnail">'+
                                '<img style="height:150px" src="'+config.URLAPI._baseUrl+res.data[i].mainUrl+'"'+
                                'alt="通用的占位符缩略图">'+
                                ' </a>'+
                                '<p style="text-align:center">'+res.data[i].productName+'</p>'+
                                '</div>'
                        }
                        $(".product-list").append(html);
                    }
                },
                function (err) {

                })
        }
        intiProduct();

    })
})