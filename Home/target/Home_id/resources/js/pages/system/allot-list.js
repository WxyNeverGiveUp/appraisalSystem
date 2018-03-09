// 吴晓阳
$(document).ready(function() {
	var
		el = {
			J_tip: '.tip', //提示信息
			J_change: '.change', // 修改按钮
			J_delete: '.delete', // 删除按钮
			J_ajax_submit: '.J-ajax-submit', // ajax提交按钮
			J_department: '.department', // 管辖部门名称
		};

		// 入口函数
		init();

		function init(){

			// ajax点击修改
			$(el.J_change).click(function(ev) {
				var path_url = _ajax.url.system.allot.list.update,
					department = $(el.J_department).val(), // 管辖部门名称
					// 附加上点击此按钮的信息在数据库中的顺序
					id = $(this).attr('data-num');
					$('#dataId').val(id);// 传值成功
				// 如果符合条件无法提交
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							id: id,
						},
						success: function(data) {
							// 把符合条件的选上!
							var options = data.data.did;
							// select2初始化默认赋多值
							$('.department').select2().val(options).trigger('change');
						},
						error: function(data,errorMsg) {
							console.log('error');
						}
					})
			});
			// ajax修改提交
			$(el.J_ajax_submit).click(function(ev) {
				// 先清空提示信息
				$(el.J_tip).text('');
				var 
					id = $('#dataId').val(), // 附加上点击此按钮的信息在数据库中的顺序
					path_url = _ajax.url.system.allot.list.submit,
					department = $(el.J_department).val(), // 管辖部门名称
					department_text = $(el.J_department).find('option:selected').text(); // 管辖部门名称
				// 如果符合条件无法提交
				if (!(ajax_flag1 || ajax_flag2 || ajax_flag3)) {
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							id: id,
							did: department
						},
						success: function(data) {
							if (data.code) {
								// 提示信息
								alert('修改成功');
								// 隐藏填写表单
								$('button[data-dismiss="modal"]').click();
								// 修改dom
								var id = $('#dataId').val(); // 获取到当前次序
								$('.table tr[data-id='+ id +'] > td.department-text').text(department_text);
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
			// ajax删除
			$(el.J_delete).click(function(ev) {
				// 获取序列
				var 
					id = $(this).attr('data-num'),
					path_url = _ajax.url.system.allot.list.del;
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
						},
						error: function(data,errorMsg) {
							console.log('error');
						}
					})
				}
			});
		}
});