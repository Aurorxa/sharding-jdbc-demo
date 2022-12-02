package com.github.shardingjdbcdemo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.shardingjdbcdemo.entity.User;
import com.github.shardingjdbcdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class ShardingJdbcDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void readWriteTest() {
        User user = new User();
        user.setUname("张三");
        userMapper.insert(user);
    }


    @Test
    public void testTx(){
        User user = new User();
        user.setUname("李四");
        userMapper.insert(user);

        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUname, "李四");

        List<User> users = userMapper.selectList(userLambdaQueryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    @Transactional
    public void testTx2(){
        User user = new User();
        user.setUname("王五");
        userMapper.insert(user);

        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUname, "李四");

        List<User> users = userMapper.selectList(userLambdaQueryWrapper);
        System.out.println("users = " + users);
    }


    @Test
    public void testLB(){
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUname, "李四");

        List<User> users1 = userMapper.selectList(userLambdaQueryWrapper);
        System.out.println("users1 = " + users1);

        List<User> users2 = userMapper.selectList(userLambdaQueryWrapper);
        System.out.println("users2 = " + users2);
    }

}
