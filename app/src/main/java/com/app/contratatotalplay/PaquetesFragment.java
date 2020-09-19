package com.app.contratatotalplay;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.app.contratatotalplay.ui.Pager;
import com.google.android.material.tabs.TabLayout;

public class PaquetesFragment extends Fragment {

    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_paquetes, container, false);


        final TabLayout tabLayout = view.findViewById(R.id.tab4packs);

        tabLayout.addTab(tabLayout.newTab().setText("Paquetes TriplePlay"));
        tabLayout.addTab(tabLayout.newTab().setText("Paquetes DoublePlay"));
        /*tabLayout.addTab(tabLayout.newTab().setText("Paquetes con netflix"));*/

        final ViewPager viewPager =  view.findViewById(R.id.pager4packs);

        //Creating our pager adapter
        Pager adapter = new Pager(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views

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
                    tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#000000"));
                } else if (viewPager.getCurrentItem() == 1) {
                    tabLayout.selectTab(tabLayout.getTabAt(1));
                    tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#000000"));
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

