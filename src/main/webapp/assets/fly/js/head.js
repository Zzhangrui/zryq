jQuery(document).ready(function () {
       $.ajax({
           url:contextPath+"/fly/user/unRead",
           type:'post',
           dataType:'json',
           success:function (res) {
               if(res.success){
                   $("#unRead").html(res.data);
                   $("#unRead").show();
               }
           }
       })
});
