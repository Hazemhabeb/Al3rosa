package com.hazem.al3rosa.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.hazem.al3rosa.R;
import com.hazem.al3rosa.adapter.ViewPagerAdapter;
import com.hazem.al3rosa.fragment.ProfileFragment;
import com.hazem.al3rosa.fragment.dummyFragment;

public class MainActivity extends AppCompatActivity {

    //the icons of tablayout  icon white  don't selected
    private int[] tabIcons = {
            R.drawable.home_gray,
            R.drawable.magnify_gray,
            R.drawable.heart_gray,
            R.drawable.account_gray
    };
    // icon of tab layout selected blue icons
    private int[] tabIconsSelected = {
            R.drawable.home,
            R.drawable.magnify,
            R.drawable.heart,
            R.drawable.account
    };

    //inti the views
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inti the viewPager and set up it
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        //inti the tab layout and it's icons
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    /**
     * set up the view pager fragment
     *
     * @param viewPager refer to the viewPager view
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new dummyFragment(), "");
        adapter.addFragment(new dummyFragment(), "");
        adapter.addFragment(new dummyFragment(), "");
        adapter.addFragment(new ProfileFragment(), "");
        viewPager.setAdapter(adapter);
    }


    /**
     * set up the tab icons to the tab layout and inti the custom view to it
     */
    private void setupTabIcons() {
        final View view0 = getLayoutInflater().inflate(R.layout.custom_tab, null);
        ((ImageView) view0.findViewById(R.id.image_tab)).setImageResource(R.drawable.home);
        tabLayout.getTabAt(0).setCustomView(view0);

        View view1 = getLayoutInflater().inflate(R.layout.custom_tab, null);
        ((ImageView) view1.findViewById(R.id.image_tab)).setImageResource(tabIcons[1]);
        tabLayout.getTabAt(1).setCustomView(view1);

        View view2 = getLayoutInflater().inflate(R.layout.custom_tab, null);
        ((ImageView) view2.findViewById(R.id.image_tab)).setImageResource(tabIcons[2]);
        tabLayout.getTabAt(2).setCustomView(view2);

        View view3 = getLayoutInflater().inflate(R.layout.custom_tab, null);
        ((ImageView) view3.findViewById(R.id.image_tab)).setImageResource(tabIcons[3]);
        tabLayout.getTabAt(3).setCustomView(view3);


        final View[] selectedImageResources = {view0, view1,view2,view3};

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ((ImageView) selectedImageResources[tab.getPosition()].findViewById(R.id.image_tab))
                        .setImageResource(tabIconsSelected[tab.getPosition()]);

                tab.setCustomView(selectedImageResources[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ((ImageView) selectedImageResources[tab.getPosition()].findViewById(R.id.image_tab))
                        .setImageResource(tabIcons[tab.getPosition()]);

                tab.setCustomView(selectedImageResources[tab.getPosition()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
