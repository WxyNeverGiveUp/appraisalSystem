package com.pandawork.home.common.entity.check;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/8/12.
 * 能力指标考核 指标类型表所对应的实体
 */
@Entity
@Table(name = "t_ability_target_type")
public class AbilityTargetType {
    @Id
    private Integer id;
    //指标类型名字
    @Column(name = "name")
    private String name;

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
}
