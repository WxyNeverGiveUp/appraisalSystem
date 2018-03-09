// 吴晓阳
$(document).ready(function() {
	var
		el = {
			J_tip: '.tip', //提示信息
			J_change: '.change', // 修改按钮
			J_delete: '.delete', // 删除按钮
			J_init: '.init', // 初始化密码
			J_ajax_submit: '.J-ajax-submit', // ajax提交按钮
			J_username: '.username', // 用户名
			J_realname: '.realname', // 真实姓名
			J_department: '.department', // 所属部门名称
			J_position: '.position', // 职位
			J_phone: '.phone', //手机号
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
					path_url = _ajax.url.system.personnel.list.submit,
					department = $(el.J_department).val(), // 所属部门名称
					department_text = $(el.J_department).find('option:selected').text(), // 所属部门名称的值
					position = $(el.J_position).val(), // 职位名称
					position_text = $(el.J_position).find('option:selected').text(), 
					username = $(el.J_username).val(),// 用户名
					realname = $(el.J_realname).val(),// 真实名
					phone = $(el.J_phone).val(); // 手机号

				// 如果符合条件无法提交
				if (!(ajax_flag1 || ajax_flag2 || ajax_flag3)) {
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							id: id,
							username: username,
							realName: realname,
							did: department,
							rid: position,
							phone: phone,
						},
						success: function(data) {
							if (data.code) {
								// 提示信息
								alert('修改成功');
								// 隐藏填写表单
								$('button[data-dismiss="modal"]').click();
								// 修改dom
								$('.table tr[data-id='+ id +'] > td.username-text').text(username);
								$('.table tr[data-id='+ id +'] > td.realname-text').text(realname);
								$('.table tr[data-id='+ id +'] > td.department-text').text(department_text);
								$('.table tr[data-id='+ id +'] > td.position-text').text(position_text);
								$('.table tr[data-id='+ id +'] > td.phone-text').text(phone);
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
					path_url = _ajax.url.system.personnel.list.update;
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
						// 用户名称
						$(el.J_username).val(data.data.user.username);
						// 真实姓名
						$(el.J_realname).val(data.data.user.realName);
						// 所属部门 暂无
						$(el.J_department).find('option[value='+data.data.user.did+']').prop('selected',true);
						// 职位
						$(el.J_position).find('option[value='+data.data.user.rid+']').prop('selected',true);
						// 手机号
						$(el.J_phone).val(data.data.user.phone);
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
					path_url = _ajax.url.system.personnel.list.del;
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
            // ajax初始化
            $(el.J_init).click(function(ev) {
                // 获取序列
                var
                    id = $(this).attr('data-num'),
                    path_url = _ajax.url.system.personnel.list.init;
                // 取人初始化
                if (confirm("确认要初始化密码吗？")) {
                    $.ajax({
                        url: path_url,
                        type: 'get',
                        dataType: 'json',
                        data: {
                            id: id
                        },
                        success: function(data) {
                            alert('初始化成功，初始化密码为：123456。请及时时间修改！');
                        },
                        error: function(data,errorMsg) {
                            console.log('error');
                        }
                    })
                }
            });
		}
});