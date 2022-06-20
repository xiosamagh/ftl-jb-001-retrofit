package com.rmaslov.retrofit.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Builder
public class UserUpdateRequest {
    @ToString
    @Getter
    @Setter
    @Builder
    public static class Address{
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;
    }

    @ToString
    @Getter
    @Setter
    @Builder
    public static class Company{
        private String name;
        private String catchPhrase;
        private String bs;
    }
    @ToString
    @Getter
    @Setter
    @Builder
    public static class Geo{
        private String lat;
        private String lng;
    }

    private Integer id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;


}
