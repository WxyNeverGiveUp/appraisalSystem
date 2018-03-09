package com.pandawork.home.common.entity.check;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/9/26.
 */
@Entity
@Table(name = "t_ability_is_join")
public class AbilityTestIsJoin {

    @Id
    private Integer id;

    //此次考核计划打分的ID
    @Column(name = "tat_id")
    private Integer tatId;

    //被考核用户的ID
    @Column(name = "be_check_id")
    private Integer beCheckId;

    //考核计划的ID
    @Column(name = "test_id")
    private Integer testId;

    //是否参与此次考核
    @Column(name = "is_join")
    private Integer isJoin;
    //考核者的ID
    @Column(name = "check_id")
    private Integer checkId;


    public Integer getTatId() {
        return tatId;
    }

    public Integer getCheckId() {

        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTatId(Integer id) {
        return tatId;
    }

    public void setTatId(Integer tatId) {
        this.tatId = tatId;
    }

    public Integer getBeCheckId() {
        return beCheckId;
    }

    public void setBeCheckId(Integer beCheckId) {
        this.beCheckId = beCheckId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getIsJoin() {
        return isJoin;
    }

    public void setIsJoin(Integer isJoin) {
        this.isJoin = isJoin;
    }
}
