package com.pandawork.home.common.entity.check;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/9/23.
 */
@Entity
@Table(name = "t_ability_test")
public class AbilityTest {

    //主键
    @Id
    private Integer id;

    //此次考核计划的ID
    @Column(name = "test_id")
    private Integer testId;

    //被考核用户ID
    @Column(name = "be_check_id")
    private Integer beCheckId;

    //考核此用户的用户ID
    @Column(name = "check_id")
    private Integer checkId;

    //此次考核得分
    @Column(name = "score")
    private Double score;
    //是否参与此次考核
    @Column(name = "is_join")
    private Integer isJoin;

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

    public Integer getBeCheckId() {
        return beCheckId;
    }

    public void setBeCheckId(Integer beCheckId) {
        this.beCheckId = beCheckId;
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
    
    public Integer getIsJoin() {
        return isJoin;
    }

    public void setIsJoin(Integer isJoin) {
        this.isJoin = isJoin;
    }


}
