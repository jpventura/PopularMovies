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

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.jpventura.popularmovies.domain.provider.base.AbstractSelection;

/**
 * Selection for the {@code movie} table.
 */
public class MovieSelection extends AbstractSelection<MovieSelection> {
    @Override
    protected Uri baseUri() {
        return MovieColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MovieCursor} object, which is positioned before the first entry, or null.
     */
    public MovieCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MovieCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public MovieCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MovieCursor} object, which is positioned before the first entry, or null.
     */
    public MovieCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MovieCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public MovieCursor query(Context context) {
        return query(context, null);
    }


    public MovieSelection baseId(long... value) {
        addEquals("movie." + MovieColumns._ID, toObjectArray(value));
        return this;
    }

    public MovieSelection baseIdNot(long... value) {
        addNotEquals("movie." + MovieColumns._ID, toObjectArray(value));
        return this;
    }

    public MovieSelection orderByBaseId(boolean desc) {
        orderBy("movie." + MovieColumns._ID, desc);
        return this;
    }

    public MovieSelection orderByBaseId() {
        return orderByBaseId(false);
    }

    public MovieSelection adult(Boolean value) {
        addEquals(MovieColumns.ADULT, toObjectArray(value));
        return this;
    }

    public MovieSelection orderByAdult(boolean desc) {
        orderBy(MovieColumns.ADULT, desc);
        return this;
    }

    public MovieSelection orderByAdult() {
        orderBy(MovieColumns.ADULT, false);
        return this;
    }

    public MovieSelection backdropPath(String... value) {
        addEquals(MovieColumns.BACKDROP_PATH, value);
        return this;
    }

    public MovieSelection backdropPathNot(String... value) {
        addNotEquals(MovieColumns.BACKDROP_PATH, value);
        return this;
    }

    public MovieSelection backdropPathLike(String... value) {
        addLike(MovieColumns.BACKDROP_PATH, value);
        return this;
    }

    public MovieSelection backdropPathContains(String... value) {
        addContains(MovieColumns.BACKDROP_PATH, value);
        return this;
    }

    public MovieSelection backdropPathStartsWith(String... value) {
        addStartsWith(MovieColumns.BACKDROP_PATH, value);
        return this;
    }

    public MovieSelection backdropPathEndsWith(String... value) {
        addEndsWith(MovieColumns.BACKDROP_PATH, value);
        return this;
    }

    public MovieSelection orderByBackdropPath(boolean desc) {
        orderBy(MovieColumns.BACKDROP_PATH, desc);
        return this;
    }

    public MovieSelection orderByBackdropPath() {
        orderBy(MovieColumns.BACKDROP_PATH, false);
        return this;
    }

    public MovieSelection budget(Long... value) {
        addEquals(MovieColumns.BUDGET, value);
        return this;
    }

    public MovieSelection budgetNot(Long... value) {
        addNotEquals(MovieColumns.BUDGET, value);
        return this;
    }

    public MovieSelection budgetGt(long value) {
        addGreaterThan(MovieColumns.BUDGET, value);
        return this;
    }

    public MovieSelection budgetGtEq(long value) {
        addGreaterThanOrEquals(MovieColumns.BUDGET, value);
        return this;
    }

    public MovieSelection budgetLt(long value) {
        addLessThan(MovieColumns.BUDGET, value);
        return this;
    }

    public MovieSelection budgetLtEq(long value) {
        addLessThanOrEquals(MovieColumns.BUDGET, value);
        return this;
    }

    public MovieSelection orderByBudget(boolean desc) {
        orderBy(MovieColumns.BUDGET, desc);
        return this;
    }

    public MovieSelection orderByBudget() {
        orderBy(MovieColumns.BUDGET, false);
        return this;
    }

    public MovieSelection favorite(Boolean value) {
        addEquals(MovieColumns.FAVORITE, toObjectArray(value));
        return this;
    }

    public MovieSelection orderByFavorite(boolean desc) {
        orderBy(MovieColumns.FAVORITE, desc);
        return this;
    }

    public MovieSelection orderByFavorite() {
        orderBy(MovieColumns.FAVORITE, false);
        return this;
    }

    public MovieSelection homepage(String... value) {
        addEquals(MovieColumns.HOMEPAGE, value);
        return this;
    }

    public MovieSelection homepageNot(String... value) {
        addNotEquals(MovieColumns.HOMEPAGE, value);
        return this;
    }

    public MovieSelection homepageLike(String... value) {
        addLike(MovieColumns.HOMEPAGE, value);
        return this;
    }

    public MovieSelection homepageContains(String... value) {
        addContains(MovieColumns.HOMEPAGE, value);
        return this;
    }

    public MovieSelection homepageStartsWith(String... value) {
        addStartsWith(MovieColumns.HOMEPAGE, value);
        return this;
    }

    public MovieSelection homepageEndsWith(String... value) {
        addEndsWith(MovieColumns.HOMEPAGE, value);
        return this;
    }

    public MovieSelection orderByHomepage(boolean desc) {
        orderBy(MovieColumns.HOMEPAGE, desc);
        return this;
    }

    public MovieSelection orderByHomepage() {
        orderBy(MovieColumns.HOMEPAGE, false);
        return this;
    }

    public MovieSelection id(long... value) {
        addEquals(MovieColumns.ID, toObjectArray(value));
        return this;
    }

    public MovieSelection idNot(long... value) {
        addNotEquals(MovieColumns.ID, toObjectArray(value));
        return this;
    }

    public MovieSelection idGt(long value) {
        addGreaterThan(MovieColumns.ID, value);
        return this;
    }

    public MovieSelection idGtEq(long value) {
        addGreaterThanOrEquals(MovieColumns.ID, value);
        return this;
    }

    public MovieSelection idLt(long value) {
        addLessThan(MovieColumns.ID, value);
        return this;
    }

    public MovieSelection idLtEq(long value) {
        addLessThanOrEquals(MovieColumns.ID, value);
        return this;
    }

    public MovieSelection orderById(boolean desc) {
        orderBy(MovieColumns.ID, desc);
        return this;
    }

    public MovieSelection orderById() {
        orderBy(MovieColumns.ID, false);
        return this;
    }

    public MovieSelection imdbId(String... value) {
        addEquals(MovieColumns.IMDB_ID, value);
        return this;
    }

    public MovieSelection imdbIdNot(String... value) {
        addNotEquals(MovieColumns.IMDB_ID, value);
        return this;
    }

    public MovieSelection imdbIdLike(String... value) {
        addLike(MovieColumns.IMDB_ID, value);
        return this;
    }

    public MovieSelection imdbIdContains(String... value) {
        addContains(MovieColumns.IMDB_ID, value);
        return this;
    }

    public MovieSelection imdbIdStartsWith(String... value) {
        addStartsWith(MovieColumns.IMDB_ID, value);
        return this;
    }

    public MovieSelection imdbIdEndsWith(String... value) {
        addEndsWith(MovieColumns.IMDB_ID, value);
        return this;
    }

    public MovieSelection orderByImdbId(boolean desc) {
        orderBy(MovieColumns.IMDB_ID, desc);
        return this;
    }

    public MovieSelection orderByImdbId() {
        orderBy(MovieColumns.IMDB_ID, false);
        return this;
    }

    public MovieSelection originalTitle(String... value) {
        addEquals(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieSelection originalTitleNot(String... value) {
        addNotEquals(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieSelection originalTitleLike(String... value) {
        addLike(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieSelection originalTitleContains(String... value) {
        addContains(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieSelection originalTitleStartsWith(String... value) {
        addStartsWith(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieSelection originalTitleEndsWith(String... value) {
        addEndsWith(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieSelection orderByOriginalTitle(boolean desc) {
        orderBy(MovieColumns.ORIGINAL_TITLE, desc);
        return this;
    }

    public MovieSelection orderByOriginalTitle() {
        orderBy(MovieColumns.ORIGINAL_TITLE, false);
        return this;
    }

    public MovieSelection overview(String... value) {
        addEquals(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieSelection overviewNot(String... value) {
        addNotEquals(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieSelection overviewLike(String... value) {
        addLike(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieSelection overviewContains(String... value) {
        addContains(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieSelection overviewStartsWith(String... value) {
        addStartsWith(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieSelection overviewEndsWith(String... value) {
        addEndsWith(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieSelection orderByOverview(boolean desc) {
        orderBy(MovieColumns.OVERVIEW, desc);
        return this;
    }

    public MovieSelection orderByOverview() {
        orderBy(MovieColumns.OVERVIEW, false);
        return this;
    }

    public MovieSelection popularity(Double... value) {
        addEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieSelection popularityNot(Double... value) {
        addNotEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieSelection popularityGt(double value) {
        addGreaterThan(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieSelection popularityGtEq(double value) {
        addGreaterThanOrEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieSelection popularityLt(double value) {
        addLessThan(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieSelection popularityLtEq(double value) {
        addLessThanOrEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieSelection orderByPopularity(boolean desc) {
        orderBy(MovieColumns.POPULARITY, desc);
        return this;
    }

    public MovieSelection orderByPopularity() {
        orderBy(MovieColumns.POPULARITY, false);
        return this;
    }

    public MovieSelection posterPath(String... value) {
        addEquals(MovieColumns.POSTER_PATH, value);
        return this;
    }

    public MovieSelection posterPathNot(String... value) {
        addNotEquals(MovieColumns.POSTER_PATH, value);
        return this;
    }

    public MovieSelection posterPathLike(String... value) {
        addLike(MovieColumns.POSTER_PATH, value);
        return this;
    }

    public MovieSelection posterPathContains(String... value) {
        addContains(MovieColumns.POSTER_PATH, value);
        return this;
    }

    public MovieSelection posterPathStartsWith(String... value) {
        addStartsWith(MovieColumns.POSTER_PATH, value);
        return this;
    }

    public MovieSelection posterPathEndsWith(String... value) {
        addEndsWith(MovieColumns.POSTER_PATH, value);
        return this;
    }

    public MovieSelection orderByPosterPath(boolean desc) {
        orderBy(MovieColumns.POSTER_PATH, desc);
        return this;
    }

    public MovieSelection orderByPosterPath() {
        orderBy(MovieColumns.POSTER_PATH, false);
        return this;
    }

    public MovieSelection releaseDate(Date... value) {
        addEquals(MovieColumns.RELEASE_DATE, value);
        return this;
    }

    public MovieSelection releaseDateNot(Date... value) {
        addNotEquals(MovieColumns.RELEASE_DATE, value);
        return this;
    }

    public MovieSelection releaseDate(Long... value) {
        addEquals(MovieColumns.RELEASE_DATE, value);
        return this;
    }

    public MovieSelection releaseDateAfter(Date value) {
        addGreaterThan(MovieColumns.RELEASE_DATE, value);
        return this;
    }

    public MovieSelection releaseDateAfterEq(Date value) {
        addGreaterThanOrEquals(MovieColumns.RELEASE_DATE, value);
        return this;
    }

    public MovieSelection releaseDateBefore(Date value) {
        addLessThan(MovieColumns.RELEASE_DATE, value);
        return this;
    }

    public MovieSelection releaseDateBeforeEq(Date value) {
        addLessThanOrEquals(MovieColumns.RELEASE_DATE, value);
        return this;
    }

    public MovieSelection orderByReleaseDate(boolean desc) {
        orderBy(MovieColumns.RELEASE_DATE, desc);
        return this;
    }

    public MovieSelection orderByReleaseDate() {
        orderBy(MovieColumns.RELEASE_DATE, false);
        return this;
    }

    public MovieSelection revenue(Long... value) {
        addEquals(MovieColumns.REVENUE, value);
        return this;
    }

    public MovieSelection revenueNot(Long... value) {
        addNotEquals(MovieColumns.REVENUE, value);
        return this;
    }

    public MovieSelection revenueGt(long value) {
        addGreaterThan(MovieColumns.REVENUE, value);
        return this;
    }

    public MovieSelection revenueGtEq(long value) {
        addGreaterThanOrEquals(MovieColumns.REVENUE, value);
        return this;
    }

    public MovieSelection revenueLt(long value) {
        addLessThan(MovieColumns.REVENUE, value);
        return this;
    }

    public MovieSelection revenueLtEq(long value) {
        addLessThanOrEquals(MovieColumns.REVENUE, value);
        return this;
    }

    public MovieSelection orderByRevenue(boolean desc) {
        orderBy(MovieColumns.REVENUE, desc);
        return this;
    }

    public MovieSelection orderByRevenue() {
        orderBy(MovieColumns.REVENUE, false);
        return this;
    }

    public MovieSelection runtime(Integer... value) {
        addEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieSelection runtimeNot(Integer... value) {
        addNotEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieSelection runtimeGt(int value) {
        addGreaterThan(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieSelection runtimeGtEq(int value) {
        addGreaterThanOrEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieSelection runtimeLt(int value) {
        addLessThan(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieSelection runtimeLtEq(int value) {
        addLessThanOrEquals(MovieColumns.RUNTIME, value);
        return this;
    }

    public MovieSelection orderByRuntime(boolean desc) {
        orderBy(MovieColumns.RUNTIME, desc);
        return this;
    }

    public MovieSelection orderByRuntime() {
        orderBy(MovieColumns.RUNTIME, false);
        return this;
    }

    public MovieSelection status(String... value) {
        addEquals(MovieColumns.STATUS, value);
        return this;
    }

    public MovieSelection statusNot(String... value) {
        addNotEquals(MovieColumns.STATUS, value);
        return this;
    }

    public MovieSelection statusLike(String... value) {
        addLike(MovieColumns.STATUS, value);
        return this;
    }

    public MovieSelection statusContains(String... value) {
        addContains(MovieColumns.STATUS, value);
        return this;
    }

    public MovieSelection statusStartsWith(String... value) {
        addStartsWith(MovieColumns.STATUS, value);
        return this;
    }

    public MovieSelection statusEndsWith(String... value) {
        addEndsWith(MovieColumns.STATUS, value);
        return this;
    }

    public MovieSelection orderByStatus(boolean desc) {
        orderBy(MovieColumns.STATUS, desc);
        return this;
    }

    public MovieSelection orderByStatus() {
        orderBy(MovieColumns.STATUS, false);
        return this;
    }

    public MovieSelection tagline(String... value) {
        addEquals(MovieColumns.TAGLINE, value);
        return this;
    }

    public MovieSelection taglineNot(String... value) {
        addNotEquals(MovieColumns.TAGLINE, value);
        return this;
    }

    public MovieSelection taglineLike(String... value) {
        addLike(MovieColumns.TAGLINE, value);
        return this;
    }

    public MovieSelection taglineContains(String... value) {
        addContains(MovieColumns.TAGLINE, value);
        return this;
    }

    public MovieSelection taglineStartsWith(String... value) {
        addStartsWith(MovieColumns.TAGLINE, value);
        return this;
    }

    public MovieSelection taglineEndsWith(String... value) {
        addEndsWith(MovieColumns.TAGLINE, value);
        return this;
    }

    public MovieSelection orderByTagline(boolean desc) {
        orderBy(MovieColumns.TAGLINE, desc);
        return this;
    }

    public MovieSelection orderByTagline() {
        orderBy(MovieColumns.TAGLINE, false);
        return this;
    }

    public MovieSelection title(String... value) {
        addEquals(MovieColumns.TITLE, value);
        return this;
    }

    public MovieSelection titleNot(String... value) {
        addNotEquals(MovieColumns.TITLE, value);
        return this;
    }

    public MovieSelection titleLike(String... value) {
        addLike(MovieColumns.TITLE, value);
        return this;
    }

    public MovieSelection titleContains(String... value) {
        addContains(MovieColumns.TITLE, value);
        return this;
    }

    public MovieSelection titleStartsWith(String... value) {
        addStartsWith(MovieColumns.TITLE, value);
        return this;
    }

    public MovieSelection titleEndsWith(String... value) {
        addEndsWith(MovieColumns.TITLE, value);
        return this;
    }

    public MovieSelection orderByTitle(boolean desc) {
        orderBy(MovieColumns.TITLE, desc);
        return this;
    }

    public MovieSelection orderByTitle() {
        orderBy(MovieColumns.TITLE, false);
        return this;
    }

    public MovieSelection voteAverage(Double... value) {
        addEquals(MovieColumns.VOTE_AVERAGE, value);
        return this;
    }

    public MovieSelection voteAverageNot(Double... value) {
        addNotEquals(MovieColumns.VOTE_AVERAGE, value);
        return this;
    }

    public MovieSelection voteAverageGt(double value) {
        addGreaterThan(MovieColumns.VOTE_AVERAGE, value);
        return this;
    }

    public MovieSelection voteAverageGtEq(double value) {
        addGreaterThanOrEquals(MovieColumns.VOTE_AVERAGE, value);
        return this;
    }

    public MovieSelection voteAverageLt(double value) {
        addLessThan(MovieColumns.VOTE_AVERAGE, value);
        return this;
    }

    public MovieSelection voteAverageLtEq(double value) {
        addLessThanOrEquals(MovieColumns.VOTE_AVERAGE, value);
        return this;
    }

    public MovieSelection orderByVoteAverage(boolean desc) {
        orderBy(MovieColumns.VOTE_AVERAGE, desc);
        return this;
    }

    public MovieSelection orderByVoteAverage() {
        orderBy(MovieColumns.VOTE_AVERAGE, false);
        return this;
    }

    public MovieSelection voteCount(Integer... value) {
        addEquals(MovieColumns.VOTE_COUNT, value);
        return this;
    }

    public MovieSelection voteCountNot(Integer... value) {
        addNotEquals(MovieColumns.VOTE_COUNT, value);
        return this;
    }

    public MovieSelection voteCountGt(int value) {
        addGreaterThan(MovieColumns.VOTE_COUNT, value);
        return this;
    }

    public MovieSelection voteCountGtEq(int value) {
        addGreaterThanOrEquals(MovieColumns.VOTE_COUNT, value);
        return this;
    }

    public MovieSelection voteCountLt(int value) {
        addLessThan(MovieColumns.VOTE_COUNT, value);
        return this;
    }

    public MovieSelection voteCountLtEq(int value) {
        addLessThanOrEquals(MovieColumns.VOTE_COUNT, value);
        return this;
    }

    public MovieSelection orderByVoteCount(boolean desc) {
        orderBy(MovieColumns.VOTE_COUNT, desc);
        return this;
    }

    public MovieSelection orderByVoteCount() {
        orderBy(MovieColumns.VOTE_COUNT, false);
        return this;
    }
}
