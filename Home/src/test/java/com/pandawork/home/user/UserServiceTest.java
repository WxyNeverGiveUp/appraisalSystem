package com.pandawork.home.user;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.AbstractTestCase;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.service.user.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2017/4/20.
 */
public class UserServiceTest extends AbstractTestCase {
    @Autowired
    UserService userService;

    /**
     * 测试新增用户
     * @throws Exception
     */
    @Test
    public void addUserTest() throws Exception {
        User user = new User();
        user.setUsername("陶永攀1111");
        user.setRealName("陶永攀1");
        user.setPassword("tt123456");
        user.setSex("男");
        user.setDid(1);
        user.setStatus(1);
        user.setPhone("34567");
        userService.addUser(user);
    }

    /**
     * 根据真实姓名查找用户
     * @throws Exception
     */
    @Test
    public void queryByRnameTest()throws Exception{
        System.out.println( userService.queryByRname("陶永攀1"));
    }

    /**
     * 根据用户名查找用户
     * @throws Exception
     */
    @Test
    public void queryByUnameTest()throws Exception{
        System.out.println(userService.queryByUname("陶永攀11"));
    }

    /**
     * 根据用户名和密码查找用户
     * @throws Exception
     */
    @Test
    public void  loginTest()throws Exception{
        User user = new User();
        user.setUsername("陶永攀11");
        user.setPassword("tt123456");
        System.out.println(userService.queryByUnameAndPword(user));
    }

    public void testUser()throws Exception{
//        userService.queryMore()
    }

    @Test
    public void testCountAll()throws SSException{
        userService.countAll();
    }

    /**
     * 删除用户
     * @throws SSException
     */
    @Test
    public void testDelUser()throws SSException{
        User user = new User();
        user.setId(1);
        user.setIsDelete(0);
        userService.delUser(user);
    }

    /**
     * 测试审核用户
     * @throws SSException
     */
    @Test
    public void testStatusUser()throws SSException{
        User user = new User();
        user.setId(3);
        user.setStatus(0);
        userService.statusUser(user);
    }

    /**
     * 测试修改密码
     * @throws SSException
     */
    @Test
    public void testUpdatePassword()throws SSException{
        User user = new User();
        user.setId(3);
        user.setPassword("123321");
        userService.updatePassword(user);
    }

    /**
     * 更新用户的基本信息
     * @throws SSException
     */
    @Test
    public void testUpdaterUser()throws SSException{
        User user = new User();
        user.setId(3);
        user.setRealName("hhhh");
        user.setDid(2);
        user.setDname("jjj");
        user.setRid(3);
        user.setPname(1);
        userService.updateUser(user);
    }

    /**
     * 是否参与考核
     * @throws SSException
     */
    @Test
    public void testIsJoinCheck()throws SSException{
        User user = new User();
        user.setId(4);
        user.setIsJoinCheck(1);
        userService.isJoinCheck(user);
    }

    @Test
    public void queryByIsDelete()throws SSException{
        userService.queryByIsDelete(1);
    }
}
