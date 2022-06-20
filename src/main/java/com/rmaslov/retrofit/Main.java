package com.rmaslov.retrofit;

import com.rmaslov.retrofit.request.*;
import com.rmaslov.retrofit.response.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("START");

        JsonPlaceholderAPI api = JsonPlaceholderService.getInstance().getJSONApi();
        System.out.println("----------- POSTS --------------------");
        List<PostResponse> posts = api.posts(null).execute().body();
        List<PostResponse> posts1 = api.posts(1).execute().body();

        System.out.println(posts.toString());
        System.out.println(posts1.toString());


        System.out.println("-------------- POSTS CREATE ------------");
        PostResponse postCreate = api.postCreate(PostCreateRequest.builder()
                .userId(3)
                .title("New Post")
                .body("News")
                .build()).execute().body();

        System.out.println(postCreate);

        System.out.println("-------------- POSTS UPDATE ------------");
        PostResponse postUpdate = api.postUpdate(1, PostUpdateRequest.builder()
                        .id(1)
                .userId(3)
                .title("New Post1")
                .body("News")
                .build()).execute().body();

        System.out.println(postUpdate);

        System.out.println("-------------- POSTS Delete ------------");
        Boolean postDelete  = api.postDelete(1).execute().isSuccessful();

        System.out.println(postDelete);

        System.out.println("-------------- POSTS With ID ------------");
        PostResponse postWithId  = api.postWithId(1).execute().body();

        System.out.println(postWithId);

        System.out.println("-------------- POST Comments------------");
        List<CommentResponse> commentResponses  = api.postComments(1).execute().body();

        System.out.println(commentResponses);

        System.out.println("-------------- Users ------------");
        List<UserResponse> users  = api.users().execute().body();

        System.out.println(users);

        System.out.println("-------------- Albums ------------");
        List<AlbumResponse> albums  = api.albumsWithUserId(5).execute().body();

        System.out.println(albums);

        System.out.println("-------------- Todos ------------");
        List<TodosResponse> todos  = api.todos(3).execute().body();

        System.out.println(todos);

        Call<List<CommentResponse>> commentsAll = api.postComments(1);

        Response<List<CommentResponse>> commentsCallResponse = commentsAll.execute();

        if (commentsCallResponse.isSuccessful() && commentsCallResponse.code() == 200) {
            List<CommentResponse> responses = commentsCallResponse.body();
        }
        else {
            if (commentsCallResponse.code()== 400) {
                String error = commentsCallResponse.errorBody().string();
            }
            else if(commentsCallResponse.code()== 500) {
                String error = commentsCallResponse.errorBody().string();
            }
            else if(commentsCallResponse.code()== 403) {
                String error = commentsCallResponse.errorBody().string();
            }
        }
        for (int i = 0; i<100; i++) {
            api.postComments(1).enqueue(new Callback<List<CommentResponse>>() {
                @Override
                public void onResponse(Call<List<CommentResponse>> call, Response<List<CommentResponse>> response) {
                    List<CommentResponse> commentAsyncResponse = response.body();
                }

                @Override
                public void onFailure(Call<List<CommentResponse>> call, Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        }

        System.out.println("passed");


        System.out.println("Task1 - Albums example");
        System.out.println("-----albums get ---------");

        List<AlbumResponse> albumsGet = api.albums().execute().body();

        System.out.println(albumsGet);

        System.out.println("-----albums get with id ---------");

        AlbumResponse albumsGetWithId = api.albumsWithId(2).execute().body();

        System.out.println(albumsGetWithId);

        System.out.println("-----albums create ---------");

        AlbumResponse albumNew = api.albumCreate(AlbumCreateRequest.builder()
                        .title("album1")
                        .userId(100)

                .build()).execute().body();

        System.out.println(albumNew);

        System.out.println("-----albums update ---------");

        AlbumResponse albumUpdate = api.albumUpdate(100, AlbumUpdateRequest.builder()
                        .id(100)
                .title("album111")
                .userId(100)

                .build()).execute().body();

        System.out.println(albumUpdate);

        System.out.println("-----album delete ---------");

        Boolean albumDelete = api.deleteAlbum(2).execute().isSuccessful();

        System.out.println(albumDelete);



        System.out.println("Task2 - Users example");
        System.out.println("-----users get ---------");

        List<UserResponse> usersGet = api.users().execute().body();

        System.out.println(usersGet);

        System.out.println("-----user get with id ---------");

        UserResponse userGetWithId = api.userWithId(2).execute().body();

        System.out.println(userGetWithId);

        System.out.println("-----user create ---------");

        UserResponse userNew = api.userCreate(UserCreateRequest.builder()
                        .address(UserCreateRequest.Address.builder().city("city1").suite("suite1").street("street1").zipcode("zipcode1").geo(UserCreateRequest.Geo.builder().lat("lat1").lng("lng1").build()).build())
                        .company(UserCreateRequest.Company.builder().bs("bs1").catchPhrase("catchPhrase1").name("name1").build())
                        .email("email1")
                        .username("username1")
                        .name("name1")
                        .phone("phone1")
                        .website("website1")



                .build()).execute().body();

        System.out.println(userNew);

        System.out.println("-----user update ---------");

        UserResponse userUpdate = api.userUpdate(2, UserUpdateRequest.builder()
                        .id(2)
                .address(UserUpdateRequest.Address.builder().city("city2").suite("suite1").street("street1").zipcode("zipcode1").geo(UserUpdateRequest.Geo.builder().lat("lat1").lng("lng1").build()).build())
                .company(UserUpdateRequest.Company.builder().bs("bs2").catchPhrase("catchPhrase1").name("name1").build())
                .email("email1")
                .username("username1")
                .name("name1")
                .phone("phone2")
                .website("website2")



                .build()).execute().body();

        System.out.println(userUpdate);

        System.out.println("-----user delete ---------");

        Boolean userDelete = api.userDelete(1).execute().isSuccessful();

        System.out.println(userDelete);



        System.out.println("Task3 - Comments example");
        System.out.println("-----comments get ---------");

        List<CommentResponse> commentsGet = api.commentsGet().execute().body();

        System.out.println(commentsGet);

        System.out.println("-----comment get with id ---------");

        CommentResponse commentWithId = api.commentGetWithId(1).execute().body();

        System.out.println(commentWithId);

        System.out.println("-----comment create ---------");

        CommentResponse commentCreate = api.commentCreate(CommentCreateRequest.builder()
                        .body("body1")
                        .postId(2)
                        .email("email1")
                        .name("name1")

                .build()).execute().body();

        System.out.println(commentCreate);

        System.out.println("-----comment update ---------");

        CommentResponse commentUpdate = api.commentUpdate(1, CommentUpdateRequest.builder()
                        .id(1)
                        .body("body2")
                        .email("email1")
                        .name("name1")
                        .postId(2)


                .build()).execute().body();

        System.out.println(commentUpdate);

        System.out.println("-----comment delete ---------");

        Boolean commentDelete = api.commentDelete(1).execute().isSuccessful();

        System.out.println(commentDelete);








    }
}
