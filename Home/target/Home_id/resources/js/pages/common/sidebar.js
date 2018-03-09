$(document).ready(function() {
	var
		el = {
        	treeview: '.treeview', 
        	treeview_menu: '.treeview-menu',
		},
		NONE_CLASS = 'none',
		open_class = 'menu-open';

		init();
		function init(){
			// this._addEventLintener();
			// this._hideTip();
			//当前页所在导航栏展开
			var pageUrl;
			pageUrl = window.location.href; // 全部地址栏
			// pageUrl = window.location.pathname;
			console.log(pageUrl);
			$('.sidebar-menu a').each(function(){
				url=$(this).attr('href');
				console.log(url);
				if(url==pageUrl){
					$(this).parents(el.treeview).addClass(open_class);
					$(this).parents(el.treeview_menu).show();
					// 给自己添加高亮
					$(this).css('color','#fff');
				}
			});
		}
		/*备用方案1*/
		// function init(){
		// 	//当前页所在导航栏展开
		// 	var pageUrl = splitSidebar(window.location.href);
		// 		console.log(splitSidebar(pageUrl));
		// 	$('.sidebar-menu a').each(function(){
		// 		url = splitSidebar($(this).attr('href'));
		// 		if(url==pageUrl){
		// 			$(this).parents(el.treeview).addClass(open_class);
		// 			$(this).parents(el.treeview_menu).show();
		// 		}
		// 	});
		// }
		// function splitSidebar(str) {
		// 	var strFirst = new Array;
		// 	strs = str.split('/');
		// 	return strs[3]; // 返回/后第一个路径
		// }
		// 先执行一次获取当前时间
        getNowFormatDate();
		function getNowFormatDate() {
		    var time=new Date();  
          	var year=time.getFullYear();  //获取年份  
          	var month=time.getMonth()+1;  //获取月份  
          	var day=time.getDate();   //获取日期  
          	var hour=checkTime(time.getHours());   //获取时  
          	var minite=checkTime(time.getMinutes());  //获取分  
          	var second=checkTime(time.getSeconds());  //获取秒  
          	/****当时、分、秒、小于10时，则添加0****/  
          	function checkTime(i){  
          	    if(i<10) return "0"+i;  
          	    return i;  
          	} 
          	var currentdate = year + "年" + month + "月" + day
          	        + "日 " + hour + ":" + minite
          	        + ":" + second;
          	$('#nowTime').text(currentdate);
		}
		var nowTime = setInterval(function () {
			getNowFormatDate();
		},1000);

});