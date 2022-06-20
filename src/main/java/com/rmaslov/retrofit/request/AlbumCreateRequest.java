package com.rmaslov.retrofit.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class AlbumCreateRequest {
    private Integer userId;
    private String title;
}
