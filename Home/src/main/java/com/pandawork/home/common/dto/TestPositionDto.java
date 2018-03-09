package com.pandawork.home.common.dto;

/**
 * Created by Taoyongpan on 2017/9/15.
 */
public class TestPositionDto {

    //此次考核计划的ID
    private Integer id;
    //考核计划的ID
    private Integer testId;
    //考核计划问题指标
    private String target;
    //考核计划问题指标类型
    private String targetType;
    //考核计划权重
    private String weight;
    //此问题是否可用
    private Integer isAvailable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }
}
