package com.pandawork.home.common.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/5/24.
 * 用户基本信息表
 */
@Entity
@Table(name = "t_user")
public class User {
    @Id
    private Integer id;
    //用户名
    @Column(name = "username")
    private String username;
    //真实姓名
    @Column(name = "real_name")
    private String realName;
    //密码
    @Column(name = "password")
    private String password;
    //部门ID
    @Column(name = "did")
    private Integer did;
    //部门名字 ，该选项不可修改，只会跟着部门ID的变化而变化，但可以直接调用
    @Column(name = "dname")
    private String dname;
    //角色ID
    @Column(name = "rid")
    private Integer rid;
    //权限等级，该选项不可修改，只会跟着角色ID的变化而变化，但可以直接调用（名字）
    @Column(name = "pname")
    private Integer  pname;
    //是否参与考核，1是参与考核，0是不参与考核
    @Column(name = "is_join_check")
    private Integer isJoinCheck;
    //是否被考核，1是被考核，0是不被考核
    @Column(name = "is_be_check")
    private Integer isBeCheck;
    //审核状态，0是未审核，1是审核通过，2是审核未通过
    @Column(name = "status")
    private Integer status;
    //是否删除，0是被删除，1是不被删除
    @Column(name = "is_delete")
    private Integer isDelete;
    //性别
    @Column(name = "sex")
    private String sex;
    //手机号
    @Column(name = "phone")
    private String phone;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPname() {
        return pname;
    }

    public void setPname(Integer pname) {
        this.pname = pname;
    }

    public Integer getIsJoinCheck() {
        return isJoinCheck;
    }

    public void setIsJoinCheck(Integer isJoinCheck) {
        this.isJoinCheck = isJoinCheck;
    }

    public Integer getIsBeCheck() {
        return isBeCheck;
    }

    public void setIsBeCheck(Integer isBeCheck) {
        this.isBeCheck = isBeCheck;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", did=" + did +
                ", dname='" + dname + '\'' +
                ", rid=" + rid +
                ", pname=" + pname +
                ", isJoinCheck=" + isJoinCheck +
                ", isBeCheck=" + isBeCheck +
                ", status=" + status +
                ", isDelete=" + isDelete +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
