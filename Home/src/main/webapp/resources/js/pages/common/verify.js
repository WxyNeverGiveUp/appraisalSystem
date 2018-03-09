/*未入驻单位的js
吴晓阳*/
// 因为跨页面所以需要全局定义
var 
	ajax_arr1 = new Array, // 文本框ajax提交时判断是否可以提交的数组
	ajax_arr2 = new Array, // 下拉框ajax提交时判断是否可以提交的数组
	ajax_arr3 = new Array, // 多选下拉框ajax提交时判断是否可以提交的数组
	ajax_flag1,
	ajax_flag2,
	ajax_flag3,
	flag1,
	flag2,
	flag3;
// 入口函数
$(document).ready(function() {
	// 变量声明
	// 对象盒子
	var 
		el = {
			J_ajax_submit: '.J-ajax-submit', // ajax提交按钮
			J_submit: '.J-submit', // 表单提交按钮
			J_require_text: '.require-text', // 必填文本框
			J_require_option: '.require-option', // 必选下拉框
			J_require_options: '.require-options', // 必填多选下拉框
			J_a_require_text: '.a-require-text', // ajax必填文本框
			J_a_require_option: '.a-require-option', // ajax必选下拉框
			J_a_require_options: '.a-require-options', // ajax必填多选下拉框
		};
	// 消息盒子 暂时没什么用
	var 
		tip = {
			J_search_tip: '请输入18位的同意社会信用代码'
		}
	// 加载函数
	_verify();

	// 验证函数 (私有函数_)
	function _verify() {
		var 
			arr1 = new Array, // 必填文本框的数组
			arr2 = new Array, // 必填下拉框的数组
			arr3 = new Array; // 必填多选下拉框的数组
		
		// 普通提交
		$(el.J_submit).click(function(event) {
			// 必填文本框
			$(el.J_require_text).each(function() {
				var textVal = $(this).val();
				if (textVal == "") {
					$(this).parent().addClass('has-error');
					arr1.push(textVal); // 为空则存入数组中
				}
				else{
					$(this).parent().removeClass('has-error');
				}
				// 判断flag
				if (arr1.length) {
					flag1 = true;
				}
				else{
					flag1= false;
				}
			});
			$(el.J_require_text).change(function() {
				var textVal = $(this).val();
				if (textVal == "") {
					$(this).parent().addClass('has-error');
				} else{
					arr1.pop(); // 清除存入数组中的text为空的个数
					$(this).parent().removeClass('has-error');
				}
			});
			// 必填下拉框
			$(el.J_require_option).each(function() {
				var optionVal = $(this).val();
				if (optionVal == -1) {
					$(this).parent().addClass('has-error');
					arr2.push(optionVal); // 为空则存入数组中
				} 
				else{
					$(this).parent().removeClass('has-error');
				}
				// 判断flag
				if (arr2.length) {
					flag2 = true;
				}
				else{
					flag2= false;
				}
			});
			$(el.J_require_option).change(function() {
				var optionVal = $(this).children('option:selected').val();
				if (optionVal == -1) {
					$(this).parent().addClass('has-error');
					// console.log('error:下拉框未填写') // 调试提醒
				} else{
					arr2.pop(); // 清除存入数组中的text为空的个数
					$(this).parent().removeClass('has-error');
				}
			});
			// 多选下拉框
			$(el.J_require_options).each(function() {
				var optionsVal = $(this).next().find('.select2-selection__choice').length;
				if (optionsVal == 0) {
					$(this).parent().addClass('has-error');
					$(this).next().find('.select2-selection').css('border', '1px solid #dd4b39');
					arr3.push(optionsVal); // 为空则存入数组中
				} 
				else{
					$(this).parent().removeClass('has-error');
					$(this).next().find('.select2-selection').css('border','1px solid #ccc');
				}
				// 判断flag
				if (arr3.length) {
					flag3 = true;
				}
				else{
					flag3 = false;
				}
			});
			$(el.J_require_options).change(function() {
				var optionsVal = $(this).next().find('.select2-selection__choice').length;
				if (optionsVal == 0) {
					$(this).parent().addClass('has-error');
					$(this).next().find('.select2-selection').css('border', '1px solid #dd4b39');
				} else{
					arr3.pop(); // 清除存入数组中的text为空的个数
					$(this).parent().removeClass('has-error');
					$(this).next().find('.select2-selection').css('border','1px solid #ccc');
				}
			});
			// 阻止表单提交
			if (flag1 || flag2 || flag3) {
				// 如果有提示,则显示提示
				if ($(this).prev().length) {
					$(this).prev().removeClass('none');
					$("body").animate({scrollTop:0}, 500);
					return false;
				}
				// 如果没有提示,则显不示提示
				else{
					$("body").animate({scrollTop:0}, 500);
					return false;
				}
			}
		});
		// ajax提交
		$(el.J_ajax_submit).click(function(event) {
			// 必填文本框
			$(el.J_a_require_text).each(function() {
				var textVal = $(this).val();
				if (textVal == "") {
					$(this).parent().addClass('has-error');
					ajax_arr1.push(textVal); // 为空则存入数组中
				}
				else{
					$(this).parent().removeClass('has-error');
				}
				// 判断flag
				if (ajax_arr1.length) {
					ajax_flag1 = true;
				}
				else{
					ajax_flag1= false;
				}
			});
			$(el.J_a_require_text).change(function() {
				var textVal = $(this).val();
				if (textVal == "") {
					$(this).parent().addClass('has-error');
				} else{
					ajax_arr1.pop(); // 清除存入数组中的text为空的个数
					$(this).parent().removeClass('has-error');
				}
			});
			// 必填下拉框
			$(el.J_a_require_option).each(function() {
				var optionVal = $(this).val();
				if (optionVal == -1) {
					$(this).parent().addClass('has-error');
					ajax_arr2.push(optionVal); // 为空则存入数组中
				} 
				else{
					$(this).parent().removeClass('has-error');
				}
				// 判断flag
				if (ajax_arr2.length) {
					ajax_flag2 = true;
				}
				else{
					ajax_flag2= false;
				}
			});
			$(el.J_a_require_option).change(function() {
				var optionVal = $(this).children('option:selected').val();
				if (optionVal == -1) {
					$(this).parent().addClass('has-error');
					// console.log('error:下拉框未填写') // 调试提醒
				} else{
					ajax_arr2.pop(); // 清除存入数组中的text为空的个数
					$(this).parent().removeClass('has-error');
				}
			});
			// 多选下拉框
			$(el.J_a_require_options).each(function() {
				var optionsVal = $(this).next().find('.select2-selection__choice').length;
				if (optionsVal == 0) {
					$(this).parent().addClass('has-error');
					$(this).next().find('.select2-selection').css('border', '1px solid #dd4b39');
					ajax_arr3.push(optionsVal); // 为空则存入数组中
				} 
				else{
					$(this).parent().removeClass('has-error');
					$(this).next().find('.select2-selection').css('border','1px solid #ccc');
				}
				// 判断flag
				if (ajax_arr3.length) {
					ajax_flag3 = true;
				}
				else{
					ajax_flag3 = false;
				}
			});
			$(el.J_a_require_options).change(function() {
				var optionsVal = $(this).next().find('.select2-selection__choice').length;
				if (optionsVal == 0) {
					$(this).parent().addClass('has-error');
					$(this).next().find('.select2-selection').css('border', '1px solid #dd4b39');
				} else{
					ajax_arr3.pop(); // 清除存入数组中的text为空的个数
					$(this).parent().removeClass('has-error');
					$(this).next().find('.select2-selection').css('border','1px solid #ccc');
				}
			});
		});
		/*// 企业注册认证信息正则验证
		// 固定电话
		$(el.J_telephone).blur(function() {
			var reg = /^\d{3}-\d{8}|\d{4}-\d{7}$/;
			if (!(reg.test($(el.J_telephone).val())) && ($(el.J_telephone).val().length!=0)){
				$(el.J_telephone).css('border','1px solid #F61E1E');
				$(el.J_telephone).next().removeClass('none');
			}else{
				$(el.J_telephone).css('border','1px solid #ccc');
				$(el.J_telephone).next().addClass('none');
			}
		});

		// 招聘邮箱
		$(el.J_work_email).blur(function() {
			var reg = /^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/;
			if (!(reg.test($(el.J_work_email).val())) && ($(el.J_work_email).val().length!=0)){
				$(el.J_work_email).css('border','1px solid #F61E1E');
				$(el.J_work_email).next().removeClass('none');
			}else{
				$(el.J_work_email).css('border','1px solid #ccc');
				$(el.J_work_email).next().addClass('none');
			}
		});
		// 邮编
		$(el.J_postcode).blur(function() {
			var reg = /^[0-9]\d{5}$/;
			if (!(reg.test($(el.J_postcode).val())) && ($(el.J_postcode).val().length!=0)){
				$(el.J_postcode).css('border','1px solid #F61E1E');
				$(el.J_postcode).next().removeClass('none');
			}else{
				$(el.J_postcode).css('border','1px solid #ccc');
				$(el.J_postcode).next().addClass('none');
			}
		});

		// 基本人联系信息正则验证
		// 姓名
		$(el.J_name).blur(function() {
			var reg = /^([\u4e00-\u9fa5]){2,7}$/;
			if (!(reg.test($(el.J_name).val())) && ($(el.J_name).val().length!=0)){
				$(el.J_name).css('border','1px solid #F61E1E');
				$(el.J_name).next().removeClass('none');
			}else{
				$(el.J_name).css('border','1px solid #ccc');
				$(el.J_name).next().addClass('none');
			}
		});

		// 手机号
		$(el.J_phone).blur(function() {
			var reg = /^1[3|4|5|7|8][0-9]{9}$/;
			if(!(reg.test($(el.J_phone).val())) && ($(el.J_phone).val().length!=0)){
				$(el.J_phone).css('border','1px solid #F61E1E');
				$(el.J_phone).parent().next().removeClass('none');
			}else{
				$(el.J_phone).css('border','1px solid #ccc');
				$(el.J_phone).parent().next().addClass('none');
				// 增加是否存在重复号码
				var phone = $(el.J_phone).val();
				$.ajax({
					url: 'http://www.dsjyw.net/recruitEntrance/recruitEntrance/PhoneJson',
					type: 'get',
					dataType: 'json',
					data: {
						phone: phone,
					},
					success: function(data){
						console.log(data.code);
						var code = data.code;
						if (code) {
							$(el.J_phone).parent().next().next().addClass('none');
						}
						else{
							$(el.J_phone).parent().next().next().removeClass('none');
						}
					},
					error: function(data,errorMsg) {
						console.log('error:异常,JSON数据出错');
					}
				})
			}
		});

		// 登录密码
		$(el.J_psw).blur(function() {
			var reg = /^[a-zA-Z0-9]{6,16}$/;
			if(!(reg.test($(el.J_psw).val())) && ($(el.J_psw).val().length != 0)){
				$(el.J_psw).css('border','1px solid #F61E1E');
				$(el.J_psw).next().removeClass('none');
			}else{
				$(el.J_psw).css('border','1px solid #ccc');
				$(el.J_psw).next().addClass('none');
			}
		});

		// 重复密码
		$(el.J_psw2).blur(function() {
			if(!($(el.J_psw2).val() == $(el.J_psw).val()) && ($(el.J_psw2).val().length != 0)){
				$(el.J_psw2).css('border','1px solid #F61E1E');
				$(el.J_psw2).next().removeClass('none');
			}else{
				$(el.J_psw2).css('border','1px solid #ccc');
				$(el.J_psw2).next().addClass('none');
			}
		});

		// 邮箱验证
		$(el.J_email).blur(function() {
			var reg = /^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/;
			if(!(reg.test($(el.J_email).val())) && ($(el.J_email).val().length != 0)){
				$(el.J_email).css('border','1px solid #F61E1E');
				$(el.J_email).next().removeClass('none');
			}else{
				$(el.J_email).css('border','1px solid #ccc');
				$(el.J_email).next().addClass('none');
			}
		});*/


	};
	
});
