/*
 * Copyright (C) 2015 The Android Open Source Project
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
package com.jpventura.popularmovies.adapter;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jpventura.popularmovies.R;
import com.jpventura.popularmovies.widget.OnItemSelectedListener;
import com.jpventura.popularmovies.domain.provider.movie.MovieCursor;
import com.jpventura.popularmovies.domain.widget.CursorRecyclerAdapter;
import com.squareup.picasso.Picasso;

public class MovieAdapter extends CursorRecyclerAdapter<MovieAdapter.ViewHolder>
        implements View.OnClickListener {
    private static final int ITEM_SELECTED_DELAY = 20;

    private Context mContext;
    private OnItemSelectedListener<Bundle> mOnItemSelectedListener;

    public MovieAdapter(Context context, Cursor cursor) {
        super(cursor);
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_card, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolderCursor(ViewHolder holder, Cursor data) {
        Bundle bundle = new Bundle();
        MovieCursor cursor = new MovieCursor(data);
        bundle.putLong("_id", cursor.getBaseId());
        bundle.putLong("id", cursor.getId());
        holder.itemView.setTag(bundle);
        setPosterImage(holder, cursor.getPosterPath());
    }

    @Override
    public void onClick(final View view) {
        if (null == mOnItemSelectedListener) {
            return;
        }
        // Delay the OnItemSelectedListener just a little bit, so the ripple effect
        // animation can finish.
        Runnable selectItem = new Runnable() {
            @Override
            public void run() {
                mOnItemSelectedListener.onItemSelected(view, (Bundle) view.getTag());
            }
        };
        Handler handler = new Handler();
        handler.postDelayed(selectItem, ITEM_SELECTED_DELAY);
    }

    public void setOnItemSelectedListener(@Nullable OnItemSelectedListener<Bundle> listener) {
        mOnItemSelectedListener = listener;
    }

    private void setPosterImage(ViewHolder holder, String posterPath) {
        Picasso.with(mContext)
                .load(mContext.getString(R.string.tmdb_url_poster) + posterPath)
                .placeholder(R.drawable.placeholder)
                .into(holder.posterImage);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView posterImage;

        public ViewHolder(View item) {
            super(item);
            posterImage = (ImageView) item.findViewById(R.id.image_view_poster);
        }
    }
}
