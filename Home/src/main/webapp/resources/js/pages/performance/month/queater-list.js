// 吴晓阳
$(document).ready(function() {
	var
		el = {
			J_tip: '.tip', //提示信息
			J_export: '.export', // 确定导出按钮
			J_exportAll: '.export-all', // 全部导出按钮
		};

		// 入口函数
		init();

		function init(){
			// 获取所有参数
			// ajax修改
			var arr = new Array; // 定义一个数组存放所有号
			$(el.J_exportAll).click(function(ev) {
				// 先清空提示信息
				$(el.J_tip).text('');
				// 附加上点击此按钮的信息在数据库中的顺序
				var 
					path_url = _ajax.url.exam.year.summary.submit;

					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							beCheckId: id,
							year: year,
							summaryScore: score
						},
						success: function(data) {
							if (data.code) {
								// 提示信息
								arr.push();
							}
							else{
								$(el.J_tip).text(data.errorMsg[0].msg);
							}
						},
						error: function(data,errorMsg) {
							console.log('error');
						}
					})
			});
			
		}
});