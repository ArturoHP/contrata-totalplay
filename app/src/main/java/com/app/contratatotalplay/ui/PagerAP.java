package com.app.contratatotalplay.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.app.contratatotalplay.ui.paquetesnetflix.PaqueteNfxdp;
import com.app.contratatotalplay.ui.paquetesnetflix.PaqueteNfxtp;

public class PagerAP extends FragmentStatePagerAdapter {
    int tabCount;

    public PagerAP(FragmentManager fmnfx, int tabCount) {
        super(fmnfx);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position4AP) {
        //Returning the current tabs
        switch (position4AP) {
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

    @Override
    public int getCount() {
        return tabCount;
    }
}
