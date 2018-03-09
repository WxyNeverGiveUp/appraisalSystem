(function(){

    var site = {
        //这是前端本地需要配置的，用来看自己写的页面
        website:'http://localhost:8080/', //站点地址
        //静态资源地址
        staticWebsite: 'http://localhost:8080/resources/'

        // website:'http://39.108.137.243/Home_id/', //站点地址
        // //静态资源地址
        // staticWebsite: 'http://39.108.137.243/Home_id/resources/js'
    }
    // 页面内容
    _ajax = {
        status: 0, //0-前端调试，1-后端调试, 2-后端部署
        website: site.website,
        staticWebsite: site.staticWebsite,
        //统一错误信息入口
        msg:{
            0: '网络加载错误'
        },
        //ajax地址信息
        url: {
            //系统考核
            system:{
               //角色管理
               role:{
                    // 列表
                    list:{
                        test: site.staticWebsite + 'mock/plan_management.json',
                        update: site.website + 'role/ajax/update', // 点击
                        del: site.website + 'role/ajax/del', //删除
                        submit: site.website + 'role/update'// 提交
                    },
                    // 添加
                    add:{
                        // 暂无
                    }
                },
                //权限管理
                jurisdiction:{
                    // 列表
                    list:{
                        del: site.website + 'power/ajax/del', //删除
                        update: site.website + 'power/ajax/update', //点击修改
                        submit: site.website + 'power/update' // 提交
                    },
                    // 添加
                    add:{
                        // 暂无
                    }
                },
                //部门管理
                department:{
                    // 列表
                    list:{
                        update: site.website + 'department/ajax/update', // 点击修改
                        del: site.website + 'department/ajax/del', // 点击修改
                        submit: site.website + 'department/update', // 提交
                    },
                    // 添加
                    add:{
                        // 暂无
                    }
                },
                //人员管理
                personnel:{
                    // 列表
                    list:{
                        update: site.website + 'user/ajax/update', //点击修改
                        init: site.website + 'user/init/password', //初始化密码
                        del : site.website + 'user/ajax/del', //删除
                        submit: site.website + 'user/update', // 提交
                    }
                },
                //管辖分配
                allot:{
                    // 列表
                    list:{
                        del: site.website + 'allot/ajax/del', // 删除
                        update: site.website + 'allot/ajax/update', // 点击修改
                        submit: site.website + 'allot/update' // 修改提交
                    }
                },
                //账号管理
                account:{
                    // 列表
                    list:{
                        pass: site.website + 'user/status', // 通过
                        no_pass: site.website + 'user/status/not', // 不通过
                    }
                },
            },
            //考核考核
            evaluation:{
               //考核计划
               plan_management:{
                    // 列表
                    list:{
                        edit: site.website + 'testplan/edit', // 修改状态
                        del: site.website + 'testplan/del', // 删除
                        update: site.website + 'testplan/to/update', // 点击修改
                        submit: site.website + 'testplan/update', // 点击提交
                    },
                    // 详情页 分配
                    detail:{
                        add: site.website + 'testplan/join', //添加
                        del: site.website + 'testplan/del/join', //移除
                        addAll: site.website + 'testplan/add/all', // 添加全部
                    }
                },
                //月/季度考核管理
                month:{
                    // 工作计划列表
                    plan_list:{
                        update: site.website + 'workplan/month/to/update', // 点击修改
                        submit: site.website + 'workplan/month/update', // 点击提交
                        del: site.website + 'workplan/month/del', // 删除
                        submit2: site.website + 'workplan/work/com', // 工作完成结果提交
                    },
                },
                //年度考核管理
                year:{
                    // 绩效综合列表
                    synthetical_list:{
                        change: site.staticWebsite + 'mock/synthetical_list.json'
                    },
                    // 能力指标列表
                    ability_list:{
                        add: site.website + 'test/position/add', // 添加
                        submit: site.website + 'test/position/edit', // 点击修改
                        update: site.website + 'test/position/to/edit', // 点击修改按钮
                        delete: site.website + 'test/position/del', // 删除本道题
                    },
                    // 个人总结判断
                    summary:{
                        verify: site.website + '/summary/judge/add', // 判断是否可以提交
                    }
                }
            },
            //测评模块
            exam:{
                // 月度
                month:{
                    // 详情页
                    detail:{
                        submit: site.website + 'check/month/mark', // 打分
                    }
                },
                // 年度
                year:{
                    summary:{
                        submit: site.website + 'check/summary/mark', // 个人总结打分
                    },
                    year:{
                        submit: site.website + 'check/year/mark', // 年度绩效打分
                    }
                }
            },
            //成绩查询
            performance:{
               //考核计划
               plan_management:{
                    // 列表
                    list:{
                        change: site.staticWebsite + 'mock/plan_management.json'
                    },
                    // 添加
                    add:{
                        // 暂无
                    }
                }
            }
        },
    }
})();