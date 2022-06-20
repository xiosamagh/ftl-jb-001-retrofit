package com.rmaslov.retrofit.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class CommentCreateRequest {

    private Integer postId;
    private String name;
    private String email;
    private String body;
}
