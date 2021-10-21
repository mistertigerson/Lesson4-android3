package lbf.com.lesson4_34.data.remote;

import java.util.List;

import lbf.com.lesson4_34.data.models.Film;
import lbf.com.lesson4_34.data.models.Post;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HerokuApi {

    @POST("/posts/")
    Call<Post> createPost(@Body Post film);

    @GET("/posts/")
    Call<List<Post>> getPost();

    @PUT("posts/{postId}")
    Call<Post> putPost(@Path("id") String id, @Body Post post);

    @DELETE("posts/{postId}")
    Call<Post> deletePost(@Path("id") int id, @Body Post post);

}
