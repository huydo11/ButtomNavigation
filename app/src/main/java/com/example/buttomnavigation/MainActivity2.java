package com.example.buttomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {
    private BottomNavigationView navView;
    private ViewPager vpView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        navView = findViewById(R.id.nav);
        vpView = findViewById(R.id.vpView);
        setUpViewPager();
        navView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        vpView.setCurrentItem(0);
                        break;
                    case R.id.bill:
                        vpView.setCurrentItem(1);
                        break;
                    case R.id.personnal:
                        vpView.setCurrentItem(2);
                        break;
                }
            }
        });
    }

    private void setUpViewPager() {
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpView.setAdapter(vpAdapter);
        vpView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        navView.getMenu().findItem(R.id.home).setChecked(true);
                        break;
                    case 1:
                        navView.getMenu().findItem(R.id.bill).setChecked(true);
                        break;
                    case 2:
                        navView.getMenu().findItem(R.id.personnal).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}