$(document).ready(function() {
	layui.use(['element', 'layer', 'laypage', 'util'], function() {
		var e = layui.element,
			layer = layui.layer,
			laypage = layui.laypage,
			layutil = layui.util;

//================== 数据获取 start ========================
    var url = "";
    var pageIndex = 0;
    var limit = 10;
    var data = {
        page : pageIndex,
        limit : limit
      }
		e.on('tab(index-tab-filter)',function(data){
		  if(data.index == 0){
		    var url = "./subject/list";
		    $.ajax({
		      type : 'POST',
		      url : url,
		      data : "page=" + pageIndex + "&limit=" + limit,
		      success : function(data){
		        console.log(data);
		      },
		      error : function(){
		        console.log("帖子太过久远,找不到了呢...")
		      }
		      
		    })
		  }
		});
		
		
		

//================== 分页 start ========================		

//================== 搜索框 start ========================
		
		
		$('.es-search').on('click', function() {
			layer.open({
				title: false,
				content: '<input id="es-search" type="text" autofocus="true" placeholder="搜索内容, 回车跳转" class="es-search-input">',
				btn: false,
				shadeClose: true,
			});
			$('#es-search').bind('keydown', function(event) {
				if(event.keyCode == "13") {
					var str = this.value;
					layer.msg(str, {
						icon: 1,
						anim: 6
					})
				}
			});
		});

		
		
	//================== 分页 end ========================		
		$('html').niceScroll();
		$('.logo').on('mouseenter', function() {
			$(this).children('i').css('color', '#ff0000');
		});

		$('.logo').on('mouseleave', function() {
			$(this).children('i').css('color', '#393D49');
		});

		$('.nav a').on('mouseenter', function() {
			$(this).children('i').addClass('nav-this');
			$(this).children('font').addClass('nav-this');
		});
		$('.nav a').on('mouseleave', function() {
			$(this).children('i').removeClass('nav-this');
			$(this).children('font').removeClass('nav-this');
		});
		$('.nav-user a').on('mouseenter', function() {
			$(this).children('i').css('color', '#FFFFFF');
		});
		$('.nav-user a').on('mouseleave', function() {
			$(this).children('i').css('color', '#A9B7B7');
		});

		$('.nav-user span a').on('mouseenter', function() {
			$(this).css('color', '#FFFFFF');
			$(this).css('color', '#FFFFFF');
		});
		$('.nav-user span a').on('mouseleave', function() {
			$(this).css('color', '#A9B7B7');
			$(this).css('color', '#A9B7B7');
		});
		
	//================== 工具集 start ========================
    layutil.fixbar({
      bar1: true,
      bar2: true,
      showHeight: 20,
      bgcolor: '#009688',
      css: {
        bottom: 100
      },
      click: function(type) {

      }

    });

    $('.layui-fixbar li').on('mouseenter', function() {
      var type = $(this).attr('lay-type');
      if(type === 'bar1') {
        var index = layer.tips('<img src="resources/images/bc-2.png" />', $(this), {
          area: ['155px', '140px'],
          time: 20 * 1000,
        });
        $(this).on('mouseleave', function(){
          layer.close(index);
        });
        
        $('html').on('mousewheel', function() {
          layer.close(index);
        })
      } else if(type === 'bar2') {
        var index = layer.tips('給我一個吻~', $(this));
        $(this).on('mouseleave', function(){
          layer.close(index);
        });
        
        $('html').on('mousewheel', function() {
          layer.close(index);
        })

      }else if(type === 'top'){
        var index = layer.tips('嗖嗖嗖~', $(this));
        
        $(this).on('mouseleave', function(){
          layer.close(index);
        });
        
        $('html').on('mousewheel', function() {
          layer.close(index);
        })
        
      }

    })
//================== 工具集 end ========================
    

	});
});