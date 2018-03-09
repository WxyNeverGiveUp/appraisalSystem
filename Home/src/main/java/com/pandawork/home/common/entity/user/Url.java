package com.pandawork.home.common.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Taoyongpan on 2017/10/3.
 * 用户权限实体
 */
@Entity
@Table(name = "t_url")
public class Url {

    @Id
    private Integer id;

    @Column(name = "url_name")
    private String urlName;


    @Column(name = "url")
    private String url;


    @Column(name = "power")
    private Integer power;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}
