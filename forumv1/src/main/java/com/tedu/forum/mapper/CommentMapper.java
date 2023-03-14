package com.tedu.forum.mapper;

import com.tedu.forum.pojo.entity.Comment;
import com.tedu.forum.pojo.vo.CommentVo;

import java.util.List;

public interface CommentMapper {
    int insert(Comment comment);

    List<CommentVo> selectByForum(int id);

}
