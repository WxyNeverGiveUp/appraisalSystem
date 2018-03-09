package com.pandawork.home.common.entity.check;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/8/12.
 * 工作计划表
 */
@Entity
@Table(name = "t_work_plan")
public class WorkPlan {
    @Id
    private Integer id;
    //可考核用户的ID
    @Column(name = "be_check_id")
    private Integer beCheckId;
    //考核 该用户的用户ID
    @Column(name = "check_id")
    private Integer checkId;
    //当前年份
    @Column(name = "year")
    private Integer year;
    //当前月份
    @Column(name = "month")
    private Integer month;
    //当前季度
    @Column(name = "queater")
    private Integer queater;
    //该月得分
    @Column(name = "month_score")
    private Double monthScore;
    //该季度得分
    @Column(name = "queater_score")
    private Double queaterScore;
    //考核计划ID
    @Column(name = "test_id")
    private Integer testId;

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getQueater() {
        return queater;
    }

    public void setQueater(Integer queater) {
        this.queater = queater;
    }

    public Double getMonthScore() {
        return monthScore;
    }

    public void setMonthScore(Double monthScore) {
        this.monthScore = monthScore;
    }

    public Double getQueaterScore() {
        return queaterScore;
    }

    public void setQueaterScore(Double queaterScore) {
        this.queaterScore = queaterScore;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }
}
