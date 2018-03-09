// 吴晓阳
$(document).ready(function() {
	var
		el = {
			J_year: '.year',// 考核方式复选框
			J_nature: '.nature',// 考核性质下拉框
			J_name: '.name',// 计划名称
			J_time_start: '.daterangepicker_start', // 开始时间
			J_time_end: '.daterangepicker_end', // 结束时间
			J_time: '#reservation', // 时间范围
			J_tip: '.tip', //提示信息
			J_ajax_submit: '.J-ajax-submit', // ajax提交按钮
			J_change: '.change', // 修改按钮
			J_delete: '.delete', // 删除按钮
			J_status: '.status', // 状态按钮
		};

		// 入口函数
		init();

		function init(){
			
			// ajax点击修改
			$(el.J_change).click(function(ev) {
				// 附加上点击此按钮的信息在数据库中的顺序
				var 
					id = $(this).attr('data-num'),
					path_url = _ajax.url.evaluation.plan_management.list.update; // 后台方法地址
					$('#dataId').val(id);// 传值成功
					// 如果符合条件无法提交
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							id: id
						},
						success: function(data) {
							if (data.code) {
								// 修改dom
								// 计划名称
								$(el.J_name).val(data.data.testPlan.testName);
								// 所属年份
								$(el.J_year).val(data.data.testPlan.year);
								// 考核性质
								$(el.J_nature).children('option[value='+ data.data.testPlan.testTypeId +']').prop('selected',true);
								// 时间
								$('#reservation').val(data.data.testPlan.finishTime);
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
			// ajax修改提交
			$(el.J_ajax_submit).click(function(ev) {
				// 先清空提示信息
				$(el.J_tip).text('');
				// 附加上点击此按钮的信息在数据库中的顺序
				var 
					id = $('#dataId').val(),
					path_url = _ajax.url.evaluation.plan_management.list.submit, // 后台方法地址
					name = $(el.J_name).val(), // 计划名称
					year = $(el.J_year).val(),
					nature = $(el.J_nature).val(), // 考核性质选项值
					nature_text = $(el.J_nature).find('option:selected').text(), // 考核性质的文本值
					time = $(el.J_time).val(), // 时间范围
					time_start = $(el.J_time_start).val(), // 开始时间
					time_end = $(el.J_time_end).val(); // 结束时间

				// 如果符合条件无法提交
				if (!(ajax_flag1 || ajax_flag2 || ajax_flag3)) {
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							testId: id,
							testName: name,
							testTypeId: nature,
							startTime: time,
							year: year,
						},
						success: function(data) {
							// console.log(data.errorMsg[0].msg);
							if (data.code) {
								// 提示信息
								alert('修改成功');
								// 隐藏填写表单
								$('button[data-dismiss="modal"]').click();
								// 修改dom
								$('.table tr[data-id='+ id +'] > td.name-text').text(name);
								$('.table tr[data-id='+ id +'] > td.nature-text').text(nature_text);
								$('.table tr[data-id='+ id +'] > td.time-start-text').text(time);
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
					path_url = _ajax.url.evaluation.plan_management.list.del;
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
							$('button[data-num='+ id +']').parents('tr').remove();
							// 暂定
						},
						error: function(data,errorMsg) {
							console.log('error');
						}
					})
				}
			});
			// ajax修改状态
			$(el.J_status).click(function(ev) {
				// 获取序列
				var 
					id = $(this).attr('data-num'),
					path_url = _ajax.url.evaluation.plan_management.list.edit,
					status = {
					    2:"考核开启",
						1: "填写开启",
						0: "未开启"
					}
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							id: id
						},
						success: function(data) {
								$('.table tr[data-id='+ id +'] .status-text').text(status[data.data.status]);
							// 修改数据数量信息
						},
						error: function(data,errorMsg) {
							console.log('error');
						}
					})	
			});
		}
});