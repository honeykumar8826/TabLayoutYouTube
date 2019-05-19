package com.tab;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "TAG";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*initialization of id*/
        inItId();
        /* adding the tabLayout*/
        addTabDynamically();
        setupTabIcons();
        /* adding the toolBar*/
        // addToolbar();
        /*adding the listener for the tabLayout*/
        listenerOnTab();
        /*adding the listener for the viewpager*/
        listenerOnViewPager();
        /*adding the adapter on viewpager*/
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
    }

    private void listenerOnViewPager() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
               /* if (tabLayout.getTabAt(i) != null) {*/
                    tabLayout.getTabAt(i).select();
                    Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show();
               /* }*/
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void listenerOnTab() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                int tabPosition = tab.getPosition();
                switch (tabPosition)
                {
                    case 0:
                        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#DD2C00"), PorterDuff.Mode.SRC_IN);
                        break;
                    case 1:
                        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#DD2C00"), PorterDuff.Mode.SRC_IN);
                        break;
                    case 2:
                        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#DD2C00"), PorterDuff.Mode.SRC_IN);
                        break;
                    case 3:
                        tabLayout.getTabAt(3).getIcon().setColorFilter(Color.parseColor("#DD2C00"), PorterDuff.Mode.SRC_IN);
                        break;
                    case 4:
                        tabLayout.getTabAt(4).getIcon().setColorFilter(Color.parseColor("#DD2C00"), PorterDuff.Mode.SRC_IN);
                        break;
                        default:
                            break;

                }
                Toast.makeText(MainActivity.this, "move", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabPosition = tab.getPosition();
                switch (tabPosition)
                {
                    case 0:
                        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#757575"), PorterDuff.Mode.SRC_IN);
                        break;
                        case 1:
                        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#757575"), PorterDuff.Mode.SRC_IN);
                        break;
                        case 2:
                        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#757575"), PorterDuff.Mode.SRC_IN);
                        break;
                        case 3:
                        tabLayout.getTabAt(3).getIcon().setColorFilter(Color.parseColor("#757575"), PorterDuff.Mode.SRC_IN);
                        break;
                        case 4:
                        tabLayout.getTabAt(4).getIcon().setColorFilter(Color.parseColor("#757575"), PorterDuff.Mode.SRC_IN);
                        break;
                        default:
                            break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void addTabDynamically() {
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Trending"));
        tabLayout.addTab(tabLayout.newTab().setText("Subscriptions"));
        tabLayout.addTab(tabLayout.newTab().setText("Inbox"));
        tabLayout.addTab(tabLayout.newTab().setText("Library"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    }

    private void inItId() {
        /*  toolbar = findViewById(R.id.toolbar);*/
        viewPager = findViewById(R.id.viewpager_chat);
        tabLayout = findViewById(R.id.tabLayoutChat);
        context = this;
    }

    private void setupTabIcons() {
        int tabIcons[] = {
                R.drawable.ic_home,
                R.drawable.ic_search,
                R.drawable.ic_subscriptions,
                R.drawable.ic_email_black_24dp,
                R.drawable.ic_tab
        };
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
    }
}
