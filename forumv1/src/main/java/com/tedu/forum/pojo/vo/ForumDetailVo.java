package com.tedu.forum.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ForumDetailVo {
    private Integer id;
    private String title;
    private String content;
    private String urls;
    private String nickname;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date created;
    private Integer categoryId;


}
