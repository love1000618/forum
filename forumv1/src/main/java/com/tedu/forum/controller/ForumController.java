package com.tedu.forum.controller;

import com.tedu.forum.mapper.ForumMapper;
import com.tedu.forum.pojo.dto.ForumDto;
import com.tedu.forum.pojo.entity.Forum;
import com.tedu.forum.pojo.vo.ForumDetailVo;
import com.tedu.forum.pojo.vo.ForumIndexVo;
import com.tedu.forum.pojo.vo.UserVo;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/forum/")
public class ForumController {
    @Autowired
    ForumMapper mapper;

    @RequestMapping("insert")
    public int insert (@RequestBody ForumDto forum, HttpSession session){
        //得到登入成功後保存的用戶
        UserVo user = (UserVo) session.getAttribute("user");

        //如果沒有值代表未登入,告訴客戶端去登入
        if(user==null){
            return 2;
        }
        Forum f = new Forum();
        BeanUtils.copyProperties(forum,f);
        f.setCreated(new Date());
        f.setUserId(user.getId());
        mapper.insert(f);
        return 1;

    }

    @RequestMapping("select")
    public List<ForumIndexVo> select(){
        return mapper.select();
    }

    @RequestMapping("selectById")
    public ForumDetailVo selectById(int id){
        return mapper.selectById(id);
    }

    @RequestMapping("selectByCid")
    public List<ForumIndexVo> selectByCid(int id){
        return mapper.selectByCid(id);
    }

    @RequestMapping("selectByWd")
    public List<ForumIndexVo> selectByWd(String wd){
        return mapper.selectByWd(wd);
    }
}
