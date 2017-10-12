$(document).ready(function() {
	layui.use(['element', 'layer', 'laypage', 'util','form'], function() {
		var e = layui.element,
			layer = layui.layer,
			laypage = layui.laypage,
			form = layui.form,
			layutil = layui.util;
		
		
		
		
		
    
//================== 数据获取 start ========================
e.on('tab(index-tab-filter)',function(data){
  if(data.index == 1){
    var pageObj = {curr: 1, limit: 10};
    ajaxPageHelper(pageObj);
  }
  
  
  
  
});
		
function ajaxPageHelper(pageObj){
  $.ajax({
    type : 'POST',
    url : "index/subject/list",
    data : "page=" + pageObj.curr + "&limit=" + pageObj.limit,
    success : function(result){
      var data = result.data;
      var total = result.total;
      $('#subjectList').empty();
      for(i in data){
        addSubject(i, data[i], pageObj.curr, pageObj.limit);
      }
      form.render('radio');
      laypage.render({
        elem: 'tabPage',
        count: total,
        curr: pageObj.curr,
        limit: pageObj.limit,
        layout: ['count', 'prev', 'page', 'next', 'limit', 'skip'],
        jump: function(pageObj ,first){
          //console.log($(this));
          if(!first){
            ajaxPageHelper(pageObj);
            //console.log(pageObj.curr, pageObj.limit);
          }
        }
      });
    },
    error : function(){
      console.log("帖子太过久远,找不到了呢...")
    }
  });   
}		
function addSubject(i, data, curr, limit){
  var index = limit*(curr-1) + parseInt(i) + 1;
  var liDom = '<li id="li' + data.subjectid +'"><h2>第' + index + '题:' + data.subjecttitle +  '</h2></li>';
  $('#subjectList').append(liDom);
  var od = '<div class="layui-form opdiv"><div class="layui-form-item" id="od' + data.subjectid + '"><div></div>'
  $('#li' + data.subjectid).append(od);
  var opra = '<input type="radio" name="op' + data.subjectid + '" value="A" title="' + data.subjectoptiona + '">';
  var oprb = '<input type="radio" name="op' + data.subjectid + '" value="B" title="' + data.subjectoptionb + '">';
  var oprc = '<input type="radio" name="op' + data.subjectid + '" value="C" title="' + data.subjectoptionc + '">';
  var oprd = '<input type="radio" name="op' + data.subjectid + '" value="D" title="' + data.subjectoptiond + '">';
  $('#od' + data.subjectid).append(opra).append(oprb).append(oprc).append(oprd);
  
  
}		

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