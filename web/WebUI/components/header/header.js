/**
 * Created by Administrator on 2017/2/22.
 */
//define(['jquery','app'],function($){
//    $(".h_nav").on("click","li",function(){
//        //$(this).find("a").addClass("cur");
//        $(this).find("a").addClass("cur");
//    })
//});

require(['../config'], function(config) {
    require.config(config.js);
    require(['jquery', 'app','bootstrap','common'],function($,app,bootstrap,common){
        var pathName = (window.location.pathname);
        var nameArray = pathName.split("/");
        var fileName = nameArray[nameArray.length-1];

        $("[href='"+fileName+"']").addClass("cur");

        function getInfo() {
            var userInfo = localStorage.getItem("userInfo");
            if(userInfo == null){
                common.getData(config.URLAPI.getCompanyInfo,"get",
                    {},
                    function(res){
                        $(".phone").text(res.data.phone);
                    },
                    function(err){

                    })
            }else{
                var data = JSON.parse(userInfo);
                $(".phone").text(data.phone);
            }
        }
        getInfo();
    })
})
