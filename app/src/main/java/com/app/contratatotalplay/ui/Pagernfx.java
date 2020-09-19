package com.app.contratatotalplay.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.app.contratatotalplay.ui.paquetesdp.Paquetedp;
import com.app.contratatotalplay.ui.paquetesnetflix.PaqueteNfxdp;
import com.app.contratatotalplay.ui.paquetesnetflix.PaqueteNfxtp;
import com.app.contratatotalplay.ui.paquetestp.Paquetetp;

public class Pagernfx extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pagernfx(FragmentManager fmnfx, int tabCount) {
        super(fmnfx);
        //Initializing tab count
        this.tabCount = tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position4nfx) {
        //Returning the current tabs
        switch (position4nfx) {
            case 0:
                PaqueteNfxtp paquetetp = new PaqueteNfxtp();
                return paquetetp;
            case 1:
                PaqueteNfxdp tab2 = new PaqueteNfxdp();
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