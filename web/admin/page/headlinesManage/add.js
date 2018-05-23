var $;
layui.config({
	base : "js/"
}).use(['form','layer','jquery'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage;
		$ = layui.jquery;

 	var addUserArray = [],addUser;
 	form.on("submit(add)",function(data){
 		//弹出loading
 		var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        $.ajax({
            type : "POST",
            url : BASE_URL + '/headLines/save',
            data : JSON.stringify(data.field),
            contentType : "application/json",
            dataType : "json",
            success:function(data) {
                if(data.success){
                    top.layer.close(index);
                    layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                }
                top.layer.msg(data.errorMsg);
            }
        });
 		return false;
 	})

    $('#imgFile').change(function (obj) {
        var fileObj = imgFile.files[0]; // js 获取文件对象
        if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
            layer.msg("请选择图片");
            return;
        }
        var formFile = new FormData();
        formFile.append("smfile", fileObj); //加入文件对象
        var index= layer.load(1);
        $.ajax({
            url: "https://sm.ms/api/upload",
            data: formFile,
            type: "Post",
            dataType: "json",
            cache: false,//上传文件无需缓存
            processData: false,//用于对data参数进行序列化处理 这里必须false
            contentType: false, //必须
            success: function (result) {
                layer.close(index);
                if(result.code == 'success'){
                    $('#categoryImage').val(result.data.url);
                    layer.msg("上传完成!");
                }else{
                    layer.msg("上传失败!");
                }

            },
        })
    });
	
})

//格式化时间
function formatTime(_time){
    var year = _time.getFullYear();
    var month = _time.getMonth()+1<10 ? "0"+(_time.getMonth()+1) : _time.getMonth()+1;
    var day = _time.getDate()<10 ? "0"+_time.getDate() : _time.getDate();
    var hour = _time.getHours()<10 ? "0"+_time.getHours() : _time.getHours();
    var minute = _time.getMinutes()<10 ? "0"+_time.getMinutes() : _time.getMinutes();
    return year+"-"+month+"-"+day+" "+hour+":"+minute;
}
