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

import android.net.Uri;
import android.provider.BaseColumns;

import com.jpventura.popularmovies.domain.provider.PopularMoviesProvider;

/**
 * Popular Movies Content Provider.
 */
public class MovieColumns implements BaseColumns {
    public static final String TABLE_NAME = "movie";
    public static final Uri CONTENT_URI = Uri.parse(PopularMoviesProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String ADULT = "adult";

    public static final String BACKDROP_PATH = "backdrop_path";

    public static final String BUDGET = "budget";

    public static final String FAVORITE = "favorite";

    public static final String HOMEPAGE = "homepage";

    public static final String ID = "id";

    public static final String IMDB_ID = "imdb_id";

    public static final String ORIGINAL_TITLE = "original_title";

    public static final String OVERVIEW = "overview";

    public static final String POPULARITY = "popularity";

    public static final String POSTER_PATH = "poster_path";

    public static final String RELEASE_DATE = "release_date";

    public static final String REVENUE = "revenue";

    public static final String RUNTIME = "runtime";

    public static final String STATUS = "status";

    public static final String TAGLINE = "tagline";

    public static final String TITLE = "title";

    public static final String VOTE_AVERAGE = "vote_average";

    public static final String VOTE_COUNT = "vote_count";

    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            ADULT,
            BACKDROP_PATH,
            BUDGET,
            FAVORITE,
            HOMEPAGE,
            ID,
            IMDB_ID,
            ORIGINAL_TITLE,
            OVERVIEW,
            POPULARITY,
            POSTER_PATH,
            RELEASE_DATE,
            REVENUE,
            RUNTIME,
            STATUS,
            TAGLINE,
            TITLE,
            VOTE_AVERAGE,
            VOTE_COUNT
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(ADULT) || c.contains("." + ADULT)) return true;
            if (c.equals(BACKDROP_PATH) || c.contains("." + BACKDROP_PATH)) return true;
            if (c.equals(BUDGET) || c.contains("." + BUDGET)) return true;
            if (c.equals(FAVORITE) || c.contains("." + FAVORITE)) return true;
            if (c.equals(HOMEPAGE) || c.contains("." + HOMEPAGE)) return true;
            if (c.equals(ID) || c.contains("." + ID)) return true;
            if (c.equals(IMDB_ID) || c.contains("." + IMDB_ID)) return true;
            if (c.equals(ORIGINAL_TITLE) || c.contains("." + ORIGINAL_TITLE)) return true;
            if (c.equals(OVERVIEW) || c.contains("." + OVERVIEW)) return true;
            if (c.equals(POPULARITY) || c.contains("." + POPULARITY)) return true;
            if (c.equals(POSTER_PATH) || c.contains("." + POSTER_PATH)) return true;
            if (c.equals(RELEASE_DATE) || c.contains("." + RELEASE_DATE)) return true;
            if (c.equals(REVENUE) || c.contains("." + REVENUE)) return true;
            if (c.equals(RUNTIME) || c.contains("." + RUNTIME)) return true;
            if (c.equals(STATUS) || c.contains("." + STATUS)) return true;
            if (c.equals(TAGLINE) || c.contains("." + TAGLINE)) return true;
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(VOTE_AVERAGE) || c.contains("." + VOTE_AVERAGE)) return true;
            if (c.equals(VOTE_COUNT) || c.contains("." + VOTE_COUNT)) return true;
        }
        return false;
    }

}
