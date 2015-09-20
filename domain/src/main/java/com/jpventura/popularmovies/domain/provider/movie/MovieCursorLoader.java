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

import android.content.Context;

import com.jpventura.popularmovies.domain.provider.base.AbstractCursorLoader;

public class MovieCursorLoader extends AbstractCursorLoader<MovieSelection> {
    public MovieCursorLoader(Context context, MovieSelection selection) {
        this(context, null, selection);
    }

    public MovieCursorLoader(Context context, String[] projection, MovieSelection selection) {
        super(context, projection, selection);
    }
}
