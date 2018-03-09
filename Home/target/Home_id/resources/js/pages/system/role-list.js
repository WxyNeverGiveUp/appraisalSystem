// 吴晓阳
$(document).ready(function() {
	var
		el = {
			J_tip: '.tip', //提示信息
			J_ajax_submit: '.J-ajax-submit', // ajax提交按钮
			J_change: '.change', // 修改按钮
			J_delete: '.delete', // 删除按钮
			J_role: '.role',// 角色名称
			J_remark: '.remark', // 备注
		};

		// 入口函数
		init();

		function init(){

			// ajax修改提交
			$(el.J_ajax_submit).click(function(ev) {
				// 先清空提示信息
				$(el.J_tip).text('');
				// 附加上点击此按钮的信息在数据库中的顺序
				var 
					id = parseInt($('#dataId').val()), // 获取id
					path_url = _ajax.url.system.role.list.submit,
					name = $(el.J_role).val(), // 角色名称
					jurisdiction = $(el.J_jurisdiction).val(); // 权限
				// 如果符合条件无法提交
				if (!(ajax_flag1 || ajax_flag2 || ajax_flag3)) {
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							id: id,
							name: name,
							pid: 1,
						},
						success: function(data) {
							if (data.code) {
								// 提示信息
								alert('修改成功');
								// 隐藏填写表单
								$('button[data-dismiss="modal"]').click();
								// 修改dom
								$('.table tr[data-id='+ id +'] > td.role-text').text(name);
							}
							else{
								$(el.J_tip).text(data.errorMsg[0].msg);
							}
						},
						error: function(data,errorMsg) {
							console.log('error');
						}
					})
				}
				else{
					$("body").animate({scrollTop:0}, 500);
					$(el.J_tip).text('信息为空,无法提交');
				}
			});
			// ajax点击修改
			$(el.J_change).click(function(ev) {
				// 获取序列
				var 
					id = $(this).attr('data-num'),
					path_url = _ajax.url.system.role.list.update;
					 // 传值成功
					$('#dataId').val(id);
				$.ajax({
					url: path_url,
					type: 'post',
					dataType: 'json',
					data: {
						id: id
					},
					success: function(data) {
						// 添加默认值
						// 角色名称
						$(el.J_role).val(data.data.role.name);
						// 备注
						$(el.J_remark).val(data.data.power);
					},
					error: function(data,errorMsg) {
						console.log('error');
					}
				})
			});
			// ajax删除
			$(el.J_delete).click(function(ev) {
				// 获取序列
				var 
					id = $(this).attr('data-num'),
					path_url = _ajax.url.system.role.list.del;
				// 删除确认
				if (confirm("确认要删除？")) {
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							id: id
						},
						success: function(data) {
							$('.table tr[data-id='+ id +']').remove();
							// 修改数据数量信息
							// 暂定
						},
						error: function(data,errorMsg) {
							console.log(errorMsg);
						}
					})
				}
			});
		}
});