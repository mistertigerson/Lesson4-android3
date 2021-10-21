package lbf.com.lesson4_34.data.remote;

import java.util.List;

import lbf.com.lesson4_34.data.models.Film;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GhibliApi {

    @GET("/films")
    Call<List<Film>> getFilms();

}
