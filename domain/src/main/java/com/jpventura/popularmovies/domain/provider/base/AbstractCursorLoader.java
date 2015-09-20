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
package com.jpventura.popularmovies.domain.provider.base;

import android.content.Context;
import android.support.v4.content.CursorLoader;

public class AbstractCursorLoader<T extends AbstractSelection<?>> extends CursorLoader {
    public AbstractCursorLoader(Context context, T selection) {
        this(context, null, selection);
    }

    public AbstractCursorLoader(Context context, String[] projection, T selection) {
        super(context, selection.uri(), projection, selection.sel(), selection.args(), selection.order());
    }
}
