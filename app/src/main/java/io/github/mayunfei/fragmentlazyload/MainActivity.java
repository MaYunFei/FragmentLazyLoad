package io.github.mayunfei.fragmentlazyload;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MyViewPageAdapter myViewPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        myViewPageAdapter = new MyViewPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myViewPageAdapter);
        viewPager.setOffscreenPageLimit(1);
    }

    class MyViewPageAdapter extends FragmentStatePagerAdapter {

        public MyViewPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ShowFragment.getInstance(position);
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

}
