package com.tedu.forum.pojo.dto;

import lombok.Data;

@Data
public class ForumDto {
    private String title;
    private String content;
    private String urls;
    private Integer categoryId;

}
