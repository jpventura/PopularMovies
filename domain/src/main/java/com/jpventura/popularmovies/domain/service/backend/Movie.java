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

import java.util.ArrayList;
import java.util.List;

public class Movie implements Parcelable {
    public long id;

    public String title;

    public String original_title;

    public double popularity;

    public String backdrop_path;

    public String poster_path;

    public String release_date;

    public boolean adult;

    public long budget;

    public List<Genre> genres;

    public String homepage;

    public String overview;

    public String imdb_id;

    public long revenue;

    public int runtime;

    public String tagline;

    public double vote_average;

    public int vote_count;

    public String status;

    public Collection belongs_to_collection;

    private Movie() {
        genres = new ArrayList<>();
    }

    private Movie(Parcel source) {
        this();
        id = source.readLong();
        title = source.readString();
        original_title = source.readString();
        popularity = source.readDouble();
        backdrop_path = source.readString();
        poster_path= source.readString();
        release_date = source.readString();
        adult = source.readInt() == 1;
        budget = source.readLong();
        source.readTypedList(genres, Genre.CREATOR);
        homepage = source.readString();
        overview = source.readString();
        imdb_id = source.readString();
        revenue = source.readLong();
        runtime = source.readInt();
        tagline = source.readString();
        vote_average = source.readDouble();
        vote_count = source.readInt();
        status = source.readString();
        belongs_to_collection = source.readParcelable(Collection.class.getClassLoader());
    }

    public static final Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeString(original_title);
        dest.writeDouble(popularity);
        dest.writeString(backdrop_path);
        dest.writeString(poster_path);
        dest.writeString(release_date);
        dest.writeInt(adult ? 1 : 0);
        dest.writeLong(budget);
        dest.writeTypedList(genres);
        dest.writeString(homepage);
        dest.writeString(overview);
        dest.writeString(imdb_id);
        dest.writeLong(revenue);
        dest.writeInt(runtime);
        dest.writeString(tagline);
        dest.writeDouble(vote_average);
        dest.writeInt(vote_count);
        dest.writeString(status);
        dest.writeParcelable(belongs_to_collection, 0);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this).toString();
    }
}
