package com.rmaslov.retrofit.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class AlbumUpdateRequest {
    private Integer id;
    private Integer userId;
    private String title;

}
