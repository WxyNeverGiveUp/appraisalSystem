package com.pandawork.home.common.entity.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/8/12.
 * 管辖分配表
 * 这是针对公司副总经理的表 ，用来分配副总经理的管辖范围
 */
@Entity
@Table(name = "t_allot")
public class Allot {

    @Id
    private Integer id;
    //用户ID（公司副总经理的ID）
    @Column(name = "uid")
    private Integer uid;
    //部门ID（副总经理所管辖的部门ID）
    @Column(name = "did")
    private Integer did;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }
}
