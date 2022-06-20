package com.rmaslov.retrofit.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class CommentResponse {
    private Integer postId;
    private Integer id;
    private String name;
    private String email;
    private String body;


}
