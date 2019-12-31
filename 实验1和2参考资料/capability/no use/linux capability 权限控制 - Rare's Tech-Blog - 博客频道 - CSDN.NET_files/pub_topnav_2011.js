// IE6-IE8 Alarm
var isOldIE = (function(){
		if(!document.all) return false;
		var ver = /MSIE\s([0-9.]+)/i.exec(navigator.appVersion);
		if(ver) return parseFloat(ver[1]) < 8.9;
		return false;
	})();
if(isOldIE){
	show_down_note();
}
function show_down_note() {
    var div = document.createElement('div');
	/*
    div.style.position = 'absolute';
	div.style.zIndex = '101';
    div.style.left = '0px';
    div.style.top = '0px';
	*/
    div.style.display = 'block';
    div.style.width = '100%';
    div.style.height = '26px';
    div.style.backgroundColor = '#ffffdd';
    div.style.textAlign = 'center';
    div.style.borderBottom = 'solid 1px #ccc';
    div.innerHTML = '<span style="font-size:14px;font-family:微软雅黑;">亲，你的浏览器过时了，请立即更换'
		+ '<a href="http://download.csdn.net/chrome/go/3641062" title="点击下载">Chrome浏览器</a>。</span>'
        + '<a style="float:right;margin-right:10px;*margin-top:-20px;found-weight:bold;font-family:Verdana;" title="关闭" '
		+ 'href="javascript:void(0);" onclick="javascript:this.parentNode.style.display=\'none\';return false;">X</a>';
    document.write(div.outerHTML);
}
// IE6-IE8 Alarm

document.writeln("<link rel=\"stylesheet\" type=\"text\/css\" href=\"http://csdnimg.cn/pubnav/css/navtop_2011.css\" \/>");
document.writeln("<div class=\"nav_top_2011\">");
var p__un = document.cookie.match(new RegExp("(^| )UserName=([^;]*)(;|$)"));
if (p__un) {
	document.write('<p>欢迎<em>' + p__un[2] + '</em>我的：<a href="http://download.csdn.net/my" class="red">资源</a><a href="http://writeblog.csdn.net/" class="red">博客</a><a href="http://hi.csdn.net/my.html">空间</a><a href="http://my.csdn.net/resume">简历</a><a href="http://passport.csdn.net/account/profile">设置</a>|<a href="http://passport.csdn.net/help/faq">帮助</a>|<a href="http://passport.csdn.net/account/logout">退出</a></p>');
} else {
	document.write('<p><span style="color:red;">您还未登录！</span>|<a href="http://passport.csdn.net/UserLogin.aspx">登录</a>|<a href="http://passport.csdn.net/CSDNUserRegister.aspx">注册</a>|<a href="http://passport.csdn.net/help/faq">帮助</a></p>');
}
document.writeln("<ul>");
document.writeln("<li><a href=\"http:\/\/www.csdn.net\/\" target=\"_blank\">CSDN首页<\/a><\/li>");
document.writeln("<li><a href=\"http:\/\/news.csdn.net\/\" target=\"_blank\">资讯<\/a><\/li>");
document.writeln("<li><a href=\"http:\/\/bbs.csdn.net\/\" target=\"_blank\">论坛<\/a><\/li>");
document.writeln("<li><a href=\"http:\/\/blog.csdn.net\/\" target=\"_blank\">博客<\/a><\/li>");
document.writeln("<li><a href=\"http:\/\/download.csdn.net\/\" target=\"_blank\">下载<\/a><\/li>");
document.writeln("<li><a href=\"http:\/\/so.csdn.net\/\" target=\"_blank\">搜索<\/a><\/li>");
document.writeln("<li class=\"more\" ><h2 id=\"topnav_btnmore\"><a href=\"javascript:void(0);\">更多<\/a><\/h2>");
document.writeln("<ul id=\"topnav_hidlist\">");
document.writeln("<li><a href=\"http:\/\/cto.csdn.net\/\" target=\"_blank\">CTO俱乐部<\/a><\/li>");
document.writeln("<li><a href=\"http:\/\/student.csdn.net\/\" target=\"_blank\">学生大本营<\/a><\/li>");
document.writeln("<li><a href=\"http:\/\/edu.csdn.net\/\" target=\"_blank\">培训充电<\/a><\/li>");
document.writeln("<li><a href=\"http:\/\/mobile.csdn.net\/\" target=\"_blank\">移动开发<\/a><\/li>");
document.writeln("<li><a href=\"http:\/\/sd.csdn.net\/\" target=\"_blank\">软件研发<\/a><\/li>");
document.writeln("<li><a href=\"http:\/\/cloud.csdn.net\/\" target=\"_blank\">云计算<\/a><\/li>");
document.writeln("<li><a href=\"http:\/\/www.programmer.com.cn\/\" target=\"_blank\">程序员<\/a><\/li>");
document.writeln("<li><a href=\"http:\/\/tup.csdn.net\/\" target=\"_blank\">TUP<\/a><\/li>");
document.writeln("<\/ul>");
document.writeln("<\/li>");
document.writeln("<\/ul>");
document.writeln("<\/div>");
var btnMore = document.getElementById("topnav_btnmore")
var hidList = document.getElementById("topnav_hidlist");
btnMore.onclick =  function()
{
	hidList.style.display = hidList.style.display =="block"?"none":"block";
}
document.body.onclick = function(event){
	event = event || window.event;
	var target = event.target || event.srcElement;
	if(target.parentNode.id == btnMore.id){
		return;
	}
	if(target.id != btnMore.id){
		hidList.style.display = "none";
	}
}

// Google code
var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-535605-6']);
_gaq.push(['_setDomainName', 'csdn.net']);
_gaq.push(['_trackPageview']);

(function() {
var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
})();
