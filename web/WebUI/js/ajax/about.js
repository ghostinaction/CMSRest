/**
 * Created by Administrator on 2017/2/22.
 */
require(['../config'], function(config) {
    require.config(config.js);
    require(['jquery','app','common','bootstrap'],function($,app,common){
    	var content = [];

        var artId = common.getSearchString("artId");


    	function initCpyIns(){
            var beginArtId = 0;
    		common.getData(config.URLAPI.getCpyInst,"get",
    	            {},
    	            function(res){
                       if(res.status == 'S'){
                           var html = "";
                           beginArtId = res.data[0].id;
                           for(var i=0; i< res.data.length; i++){
                               html += '<li><a data-id="'+res.data[i].id+'" data-content="'+res.data[i].instType+'" href="about.html?artId='+res.data[i].id+'">'+res.data[i].instType+'</a></li>';
                           }
                           console.log(html);
                           $(".menu .part").empty();
                           $(".menu .part").append(html);
                           if(!artId){
                                artId = beginArtId;
                               getDetail(artId);
                           }else{
                               getDetail(artId);
                           }
                       }
    	            },
    	            function(err){
    	            })
    	}

        function getDetail(artId){
            common.getData(config.URLAPI.getCpyInsDetail,"get",
                {"artId":artId},
                function(res){
                    if(res.status == 'S'){
                        $(".content").empty();
                        $(".content").html(res.data.content);
                        $("#ahref").text(res.data.instType);
                    }
                },
                function(err){
                })
        }

        initCpyIns();
    })
})