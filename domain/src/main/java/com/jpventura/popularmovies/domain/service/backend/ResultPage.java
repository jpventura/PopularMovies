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

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultPage implements Parcelable {
    public int page;

    public List<Movie> results;

    @SerializedName("total_pages")
    public int totalPages;

    @SerializedName("total_results")
    public int totalResults;

    private ResultPage(Parcel source) {
        page = source.readInt();
        source.readTypedList(results, Movie.CREATOR);
        totalPages = source.readInt();
        totalResults = source.readInt();
    }

    public static final Parcelable.Creator<ResultPage> CREATOR = new Creator<ResultPage>() {
        @Override
        public ResultPage createFromParcel(Parcel source) {
            return new ResultPage(source);
        }

        @Override
        public ResultPage[] newArray(int size) {
            return new ResultPage[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(page);
        dest.writeTypedList(results);
        dest.writeInt(totalPages);
        dest.writeInt(totalResults);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this).toString();
    }
}
