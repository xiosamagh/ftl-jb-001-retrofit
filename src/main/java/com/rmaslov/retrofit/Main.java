package com.rmaslov.retrofit;

import com.rmaslov.retrofit.request.AlbumCreateRequest;
import com.rmaslov.retrofit.request.AlbumUpdateRequest;
import com.rmaslov.retrofit.request.PostCreateRequest;
import com.rmaslov.retrofit.request.PostUpdateRequest;
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

        Boolean albumDelete = api.albums().execute().isSuccessful();

        System.out.println(albumDelete);











    }
}
