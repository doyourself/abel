var sto;
function alertT(val){
	var str='<div id="alertPG"><div id="alertMenu"><div id="alertX"><img style="cursor: pointer; width:20px; height:18px;" class="closeAlent" src="/Abel/images/blue/close_1.gif"/></div></div>	<div id="alertBanner"><table width="370px" cellpadding="0" cellspacing="0">	<tr><td colspan="2" align="center" style="color:#F7925E">'+val+'</td></tr><tr><td  width="20%;"></td><td align="right"><button type="button" class="btn3 closeAlent">确定</button><!-- <button type="button">取消</button> --></td></tr></table>	</div></div>';
	var str2='<div id="alertbanner" style="width:100%; height:100%;opacity:0.60; filter:alpha(opacity = 60); background:#ccc; position: fixed; z-index: 10000; left:0; top:0; float:left; display:inline;"></div>';
	$("body").append(str2);
	$("body").append(str);
	sto = setTimeout(function(){
		$('#alertPG').fadeOut("slow");
		$("#alertbanner").fadeOut("slow");
		setTimeout(function(){
			$('#alertPG').remove();
			$("#alertbanner").remove();
		},3000);
	},5000);
}
var yd=false;
$(function(){
	$(".closeAlent").live("click",function(e){
		e.preventDefault();
		$('#alertPG').fadeOut("slow");
		$("#alertbanner").fadeOut("slow");
		setTimeout(function(){
			$('#alertPG').remove();
			$("#alertbanner").remove();
		},3000);
	});
	$("#alertX img").live("mouseover",function(){
		$(this).attr("src","/Abel/images/blue/close_2.gif");
	});
	$("#alertX img").live("mouseout",function(){
		$(this).attr("src","/Abel/images/blue/close_1.gif");
	});
	
	$("#alertPG").live("mousedown",function(e){
		clearInterval(sto); 
		var w = e.clientX;
		var h = e.clientY;
		var pg = $(this).offset();
		var ww = pg.left;
		var hh = pg.top;
		var pgw = w-ww;
		yd=true;
		$("body").live("mousemove",function(e){
		if(yd==true){
			var w = e.clientX;
			var h = e.clientY;
			$("#alertPG").css("top",h);
			$("#alertPG").css("left",w-pgw);
		}
	});
	});
	$("#alertPG").live("mouseup",function(){
		yd=false;
	});
});