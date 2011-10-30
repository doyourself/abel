$(function(){
	$("#sub").live("click",function(){
		var compendium = $.trim($("#compendium").val());
		if(compendium==""){
			alert("简述不能为空！");
		}else{
		$("#notepadForm").submit();
		}
	});
	$("#delnotepad").live("click",function(){
		var id =$(this).attr("name");
		if(id==""){
			alert("非法操作！");
		}else if(confirm("确定要删除？删除后数据将无法回复！")){
			$.post("/Abel/notepad_delete.action",{"notepad.id":id},function(){});
			location.reload();
		}
	});
});