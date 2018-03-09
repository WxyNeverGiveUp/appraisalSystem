package com.pandawork.home.common.entity.check;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/8/12.
 * 能力指标考核问题表
 */
@Entity
@Table(name = "t_ability_position")
public class AbilityPosition {
    @Id
    private Integer id;
    //部门ID
    @Column(name = "did")
    private Integer did;
    //指标ID
    @Column(name = "target_id")
    private String targetId;
    //所占权重
    @Column(name = "weight")
    private Integer weight;
    //是否可用，0是不可用，1是可用
    @Column(name = "is_available")
    private Integer isAvailable;
    //此次的考核计划ID
    @Column(name = "test_id")
    private Integer testId;
    //考核问题指标ID
    @Column(name = "target_type_id")
    private String targetTypeId;

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getTargetId() {
        return targetId;
    }

    public String getTargetTypeId() {
        return targetTypeId;
    }

    public void setTargetTypeId(String targetTypeId) {
        this.targetTypeId = targetTypeId;
    }


    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }
}
