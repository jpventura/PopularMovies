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
package com.jpventura.popularmovies.domain.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.jpventura.popularmovies.domain.BuildConfig;
import com.jpventura.popularmovies.domain.provider.movie.MovieColumns;

public class PopularMoviesDB extends SQLiteOpenHelper {
    private static final String TAG = PopularMoviesDB.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "popular_movies.db";
    private static final int DATABASE_VERSION = 1;
    private static PopularMoviesDB sInstance;
    private final Context mContext;
    private final PopularMoviesDBCallbacks mOpenHelperCallbacks;

    // @formatter:off
    public static final String SQL_CREATE_TABLE_MOVIE = "CREATE TABLE IF NOT EXISTS "
            + MovieColumns.TABLE_NAME + " ( "
            + MovieColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + MovieColumns.ADULT + " INTEGER, "
            + MovieColumns.BACKDROP_PATH + " TEXT, "
            + MovieColumns.BUDGET + " INTEGER, "
            + MovieColumns.FAVORITE + " INTEGER DEFAULT 0, "
            + MovieColumns.HOMEPAGE + " TEXT, "
            + MovieColumns.ID + " INTEGER NOT NULL, "
            + MovieColumns.IMDB_ID + " TEXT, "
            + MovieColumns.ORIGINAL_TITLE + " TEXT, "
            + MovieColumns.OVERVIEW + " TEXT, "
            + MovieColumns.POPULARITY + " REAL, "
            + MovieColumns.POSTER_PATH + " TEXT NOT NULL, "
            + MovieColumns.RELEASE_DATE + " INTEGER, "
            + MovieColumns.REVENUE + " INTEGER, "
            + MovieColumns.RUNTIME + " INTEGER, "
            + MovieColumns.STATUS + " TEXT, "
            + MovieColumns.TAGLINE + " TEXT, "
            + MovieColumns.TITLE + " TEXT, "
            + MovieColumns.VOTE_AVERAGE + " REAL, "
            + MovieColumns.VOTE_COUNT + " INTEGER "
            + ", CONSTRAINT UNIQUE_ID UNIQUE (" + MovieColumns.ID + ") ON CONFLICT REPLACE"
            + " );";

    // @formatter:on

    public static PopularMoviesDB getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static PopularMoviesDB newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static PopularMoviesDB newInstancePreHoneycomb(Context context) {
        return new PopularMoviesDB(context);
    }

    private PopularMoviesDB(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new PopularMoviesDBCallbacks();
    }

    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static PopularMoviesDB newInstancePostHoneycomb(Context context) {
        return new PopularMoviesDB(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private PopularMoviesDB(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new PopularMoviesDBCallbacks();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_MOVIE);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
