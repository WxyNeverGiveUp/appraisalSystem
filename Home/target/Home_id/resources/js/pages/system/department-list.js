// 吴晓阳
$(document).ready(function() {
	var
		el = {
			J_tip: '.tip', //提示信息
			J_change: '.change', // 修改按钮
			J_delete: '.delete', // 删除按钮
			J_ajax_submit: '.J-ajax-submit', // ajax提交按钮
			J_department: '.department', // 部门名称
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
					id = $('#dataId').val(), // 获取到当前次序
					path_url = _ajax.url.system.department.list.submit,
					department = $(el.J_department).val(); // 部门名称
				// 如果符合条件无法提交
				if (!(ajax_flag1 || ajax_flag2 || ajax_flag3)) {
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							id: id,
							name: department
						},
						success: function(data) {
							// console.log(data.errorMsg[0].msg);
							if (data.code) {
								// 提示信息
								alert('修改成功');
								// 隐藏填写表单
								$('button[data-dismiss="modal"]').click();
								// 修改dom
								$('.table tr[data-id='+ id +'] > td.department-text').text(department);
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
			// ajax修改
			$(el.J_change).click(function(ev) {
				// 点击修改计划时传一个次序给修改弹出框
				var id = $(this).attr('data-num'),
					path_url = _ajax.url.system.department.list.update;
					 // 传值成功
					 $('#dataId').val(id);
				$.ajax({
					url: path_url,
					type: 'get',
					dataType: 'json',
					data: {
						id: id
					},
					success: function(data) {
						// 添加默认值
						// 部门名称
						$(el.J_department).val(data.data.department.name);
					},
					error: function(data,errorMsg) {
						console.log('error');
					}
				})
			})
			// ajax删除
			$(el.J_delete).click(function(ev) {
				// 获取序列
				var 
					id = $(this).attr('data-num'),
					path_url = _ajax.url.system.department.list.del;
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
							console.log('error');
						}
					})
				}
			});
		}
});