package com.tedu.forum.mapper;

import com.tedu.forum.pojo.entity.User;
import com.tedu.forum.pojo.vo.UserVo;

public interface UserMapper {
    UserVo selectByUsername(String username);

    int insert(User user);
}
