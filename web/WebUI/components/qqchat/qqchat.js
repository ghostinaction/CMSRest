/**
 * Created by Administrator on 2017/3/28.
 */
require(['../config'], function(config) {
    require.config(config.js);
    require(['jquery','common','app','bootstrap'],function($,common){

        common.getData(config.URLAPI.getCompanyInfo,"get",
            {},
            function(res){
                $("#qqChat").attr("href","http://wpa.qq.com/msgrd?v=3&uin="+res.data.qqChat+"&site=qq&menu=yes")
            },
            function(err){

            })

        $(function () {
            var height = 200;
            $(".tenQQ").css("top",height);
            $(window).scroll(function(){
                if($(window).scrollTop() >=200){
                    $(".tenQQ").css("top",$(window).scrollTop())
                }else{
                    $(".tenQQ").css("top",200);
                }
            })
        })
    })
})