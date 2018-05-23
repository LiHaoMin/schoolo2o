layui.config({
	base : "js/"
}).use(['form','layer','jquery'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		$ = layui.jquery;
	//video背景
	$(window).resize(function(){
		/*if($(".video-player").width() > $(window).width()){
			$(".video-player").css({"height":$(window).height(),"width":"auto","left":-($(".video-player").width()-$(window).width())/2});
		}else{
			$(".video-player").css({"width":$(window).width(),"height":"auto","left":-($(".video-player").width()-$(window).width())/2});
		}*/
		$(".video-player").css({"width":$(document).width(),"height":$(document).height()});
	}).resize();
	
	//登录按钮事件
	form.on("submit(login)",function(data){
		var username = data.field.username;
		var password = data.field.password;
		var index = layer.load(1);
		$.get('http://localhost:8080/user/login',data.field,function(data){
			layer.close(index);
			if(data.success){
				window.location.href = "../../index.html";
                window.sessionStorage.setItem("user",data.data);
			}else{
				layer.msg(data.errorMsg);
			}
		});		
		return false;
	})
})
