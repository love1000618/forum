package com.tedu.forum.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Forum {
    private Integer id;
    private String title;
    private String content;
    private String urls;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date created;
    private Integer userId;
    private Integer categoryId;

}
