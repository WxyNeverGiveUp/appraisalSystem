package com.pandawork.home.common.entity.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/8/12.
 * 部门基本信息表
 */
@Entity
@Table(name = "t_department")
public class Department {

    @Id
    private Integer id;
    //部门名字
    @Column(name = "name")
    private String name;
    //是否删除，0是被删除，1是不被删除
    @Column(name = "is_delete")
    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
