package com.pandawork.home.common.entity.check;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/8/12.
 * 能力指标考核指标表所对应的实体
 */
@Entity
@Table(name = "t_ability_target")
public class AbilityTarget {
    @Id
    private Integer id;
    //指标类型ID，来自能力指标考核指标类型表
    @Column(name = "type_id")
    private Integer typeId;
    //指标名字
    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
