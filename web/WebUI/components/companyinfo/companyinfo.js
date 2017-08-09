/**
 * Created by Administrator on 2017/2/22.
 */
/**
 * Created by Administrator on 2017/2/24.
 */
require(['../config'], function(config) {
    require.config(config.js);
    require(['jquery','common','app','bootstrap'],function($,common){

        function getInfo(){
            var userInfo = localStorage.getItem("userInfo");
            if(userInfo == null){
                common.getData(config.URLAPI.getCompanyInfo,"get",
                    {},
                    function(res){
                        $('#address').text(res.data.address)
                        $('#phone').text(res.data.phone)
                        $('#chuanzheng').text(res.data.chuanzheng)
                        $('#people').text(res.data.people)
                        $('#busEmail').text(res.data.busEmail)
                        $('#jishuEmail').text(res.data.jishuEmail)
                        $('#page').text(res.data.page)
                        $('#business').text(res.data.business)
                    },
                    function(err){

                    })
            }else{
                var data = JSON.parse(userInfo);
                $('#address').text(data.address)
                $('#phone').text(data.phone)
                $('#chuanzheng').text(data.chuanzheng)
                $('#people').text(data.people)
                $('#busEmail').text(data.busEmail)
                $('#jishuEmail').text(data.jishuEmail)
                $('#page').text(data.page)
                $('#business').text(data.business)
            }

        }
        getInfo();
    })
})