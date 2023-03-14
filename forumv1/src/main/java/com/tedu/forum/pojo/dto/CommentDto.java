package com.tedu.forum.pojo.dto;

import lombok.Data;

@Data
public class CommentDto {
    private String content;
    private Integer forumId;
}
