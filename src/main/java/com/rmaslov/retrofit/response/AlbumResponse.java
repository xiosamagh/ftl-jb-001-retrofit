package com.rmaslov.retrofit.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AlbumResponse {
    private int userId;
    private int id;
    private String title;
}
