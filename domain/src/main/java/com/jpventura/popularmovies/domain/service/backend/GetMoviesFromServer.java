/*
 * Copyright 2015 Joao Paulo Fernandes Ventura.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jpventura.popularmovies.domain.service.backend;

import android.content.Context;

import com.jpventura.popularmovies.domain.BuildConfig;
import com.jpventura.popularmovies.domain.R;
import com.jpventura.popularmovies.domain.provider.movie.MovieContentValues;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class GetMoviesFromServer {
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

        String apiKey = mContext.get().getString(R.string.tmdb_api_key);
        mMovieDB.getMovie(id, apiKey, Locale.getDefault().getLanguage(), onGetMovie);
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

        String apiKey = mContext.get().getString(R.string.tmdb_api_key);
        mMovieDB.getMovieList(listType, apiKey, Locale.getDefault().getLanguage(), onGetMovieList);
    }

    private boolean isValueMissing(Movie movie) {
        return null == movie.backdrop_path || null == movie.overview || null == movie.release_date;
    }

    private void insertMovieIntoDatabase(Movie movie) {
        mMovieContentValues.putAll(movie).insert(mContext.get());
    }

    private void insertMovieListIntoDatabase(List<Movie> movieList) {
        for (Movie movie : movieList) {
            if (null == movie.poster_path) continue;

            if (isValueMissing(movie)) {
                getMovieFromServer(movie.id);
            } else {
                insertMovieIntoDatabase(movie);
            }
        }
    }
}
