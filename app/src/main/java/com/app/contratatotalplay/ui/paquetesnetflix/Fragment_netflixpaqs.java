package com.app.contratatotalplay.ui.paquetesnetflix;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.app.contratatotalplay.R;
import com.app.contratatotalplay.ui.Pager;
import com.app.contratatotalplay.ui.Pagernfx;
import com.google.android.material.tabs.TabLayout;

public class Fragment_netflixpaqs extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_paquetesnfxs, container, false);

        final TabLayout tabLayout = view.findViewById(R.id.tab4packsnfx);

        tabLayout.addTab(tabLayout.newTab().setText("TriplePlay"));
        tabLayout.addTab(tabLayout.newTab().setText("DoublePlay"));

        final ViewPager viewPager =  view.findViewById(R.id.pager4packsnfx);

        Pagernfx adapter = new Pagernfx(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (viewPager.getCurrentItem() == 0){
                    tabLayout.selectTab(tabLayout.getTabAt(0));
                    tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF0000"));
                } else if (viewPager.getCurrentItem() == 1) {
                    tabLayout.selectTab(tabLayout.getTabAt(1));
                    tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF0000"));
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }
}
