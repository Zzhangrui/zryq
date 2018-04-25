/*
  Created by Administrator on 2017/2/19.
 */

(function ($) {
    //huanead_main_nav_wrap 宽度
/*
    var WIDTH = parseInt($("#head_main_nav_wrap").css("width"));
    var LENGTH = $("#slider_box li").length;
    //按钮大小
    var btnWidth = 50;

    var NewWidth = (WIDTH - btnWidth * 2) / 14;


    //页面初始化大小
    $("#slider_box").css({width: (WIDTH - btnWidth * 2), left: btnWidth});
    $("#slider_box ul").css({width: NewWidth * LENGTH + 1, marginLeft: 0});
    $("#slider_lf_btn,#slider_rt_btn").css('width', btnWidth);
    $("#slider_box li").css('width', NewWidth);


    //按钮点击
    var ML = parseInt($("#slider_box ul").css("margin-left"));
    //console.log("ML=" + ML);
    //左
    $("#slider_lf_btn").click(function () {
        if (ML < 0 ) {
            if(!$(this).hasClass("active")){
                $(this).addClass("active");
                ML = parseFloat($("#slider_box ul").css("margin-left")) + (NewWidth*3);
                if(ML>0){
                    ML=0;
                }
                $("#slider_box ul").animate({marginLeft: ML},"fast",function(){
                    $("#slider_lf_btn").removeClass("active");
                });
            }
        }
    });

    //右


    $("#slider_rt_btn").click(function () {
        if ( ML > (LENGTH - 14) * (-NewWidth) ) {
            if(!$(this).hasClass("active")){
                $(this).addClass("active");
                ML = parseFloat($("#slider_box ul").css("margin-left")) - (NewWidth*3);
                if(ML<(LENGTH - 14) * (-NewWidth)){
                    ML=(LENGTH - 14) * (-NewWidth);
                }
                $("#slider_box ul").animate({marginLeft: ML},"fast",function () {
                    $("#slider_rt_btn").removeClass("active");
                });
            }
        }
    });
                */
               
    //#head_main_nav_wrap的width
    var WIDTH = parseInt($("#head_main_nav_wrap").css("width"));
    //li个数
    var LENGTH = $("#slider_box li").length;
    //按钮大小
    var btnWidth = 48;
    //一个li的width
    var NewWidth = (WIDTH - btnWidth * 1) / 14;
    //页面初始化大小
    $("#slider_box").css({width: WIDTH, left: 0});
   // $("#slider_box ul").css({width: NewWidth * LENGTH + 1, marginLeft: 0});
    $("#slider_rt_btn").css('width', btnWidth);
    $("#slider_box li").css('width', NewWidth);
//控制top_menu一行显示14个，点击按钮显示全部
    $('#js-slider_ul li:gt(13)').hide();
     //是否隐藏
    var isHide = true; 
    //按钮绑定监听
    $('#slider_rt_btn').click(function(){
      if(isHide){
        $('#js-slider_ul li:hidden').show();
        $(this).css('color',"#e14f4f");
        isHide = false;
      }else {
        $('#js-slider_ul li:gt(13)').hide();
        $(this).css('color',"");
        isHide = true;
      }
    });
    




    //主页面折叠
    $("#fold_con a").click(function () {
        $(this).removeClass("active").siblings().addClass("active");
            if($(this).hasClass("fold_close")){
                $("#con_main_nav").animate({width:"20px"});
                $("#nav_wrap").animate({width:0}).hide();
                $("#con_box").animate({left:"20px"});
                $("#accordion").css("display","none");
            }else{
                $("#con_main_nav").animate({width:"180px"});
                $("#nav_wrap").show().animate({width:"179px"});
                $("#con_box").animate({left:"180"});
                $("#accordion").css("display","block");
            }
    })


    //个人资料 边栏折叠 star
    $(".User_Article_nav span").click(function () {
        // console.log("在这里！！");
        var thisIndex=$(this).index();
        // console.log(thisIndex);
        $(this).addClass("active").siblings().removeClass("active");
        if(thisIndex===0){
            $(".js_first").show();
            $(".js_second").hide();

        }else{
            $(".js_first").hide();
            $(".js_second").show();
        }
    });

    $(".User_Article_news_con>li,.User_Article_news_sub>li").click(function () {

        $(this).toggleClass("active").siblings().removeClass("active").children("div").children('span').removeClass("fa-minus").addClass("fa-plus");
        //alert($(this).children("div").children('span').attr("class"));
        if($(this).children("div").children('span').hasClass('fa-minus')){
            $(this).children("div").children('span').removeClass("fa-minus").addClass("fa-plus");
        }else{
            $(this).children("div").children('span').removeClass("fa-plus").addClass("fa-minus");
        }
    });
    //个人资料 边栏折叠 end
})(jQuery);



/**
    *左侧left_menu
*/
$(function() {
    var Accordion = function(el, multiple) {
        this.el = el || {};
        this.multiple = multiple || false;

        // Variables privadas
        var links = this.el.find('.link');
        // Evento
        links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
    }

    Accordion.prototype.dropdown = function(e) {
        var $el = e.data.el;
            $this = $(this),
            $next = $this.next();

        $next.slideToggle();
        $this.parent().toggleClass('open');

        if (!e.data.multiple) {
            $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
        };
    }   

    var accordion = new Accordion($('#accordion'), false);
});

