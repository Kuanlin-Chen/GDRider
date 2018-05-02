package com.gdrider.gd;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import java.util.ArrayList;
import java.util.List;

import com.gdrider.gd.fragments.MainFragment;
import com.gdrider.gd.fragments.CartFragment;
import com.gdrider.gd.fragments.FavoFragment;
import com.gdrider.gd.fragments.SeekFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private final String label = "MainActivity:";
    private final String tag = "KeyCode";
    public static int KEYCODE = 0;
    public static char KEYCHAR = 'a';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
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

    @Override
    public boolean dispatchKeyEvent(KeyEvent event){
        System.out.println(label+(char)event.getUnicodeChar());
        KEYCHAR = (char)event.getUnicodeChar();
        KEYCODE = event.getKeyCode();
        return super.dispatchKeyEvent(event);
    }
}
