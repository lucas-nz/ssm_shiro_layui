layui.use(['element', 'form', 'layer'], function() {
	var e = layui.element,
	  layer = layui.layer,
		form = layui.form;

	form.verify({
		username: function(value, item) { //value：表单的值、item：表单的DOM对象
		    if("" == value){
		      return '用户名不能为空';
		    }
/*				if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
					return '用户名不能有特殊字符';
				}
				if(/(^\_)|(\__)|(\_+$)/.test(value)) {
					return '用户名首尾不能出现下划线\'_\'';
				}
				if(/^\d+\d+\d$/.test(value)) {
					return '用户名不能全为数字';
				}
*/		},
		 pass: [
		         /^[\S]{3,12}$/
		         ,'密码必须3到12位，且不能出现空格'
		       ] 
	});
	
	$(document).keypress(function(e){
	  //回车事件
	  if(e.which == 13){
	    $('#loginBtn').click();
	  }
	});
	form.on('submit(loginForm)', function(data){
	  console.log(JSON.stringify(data));
	  console.log(data.field.username, data.field.password);
	  $.ajax({
	    method: 'POST',
	    data: {
	      username: data.field.username, 
	      password: data.field.password
	    },
	    url: './login',
	    success: function(result){
	      console.log(result);
	      if(result.status == "error"){
	        layer.msg(result.msg, {
	          icon : 2,
	          anim: 6
	        });
	        console.log($(':input').length);
	        for(var i = 0; i < $(':input').length - 1; i++){
	          $(':input')[i].value="";
	        }
	        $(':input')[0].focus();
	        
	      }
	      if(result.status == "success"){
	        layer.msg('正在登录',{
	          icon: 16,
	          shade: 0.1,
	          time: 1000
	        });
	        setTimeout(loginClick, 2000);
	        
	      }
	    }
	  });
	});
	
function loginClick(){
  $('.logo')[0].click();
}
	
});