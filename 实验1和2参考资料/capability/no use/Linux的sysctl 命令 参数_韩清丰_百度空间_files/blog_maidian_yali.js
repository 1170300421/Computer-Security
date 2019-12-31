var cnum = Math.ceil(Math.random()*(2-0)+0);
var isSwitchOn = false;
if (cnum === 2){
	var isSwitchOn = false;
}
var BlogMaiDianYali = {
	isSwitchOn : isSwitchOn,
	listPageUrl : "http://hi.baidu.com/{spaceurl}/blog/tlist/{pagenum}",
	detailPageUrl : "http://hi.baidu.com/{spaceurl}/blog/tbody/{blogid}.html",
	detailReferPageUrl : "http://hi.baidu.com/{spaceurl}/blog/tbody/{blogid}.html?from=psrefer"
};