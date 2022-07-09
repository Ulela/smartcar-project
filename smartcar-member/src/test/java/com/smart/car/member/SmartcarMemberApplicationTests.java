package com.smart.car.member;

import com.smart.car.member.entity.MemberUser;
import com.smart.car.member.entity.MemberUserExample;
import com.smart.car.member.mapper.MemberUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SmartcarMemberApplicationTests {

    @Resource
    private MemberUserMapper userMapper;

    //新增
    @Test
    void contextLoadsAdd() {
        MemberUser memberUser = new MemberUser().setId("100")
                .setRealName("江湖一点雨")
                .setPhone("18812345678")
                .setRemark("新增测试").setCreateDate(new Date()).setUpdateDate(new Date());
        int userList = userMapper.insert(memberUser);
        System.out.println("新增成功"+userList);
    }

    //查询
    @Test
    void contextLoadsQuery() {
        MemberUserExample userExample = new MemberUserExample();
        List<MemberUser> userList = userMapper.selectByExample(userExample);
        userList.forEach((item)-> { System.out.println(item); });
        System.out.println("查询成功");
    }

    //修改
    @Test
    void contextLoadsEdit() {
        MemberUserExample userExample = new MemberUserExample();
        MemberUser memberUser = new MemberUser()
                .setId("11")
                .setBirth("1999-01-07").setUpdateDate(new Date());
        //不存在或失败返回0，成功返回1
        int userList = userMapper.updateByPrimaryKey(memberUser);
        System.out.println("修改成功"+userList);
    }

    //删除
    @Test
    void contextLoadsDel() {
        //不存在或失败返回0，成功返回1
        int userList = userMapper.deleteByPrimaryKey("20");
        System.out.println("删除成功"+userList);
    }
}

