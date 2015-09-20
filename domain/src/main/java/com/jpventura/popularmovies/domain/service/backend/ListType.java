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
package com.jpventura.popularmovies.domain.service.backend;

import android.util.Log;

public enum ListType {
    NOW_PLAYING("now_playing"),
    POPULAR("popular"),
    TOP_RATED("top_rated");

    private String listType;

    public static ListType valueOf(int val) {
        Log.e("ventura", "valueOf(" + Integer.toString(val)+ ")");
        try {
            return values()[val];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return listType;
    }

    ListType(String listType) {
        this.listType = listType;
    }
}
