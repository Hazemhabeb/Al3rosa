package com.hazem.al3rosa.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.hazem.al3rosa.R;
import com.hazem.al3rosa.adapter.ViewPagerAdapter;
import com.hazem.al3rosa.fragment.dummyProductFragment;

public class Products extends AppCompatActivity {

    //inti the views
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        // inti the viewPager and set up it
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        //inti the tab layout and it's icons
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }


    /**
     * set up the view pager fragment
     *
     * @param viewPager refer to the viewPager view
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new dummyProductFragment(), "بوتوجاز");
        adapter.addFragment(new dummyProductFragment(), "غسالة");
        adapter.addFragment(new dummyProductFragment(), "سخان");
        adapter.addFragment(new dummyProductFragment(), "ميكرويف");
        adapter.addFragment(new dummyProductFragment(), "ميكرويف");
        adapter.addFragment(new dummyProductFragment(), "ميكرويف");
        adapter.addFragment(new dummyProductFragment(), "ميكرويف");

        viewPager.setAdapter(adapter);
    }
}
