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

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface IMovieDB {
    String REST_ENDPOINT = "http://api.themoviedb.org/3";

    @GET("/movie/{id}")
    void getMovie(@Path("id") long id,
                  @Query("api_key") String apiKey,
                  @Query("language") String language,
                  GetMovieCallback callback);

    @GET("/movie/{list_type}")
    void getMovieList(@Path("list_type") ListType listType,
                      @Query("api_key") String apiKey,
                      @Query("language") String language,
                      GetMovieListCallback callback);

    @GET("/movie/{list_type}")
    void getMovieList(@Path("list_type") ListType listType,
                      @Query("api_key") String apiKey,
                      @Query("language") String language,
                      @Query("page") int page,
                      GetMovieListCallback callback);
}
