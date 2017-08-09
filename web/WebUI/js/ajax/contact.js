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
                        $('#address1').text(res.data.address)
                        $('#phone1').text(res.data.phone)
                        $('#chuanzheng1').text(res.data.chuanzheng)
                        $('#people1').text(res.data.people)
                        $('#busEmail1').text(res.data.busEmail)
                        $('#jishuEmail1').text(res.data.jishuEmail)
                        $('#page1').text(res.data.page)
                        $('#business1').text(res.data.business)
                    },
                    function(err){

                    })
            }else{
                var data = JSON.parse(userInfo);
                $('#address1').text(data.address)
                $('#phone1').text(data.phone)
                $('#chuanzheng1').text(data.chuanzheng)
                $('#people1').text(data.people)
                $('#busEmail1').text(data.busEmail)
                $('#jishuEmail1').text(data.jishuEmail)
                $('#page1').text(data.page)
                $('#business1').text(data.business)
            }

        }
        getInfo();
    })
})
