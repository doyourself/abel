$(function(){
	var blogId = $("#blogId").val();
	var type = $("#type").val();
	$.post("/Abel/comment_list.action",{"resould":blogId,"type":1},function(data){
		$("#commentBanner").html(data);
	});
	$("#commentBtn").click(function(){
		var val = $("#tcommr_text").val();
		var id = $("#blogId").val();
		if($.trim(val)!="" && id !=""){
			$.post("/Abel/comment_addComment.action",{"comment.description":val,"comment.status":0,"comment.sortId":id,"comment.type":1,"comment.level":0},function(data){
				$(".comment_list_b:eq(0)").before(data);
			});
		}else{
			alert(val);
		}
	});
	$(".shfId").live("click",function(e){
		var id = $(this).attr("name");
		$("#showText_"+id).show();
	});
	$(".chf1").live('click',function(e){
		e.preventDefault();
		var id = $(this).attr("name");
		var val=$("#text1_"+id).val();
		var parentId = $(this).parent().parent().parent().parent().attr("id");
		if(id != "" && val!=""){
			$.post("/Abel/comment_addComment.action",{"comment.description":val,"comment.status":0,"comment.sortId":id,"comment.type":1,"comment.level":1,"comment.parentId":parentId},function(data){
				$("#text1_"+id).attr("value","");
				$("#showComment_"+id).hide();
				$(".sortId1_"+id+":eq(0)").before(data);
			});
			
		}
	});
	$(".chf2").live("click",function(e){
		e.preventDefault();
		var id  =$(this).attr("name");
		var val = $("#text2_"+id).val();
		var parentId = $(this).parent().parent().parent().parent().parent().attr("id");
		if(id != "" && val!=""){
			$.post("/Abel/comment_addComment.action",{"comment.description":val,"comment.status":0,"comment.sortId":id,"comment.type":1,"comment.level":2,"comment.parentId":parentId},function(data){
				$("#text1_"+id).attr("value","");
				$("#showComment_"+id).hide();
				$("#show2_"+id).append(data);
				$("#showList_"+id).hide();
			});
		}
	});
	$(".huf2").live("click",function(e){
		e.preventDefault();
		var sortId = $(this).attr("name");
		$("#showList_"+sortId).show();
	});
	$(".shfId").live("click",function(e){
		e.preventDefault();
		var sortId = $(this).attr("name");
		$("#showText_"+sortId).show();
	});
	$(".btn3").live("click",function(){
		$(".srkText").attr("value","");
		$(".srk").hide();
		$(".con_sub_pg").hide();
	});
	$(".chf3").live("click",function(e){
		e.preventDefault();
		var id  =$(this).attr("name");
		var val = $("#text3_"+id).val();
		var parentId = $(this).attr("abc");
		if(id != "" && val!=""){
			$.post("/Abel/comment_addComment.action",{"comment.description":val,"comment.status":0,"comment.sortId":id,"comment.type":1,"comment.level":2,"comment.parentId":parentId},function(data){
				$("#text1_"+id).attr("value","");
				$("#showComment_"+id).hide();
				$(".sortId1_"+id+":eq(0)").before(data);
			});
		}
	});
	$(".huifu").live('click',function(e){
		e.preventDefault();
		var sortId = $(this).attr("name");
		$("#showComment_"+sortId).show();
	});
	$(".sor").live("click",function(e){
		e.preventDefault();
		var id = $(this).parent().attr("cid");
		var type = $(this).attr("name");
		var href = $(this).attr("href");
		$.post("/Abel/comment_updateSRO.action",{"comment.id":id,"column":type},function(){
			
		});
		var val = $(this).html();
		var value = parseInt(href)+1;
		$(this).html(val.substring(0,3)+value+")");
		$(this).attr("class","sorError");
	});
	$(".sorError").live("click",function(e){
		e.preventDefault();
		alert("您已经发表过看法！");
	});
});

