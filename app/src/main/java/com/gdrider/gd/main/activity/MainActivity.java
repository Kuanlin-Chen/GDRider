package com.gdrider.gd.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import com.facebook.login.LoginManager;
import com.gdrider.gd.login.LoginActivity;
import com.gdrider.gd.main.custom.CustomViewPager;
import com.gdrider.gd.main.fragments.CartFragment;
import com.gdrider.gd.main.fragments.FavoFragment;
import com.gdrider.gd.main.fragments.MainFragment;
import com.gdrider.gd.main.fragments.SeekFragment;
import com.gdrider.gd.R;
import com.gdrider.gd.main.model.DataBase;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private CustomViewPager viewPager;
    private DrawerLayout drawerLayout;
    private final String label = "MainActivity:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initial Database
        DataBase.getInstance().initDB(this);
        //Just for testing
        if(DataBase.getInstance().getDB().getAllData().getCount()==0){
            DataBase.getInstance().getDB().insertData("1", "全罩式安全帽", "黑", 2700, R.drawable.gdemo, 0, 0);
            DataBase.getInstance().getDB().insertData("2", "半罩式安全帽", "白", 2000, R.drawable.gdemo, 0, 0);
            DataBase.getInstance().getDB().insertData("3", "全罩式安全帽", "藍", 2500, R.drawable.gdemo, 0, 0);
            DataBase.getInstance().getDB().insertData("4", "半罩式安全帽", "紅", 2600, R.drawable.gdemo, 0, 0);
        }

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.title);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer , R.string.closeDrawer){
            @Override
            public void onDrawerClosed(View drawerView) {
                super .onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super .onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //handle navigation click events
        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        //set item as selected to persist highlight
                        //close drawer when item is tapped
                        drawerLayout.closeDrawers();

                        //Add code here to update the UI based on the item selected
                        //For example, swap UI fragments here
                        switch (menuItem.getItemId()){
                            case R.id.navigation_item_logout:
                                LoginManager.getInstance().logOut();
                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                startActivity(intent);
                                MainActivity.this.finish();
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });

        viewPager = (CustomViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        //setupTabIcons();
    }

    private void setupViewPager(CustomViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MainFragment(), getString(R.string.title_main));
        adapter.addFragment(new CartFragment(), getString(R.string.title_cart));
        adapter.addFragment(new FavoFragment(), getString(R.string.title_favo));
        adapter.addFragment(new SeekFragment(), getString(R.string.title_seek));
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_menu_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_menu_cart);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_menu_favo);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_menu_seek);
    }
}
