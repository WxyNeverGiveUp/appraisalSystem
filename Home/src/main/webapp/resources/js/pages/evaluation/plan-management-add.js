// 吴晓阳
$(document).ready(function() {
	var
		el = {
			J_type: '.type', // 考核性质
			J_quarter: '.quarter', // 季度选择
			J_month: '.month', // 月度选择
			J_quarter_option: '.quarter-option', // 季度选项
			J_month_option: '.month-option', // 季度选项
		};

		// 入口函数
		init();

		function init(){
			
			// 控制季度月度的选择
			$(el.J_type).change(function(ev) {
				var value = $(el.J_type).val();
				console.log(value);
				switch (value) {
					case "5":
						$(el.J_quarter).removeClass('none');
						$(el.J_quarter_option).addClass('require-option');
						$(el.J_month).addClass('none');
						$(el.J_month_option).removeClass('require-option');
						break;
					case "6":
						$(el.J_quarter).addClass('none');
						$(el.J_quarter_option).removeClass('require-option');
						$(el.J_month).removeClass('none');
						$(el.J_month_option).addClass('require-option');
						break;	
					default:
						$(el.J_month).addClass('none');
						$(el.J_quarter).addClass('none');
                        $(el.J_month_option).removeClass('require-option');
                        $(el.J_quarter_option).removeClass('require-option');
						break;
				}
			});
		}
});