package com.pandawork.home.common.entity.check;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/8/12.
 * 能力指标考核结果表所对应的实体
 */
@Entity
@Table(name = "t_ability_result")
public class AbilityResult {
    @Id
    private Integer id;
    //被考核用户的ID
    @Column(name = "be_check_id")
    private Integer beCheckId;
    //考核 该用户的用户ID
    @Column(name = "check_id")
    private Integer checkId;
    //角色ID
    @Column(name = "rid")
    private Integer rid;
    //当前年份
    @Column(name = "year")
    private Integer year;
    //部门ID
    @Column(name = "did")
    private Integer did;
    //总共得分
    @Column(name = "total_score")
    private Double totalScore;
    //是否提交本次成绩，0是不提交，1是提交
    @Column(name = "is_submit")
    private Integer isSubmit;
    //能力指标考核结束时间
    @Column(name = "finish_time")
    private String finishTime;
    //此次的考核计划ID
    @Column(name = "test_id")
    private Integer testId;
    //是否参与此次考核，已参与为1，未参与为0
    @Column(name = "is_join")
    private Integer isJoin;

    public Integer getIsJoin() {
        return isJoin;
    }

    public void setIsJoin(Integer isJoin) {
        this.isJoin = isJoin;
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

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getIsSubmit() {
        return isSubmit;
    }

    public void setIsSubmit(Integer isSubmit) {
        this.isSubmit = isSubmit;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }
}
