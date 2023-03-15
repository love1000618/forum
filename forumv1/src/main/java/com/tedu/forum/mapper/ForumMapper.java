package com.tedu.forum.mapper;

import com.tedu.forum.pojo.entity.Forum;
import com.tedu.forum.pojo.vo.ForumDetailVo;
import com.tedu.forum.pojo.vo.ForumIndexVo;

import java.util.List;

public interface ForumMapper {

    int insert(Forum forum);

    List<ForumIndexVo> select();

    ForumDetailVo selectById(int id);

    List<ForumIndexVo> selectByCid(int id);

    List<ForumIndexVo> selectByWd(String wd);


}
