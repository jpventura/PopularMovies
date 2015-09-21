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

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jpventura.popularmovies.R;
import com.jpventura.popularmovies.adapter.MovieAdapter;
import com.jpventura.popularmovies.domain.provider.movie.MovieColumns;
import com.jpventura.popularmovies.widget.OnItemSelectedListener;

public class TabPageFragment extends Fragment
        implements LoaderCallbacks<Cursor>, OnItemSelectedListener<Bundle> {
    public static final String FRAGMENT_LOADER_STRATEGY = "loader_id";

    private static final String[] PROJECTION = {
            MovieColumns._ID,
            MovieColumns.ID,
            MovieColumns.POSTER_PATH
    };

    private static final int SPAN_PORTRAIT = 2;
    private static final int SPAN_LANDSCAPE = 3;

    private MovieAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private LayoutManager mLayoutManager;

    public static Fragment newInstance(int position) {
        Fragment fragment = new TabPageFragment();
        Bundle args = new Bundle();
        args.putInt(FRAGMENT_LOADER_STRATEGY, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        int strategy = getArguments().getInt(FRAGMENT_LOADER_STRATEGY);
        getLoaderManager().initLoader(strategy, Bundle.EMPTY, this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle instanceState) {
        mAdapter = new MovieAdapter(getContext(), null);
        mAdapter.setOnItemSelectedListener(this);

        View root = inflater.inflate(R.layout.fragment_page, container, false);

        mLayoutManager = new GridLayoutManager(getContext(), getSpanCount());

        mRecyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        return root;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int loaderStrategy, Bundle args) {
        return CreateLoader.valueOf(loaderStrategy).execute(getContext(), PROJECTION);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }


    @Override
    public void onItemSelected(View view, Bundle movie) {
        Intent intent = new Intent(getActivity(), OverviewActivity.class);
        intent.putExtra(OverviewActivity.EXTRA_BUNDLE, movie);
        startActivity(intent);
    }

    /**
     * @return The the span count according the device rotation.
     */
    protected int getSpanCount() {
        int orientation = getResources().getConfiguration().orientation;
        return Configuration.ORIENTATION_LANDSCAPE == orientation ? SPAN_LANDSCAPE : SPAN_PORTRAIT;
    }
}
