$(function(){
	$("#addcategory").click(function(e){
		e.preventDefault();
		$("#addcateb").show();
		$(this).hide();
	});
	$("#qx_category_blog").click(function(e){
		e.preventDefault();
		$("#category_value").attr("value","请输入分类名称");
		$("#addcateb").hide();
		$("#addcategory").show();
	});
	$("#add_category_blog").click(function(){
		var val = $("#category_value").val();
		var type = $("#type").val();
		if(val != "请输入分类名称"&& $.trim(val)!=""&&type!=""){
			$.post("/Abel/category_saveOrUpdate.action",{"category.name":val,"category.type":type,"Ct":"js"},function(data){
				$("#category_name").html(data);
			});
			$("#addcateb").hide();
		}else{
			alert(val);
		}
	});
	$("#blog_sub").click(function(e){
		e.preventDefault();
		var Title = $.trim($("#Title").val());
		var Tag = $.trim($("#Tag").val());
		var category_name = $.trim($("#category_name").val());
		if(Title ==""){
			alert("标题不能为空！");
		}else if(Tag == ""){
			alert("标签不能为空！");
		}else if(category_name == 0){
			alert("请选择分类！");
		}else{
			$("#categoryForm").submit();
		}
	});
	$("#editCategory").click(function(e){
		e.preventDefault();
		var type = $("#type").val();
		$.fn.colorbox({href:"/Abel/category_list.action?type="+type});
	});
	$(".editUpdate").live("click",function(e){
		e.preventDefault();
		var id = $(this).attr("href");
		var val = $.trim($("#text_"+id).val());
		if(val == ""){
			alert("请输入分类名称！");
		}else{
			$.post("/Abel/category_update.action",{"category.id":id,"category.name":val,"category.type":1},function(){})
			alert("分类修改成功！");
			location.reload();
		}
	});
	$(".delCategory").live("click",function(e){
		e.preventDefault();
		var id = $(this).attr("href");
		if(id == ""){
			alert("非法操作！");
		}else{
			$.post("/Abel/category_delete.action",{"category.id":id},function(){})
		}
	});
});

