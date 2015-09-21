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

import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.graphics.Palette.PaletteAsyncListener;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.jpventura.popularmovies.R;
import com.jpventura.popularmovies.domain.provider.movie.MovieColumns;
import com.jpventura.popularmovies.domain.provider.movie.MovieCursor;
import com.jpventura.popularmovies.domain.provider.movie.MovieSelection;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class OverviewActivity extends AppCompatActivity
        implements Callback, LoaderCallbacks<Cursor>, PaletteAsyncListener {

    public static final String EXTRA_BUNDLE = "bundle_movie_key";
    public static final String EXTRA_MOVIE_ID = "_id";

    private static final String[] PROJECTION = {
            MovieColumns._ID,
            MovieColumns.BACKDROP_PATH,
            MovieColumns.ID,
            MovieColumns.POSTER_PATH,
            MovieColumns.TITLE,
    };

    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;
    private ImageView mImageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        Bundle args = getIntent().getBundleExtra(EXTRA_BUNDLE);
        onCreateToolbar();
        getSupportLoaderManager().initLoader(CreateLoader.ID.toInteger(), args, this);
        addFragment(args);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int strategy, Bundle args) {
        MovieSelection selection = new MovieSelection().baseId(args.getLong(EXTRA_MOVIE_ID));

        return new CursorLoader(this,
                MovieColumns.CONTENT_URI,
                PROJECTION,
                selection.sel(),
                selection.args(),
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data.getCount() == 0) return;

        MovieCursor cursor = new MovieCursor(data);
        cursor.moveToFirst();
        String url = null == cursor.getBackdropPath() ?
                cursor.getPosterPath() : cursor.getBackdropPath();
        setBackgroundImage(getString(R.string.tmdb_url_backdrop) + url);
        setTitle(cursor.getTitle());
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    public void addFragment(Bundle bundle) {
        OverviewFragment fragment = new OverviewFragment();
        fragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, fragment)
                .commit();
    }

    protected void onCreateToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (isOrientationLandscape()) return;

        // Issue 176673: CollapsingToolbarLayout cannot be scrolled on landscape mode.
        // https://code.google.com/p/android/issues/detail?id=176673
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mCollapsingToolbarLayout.setExpandedTitleColor(getColour(android.R.color.transparent));

        // Issue 183166: CoordinatorLayout NullPointerException in onTouchEvent
        // https://code.google.com/p/android/issues/detail?id=183166
        mCollapsingToolbarLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }

    protected int getColour(int resourceId) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return ContextCompat.getColor(this, resourceId);
        } else {
            return getColor(resourceId);
        }
    }

    public void setBackgroundImage(String url) {
        mImageView = (ImageView) findViewById(R.id.image_view_background);
        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .into(mImageView, this);
    }

    @Override
    public void setTitle(CharSequence title) {
        if (isOrientationLandscape()) {
            getSupportActionBar().setTitle(title);
        } else {
            mCollapsingToolbarLayout.setTitle(title);
        }
    }

    @Override
    public void onGenerated(Palette palette) {
        if (isOrientationLandscape()) return;

        int colorPrimaryDark = palette.getDarkMutedColor(getColour(R.color.colorPrimaryDark));
        int colorPrimary = palette.getDarkMutedColor(getColour(R.color.colorPrimary));

        mCollapsingToolbarLayout.setStatusBarScrimColor(palette.getDarkMutedColor(colorPrimaryDark));
        mCollapsingToolbarLayout.setContentScrimColor(colorPrimary);
    }

    @Override
    public void onSuccess() {
        Bitmap bitmap = ((BitmapDrawable) mImageView.getDrawable()).getBitmap();
        Palette.from(bitmap).generate(this);
    }

    @Override
    public void onError() {
    }

    private boolean isOrientationLandscape() {
        return Configuration.ORIENTATION_LANDSCAPE == getResources().getConfiguration().orientation;
    }
}
