// 吴晓阳
$(document).ready(function() {
    var
        el = {
            J_tip: '.tip', //提示信息
            J_submit: '.J-submit', // 新增ajax提交按钮
            J_ajax_submit2: '.J-ajax-submit2', // 修改ajax提交按钮
            J_change: '.change', // 修改按钮
            J_add: '.add', // 新增按钮
            J_delete: '.delete', // 删除按钮
            J_role: '.role',// 角色名称
            J_jurisdiction: '.jurisdiction', // 所选权限
            J_weight_error: '.weight-error', // 权重错误提示信息
        };

    // 入口函数
    init();

    function init(){
        // 验证权重
        function testWeight() {
            // 判断权重
            var testArr = new Array, // 这个数组代表为填写的题都是哪些
                total = 0; // 总分默认为0
            // 遍历一个一个的题目
            $('.timeline-item').each(function(index, o) {
                var length = $(o).find('.timeline-body > .form-group input[type="radio"]:checked').length;
                // 算总分
                total += parseInt($(o).find('.weight').text());
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
        // ajax新增
        $(el.J_add).click(function(ev) {
            $('#add-list input[type="text"]').addClass('a-require-text');
            $('#add-list select').addClass('a-require-option');
            $('#update-list input[type="text"]').removeClass('a-require-text');
            $('#update-list select').removeClass('a-require-option');
            // 清空提示信息
            $(el.J_tip).text('');
        });

        // 点击修改
        $(el.J_change).click(function(ev) {
            $('#add-list input[type="text"]').removeClass('a-require-text');
            $('#add-list select').removeClass('a-require-option');
            $('#update-list input[type="text"]').addClass('a-require-text');
            $('#update-list select').addClass('a-require-option');
            // 清空提示信息
            $(el.J_tip).text('');
            // 获取序列
            var
                id = $(this).attr('data-num'),
                path_url = _ajax.url.evaluation.year.ability_list.update;
            // 传值成功
            $('#dataId').val(id);
            $.ajax({
                url: path_url,
                type: 'get',
                dataType: 'json',
                data: {
                    positionId: id
                },
                success: function(data) {
                    // 添加默认值
                    $('.already-weight').val(data.data.abilityPosition.weight); // 之后判断用的 先前的权重
                    // 权重名称
                    $('.update-weight').val(data.data.abilityPosition.weight);
                    // 问题类型
                    $('.update-type').val(data.data.abilityPosition.targetTypeId);
                    // 问题
                    $('.update-title').val(data.data.abilityPosition.targetId);
                    // 选项
                    $('.update-content1').val(data.data.option1.optionContent);
                    $('.update-content2').val(data.data.option2.optionContent);
                    $('.update-content3').val(data.data.option3.optionContent);
                    $('.update-content4').val(data.data.option4.optionContent);


                },
                error: function(data,errorMsg) {
                    console.log('error');
                }
            })
        });

        // ajax修改提交
        $(el.J_ajax_submit2).click(function(ev) {
            // 附加上点击此按钮的信息在数据库中的顺序
            var
                path_url = _ajax.url.evaluation.year.ability_list.submit,
                id = $('#dataId').val(), // 当前问题序号
                title = $('.update-title').val(), // 新增题目
                option1 = $('.update-content1').val(), // 选项1
                option2 = $('.update-content2').val(), // 选项2
                option3 = $('.update-content3').val(), // 选项3
                option4 = $('.update-content4').val(), // 选项4
                weight = parseInt($('.update-weight').val()), // 权重
                already_weight = parseInt($('.already-weight').val()), // 比较用的先前的权重
                type = $('.update-type').val(), // 类型的value
                reg = /^([1-9]\d?|100)$/; // 1-100数字的正则
            // 判断权重
            var
                total = 0; // 总分默认为0
            // 遍历一个一个的题目
            $('.timeline-item').each(function(index, o) {
                // 算总分
                total += parseInt($(o).find('.weight').text());
            });
            // 如果符合条件无法提交
            if (!(ajax_flag1 || ajax_flag2 || ajax_flag3) && reg.test(weight) && (total - already_weight + weight) <= 100) {
                $.ajax({
                    url: path_url,
                    type: 'get',
                    dataType: 'json',
                    data: {
                        positionId: id,
                        targetType: type,
                        weight: weight,
                        target: title,
                        optionName1: 1,
                        optionName2: 2,
                        optionName3: 3,
                        optionName4: 4,
                        content1: option1,
                        content2: option2,
                        content3: option3,
                        content4: option4,
                    },
                    success: function(data) {
                        if (data.code) {
                            // 提示信息
                            alert('修改成功');
                            // 隐藏填写表单
                            $('button[data-dismiss="modal"]').click();
                            // 修改dom
                            // 问题类型
                            $('.timeline li[data-id='+id+'] .type').text(type);
                            // 权重
                            $('.timeline li[data-id='+id+'] .weight').text(weight);
                            // 问题
                            $('.timeline li[data-id='+id+'] .title').text(title);
                            // 选项
                            $('.timeline li[data-id='+id+'] .option1').text(option1);
                            $('.timeline li[data-id='+id+'] .option2').text(option2);
                            $('.timeline li[data-id='+id+'] .option3').text(option3);
                            $('.timeline li[data-id='+id+'] .option4').text(option4);
                        }
                    },
                    error: function(data,errorMsg) {
                        console.log('error');
                    }
                })
            }
            else{
                $("body").animate({scrollTop:0}, 500);
                alert('信息不全或问题总比重大于100%,无法提交')
                $(el.J_tip).text('信息不全或问题总比重大于100%,无法提交');
            }
        });

        // ajax删除
        $(el.J_delete).click(function(ev) {
            // 获取序列
            var
                that = $(this),
                id = $(this).attr('data-num'),
                path_url = _ajax.url.evaluation.year.ability_list.delete;
            // 删除确认
            if (confirm("确认要删除？")) {
                $.ajax({
                    url: path_url,
                    type: 'get',
                    dataType: 'json',
                    data: {
                        positionId: id
                    },
                    success: function(data) {
                        that.parents('li').remove();
                    },
                    error: function(data,errorMsg) {
                        console.log(errorMsg);
                    }
                })
            }
        });

        // 提交题目权重判断
        $(el.J_submit).click(function(ev) {
            // 判断权重
            var add_weight = parseInt($('.add-weight').val()), // 添加的题的权重
                total = 0; // 总分默认为0
            // 遍历一个一个的题目
            $('.timeline-item').each(function(index, o) {
                var length = $(o).find('.timeline-body > .form-group input[type="radio"]:checked').length;
                // 算总分
                total += parseInt($(o).find('.weight').text());
            });
            // 选择显示错误信息
            if ((total + add_weight) > 100) {
                $(el.J_weight_error).removeClass('none');
                alert('总权重大于100,无法提交');
                return false;
            }
            else{
                $(el.J_weight_error).addClass('none');
            }
        });
    }
});
