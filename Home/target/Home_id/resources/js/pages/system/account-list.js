// 吴晓阳
$(document).ready(function() {
	var
		el = {
			J_pass: '.pass', // 审核通过
			J_refuse: '.refuse', // 审核不通过按钮
		};

		// 入口函数
		init();

		function init(){

			// ajax修改提交
			$(el.J_pass).click(function(ev) {
				
				// 附加上点击此按钮的信息在数据库中的顺序
				var 
					path_url = _ajax.url.system.account.list.pass
					id = $(this).attr('data-num'); // 当前序列
				// 如果符合条件无法提交
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							id: id
						},
						success: function(data) {
							$('.table tr[data-id='+ id +'] > td.status').text('审核通过');
						},
						error: function(data,errorMsg) {
							console.log('error');
						}
					})
			});

			$(el.J_refuse).click(function(ev) {
				
				// 附加上点击此按钮的信息在数据库中的顺序
				var 
					path_url = _ajax.url.system.account.list.no_pass
					id = $(this).attr('data-num'); // 当前序列
				// 如果符合条件无法提交
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							id: id
						},
						success: function(data) {
							$('.table tr[data-id='+ id +'] > td.status').text('审核不通过');
						},
						error: function(data,errorMsg) {
							console.log('error');
						}
					})
				});
		}
});