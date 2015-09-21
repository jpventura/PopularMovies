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

import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.jpventura.popularmovies.R;
import com.jpventura.popularmovies.adapter.TabPagerAdapter;

public class MainActivity extends AppCompatActivity
        implements TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener {
    private static final String VIEW_PAGER_CURRENT_ITEM = "VIEW_PAGER_KEY";

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

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main);

        // Set up the action bar.
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        String[] pageTitles = getResources().getStringArray(R.array.page_title);
        mTabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), pageTitles);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mTabPagerAdapter);
        mViewPager.addOnPageChangeListener(this);

        // Set up the TabLayout with the pager adapter.
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout.setOnTabSelectedListener(this);

        mTabLayout.setTabsFromPagerAdapter(mTabPagerAdapter);
        if ((null != state) && state.containsKey(VIEW_PAGER_CURRENT_ITEM)) {
            mViewPager.setCurrentItem(state.getInt(VIEW_PAGER_CURRENT_ITEM));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(VIEW_PAGER_CURRENT_ITEM, mViewPager.getCurrentItem());
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        mTabLayout.setScrollPosition(position, positionOffset, true);
    }

    public void onPageSelected(int position) {
        mTabLayout.setScrollPosition(position, 0, true);
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
