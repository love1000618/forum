package com.tedu.forum.controller;

import com.tedu.forum.mapper.UserMapper;
import com.tedu.forum.pojo.dto.UserLoginDto;
import com.tedu.forum.pojo.dto.UserRegDto;
import com.tedu.forum.pojo.entity.User;
import com.tedu.forum.pojo.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    UserMapper mapper;

    @RequestMapping("/reg")
    public int reg(@RequestBody UserRegDto user) {
        UserVo u = mapper.selectByUsername(user.getUsername());
        UserVo uNickname = mapper.selectByNickname(user.getNickname());
        if (u != null) {
            return 2;//帳號已存在
        }
        User userEntity = new User();

        BeanUtils.copyProperties(user, userEntity);
        if(userEntity.getPassword().equals(userEntity.getUsername())){
            return 4;//帳號密碼不能相同
        }else if (uNickname !=null){
            return 5;//暱稱重複
        }else if (userEntity.getUsername().isEmpty()||
                userEntity.getPassword().isEmpty()||
                userEntity.getNickname().isEmpty()){
            return 3;
        }else {
            mapper.insert(userEntity);

            return 1;//註冊成功
        }

    }

    @RequestMapping("/login")
    public int login(@RequestBody UserLoginDto user,
                     HttpSession session, HttpServletResponse response){
        System.out.println("user = "+user );
        UserVo u = mapper.selectByUsername(user.getUsername());
        if(u != null){
            if(u.getPassword().equals(user.getPassword())){
                //把用戶對象保存到當前客戶端對應的對話裡面
                session.setAttribute("user",u);
                //判斷是否需要記住帳號密碼
                if (user.getRem()){
                    Cookie c1 = new Cookie("username",user.getUsername());
                    //設定保存時間
                    c1.setMaxAge(60*60*24);
                    Cookie c2 = new Cookie("password", user.getPassword());
                    //把cookie發給客戶端
                    response.addCookie(c1);
                    response.addCookie(c2);
                }
                return 1;//登入成功

            }
            return 2;//密碼錯誤
        }
        return 3;//用戶名不存在
    }

    @RequestMapping("/currentUser")
    public UserVo currentUser(HttpSession session){

        return (UserVo) session.getAttribute("user");
    }

    @RequestMapping("/logout")
    public void logout(HttpSession session){
        //刪除登入成功時保存的對象
        session.removeAttribute("user");
    }
}
