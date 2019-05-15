package com.jk.mapper;

import com.jk.model.UserBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UserMapper {
    @Select("select * from t_user")
    List<UserBean> queryUser();
}
