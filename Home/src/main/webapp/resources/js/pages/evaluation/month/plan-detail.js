// 吴晓阳
$(document).ready(function() {
	var
		el = {
			J_tip: '.tip', //提示信息
			J_change: '.change', // 修改按钮
			J_refer: '.refer', // 工作完成情况按钮
			J_delete: '.delete', // 删除按钮
			J_ajax_submit: '.J-ajax-submit', // ajax提交按钮
			J_ajax_submit2: '.J-ajax-submit2', // 工作完成情况提交
			J_time: '#reservation', // 时间
			J_weight: '.weight', // 权重
			J_content: '#editor1', // 工作内容
			J_expect_result: '.expect-result', // 预期成果
			J_performance_result: '.performance-result', // 工作完成情况
			J_weight_error: '.weight-error', // 权重错误提示信息
		};

		// 入口函数
		init();

		function init(){
			// 判断权重
			function testWeight() {
				// 判断权重
				var testArr = new Array, // 这个数组代表为填写的题都是哪些
					total = 0; // 总分默认为0
				// 遍历一个一个的题目
				$('.weight-text').each(function(index, o) {
					// 算总权重
					total += parseInt($(o).text());	
				});
				// 选择显示错误信息
				if (total > 100) {
					$(el.J_weight_error).removeClass('none');
				}
				else{
					$(el.J_weight_error).addClass('none');
				}
			}
			testWeight();

			// 点击修改计划时传一个次序给修改弹出框
			$(el.J_change).click(function(ev) {
				// 先清空提示信息
				$(el.J_tip).text('');
				var 
					id = $(this).attr('data-num'),
					path_url = _ajax.url.evaluation.month.plan_list.update;
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
							// console.log(data.errorMsg[0].msg);
							if (data.code) {
								// 修改dom
								// 时间
								$(el.J_time).val(data.data.workDetail.endTime);
								// 工作计划内容赋值 特定的
								CKEDITOR.instances.editor1.setData(data.data.workDetail.planContent)
								// 权重
								$(el.J_weight).val(data.data.workDetail.weight);
								// 先前权重判断用
								$('.already-weight').val(data.data.workDetail.weight);
								// 预期工作成果
								$(el.J_expect_result).val(data.data.workDetail.expectResult);

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
			// ajax修改
			$(el.J_ajax_submit).click(function(ev) {
				// 先清空提示信息
				$(el.J_tip).text('');
				var 
					id = $('#dataId').val(), // 获取顺序
					path_url = _ajax.url.evaluation.month.plan_list.submit,
					time = $(el.J_time).val(), // 时间
					content = CKEDITOR.instances.editor1.document.getBody().getText(), // 工作内容取值（纯文本）
					result = $(el.J_expect_result).val(), // 预期成果
					weight = parseInt($(el.J_weight).val()), // 权重
					already_weight = parseInt($('.already-weight').val()), // 判断用权重
					reg = /^([1-9]\d?|100)$/; // 1-100数字的正则
                // 判断权重
                var
                    total = 0; // 总分默认为0
                // 遍历一个一个的题目
                $('.weight-text').each(function(index, o) {
                    // 算总分
                    total += parseInt($(o).text());
                });
				// 如果符合条件无法提交
				if (!(ajax_flag1 || ajax_flag2 || ajax_flag3) && reg.test(weight) && (total - already_weight + weight) <= 100) {
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							id: id,
							startTime: time,
							weight: weight,
							planContent: content,
							excpetResult: result,
						},
						success: function(data) {
							// console.log(data.errorMsg[0].msg);
							if (data.code) {
								// 提示信息
								alert('修改成功');
								// 隐藏填写表单
								$('button[data-dismiss="modal"]').click();
								// 修改dom
								// 工作内容
								$('.table tr[data-id='+ id +'] > td.content-text').text(content);
								// 考核时间
								$('.table tr[data-id='+ id +'] > td.time-text').text(time);
								// 权重
								$('.table tr[data-id='+ id +'] > td.weight-text').text(weight + "%");
								// 预期成果
								$('.table tr[data-id='+ id +'] > td.result-text').text(result);
								// 验证权重
								testWeight();
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
					alert('信息为空或权重不在1~100或总权重大于100,无法提交')
					$(el.J_tip).text('信息为空或权重不在1~100,无法提交');
				}
			});
			// ajax删除
			$(el.J_delete).click(function(ev) {
				// 获取序列
				var 
					id = $(this).attr('data-num'),
					path_url = _ajax.url.evaluation.month.plan_list.del;
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

			// 点击完成按钮
			$(el.J_refer).click(function(ev) {
				// 先清空提示信息
				var 
					id = $(this).attr('data-num'),
					text = $('.table tr[data-id='+ id +'] > td.performance-text').text();
				// 赋默认值
				$('#dataId2').val(id);
				$(el.J_performance_result).val(text);
			});
			// ajax提交工作完成结果
			$(el.J_ajax_submit2).click(function(ev) {
				var 
					id = $('#dataId2').val(), // 获取顺序 这一条工作计划的id
					path_url = _ajax.url.evaluation.month.plan_list.submit2,
					tid = $('.tid').val(), // 考核计划的id
					performance = $(el.J_performance_result).val(); // 获取工作完成结果
				// 如果符合条件无法提交
					$.ajax({
						url: path_url,
						type: 'post',
						dataType: 'json',
						data: {
							id: id,
							tid: tid,
							workCompletion: performance,
						},
						success: function(data) {
							// console.log(data.errorMsg[0].msg);
							if (data.code) {
								// 提示信息
								alert('修改成功');
								// 隐藏填写表单
								$('button[data-dismiss="modal"]').click();
								// 修改dom
								// 工作完成情况
								$('.table tr[data-id='+ id +'] > td.performance-text').text(performance);
							}
						},
						error: function(data,errorMsg) {
							console.log('error');
						}
					})
			});
		}
});