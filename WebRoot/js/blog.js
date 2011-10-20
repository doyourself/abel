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
});

