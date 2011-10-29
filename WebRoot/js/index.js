$(function(){
	$.post("/Abel/dynamic_findList.action",{"start":0,"end":10},function(data){
		$(".val_res_pg:eq(0)").before(data);
	});
	$("#send").click(function(e){
		e.preventDefault();
		var textarea=$.trim($("#textarea").val());
		var selectType=$("#selectType").val();
		if(textarea!=""){
			$.post("/Abel/dynamic_save.action",{"dynamic.description":textarea,"dynamic.type":selectType},function(data){
				$("#textarea").attr("value","");
				$(".val_res_pg:eq(0)").before(data);
			});
		}
	});
});