// 吴晓阳
$(document).ready(function() {
	var
		el = {
			J_tip: '.tip', //提示信息
			J_weight: '.weight', // 权重验证
			J_submit: '.J-submit', // ajax提交按钮
		};

		// 入口函数
		init();

		function init(){

			// 普通修改
			$(el.J_submit).click(function(ev) {
				// 先清空提示信息
				$(el.J_tip).text('');
				var 
					weight = parseInt($(el.J_weight).val()), // 权重
					reg = /^([1-9]\d?|100)$/, // 1-100数字的正则
                    already_weight = parseInt($('.already-weight').val()), // 先前的权重
					weight_sum = weight + already_weight; // 总权重

                // 如果符合条件无法提交
				if (!(flag1 || flag2 || flag3) && reg.test(weight) && !(weight_sum>100)) {
					return true;
				}
				else{
                    console.log(already_weight);
                    console.log(weight_sum);
					$("body").animate({scrollTop:0}, 500);
					alert('信息为空或权重不在1~100或总权重大于100,无法提交'); // 弹窗提醒
					$(el.J_tip).text('信息为空或权重不在1~100或总权重大于100,无法提交');
					return false;
				}
			});
		}
});