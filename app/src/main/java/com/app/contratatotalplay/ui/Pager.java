package com.app.contratatotalplay.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.app.contratatotalplay.ui.paquetesdp.Paquetedp;
import com.app.contratatotalplay.ui.paquetesnetflix.Fragment_netflixpaqs;
import com.app.contratatotalplay.ui.paquetesnetflix.PaqueteNfxtp;
import com.app.contratatotalplay.ui.paquetestp.Paquetetp;

public class Pager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                Paquetetp tab1 = new Paquetetp();
                return tab1;
            case 1:
                Paquetedp tab2 = new Paquetedp();
                return tab2;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}
