// 吴晓阳
$(document).ready(function() {
    var
        el = {
            J_year: '.year',// 选择年份的下拉框
        };

    // 入口函数
    init();

    function init(){


        // 点击修改
        $(el.J_year).change(function(ev) {
            var
                year = $(el.J_year).find('option:selected').val();
                path_url = _ajax.url.evaluation.year.summary.verify;
            $.ajax({
                url: path_url,
                type: 'post',
                dataType: 'json',
                data: {
                    year: year,
                },
                success: function(data) {
                    if(data.code == 0){ // 0表示已经有不可以添加
                        $('.J-submit').addClass('none'); // 隐藏提交按钮
                        alert('对不起，'+ year + '年年度个人总结已经添加，无法再次添加。请选择正确的年份！'); // 提示信息
                    }else{
                        $('.J-submit').removeClass('none');
                    }

                },
                error: function(data,errorMsg) {
                    console.log('error');
                }
            })
        });

    }
});

