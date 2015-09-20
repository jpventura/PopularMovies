/*
 * Copyright (C) 2015 Joao Paulo Fernandes Ventura
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jpventura.popularmovies.domain.provider.movie;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpventura.popularmovies.domain.provider.base.AbstractContentValues;
import com.jpventura.popularmovies.domain.service.backend.Movie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Content values wrapper for the {@code movie} table.
 */
public class MovieContentValues extends AbstractContentValues<Movie> {
    @Override
    public Uri uri() {
        return MovieColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable MovieSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The content provider context.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable MovieSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public MovieContentValues putAdult(@Nullable Boolean value) {
        mContentValues.put(MovieColumns.ADULT, value);
        return this;
    }

    public MovieContentValues putAdultNull() {
        mContentValues.putNull(MovieColumns.ADULT);
        return this;
    }

    public MovieContentValues putBackdropPath(@Nullable String value) {
        mContentValues.put(MovieColumns.BACKDROP_PATH, value);
        return this;
    }

    public MovieContentValues putBackdropPathNull() {
        mContentValues.putNull(MovieColumns.BACKDROP_PATH);
        return this;
    }

    public MovieContentValues putBudget(@Nullable Long value) {
        mContentValues.put(MovieColumns.BUDGET, value);
        return this;
    }

    public MovieContentValues putBudgetNull() {
        mContentValues.putNull(MovieColumns.BUDGET);
        return this;
    }

    public MovieContentValues putFavorite(@Nullable Boolean value) {
        mContentValues.put(MovieColumns.FAVORITE, value);
        return this;
    }

    public MovieContentValues putFavoriteNull() {
        mContentValues.putNull(MovieColumns.FAVORITE);
        return this;
    }

    public MovieContentValues putHomepage(@Nullable String value) {
        mContentValues.put(MovieColumns.HOMEPAGE, value);
        return this;
    }

    public MovieContentValues putHomepageNull() {
        mContentValues.putNull(MovieColumns.HOMEPAGE);
        return this;
    }

    public MovieContentValues putId(long value) {
        mContentValues.put(MovieColumns.ID, value);
        return this;
    }

    public MovieContentValues putImdbId(@Nullable String value) {
        mContentValues.put(MovieColumns.IMDB_ID, value);
        return this;
    }

    public MovieContentValues putImdbIdNull() {
        mContentValues.putNull(MovieColumns.IMDB_ID);
        return this;
    }

    public MovieContentValues putOriginalTitle(@Nullable String value) {
        mContentValues.put(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieContentValues putOriginalTitleNull() {
        mContentValues.putNull(MovieColumns.ORIGINAL_TITLE);
        return this;
    }

    public MovieContentValues putOverview(@Nullable String value) {
        mContentValues.put(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieContentValues putOverviewNull() {
        mContentValues.putNull(MovieColumns.OVERVIEW);
        return this;
    }

    public MovieContentValues putPopularity(@Nullable Double value) {
        mContentValues.put(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieContentValues putPopularityNull() {
        mContentValues.putNull(MovieColumns.POPULARITY);
        return this;
    }

    public MovieContentValues putPosterPath(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("posterPath must not be null");
        mContentValues.put(MovieColumns.POSTER_PATH, value);
        return this;
    }

    public MovieContentValues putReleaseDate(@Nullable Date value) {
        mContentValues.put(MovieColumns.RELEASE_DATE, value == null ? null : value.getTime());
        return this;
    }

    public MovieContentValues putReleaseDateNull() {
        mContentValues.putNull(MovieColumns.RELEASE_DATE);
        return this;
    }

    public MovieContentValues putReleaseDate(@Nullable String value) {
        try {
            SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
            putReleaseDate(parser.parse(value));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return this;
    }

    public MovieContentValues putReleaseDate(@Nullable Long value) {
        mContentValues.put(MovieColumns.RELEASE_DATE, value);
        return this;
    }

    public MovieContentValues putRevenue(@Nullable Long value) {
        mContentValues.put(MovieColumns.REVENUE, value);
        return this;
    }

    public MovieContentValues putRevenueNull() {
        mContentValues.putNull(MovieColumns.REVENUE);
        return this;
    }

    public MovieContentValues putRuntime(@Nullable Integer value) {
        mContentValues.put(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieContentValues putRuntimeNull() {
        mContentValues.putNull(MovieColumns.RUNTIME);
        return this;
    }

    public MovieContentValues putStatus(@Nullable String value) {
        mContentValues.put(MovieColumns.STATUS, value);
        return this;
    }

    public MovieContentValues putStatusNull() {
        mContentValues.putNull(MovieColumns.STATUS);
        return this;
    }

    public MovieContentValues putTagline(@Nullable String value) {
        mContentValues.put(MovieColumns.TAGLINE, value);
        return this;
    }

    public MovieContentValues putTaglineNull() {
        mContentValues.putNull(MovieColumns.TAGLINE);
        return this;
    }

    public MovieContentValues putTitle(@Nullable String value) {
        mContentValues.put(MovieColumns.TITLE, value);
        return this;
    }

    public MovieContentValues putTitleNull() {
        mContentValues.putNull(MovieColumns.TITLE);
        return this;
    }

    public MovieContentValues putVoteAverage(@Nullable Double value) {
        mContentValues.put(MovieColumns.VOTE_AVERAGE, value);
        return this;
    }

    public MovieContentValues putVoteAverageNull() {
        mContentValues.putNull(MovieColumns.VOTE_AVERAGE);
        return this;
    }

    public MovieContentValues putVoteCount(@Nullable Integer value) {
        mContentValues.put(MovieColumns.VOTE_COUNT, value);
        return this;
    }

    public MovieContentValues putVoteCountNull() {
        mContentValues.putNull(MovieColumns.VOTE_COUNT);
        return this;
    }

    public MovieContentValues putAll(Movie movie) {
        if (null == movie) {
            return this;
        }

        Map map = new ObjectMapper().convertValue(movie, Map.class);

        putAdult((Boolean) map.get(MovieColumns.ADULT));

        putBackdropPath((String) map.get(MovieColumns.BACKDROP_PATH));

        putBudget((Long) map.get(MovieColumns.BUDGET));

        putFavorite((Boolean) map.get(MovieColumns.FAVORITE));

        putHomepage((String) map.get(MovieColumns.HOMEPAGE));

        putId((Long) map.get(MovieColumns.ID));

        putImdbId((String) map.get(MovieColumns.IMDB_ID));

        putOriginalTitle((String) map.get(MovieColumns.ORIGINAL_TITLE));

        putOverview((String) map.get(MovieColumns.OVERVIEW));

        putPopularity((Double) map.get(MovieColumns.POPULARITY));

        putPosterPath((String) map.get(MovieColumns.POSTER_PATH));

        putReleaseDate((String) map.get(MovieColumns.RELEASE_DATE));

        putRevenue((Long) map.get(MovieColumns.REVENUE));

        putRuntime((Integer) map.get(MovieColumns.RUNTIME));

        putStatus((String) map.get(MovieColumns.STATUS));

        putTagline((String) map.get(MovieColumns.TAGLINE));

        putTitle((String) map.get(MovieColumns.TITLE));

        putVoteAverage((Double) map.get(MovieColumns.VOTE_AVERAGE));

        putVoteCount((Integer) map.get(MovieColumns.VOTE_COUNT));

        return this;
    }
}
