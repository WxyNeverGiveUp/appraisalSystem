package com.pandawork.home.common.entity.check;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/9/14.
 */

@Entity
@Table(name = "t_test_position")
public class TestPosition {
    //主键
    @Id
    private Integer id;
    //此次的考核计划ID
    @Column(name = "test_id")
    private Integer testId;
    //此次考核计划所包含的问题ID
    @Column(name = "position_id")
    private Integer positionId;

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

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }
}
