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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.common.collect.ImmutableMap;
import com.jpventura.popularmovies.R;

import java.util.Map;

/**
 * A placeholder fragment containing a simple view.
 */
public class TabPageFragment extends Fragment {
    private static Map<Integer, TabPageFragment> sPageFragments = ImmutableMap.of(
            new Integer(0), new TabPageFragment(),
            new Integer(1), new TabPageFragment(),
            new Integer(2), new TabPageFragment()
    );

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static TabPageFragment getInstance(int sectionNumber) {
        TabPageFragment fragment = sPageFragments.get(sectionNumber);

        if (null != fragment) {
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
        }

        return fragment;
    }

    public TabPageFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        View rootView = inflater.inflate(R.layout.fragment_grid, container, false);
        return rootView;
    }

    public static int getCount() {
        return sPageFragments.size();
    }
}
