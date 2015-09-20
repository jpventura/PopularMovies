package com.jpventura.popularmovies.domain.backend;

import android.content.Context;

import com.jpventura.popularmovies.domain.BuildConfig;
import com.jpventura.popularmovies.domain.provider.movie.MovieContentValues;
import com.jpventura.popularmovies.domain.service.backend.GetMovieCallback;
import com.jpventura.popularmovies.domain.service.backend.GetMovieListCallback;
import com.jpventura.popularmovies.domain.service.backend.IMovieDB;
import com.jpventura.popularmovies.domain.service.backend.ListType;
import com.jpventura.popularmovies.domain.service.backend.Movie;
import com.jpventura.popularmovies.domain.service.backend.ResultPage;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class GetMoviesFromServer {
    private static final String API_KEY = "29d1cd112a40a9ddd1a6c016eec74ecb";

    private WeakReference<Context> mContext;
    private IMovieDB mMovieDB;
    private MovieContentValues mMovieContentValues;

    public GetMoviesFromServer(Context context) {
        mContext = new WeakReference<>(context);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(IMovieDB.REST_ENDPOINT)
                .setLogLevel(BuildConfig.DEBUG ? LogLevel.FULL : LogLevel.NONE)
                .build();
        mMovieDB = restAdapter.create(IMovieDB.class);

        mMovieContentValues = new MovieContentValues();
    }

    public void execute(long id) {
        getMovieFromServer(id);
    }

    public void execute(ListType type) {
        getMovieListFromServer(type);
    }

    private void getMovieFromServer(long id) {
        GetMovieCallback onGetMovie = new GetMovieCallback() {
            @Override
            public void success(Movie movie, Response response) {
                if (null != movie.poster_path) {
                    insertMovieIntoDatabase(movie);
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        };

        mMovieDB.getMovie(id, API_KEY, Locale.getDefault().getLanguage(), onGetMovie);
    }

    private void getMovieListFromServer(ListType listType) {
        GetMovieListCallback onGetMovieList = new GetMovieListCallback() {
            @Override
            public void success(ResultPage resultPage, Response response) {
                insertMovieListIntoDatabase(resultPage.results);
            }

            @Override
            public void failure(RetrofitError error) {
                if (BuildConfig.DEBUG) {
                    error.printStackTrace();
                }
            }
        };

        mMovieDB.getMovieList(listType, API_KEY, Locale.getDefault().getLanguage(), onGetMovieList);
    }

    private void insertMovieIntoDatabase(Movie movie) {
        mMovieContentValues.putAll(movie).insert(mContext.get());
    }

    private void insertMovieListIntoDatabase(List<Movie> movieList) {
        for (Movie movie : movieList) {
            if (null == movie.poster_path) continue;
            insertMovieIntoDatabase(movie);
        }
    }
}
