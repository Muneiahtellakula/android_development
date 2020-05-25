package com.muneiah.android2020.TabNavigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.muneiah.android2020.R;

public class TabNavActivity extends AppCompatActivity {
    //Inisilize the views
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_nav);
        //connect the view id's from layout
        tabLayout = findViewById(R.id.tabl);
        viewPager = findViewById(R.id.viewp);
        //for viewpager set the adapter
        viewPager.setAdapter(new MyFragmentViewPager(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        //tab selcet listenter
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(TabNavActivity.this, "selected " + tab.getText().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Toast.makeText(TabNavActivity.this, "un-selected " + tab.getText().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(TabNavActivity.this, "re-selected " + tab.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    //Creating new Inner classs for adapter
    public class MyFragmentViewPager extends FragmentPagerAdapter {
        String titles[] = {"chats", "Calls", "Status"};

        public MyFragmentViewPager(@NonNull FragmentManager fm) {
            super(fm);
        }

        //getting tabs/fragments possions
        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new ChatFragment();
            }
            if (position == 1) {
                return new StatusFragment();
            }
            if (position == 2) {
                return new CallsFragment();
            }
            return null;
        }

        //size of the tabs
        @Override
        public int getCount() {
            return titles.length;
        }

        //for tabpage titiles
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
