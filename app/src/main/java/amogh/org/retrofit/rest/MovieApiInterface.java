package amogh.org.retrofit.rest;

import amogh.org.retrofit.model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Amogh on 2/13/2018.
 */

public interface MovieApiInterface {

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apipKey);
}
