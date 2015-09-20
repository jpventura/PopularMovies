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

import com.jpventura.popularmovies.domain.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Popular Movies Content Provider.
 */
public interface MovieModel extends BaseModel {

    /**
     * Get the {@code adult} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getAdult();

    /**
     * Get the {@code backdrop_path} value.
     * Can be {@code null}.
     */
    @Nullable
    String getBackdropPath();

    /**
     * Get the {@code budget} value.
     * Can be {@code null}.
     */
    @Nullable
    Long getBudget();

    /**
     * Get the {@code favorite} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getFavorite();

    /**
     * Get the {@code homepage} value.
     * Can be {@code null}.
     */
    @Nullable
    String getHomepage();

    /**
     * Get the {@code id} value.
     */
    long getId();

    /**
     * Get the {@code imdb_id} value.
     * Can be {@code null}.
     */
    @Nullable
    String getImdbId();

    /**
     * Get the {@code original_title} value.
     * Can be {@code null}.
     */
    @Nullable
    String getOriginalTitle();

    /**
     * Get the {@code overview} value.
     * Can be {@code null}.
     */
    @Nullable
    String getOverview();

    /**
     * Get the {@code popularity} value.
     * Can be {@code null}.
     */
    @Nullable
    Double getPopularity();

    /**
     * Get the {@code poster_path} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPosterPath();

    /**
     * Get the {@code release_date} value.
     * Can be {@code null}.
     */
    @Nullable
    Date getReleaseDate();

    /**
     * Get the {@code revenue} value.
     * Can be {@code null}.
     */
    @Nullable
    Long getRevenue();

    /**
     * Get the {@code runtime} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getRuntime();

    /**
     * Get the {@code status} value.
     * Can be {@code null}.
     */
    @Nullable
    String getStatus();

    /**
     * Get the {@code tagline} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTagline();

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTitle();

    /**
     * Get the {@code vote_average} value.
     * Can be {@code null}.
     */
    @Nullable
    Double getVoteAverage();

    /**
     * Get the {@code vote_count} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getVoteCount();
}
