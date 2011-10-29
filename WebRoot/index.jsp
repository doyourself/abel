<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Glow - free website template</title>
<meta name="keywords" content="glow, gray, 网站模板, cssMoban.com"/>
<meta name="description" content="Glow is a free website template or free css template from cssMoban.com"/>
<link href="<%=basePath %>css/templatemo_style.css" rel="stylesheet" type="text/css"/>
<link href="<%=basePath %>css/jquery.css" rel="stylesheet" type="text/css" media="screen,projection"/>
</head>
<body>
<s:include value="/inc/ITop.jsp"></s:include>
<div id="templatemo_wrapper">

	<div id="templatemo_sidebar">
    
    	<div id="site_title">
    	
            <a href="http://demo.cssmoban.com/cssthemes/templatemo_236_glow/index.html">
                
            <img src="<%=basePath %>images/laji/templatemo_logo.png" alt="Site Title"/>
            <span>your tagline goes here</span>
    
            </a>

		</div>
        
        <div id="news_section">
            
            <h2>Latest Updates</h2>
                    
            <div class="news_box">
                <a href="#">Nunc varius venenatis sem sed</a>
                <p>Mauris suscipit mauris in purus mattis placerat. Ut rhoncus imperdiet nibh sit amet sagittis. Aliquam erat volutpat.</p>
            </div>
            
            <div class="news_box">
                <a href="#">Donec ac aliquam neque</a>
                <p>Sed tellus diam, consequat nec volutpat et, cursus ac nisi. Mauris in risus in diam consequat suscipit non.</p>
            </div>
            
            <div class="news_box">
                <a href="#">Pellentesque habitant morbi tristique</a>
                <p>Aenean in erat odio, in tempor quam. Quisque sem orci, malesuada eu  blandit et, bibendum facilisis mi.</p>
          	</div>
          
        </div>
        
        <div class="cleaner_h30"></div>
        
        <div id="request_a_quote">
        	<s:if test="#session.user!=null">
        		<h2>个人档案</h2>
        		<p></p>
        		<div style="background:#F0F3F8;width: 128px; height:128px; border:1px solid #CCD8EA;"><img src="<%=basePath%>images/user.png" style="width: 128px; height:128px;"/></div>
        		<lable style="padding-top:10px;">用户名:<s:property value="#session.user.name"/></lable>
        		<lable>积分:<s:property value="#session.user.points"/> </lable>
        	</s:if><s:else>
            <h2>开始记录你的人生</h2>
            <p>In ac libero urna. Suspendisse sed odio ut mi auctor blandit. Duis luctus nulla metus.</p>
        		
                <form action="<%=basePath%>users_login.action" method="post" id="userLogin">
                    <label>用户名：</label>
                    <input name="user.name" id="topName" size="10" class="quote_input" title="用户名 或 邮箱" type="text"/>
                    <label>密　码：</label>
                    <input name="user.password" id="topPassword" size="10" class="quote_input" title="密码" type="password"/>
                    <input name="Submit" value="" alt="提交" id="loginBtn" title="提交" type="button"/>
                </form>
                </s:else>
            
            <div class="cleaner"></div>
        </div>
	</div>
	<div id="templatemo_content">
    
        <div id="templatemo_slider">
        
            <div style="width: 600px; height: 330px;" id="one" class="contentslider"><a style="opacity: 0; display: none;" href="#" class="cs_leftBtn"><img style="padding: 0px;" src="index_files/cs_leftImg.png"/></a>
                <div class="cs_wrapper">
                    <div style="left: 0px;" class="cs_slider">
                    
                        <div style="width: 600px; height: 330px;" class="cs_article">
                            <a href="http://www.cssmoban.com/" target="_parent">
                                <img src="<%=basePath %>images/laji/templatemo_slide03.jpg" alt="CSS Templates 1"/>
                            </a>
                        </div><!-- End cs_article -->
                        
                        <div style="width: 600px; height: 330px;" class="cs_article">
                            <a href="http://www.cssmoban.com/page/2" target="_parent">
                            <img src="<%=basePath %>images/laji/templatemo_slide02.jpg" alt="CSS Templates 2"/>
                            </a>
                        </div><!-- End cs_article -->
                        
                        <div style="width: 600px; height: 330px;" class="cs_article">
                            <a href="http://www.cssmoban.com/page/3" target="_parent">
                            <img src="<%=basePath %>images/laji/templatemo_slide01.jpg" alt="CSS Templates 3"/>
                            </a>
                        </div><!-- End cs_article -->
                        
                        <div style="width: 600px; height: 330px;" class="cs_article">
                            <a href="http://www.cssmoban.com/page/4" target="_parent">
                            <img src="<%=basePath %>images/laji/templatemo_slide04.jpg" alt="CSS Templates 4"/>
                            </a>
                        </div><!-- End cs_article -->
                  
                    </div><!-- End cs_slider -->
                </div><!-- End cs_wrapper -->
            <a style="display: block; opacity: 1;" href="#" class="cs_rightBtn"><img style="padding: 0px;" src="index_files/cs_rightImg.png"/></a></div><!-- End contentslider -->
            
            <!-- Site JavaScript -->
          <script type="text/javascript" src="<%=basePath %>js/jquery-1.js"></script>
          <script type="text/javascript" src="<%=basePath %>js/jquery_002.js"></script>
          <script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
           <script type="text/javascript" src="<%=basePath %>js/taglib.js"></script>
          <script type="text/javascript">
                $(function() {
                $('#one').ContentSlider({
                width : '600px',
                height : '330px',
                speed : 400,
                easing : 'easeOutSine'
                });
                });
            </script>
          <script src="index_files/jquery.htm" type="text/javascript"></script>
          <script src="index_files/recipes.htm" type="text/javascript"></script>
            <div class="cleaner"></div>
        </div> <!-- end of templatemo_slider -->  
        
        <h1>What we do</h1>
            <p>This is a <a href="http://www.cssmoban.com/" target="_parent">Free CSS Template</a> provided by <strong>cssMoban.com</strong>. Feel free to download, edit and apply this template for your websites. <a href="#" target="_blank">All photos</a> are provided by <strong>photovaco.com</strong>.
 In ac libero urna. Suspendisse sed odio ut mi auctor blandit. Duis 
luctus nulla metus, a vulputate mauris. Integer sed nisi sapien, ut 
gravida mauris. Nam et tellus libero.</p>
      <div class="cleaner_h30"></div>
            
        <h1>Featured Work</h1> 
        
        <div id="featured_work">
            <div class="left"><img src="<%=basePath %>images/laji/templatemo_image_04.jpg" alt="image"/></div>
                    
            <div class="right">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing 
elit. Pellentesque habitant morbi tristique senectus et netus et 
malesuada fames ac turpis egestas. Aenean in erat odio, in tempor quam. <a href="#">Quisque sem</a> orci, malesuada eu blandit et, bibendum facilisis mi. </p>
              <div class="button"><a href="#">Read More</a></div>
            </div>
            
            <div class="cleaner"></div>
        </div>
            
        <div class="cleaner_h30"></div>
            
        <h1>What Our Clients Say</h1>    
        
        <blockquote>
        <p>Sed luctus sodales iaculis. Nullam consectetur odio eget 
lorem placerat et ullamcorper sapien fringilla. Class aptent taciti 
sociosqu ad litora <a href="#">torquent</a> per conubia nostra, per inceptos himenaeos.</p>
        
      <cite>Special Client  - <span>cssMoban.com</span></cite></blockquote>
        
    	<div class="cleaner"></div>
    </div> <!-- end of content -->
    
    <div class="cleaner"></div>
</div> <!-- end of wrapper -->

<div id="templatemo_footer_wrapper">

	<div id="templatemo_footer">

        <ul class="footer_menu">
            <li><a href="http://demo.cssmoban.com/cssthemes/templatemo_236_glow/index.html">Home</a></li>
            <li><a href="http://demo.cssmoban.com/cssthemes/templatemo_236_glow/services.html">Services</a></li>
            <li><a href="http://demo.cssmoban.com/cssthemes/templatemo_236_glow/blog.html">Blog</a></li>
            <li><a href="http://demo.cssmoban.com/cssthemes/templatemo_236_glow/gallery.html">Gallery</a></li>
            <li class="last_menu"><a href="http://demo.cssmoban.com/cssthemes/templatemo_236_glow/contact.html">Contact Us</a></li>
        </ul>
    
        Copyright © 2048 <a href="#">Your Company Name</a> | 
        from <a href="http://www.cssmoban.com/" target="_parent">网站模板</a> | 
        Validate <a href="http://validator.w3.org/check?uri=referer">XHTML</a> &amp; <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a>
    
    </div> <!-- end of footer -->   
</div>         
<script>
$(function(){
	$("#loginBtn").click(function(){
		var username=$("#topName").val();
		var password=$("#topPassword").val();
		if($.trim(username)==""){
			alertT("请输入用户名！");
		}else if($.trim(password)==""){
			alertT("请输入密码！");
		}else{
			$("#userLogin").submit();
		}
	});
});
</script>
</body>
</html>