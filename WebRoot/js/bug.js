$(function(){
	$("#sub").live("click",function(){
		var compendium = $.trim($("#compendium").val());
		if(compendium==""){
			alert("简述不能为空！");
		}else{
			$("#bugForm").submit();
		}
	});
	$("#delbug").live("click",function(){
		var id =$(this).attr("name");
		if(id==""){
			alert("非法操作！");
		}else if(confirm("确定要删除？删除后数据将无法回复！")){
			$.post("/Abel/bug_delete.action",{"bug.id":id},function(){});
			location.reload();
		}
	});
	//$(window).scroll(function(e){
        //var nDivHight = $("#ibody").height();
        //var scrollHeight = document.body.offsetHeight + document.body.scrollTop;
        //alert(document.documentElement.offsetHeight);
     //     var h1=this.scrollTop;
	//	   var h2=this.clientHeight;
	//	   var h3=this.scrollHeight;
	//	   alert(h1);
	//});
});