package com.pandawork.home.mapper.user;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/12.
 */
public interface UserMapper {

    /**
     * 注册用户
     * @param user
     * @return
     */
    public void addUser(@Param("user") User user)throws SSException;

    /**
     * 根据真实姓名查找用户
     * @param realName
     * @return
     * @throws Exception
     */
    public User queryByRname(@Param("realName") String realName)throws SSException;

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     * @throws Exception
     */
    public User queryByUname(@Param("username") String username)throws SSException;

    /**
     * 根据用户名和密码查找用户
     * @param user
     * @return
     * @throws Exception
     */
    public User queryByUnameAndPword(@Param("user") User user)throws SSException;

    /**
     * 多条件查询
     * @param rid
     * @param dname
     * @param status
     * @param isDelete
     * @param isBeCheck
     * @param username
     * @param realName
     * @return
     * @throws SSException
     */
    public List<User> queryMore(@Param("rid") int rid,@Param("dname") String dname,@Param("status") int status,@Param("isDelete") int isDelete,@Param("isDelete") int isBeCheck,@Param("username") String username,@Param("realName") String realName)throws SSException;

    /**
     * 计算用户条数
     * @return
     * @throws SSException
     */
    public int countAll()throws SSException;
    /**
     * 根据ID删除用户
     * @param user
     * @return
     * @throws SSException
     */
    public void delUser(@Param("user") User user)throws SSException;

    /**
     * 审核用户
     * @param user
     * @return
     * @throws SSException
     */
    public void statusUser(@Param("user") User user)throws SSException;

    /**
     * 修改用户密码
     * @param user
     * @return
     * @throws SSException
     */
    public void updatePassword(@Param("user") User user)throws SSException;

    /**
     * 修改真实姓名
     * @param user
     * @return
     * @throws SSException
     */
    public void updateRealName(@Param("user") User user)throws SSException;

    /**
     * 更新用户的基本信息
     * @param user
     * @throws SSException
     */
    public void updateUser(@Param("user") User user)throws SSException;

    /**
     * 是否参与考核，此处传的应该是数组
     * @param user
     * @throws SSException
     */
    public void isJoinCheck(@Param("user") User user)throws SSException;

    /**
     * 列出所有用户
     * @return
     * @throws SSException
     */
    public List<User> listAll()throws SSException;

    /**
     * 根据删除状态查找
     * @param isDelete
     * @return
     * @throws SSException
     */
    public List<User> queryByIsDelete(@Param("isDelete") int isDelete)throws SSException;

    /**
     * 根据ID查找
     * @param id
     * @return
     * @throws SSException
     */
    public User queryById(@Param("id") int id)throws SSException;

    /**
     * 根据角色ID查找
     * @param rid
     * @return
     * @throws SSException
     */
    public List<User> queryByRole(@Param("rid") int rid)throws SSException;

    /**
     * 根据部门ID查找
     * @param did
     * @return
     * @throws SSException
     */
    public List<User> queryByDid(@Param("did") int did)throws SSException;

    /**
     * 根据角色ID 和删除状态查询
     * @param rid
     * @param isDelete
     * @return
     * @throws SSException
     */
    public List<User> queryByRidAndIsDelete(@Param("rid") int rid,@Param("isDelete") int isDelete)throws SSException;

    /**
     * 根据部门ID和删除状态查询
     * @param did
     * @param isDelete
     * @return
     * @throws SSException
     */
    public List<User> queryByDidAndIsDelete(@Param("did") int did,@Param("isDelete") int isDelete)throws SSException;
}
