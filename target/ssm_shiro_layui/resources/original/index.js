/*
 * 
 * v.01 选项勾选框 √ 效果不好,换 layui.form
 */



$(document).ready(function() {
	layui.use(['element', 'layer', 'laypage', 'util','form'], function() {
		var e = layui.element,
			layer = layui.layer,
			laypage = layui.laypage,
			form = layui.form,
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
		      type : 'GET',
		      url : url,
		      data : "page=" + pageIndex + "&limit=" + limit,
		      success : function(data){
		        $('#subjectListPanel').empty();
		        for(var i in data){
		          subjectAppend(i, data);  
		        }
		      },
		      error : function(){
		        console.log("帖子太过久远,找不到了呢...")
		      }
		      
		    })
		    
		  }
		});
    function subjectAppend(i, data){
      var infodiv = $('#subjectListPanel');  //&#xe605;
      infodiv.append('<li id="li' + i + '"><h2>' + data[i].subjectTitle + '</h2></li>');
      var divinfo = '<div class="es-list-info">'; 
      divinfo = divinfo + '<span> <i class="layui-icon">&#xe63f;</i>' + data[i].subjectOptionA +'</span>';
      divinfo = divinfo + '<span> <i class="layui-icon">&#xe63f;</i>' + data[i].subjectOptionB +'</span>';
      divinfo = divinfo + '<span> <i class="layui-icon">&#xe63f;</i>' + data[i].subjectOptionC +'</span>';
      divinfo = divinfo + '<span> <i class="layui-icon">&#xe63f;</i>' + data[i].subjectOptionD +'</span>';
      divinfo = divinfo + '</div> ';
      $('#li' + i).append(divinfo);
      $('.es-list-info span i').on('click', function(){
        $(this).html('<i class="layui-icon correct">&#xe605;</i>');
        $(this).css('color', 'red');
      });
    }

/*
<li>
  <a href="/u/336" class="fly-avatar"> 
    <img src="//cdn.layui.com/avatar/336.jpg?t=1493709104721" alt="纸飞机"> 
  </a>
  <h2>
    <a href="/jie/15173/">开放 layui 官方交流二群</a>    
    <span class="fly-badge fly-badge-stick">置顶</span>      
  </h2>
  <div class="fly-list-info">
    <a href="/u/336" user=""> 
      <cite>纸飞机</cite> 
      <i class="iconfont icon-renzheng" title="认证信息：官方人员"></i> 
    </a> 
    <span>1天前</span> 
    <span>公告</span> 
    <span class="fly-list-kiss" title="悬赏飞吻">
      <i class="iconfont icon-kiss"></i> 10
    </span> 
    <span class="fly-list-nums">      
      <i class="iconfont icon-pinglun1" title="回答"></i> 23   
    </span> 
  </div>
</li>
 function listAppend(i,data){
  $('#bookListDiv').append('<div class="col-md-4" id="bk' + data[i].bookId + '"></div>');
  $('#bk' + data[i].bookId).append('<div class="thumbnail" id="tb' + data[i].bookId + '"></div>');
  $('#tb' + data[i].bookId).append('<img alt="300x200" src="' + imgSrc + '" />')
  $('#tb' + data[i].bookId).append('<div class="caption" id="cp' + data[i].bookId + '"></div>');
  $('#cp' + data[i].bookId).append('<h3>' + data[i].name + '</h3> 馆藏:' + data[i].number + '<a  id="btnBK' + data[i].bookId + '" href="../book/' + data[i].bookId + '/detail"><span class="glyphicon glyphicon-hand-right" style="color: rgb(115, 172, 253); font-size: 16px;float: right;"> 详细信息</span></a>')
  $('#cp' + data[i].bookId).append('<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>');

}   
 
 */		

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

		
		//$('html').niceScroll();
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