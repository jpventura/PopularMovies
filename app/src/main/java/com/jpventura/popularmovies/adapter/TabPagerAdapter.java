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
package com.jpventura.popularmovies.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jpventura.popularmovies.app.TabPageFragment;

import java.util.Locale;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {
    private String[] mPageTitles;

    public TabPagerAdapter(FragmentManager fm, String[] pageTitles) {
        super(fm);

        mPageTitles = pageTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return TabPageFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        try {
            return mPageTitles[position].toUpperCase(Locale.getDefault());
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
}
