package com.wx.mapper;

import com.wx.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
// 标记为 MyBatis 的 Mapper 接口
//在 Spring 中，Mapper 接口可以直接被注入到 Service 层使用：
//MyBatis 会在运行时通过动态代理自动生成 Mapper 接口的实现类
public interface UserMapper {

    @Select("select id, name, age, gender, phone from user")
    List<User> list();
}
