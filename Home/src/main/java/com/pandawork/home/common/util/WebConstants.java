package com.pandawork.home.common.util;


import java.util.HashMap;
import java.util.Map;

/**
 * 常量
 */
public final class WebConstants {

    //第一平台

    public static Map<String, Integer> modelTypeMap = new HashMap<>();
    //本地开发配置
//    public final static String website = "http://http://localhost:8080/";    //网站地址
//    public static String staticWebsite = "http://localhost:8080/resources/js/";    //静态资源站点
    // 网站标题
    public static String webTitle;

    // 网站名称
    public static String webName;

    public static String webFullName;


//    // 文件上传服务器地址
//    public static final String uploadWebsite;
//
//    public static final String wechatWebsite;

    // 用户ID
    public static final String WebUserId = "web_user_id";

    // web端的常量姓名
    public static final String WebUserName = "web_user_name";

    // web端的常量登录名
    public static final String WebLoginName = "web_login_name";

    public static final String WEB_ADMIN_USER_CENTER_KEY = "web_admin_vip_key";

    public static final String FILE_SEPARATOR = "/";

    public static final String ID_CARD_PIC_FOLDER = "/idCardPic/";


    //线上地址
//    public final static String website = "http://39.108.137.243/Home_id";
//    public final static String staticWebsite = "http://39.108.137.243/Home_id/resources/js";


    //本地地址
    public final static String website = "http://localhost:8080/";
    public final static String staticWebsite = "http://localhost:8080/resources/js";



}
