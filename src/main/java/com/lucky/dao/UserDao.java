package com.lucky.dao;

import com.lucky.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface UserDao {
	
	@Select("select * from user where id = #{id}")
	public User getById(@Param("id") long id);
}
