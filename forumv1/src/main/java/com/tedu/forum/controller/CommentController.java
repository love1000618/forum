package com.tedu.forum.controller;

import com.tedu.forum.mapper.CommentMapper;
import com.tedu.forum.pojo.dto.CommentDto;
import com.tedu.forum.pojo.entity.Comment;
import com.tedu.forum.pojo.vo.CommentVo;
import com.tedu.forum.pojo.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment/")
public class CommentController {
    @Autowired
    CommentMapper mapper;

    @RequestMapping("insert")
    public int insert(@RequestBody CommentDto comment,
                      HttpSession session){
        UserVo u = (UserVo) session.getAttribute("user");
        if (u == null) {
            return 2;//未登入
        }
        Comment c= new Comment();
        BeanUtils.copyProperties(comment,c);

        //把用戶對象的ID 附值到評論區
        c.setUserId(u.getId());
        c.setCreated(new Date());
        mapper.insert(c);
        return 1;
    }

    @RequestMapping("selectByForum")
    public List<CommentVo> selectByForum(int id){
        return mapper.selectByForum(id);
    }
}
