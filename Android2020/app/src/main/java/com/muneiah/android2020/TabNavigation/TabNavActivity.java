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
TabLayout tabLayout;
ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_nav);
        tabLayout=findViewById(R.id.tabl);
        viewPager=findViewById(R.id.viewp);
        viewPager.setAdapter(new MyFragmentViewPager(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(TabNavActivity.this, "selected "+tab.getText().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Toast.makeText(TabNavActivity.this, "un-selected "+tab.getText().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(TabNavActivity.this, "re-selected "+tab.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    public class MyFragmentViewPager extends FragmentPagerAdapter{
        String titles[]={"chats","Calls","Status"};
        public MyFragmentViewPager(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if(position==0){
                return  new ChatFragment();
            }
            if (position==1){
                return  new StatusFragment();
            }
            if (position==2){
                return  new CallsFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
