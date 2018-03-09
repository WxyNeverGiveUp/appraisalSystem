// 吴晓阳
$(document).ready(function() {
	var
		el = {
			J_tip: '.tip', //提示信息
			J_change: '.change', // 修改按钮
			J_ajax_submit: '.J-ajax-submit', // ajax提交按钮
			J_score: '.score', // 打分分数
			J_result: '.result', // 工作完成情况
		};

		// 入口函数
		init();

		function init(){

			// 点击修改计划时传一个次序给修改弹出框
			$(el.J_change).click(function(ev) {
				var id = $(this).attr('data-num');
				$('#dataId').val(id);// 传值成功
			});
			// ajax修改
			$(el.J_ajax_submit).click(function(ev) {
				// 先清空提示信息
				$(el.J_tip).text('');
				// 附加上点击此按钮的信息在数据库中的顺序
				var 
					id = $('#dataId').val(),
					path_url = _ajax.url.exam.month.detail.submit,
					result = $(el.J_result).val(), // 工作完成情况
					score = $(el.J_score).val(), // 分数
					reg = /^([1-9]\d?|100)$/; // 1-100数字的正则
				// 如果符合条件无法提交
				if (!(ajax_flag1 || ajax_flag2 || ajax_flag3) && reg.test(score)) {
					$.ajax({
						url: path_url,
						type: 'post',
						dataType: 'json',
						data: {
							id: id,
							completion: result,
							testScore: score
						},
						success: function(data) {
							// console.log(data.errorMsg[0].msg);
							if (data.code) {
								// 提示信息
								alert('修改成功');
								// 隐藏填写表单
								$('button[data-dismiss="modal"]').click();
								// 修改dom 分数和结果
								$('.table tr[data-id='+ id +'] > td.score-text').text(score);
								$('.table tr[data-id='+ id +'] > td.result-text').text(result);
								// 变成已打分
								$('.change[data-num='+ id +']').text('已打分');
                                $('.change[data-num='+ id +']').attr('disabled','disabled');
                                $('.change[data-num='+ id +']').removeClass('bg-green').addClass('bg-red')
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
					$(el.J_tip).text('请输入0-100内的分数');
				}
			});
		}
});