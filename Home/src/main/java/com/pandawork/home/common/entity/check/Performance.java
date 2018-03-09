package com.pandawork.home.common.entity.check;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/8/12.
 * 年度绩效综合评定表所对应的实体
 */
@Entity
@Table(name = "t_performance")
public class Performance {
    @Id
    private Integer id;
    //被考核用户的ID
    @Column(name = "be_check_id")
    private Integer beCheckId;
    //考核该用户的用户ID
    @Column(name = "check_id")
    private Integer checkId;
    //当前年份
    @Column(name = "year")
    private Integer year;
    //当前季度
    @Column(name = "queater")
    private Integer queater;
    //当前月份
    @Column(name = "month")
    private Integer month;
    //十二个月的工作计划的平均分
    @Column(name = "suggest_score")
    private Double suggestScore;
    //年度总结得分
    @Column(name = "summary_score")
    private Double summaryScore;
    //年度绩效考核得分
    @Column(name = "year_score")
    private Double yearScore;

    //是否参与此次考核
    @Column(name = "is_join")
    private Integer isJoin;

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

    public Integer getQueater() {
        return queater;
    }

    public void setQueater(Integer queater) {
        this.queater = queater;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getSuggestScore() {
        return suggestScore;
    }

    public void setSuggestScore(Double suggestScore) {
        this.suggestScore = suggestScore;
    }

    public Double getSummaryScore() {
        return summaryScore;
    }

    public void setSummaryScore(Double summaryScore) {
        this.summaryScore = summaryScore;
    }

    public Double getYearScore() {
        return yearScore;
    }

    public void setYearScore(Double yearScore) {
        this.yearScore = yearScore;
    }
    
    public Integer getIsJoin() {
        return isJoin;
    }

    public void setIsJoin(Integer isJoin) {
        this.isJoin = isJoin;
    }
}
