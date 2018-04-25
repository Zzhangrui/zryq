//解决IE7,8,input.textarea不支持placeholder
$(function(){ 
	$('input, textarea').placeholder(); 
});
//调用首页轮播图
$(function(){
			$('#slides').slides({
				preload: true,                    //显示加载图片
				preloadImage: 'img/loading.gif',  //加载图片所在的路径
				play: 4000,                       //切换等待时间
				pause: 2500,
				hoverPause: true,                 //hover停止切换
				animationStart: function(){
					$('.caption').animate({
						bottom:-40
					},100);
				},
				animationComplete: function(current){
					$('.caption').animate({
						bottom:0
					},200);
					if (window.console && console.log) {
						// example return of current slide number
						console.log(current);
					};
				}
			});
});
//通用选项卡js
$(function(){
    function tabs(tabTit,on,tabCon){
        $(tabTit).children().click(function(){
            $(this).addClass(on).siblings().removeClass(on);
            var index = $(tabTit).children().index(this);
           	$(tabCon).children().eq(index).show().siblings().hide();
    	});
	};
    tabs(".tab-hd","active",".tab-bd");//首页选项卡
});


// JavaScript Document
$(document).ready(function(e) {
	/***不需要自动滚动，去掉即可***/
	time = window.setInterval(function(){
		$('.og_next').click();	
	},5000);
	/***不需要自动滚动，去掉即可***/
	linum = $('.mainlist li').length;//图片数量
	w = linum * 250;//ul宽度
	$('.piclist').css('width', w + 'px');//ul宽度
	$('.swaplist').html($('.mainlist').html());//复制内容
	
	$('.og_next').click(function(){
		
		if($('.swaplist,.mainlist').is(':animated')){
			$('.swaplist,.mainlist').stop(true,true);
		}
		
		if($('.mainlist li').length>4){//多于4张图片
			ml = parseInt($('.mainlist').css('left'));//默认图片ul位置
			sl = parseInt($('.swaplist').css('left'));//交换图片ul位置
			if(ml<=0 && ml>w*-1){//默认图片显示时
				$('.swaplist').css({left: '1000px'});//交换图片放在显示区域右侧
				$('.mainlist').animate({left: ml - 1000 + 'px'},'slow');//默认图片滚动				
				if(ml==(w-1000)*-1){//默认图片最后一屏时
					$('.swaplist').animate({left: '0px'},'slow');//交换图片滚动
				}
			}else{//交换图片显示时
				$('.mainlist').css({left: '1000px'})//默认图片放在显示区域右
				$('.swaplist').animate({left: sl - 1000 + 'px'},'slow');//交换图片滚动
				if(sl==(w-1000)*-1){//交换图片最后一屏时
					$('.mainlist').animate({left: '0px'},'slow');//默认图片滚动
				}
			}
		}
	})
	$('.og_prev').click(function(){
		
		if($('.swaplist,.mainlist').is(':animated')){
			$('.swaplist,.mainlist').stop(true,true);
		}
		
		if($('.mainlist li').length>4){
			ml = parseInt($('.mainlist').css('left'));
			sl = parseInt($('.swaplist').css('left'));
			if(ml<=0 && ml>w*-1){
				$('.swaplist').css({left: w * -1 + 'px'});
				$('.mainlist').animate({left: ml + 1000 + 'px'},'slow');				
				if(ml==0){
					$('.swaplist').animate({left: (w - 1000) * -1 + 'px'},'slow');
				}
			}else{
				$('.mainlist').css({left: (w - 1000) * -1 + 'px'});
				$('.swaplist').animate({left: sl + 1000 + 'px'},'slow');
				if(sl==0){
					$('.mainlist').animate({left: '0px'},'slow');
				}
			}
		}
	})    
});

$(document).ready(function(){
	$('.og_prev,.og_next').hover(function(){
			$(this).fadeTo('fast',1);
		},function(){
			$(this).fadeTo('fast',0.7);
	})

})


//手风琴导航
$(document).ready(function(){				   
	/* 滑动/展开 */
	$("ul.expmenu li > div.header").click(function(){
												   
		var arrow = $(this).find("span.arrow");
	
		if(arrow.hasClass("up")){
			arrow.removeClass("up");
			arrow.addClass("down");
		}else if(arrow.hasClass("down")){
			arrow.removeClass("down");
			arrow.addClass("up");
		}
	
		$(this).parent().find("ul.menu").slideToggle();
		
	});
	
});

