<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/conf.jsp"%>

<meta charset="utf-8">
<base href="${base}" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="js/jquery.min.js"></script>

<script>
	function changeTo()
	{
		var temp = ${login}1;
        var path = window.location.href.toString();
        var proname = "/WXActivity/";
        path = path.substring(path.indexOf(proname) + proname.length, path.length);
   
        if (temp == 1)
        	//window.location.href = proname + "wx_login_test?id=zhoukk&url=" + encodeURIComponent(path);
            window.location.href = "${base}WXLogin?url=" + encodeURIComponent(path);
        else
            console.log(window.location.href);
	}

    $(function () {
        
        //changeTo();
        function onBridgeReady(){
       	 	isWX = 1;
        	WeixinJSBridge.call('hideOptionMenu');
       	 	WeixinJSBridge.call('hideToolbar');
       	 	WeixinJSBridge.invoke('getNetworkType',{},
       	 		function(e){
       	 	    	WeixinJSBridge.log(e.err_msg);
       	 			//alert(e.err_msg);
       	 	    });
       	}

       	if (typeof WeixinJSBridge == "undefined"){
       	    if( document.addEventListener ){
       	        document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
       	    }else if (document.attachEvent){
       	        document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
       	        document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
       	    }
       	}else{
       	    onBridgeReady();
       	}
        	
       //	alert(temp);
    })

</script>
<!-- Below is my jsp -->