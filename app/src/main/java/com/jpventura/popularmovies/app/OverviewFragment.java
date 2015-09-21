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

import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jpventura.popularmovies.R;
import com.jpventura.popularmovies.domain.provider.movie.MovieColumns;
import com.jpventura.popularmovies.domain.provider.movie.MovieCursor;
import com.jpventura.popularmovies.domain.provider.movie.MovieSelection;

import java.text.SimpleDateFormat;

public class OverviewFragment extends Fragment
        implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final String[] PROJECTION = {
            MovieColumns._ID,
            MovieColumns.OVERVIEW,
            MovieColumns.RELEASE_DATE,
            MovieColumns.TITLE,
            MovieColumns.VOTE_AVERAGE,
    };

    private TextView mTitleText;
    private TextView mSubtitleText;
    private TextView mOverviewText;
    private RatingBar mRatingBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        View rootView = inflater.inflate(R.layout.fragment_overview, container, false);

        mTitleText = (TextView) rootView.findViewById(R.id.text_title);
        mSubtitleText = (TextView) rootView.findViewById(R.id.subtitle);
        mRatingBar = (RatingBar) rootView.findViewById(R.id.rating_bar);
        mOverviewText = (TextView) rootView.findViewById(R.id.text_overview);

        mRatingBar = (RatingBar) rootView.findViewById(R.id.rating_bar);
        mRatingBar.setClickable(false);
        mRatingBar.setIsIndicator(true);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(CreateLoader.ID.toInteger(), getArguments(), this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int strategy, Bundle args) {
        MovieSelection selection = new MovieSelection().baseId(args.getLong(OverviewActivity.EXTRA_MOVIE_ID));
        return new CursorLoader(getContext(),
                MovieColumns.CONTENT_URI,
                PROJECTION,
                selection.sel(),
                selection.args(),
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        try {
            data.moveToFirst();
            MovieCursor movieCursor = new MovieCursor(data);
            mTitleText.setText(movieCursor.getTitle());
            mRatingBar.setRating(movieCursor.getVoteAverage().floatValue()/2);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
            mSubtitleText.setText(formatter.format(movieCursor.getReleaseDate()));
            mOverviewText.setText(movieCursor.getOverview());
        } catch (CursorIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
