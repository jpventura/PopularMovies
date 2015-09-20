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

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jpventura.popularmovies.domain.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code movie} table.
 */
public class MovieCursor extends AbstractCursor implements MovieModel {
    public MovieCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getBaseId() {
        Long res = getLongOrNull(MovieColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code adult} value.
     * Can be {@code null}.
     */
    @Nullable
    public Boolean getAdult() {
        Boolean res = getBooleanOrNull(MovieColumns.ADULT);
        return res;
    }

    /**
     * Get the {@code backdrop_path} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getBackdropPath() {
        String res = getStringOrNull(MovieColumns.BACKDROP_PATH);
        return res;
    }

    /**
     * Get the {@code budget} value.
     * Can be {@code null}.
     */
    @Nullable
    public Long getBudget() {
        Long res = getLongOrNull(MovieColumns.BUDGET);
        return res;
    }

    /**
     * Get the {@code favorite} value.
     * Can be {@code null}.
     */
    @Nullable
    public Boolean getFavorite() {
        Boolean res = getBooleanOrNull(MovieColumns.FAVORITE);
        return res;
    }

    /**
     * Get the {@code homepage} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getHomepage() {
        String res = getStringOrNull(MovieColumns.HOMEPAGE);
        return res;
    }

    /**
     * Get the {@code id} value.
     */
    public long getId() {
        Long res = getLongOrNull(MovieColumns.ID);
        if (res == null)
            throw new NullPointerException("The value of 'id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code imdb_id} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getImdbId() {
        String res = getStringOrNull(MovieColumns.IMDB_ID);
        return res;
    }

    /**
     * Get the {@code original_title} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getOriginalTitle() {
        String res = getStringOrNull(MovieColumns.ORIGINAL_TITLE);
        return res;
    }

    /**
     * Get the {@code overview} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getOverview() {
        String res = getStringOrNull(MovieColumns.OVERVIEW);
        return res;
    }

    /**
     * Get the {@code popularity} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getPopularity() {
        Double res = getDoubleOrNull(MovieColumns.POPULARITY);
        return res;
    }

    /**
     * Get the {@code poster_path} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getPosterPath() {
        String res = getStringOrNull(MovieColumns.POSTER_PATH);
        if (res == null)
            throw new NullPointerException("The value of 'poster_path' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code release_date} value.
     * Can be {@code null}.
     */
    @Nullable
    public Date getReleaseDate() {
        Date res = getDateOrNull(MovieColumns.RELEASE_DATE);
        return res;
    }

    /**
     * Get the {@code revenue} value.
     * Can be {@code null}.
     */
    @Nullable
    public Long getRevenue() {
        Long res = getLongOrNull(MovieColumns.REVENUE);
        return res;
    }

    /**
     * Get the {@code runtime} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getRuntime() {
        Integer res = getIntegerOrNull(MovieColumns.RUNTIME);
        return res;
    }

    /**
     * Get the {@code status} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getStatus() {
        String res = getStringOrNull(MovieColumns.STATUS);
        return res;
    }

    /**
     * Get the {@code tagline} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getTagline() {
        String res = getStringOrNull(MovieColumns.TAGLINE);
        return res;
    }

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getTitle() {
        String res = getStringOrNull(MovieColumns.TITLE);
        return res;
    }

    /**
     * Get the {@code vote_average} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getVoteAverage() {
        Double res = getDoubleOrNull(MovieColumns.VOTE_AVERAGE);
        return res;
    }

    /**
     * Get the {@code vote_count} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getVoteCount() {
        Integer res = getIntegerOrNull(MovieColumns.VOTE_COUNT);
        return res;
    }
}
