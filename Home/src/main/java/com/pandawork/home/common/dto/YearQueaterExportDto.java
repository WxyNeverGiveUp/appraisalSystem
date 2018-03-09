package com.pandawork.home.common.dto;

/**
 * Created by Taoyongpan on 2017/9/15.
 */
public class YearQueaterExportDto {

    //用户ID
    private Integer id;
    //当前考核 计划所在的年份
    private Integer year;
    //用户的部门名称
    private String department;
    //用户的登录名
    private String username;
    //用户的真实姓名
    private String realName;
    //用户的角色
    private String role;
    //一季度得分
    private Double queater1;
    //二季度得分
    private Double queater2;
    //三季度得分
    private Double queater3;
    //四季度得分
    private Double queater4;
    //年度总结得分
    private Double summaryScore;
    //年度能力指标得分
    private Double abilityScore;
    //年度得分
    private Double yearScore;

    //考核计划类型
    private Integer testType;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getTestType() {
        return testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getQueater1() {
        return queater1;
    }

    public void setQueater1(Double queater1) {
        this.queater1 = queater1;
    }

    public Double getQueater2() {
        return queater2;
    }

    public void setQueater2(Double queater2) {
        this.queater2 = queater2;
    }

    public Double getQueater3() {
        return queater3;
    }

    public void setQueater3(Double queater3) {
        this.queater3 = queater3;
    }

    public Double getQueater4() {
        return queater4;
    }

    public void setQueater4(Double queater4) {
        this.queater4 = queater4;
    }

    public Double getSummaryScore() {
        return summaryScore;
    }

    public void setSummaryScore(Double summaryScore) {
        this.summaryScore = summaryScore;
    }

    public Double getAbilityScore() {
        return abilityScore;
    }

    public void setAbilityScore(Double abilityScore) {
        this.abilityScore = abilityScore;
    }

    public Double getYearScore() {
        return yearScore;
    }

    public void setYearScore(Double yearScore) {
        this.yearScore = yearScore;
    }
}
