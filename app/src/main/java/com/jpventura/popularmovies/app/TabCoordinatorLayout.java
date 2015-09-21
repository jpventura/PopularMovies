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

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import com.jpventura.popularmovies.adapter.TabPagerAdapter;

public class TabCoordinatorLayout extends CoordinatorLayout
        implements ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener {
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private TabPagerAdapter mTabPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private TabLayout mTabLayout;

    public TabCoordinatorLayout(Context context) {
        this(context, null);
    }

    public TabCoordinatorLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabCoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        mTabLayout.setScrollPosition(position, positionOffset, true);
    }

    public void onPageSelected(int position) {
    }

    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        // When the given tab is reselected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }
}
