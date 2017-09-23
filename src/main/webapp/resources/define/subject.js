$(document).ready(function() {
  layui.use(['element', 'layer', 'laypage'], function() {
    var e = layui.element,
        layer = layui.layer,
        laypage = layui.laypage;


    
    laypage.render({
      elem: 'tabPage',
      count: 1000,
      layout: ['count', 'prev', 'page', 'next', 'limit', 'skip'],
      jump: function(obj){
        obj.count = 100;
      }
    });
    
    
    
    
    
    
    
    
  });
});