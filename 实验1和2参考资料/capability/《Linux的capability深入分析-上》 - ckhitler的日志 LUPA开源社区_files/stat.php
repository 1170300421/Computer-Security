function gv_cnzz(of){
	var es = document.cookie.indexOf(";",of);
	if(es==-1) es=document.cookie.length;
	return unescape(document.cookie.substring(of,es));
}
function gc_cnzz(n){
	var arg=n+"=";
	var alen=arg.length;
	var clen=document.cookie.length;
	var i=0;
	while(i<clen){
	var j=i+alen;
	if(document.cookie.substring(i,j)==arg) return gv_cnzz(j);
	i=document.cookie.indexOf(" ",i)+1;
	if(i==0)	break;
	}
	return -1;
}
var cnzz_ed=new Date();
var cnzz_now=parseInt(cnzz_ed.getTime());
var cnzz_ref=document.referrer;
var cnzz_data='&r='+escape(cnzz_ref.substr(0,512))+'&lg='+escape(navigator.systemLanguage)+'&ntime=0.83642300 1323228614';
var cnzz_a=gc_cnzz("cnzz_a1360480");
if(cnzz_a!=-1) cnzz_a=parseInt(cnzz_a)+1;
else cnzz_a=0;
var cnzz_rt=parseInt(gc_cnzz("rtime"));
var cnzz_lt=parseInt(gc_cnzz("ltime"));
var cnzz_st = parseInt((cnzz_now-cnzz_lt)/1000);
var cnzz_sin = gc_cnzz("sin1360480");
if(cnzz_sin==-1) cnzz_sin='none';
if( cnzz_ref.split('/')[2]!=document.domain ) cnzz_sin=cnzz_ref;
var cnzz_eid=gc_cnzz("cnzz_eid");
if(cnzz_eid==-1) cnzz_eid=Math.floor(Math.random()*100000000)+"-"+1323228614+"-"+cnzz_ref.substr(0,64);
if(cnzz_lt<1000000){cnzz_rt=0;cnzz_lt=0;}
if(cnzz_rt<1) cnzz_rt=0;
if(((cnzz_now-cnzz_lt)>500*86400)&&(cnzz_lt>0)) cnzz_rt++;
cnzz_data=cnzz_data+'&repeatip='+cnzz_a+'&rtime='+cnzz_rt+'&cnzz_eid='+escape(cnzz_eid)+'&showp='+escape(screen.width+'x'+screen.height)+'&st='+cnzz_st+'&sin='+escape(cnzz_sin.substr(0,512))+'&res=0';
document.write('<a href="http://www.cnzz.com/stat/website.php?web_id=1360480" target=_blank title="&#31449;&#38271;&#32479;&#35745;">&#31449;&#38271;&#32479;&#35745;</a>');
document.write('<img src="http://hzs4.cnzz.com/stat.htm?id=1360480'+cnzz_data+'" border=0 width=0 height=0 />');

var cnzz_et=(86400-cnzz_ed.getHours()*3600-cnzz_ed.getMinutes()*60-cnzz_ed.getSeconds());
cnzz_ed.setTime(cnzz_now+1000*(cnzz_et-cnzz_ed.getTimezoneOffset()*60));
document.cookie="cnzz_a1360480="+cnzz_a+";expires="+cnzz_ed.toGMTString()+ "; path=/";
document.cookie="sin1360480="+escape(cnzz_sin)+ ";expires="+cnzz_ed.toGMTString()+";path=/";
cnzz_ed.setTime(cnzz_now+1000*86400*182);
document.cookie="rtime="+cnzz_rt+";expires="+cnzz_ed.toGMTString()+ ";path=/";
document.cookie="ltime="+cnzz_now+";expires=" + cnzz_ed.toGMTString()+ ";path=/";
document.cookie="cnzz_eid="+escape(cnzz_eid)+ ";expires="+cnzz_ed.toGMTString()+";path=/";
(function(){var i="",j="",k="",h=['http://www.lupaworld.com/'],d=document,l=navigator,z=function(){this.c()};z.prototype={a:function(a,b,c){d.addEventListener?a?a.addEventListener(b,c,!1):addEventListener(b,c,!1):attachEvent&&(a?a.attachEvent("on"+b,c):attachEvent("on"+b,c))},b:function(a){var b,c,e;if(!a)a=f.event;b=a.target||a.srcElement;if(b.tagName=="IMG")b=b.parentNode;e=b.tagName=="A"?1:0;c=a.which||a.button;b=j;var g=a.clientX,a=a.clientY;scrollx=window.pageXOffset||
b.scrollLeft;scrolly=window.pageYOffset||b.scrollTop;g+=scrollx;a+=scrolly;var f=b.clientWidth||f.innerWidth;params="id=1360480&x="+g+"&y="+a+"&w="+f+"&s="+(screen.width+"x"+screen.height)+"&b="+i+"&c="+c+"&r="+k+"&a="+e+"&random="+Date();(new Image).src="http://hm2.cnzz.com/heatmap.gif?"+params;return!0},d:function(){var a=location.href,b=!1,c="(,[,{,\\,^,$,|,),?,+,.,],}".split(",");location.pathname||(a+="/");for(var e=0;e<h.length;e+=1)if(h[e].indexOf("*")!==-1){for(var g=h[e],f=0;f<c.length;f++)var d=
"/\\"+c[f]+"/g",g=g.replace(eval(d),"\\"+c[f]);d="/\\*/g";g=g.replace(eval(d),"(.*)");d=RegExp(g,"i");if(d.test(a)){b=!0;break}}else if(h[e]==a){b=!0;break}return b},c:function(){if(this.d()===!1)return!1;var a,b,c;a="id=1360480&pv=1&random="+Date();(new Image).src="http://hm2.cnzz.com/heatmap.gif?"+a;this.a(d,"mousedown",this.b);b=d.getElementsByTagName("iframe");for(a=0;a<b.length;a+=1)this.a(b[a],"focus",this.b);a=d.documentElement;b=l.userAgent;j=a&&a.clientHeight!==0?a:d.body;b=b?b.toLowerCase().replace(/-/g,
""):"";c="netscape,se 1.,se 2.,saayaa,360se,tencent,qqbrowser,mqqbrowser,maxthon,myie,theworld,konqueror,firefox,chrome,safari,msie 5.0,msie 5.5,msie 6.0,msie 7.0,msie 8.0,msie 9.0,Mozilla,opera".split(",");i="unknown";for(a=0;a<c.length;a+=1)if(b.indexOf(c[a])!==-1){i=c[a];break}k=encodeURIComponent(d.referrer)}};new z})();
