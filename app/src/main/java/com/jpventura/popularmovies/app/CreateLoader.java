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
package com.jpventura.popularmovies.app;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

import com.jpventura.popularmovies.domain.provider.movie.MovieColumns;
import com.jpventura.popularmovies.domain.provider.movie.MovieSelection;

import java.util.Calendar;

/**
 * Define {@link CursorLoader} creation strategies.
 *
 * @see <a href="https://sourcemaking.com/design_patterns/strategy">Strategy Design Pattern</a>
 */
public enum CreateLoader {
    NOW_PLAYING("now_playing") {
        @Override
        public Loader<Cursor> execute(Context context, String[] projection) {
            Calendar minimum = Calendar.getInstance();
            minimum.add(Calendar.MONTH, -1);

            Calendar maximum = Calendar.getInstance();
            maximum.add(Calendar.DAY_OF_YEAR, 7);

            MovieSelection selection = new MovieSelection();
            selection.releaseDateAfterEq(minimum.getTime())
                    .and()
                    .releaseDateBeforeEq(maximum.getTime())
                    .orderByReleaseDate(true);

            return execute(context, projection, selection);
        }
    },
    POPULAR("popular") {
        @Override
        public Loader<Cursor> execute(Context context, String[] projection) {
            MovieSelection selection = new MovieSelection()
                    .popularityGtEq(6)
                    .and()
                    .voteCountGtEq(10)
                    .orderByPopularity(true);
            return execute(context, projection, selection);
        }
    },
    TOP_RATED("top_rated") {
        @Override
        public Loader<Cursor> execute(Context context, String[] projection) {
            MovieSelection selection = new MovieSelection()
                    .voteAverageGtEq(6)
                    .and()
                    .voteCountGtEq(10)
                    .orderByVoteAverage(true);
            return execute(context, projection, selection);
        }
    },
    ID("id") {
        @Override
        public Loader<Cursor> execute(Context context, String[] projection) {
            MovieSelection selection = new MovieSelection();
            return execute(context, projection, selection);
        }
    };

    /**
     * @param context The application context.
     * @param projection The database columns to be selected.
     *
     * @return {@link CursorLoader} New {@link CursorLoader} obtained according to
     *         {@link CreateLoader#strategy} value.
     */
    public abstract Loader<Cursor> execute(Context context, String[] projection);

    public static CreateLoader valueOf(int strategy) throws IllegalArgumentException {
        try {
            return values()[strategy];
        } catch (ArrayIndexOutOfBoundsException e) {
            String error = "Unknown CreateLoader strategy: " + Integer.toString(strategy);
            throw new IllegalArgumentException(error);
        }
    }

    /**
     * @param context The application context.
     *
     * @return {@link CursorLoader} New {@link CursorLoader} obtained according to
     *         {@link CreateLoader#strategy} value.
     */
    public Loader<Cursor> execute(Context context) {
        return execute(context, MovieColumns.ALL_COLUMNS);
    }

    /**
     * @param context The application context.
     * @param id The movie ID on a <href="http://docs.themoviedb.apiary.io/#">The Movie DB</a>.
     *
     * @return {@link CursorLoader} New {@link CursorLoader} obtained according to
     *         {@link CreateLoader#strategy} value.
     */
    public Loader<Cursor> execute(Context context, long id) {
        return execute(context, MovieColumns.ALL_COLUMNS, id);
    }

    /**
     * @param context The application context.
     * @param projection The database columns to be selected.
     * @param id The movie ID on a <href="http://docs.themoviedb.apiary.io/#">The Movie DB</a>.
     *
     * @return {@link CursorLoader} New {@link CursorLoader} obtained according to
     *         {@link CreateLoader#strategy} value.
     */
    public Loader<Cursor> execute(Context context, String[] projection, long id) {
        MovieSelection movie = new MovieSelection().id(id);
        final Uri uri = movie.uri();
        final String selection = movie.sel();
        final String[] arguments = movie.args();
        final String order = movie.order();
        return new CursorLoader(context, uri, projection, selection, arguments, order);
    }

    public Integer toInteger() {
        return ordinal();
    }

    @Override
    public String toString() {
        return strategy;
    }

    public boolean equals(String strategy) {
        return strategy.equals(this.strategy);
    }

    protected Loader<Cursor> execute(Context context, String[] projection, MovieSelection movie) {
        final Uri uri = movie.uri();
        final String selection = movie.sel();
        final String[] arguments = movie.args();
        final String order = movie.order();
        return new CursorLoader(context, uri, projection, selection, arguments, order);
    }

    CreateLoader(String strategy) {
        this.strategy = strategy;
    }

    private String strategy;
}
