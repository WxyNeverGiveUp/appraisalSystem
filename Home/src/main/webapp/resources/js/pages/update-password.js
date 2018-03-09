// 吴晓阳
$(document).ready(function() {
    var
        el = {
            J_tip: '.tip', //提示信息
            J_psw_tip: '.psw-tip', //密码提示信息
            J_submit: '.J-submit', // 提交按钮
            J_psw1: '.psw1', // 密码
            J_psw2: '.psw2', // 密码
        };

    // 入口函数
    init();

    function init(){
        $(el.J_psw_tip).text('');
        var
            flag4; // 验证输入是否符合的变量
        $(el.J_psw2).blur(function(ev) {
            var
                psw1 = $(el.J_psw1).val(), // 密码
                psw2 = $(el.J_psw2).val(); // 重复密码
            if (psw1 != psw2) {
                $(el.J_psw_tip).text('重复密码与密码不一致');
                flag4 = true;
            }
            else{
                $(el.J_psw_tip).text('');
                flag4 = false;
            }
        })
        // 提交题目
        $(el.J_submit).click(function(ev) {
            // 先清空提示信息
            $(el.J_tip).text('');
            // 如果数组长度不为0 不能提交
            if (flag4 || flag1) {
                $(el.J_psw_tip).text('');
                $("body").animate({scrollTop:0}, 500);
                $(el.J_tip).text('注册信息未完整填写或密码不一致');
                return false;
            }
        });

    }
});
