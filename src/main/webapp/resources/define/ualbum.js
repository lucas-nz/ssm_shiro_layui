layui.use(['upload', 'layer', 'flow'], function(){
  var layupl = layui.upload
      layer = layui.layer,
      flow = layui.flow;
  showAlbum();
  /* 拖拽上传 */
  var albumupl = layupl.render({
    elem: '#albupl',
    url: 'user/album/upload',
    accept: 'file',
    data: {username: $('#username').text()},
    done: function(res, index, upload){
      console.log(res);
      layer.msg('正在上传',{
        icon: 16,
        shade: 0.1,
        time: 10000
      });
      if(res.total > 0){
        var start = layer.msg('上传成功~', {
          icon: 1,
          time: 20000, //20s后自动关闭
          btn: ['刷新相册', '知道了~'],
          yes: function(){
            $('#imgDiv').empty();
            showAlbum();
            layer.close(start);
          }
        });
      }
      else{
        var end = layer.msg('上传失败~', {
          icon: 1,
          time: 20000, //20s后自动关闭
          btn: ['知道了~'],
          btnAlign: 'r',
          yes: function(){
             
          }
        });
        
        
      }
    },
    error: function(){
      console.log('错误的请求!');
    }
  });



function showAlbum(){
  /* 图片加载  */
  
  flow.load({
    elem: '#imgDiv', // 指定列表容器
    scrollElem: '#imgDiv',
    done: function(page, next){
      var limit = 4;
      var lis = [];
      $.get(
          'user/album/list?page=' + page + "&limit=" + limit,
          function(res){
            layui.each(res.data, function(index, item){
              lis.push('<li><img id="img' + item.fileId + '" src="' + item.fileUrl + '"></li>');
            });
            next(lis.join(''), page < res.total/limit);
            $('.flow-default li img').hover(function(){
              console.log($(this).parent().html());
              var index = layer.open({
                type: 1,
                title: false,
                closeBtn: 0,
                anim: 0,
                offset: 'lb',
                //area: ['600px', '400px'],
                skin: 'layui-layer-nobg', //没有背景色
                shade: 0,
                content: $(this).parent().html()
              });

            },function(){
                layer.closeAll('page');
            });
            
          }

      );
      $('.flow-default li img').hover(function(){
      },function(){
        layer.close();
      }
      
      );  
    }
  
  });
}
  
});