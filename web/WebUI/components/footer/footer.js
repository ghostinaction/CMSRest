/**
 * Created by Administrator on 2017/2/22.
 */
/**
 * Created by Administrator on 2017/2/24.
 */

require(['../config'], function(config) {
    require.config(config.js);
    require(['jquery','common','app','bootstrap'],function($,common){
        function getInfo() {
            var userInfo = localStorage.getItem("userInfo");
            if(userInfo == null){
                common.getData(config.URLAPI.getCompanyInfo,"get",
                    {},
                    function(res){
                        $(".phone").text(res.data.phone);
                        $(".people").text(res.data.people);
                    },
                    function(err){

                    })
            }else{
                var data = JSON.parse(userInfo);
                $(".phone").text(data.phone);
                $(".people").text(data.people);
            }
        }
        getInfo();
    })
})
