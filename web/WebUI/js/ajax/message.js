/**
 * Created by Administrator on 2017/3/31.
 */

require(['../config'], function(config) {
    require.config(config.js);
    require(['jquery','common','app','bootstrap'],function($,common){
        function initCode(){
            var now = new Date();
            var img = $("#codeImage").get(0);
            img.src = config.URLAPI.getImageCode+"?code=" + now.getTime();
        }
        initCode();

        $("#codeImage").click(function(){
            var now = new Date();
            var img = $("#codeImage").get(0);
            img.src = config.URLAPI.getImageCode+"?code=" + now.getTime();;
        })

        $("[name='captcha']").focus(function(){
            $("#codeMsg").css("display","none");
            $("[name='captcha']").val("");
        })

        $("#from").submit(function(e){
            //e.preventDefault();
            //$("#from").submit();
            //$("#from").submit();
            var captcha = $("[name='captcha']").val();
            common.getData(config.URLAPI.checkCode,"get",
                {"captcha":captcha},
                function(res){
                    if(res.status == 'S'){
                        var nickName = $("[name='nickName']").val();
                        var email = $("[name='email']").val();
                        var phone = $("[name='phone']").val();
                        var companyName = $("[name='companyName']").val();
                        var companyAddress = $("[name='companyAddress']").val();
                        var title = $("[name='title']").val();
                        var content = $("[name='content']").val();
                        common.getData(config.URLAPI.insertMsg,"post",
                            {
                                "nickName":nickName,
                                "email":email,
                                "phone":phone,
                                "companyName":companyName,
                                "companyAddress":companyAddress,
                                "title":title,
                                "content":content
                            },
                            function(res){
                                if(res.status == 'S'){
                                    alert("提交成功");
                                    window.location.href = "../index.html"
                                }else{
                                    alert("提交失败")
                                }
                            },
                            function(err){

                            })

                    }else{
                        $("#codeMsg").css("display","block");
                        initCode();
                    }
                },
                function(err){

                })
            return false;
        })

    })
})
