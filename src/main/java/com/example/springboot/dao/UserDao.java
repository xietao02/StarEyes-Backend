package com.example.springboot.dao;

import com.example.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    User loginByID(@Param("id") String id, @Param("password")String password);

    Integer saveToken(@Param("id") String id, @Param("token") String token);

    Integer saveExpTime(@Param("id") String id, @Param("time") String expTime);

    String getToken(@Param("id") String id);

    String gerExpTime(@Param("id") String id);

    /*List<User> findAll();

    User getByID(Integer id);

    User checkByID(@Param("id") String id, @Param("password")String password);

    //insert 只会返回int
    void insert(User user);

    void update(User user);

    Integer delete(Integer id);*/
}
