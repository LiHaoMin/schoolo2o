layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
	
	var app = new Vue({
		el:'#app',
		data:{
			dataList:null,
			pageTotal:0
		}
	});
	$.get(BASE_URL + '/product/list',function(data){
		if(data.success){
			app.dataList = data.data;			
			app.pageTotal = data.total;
			laypage({
				cont: 'page',
				pages: app.pageTotal,
				jump: function(obj){
					$.get(BASE_URL + '/product/list',{page:obj.curr},function(data){
						if(data.success){
							app.dataList = data.data;
							app.pageTotal = data.total;
							form.render('checkbox');
						}
					});
				}
			});
		}
	});
	


	//添加文章
	//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
	$(window).one("resize",function(){
		$(".add_btn").click(function(){
			var index = layui.layer.open({
				title : "添加",
				type : 2,
				content : "add.html",
				success : function(layero, index){
					setTimeout(function(){
						layui.layer.tips('点击此处返回列表', '.layui-layer-setwin .layui-layer-close', {
							tips: 3
						});
					},500)
				}
			})			
			layui.layer.full(index);
		})
	}).resize();

	//批量删除
	$(".batchDel").click(function(){
		var $checkbox = $('.layui-table tbody input[type="checkbox"]:not([name="show"])');
		var $checked = $('.layui-table tbody input[type="checkbox"]:not([name="show"]):checked')
		if($checkbox.is(":checked")){
			layer.confirm('确定删除选中的信息？',{icon:3, title:'提示信息'},function(index){
				var index = layer.msg('删除中，请稍候',{icon: 16,time:false,shade:0.8});
            	//删除数据
            	var ids = '';
            	for(var j=0;j<$checked.length;j++){
    				ids += $checked.eq(j).parents("tr").find(".del").attr("data-id") + ',';
            	}
				$.get(BASE_URL + '/product/delete',{ids:ids.substring(0,ids.length - 1)},function(data){
					if(data.success){
						layer.msg(data.errorMsg);
		            	for(var j=0;j<$checked.length;j++){
		    				$checked.eq(j).parents("tr").remove(); 
		            	}						
		            	$('.layui-table thead input[type="checkbox"]').prop("checked",false);
		            	form.render();
					}else{
						layer.msg(data.errorMsg);
					}
	                layer.close(index);
				});
	        })
		}else{
			layer.msg("请选择需要删除的记录");
		}
	})

	//全选
	form.on('checkbox(allChoose)', function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		child.each(function(index, item){
			item.checked = data.elem.checked;
		});
		form.render('checkbox');
	});

	//通过判断是否全部选中来确定全选按钮是否选中
	form.on("checkbox(choose)",function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		var childChecked = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"]):checked')
		if(childChecked.length == child.length){
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = true;
		}else{
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = false;
		}
		form.render('checkbox');
	})

	//操作
	$("body").on("click",".edit",function(){  //编辑
		layer.alert('您点击了编辑按钮，暂时不存在编辑内容，后期会添加，敬请谅解。。。',{icon:6, title:'编辑'});
	})

	$("body").on("click",".del",function(){  //删除
		var _this = $(this);
		layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
			//_this.parents("tr").remove(); 
			$.get(BASE_URL + '/product/delete',{ids:_this.attr("data-id")},function(data){
					if(data.success){
						layer.msg(data.errorMsg);
						_this.parents("tr").remove(); 
					}else{
						layer.msg(data.errorMsg);
					}
			});
			layer.close(index);
		});
	})
})
