package com.torchacademy.maintenancemanagement;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by omar.halabi on 6/23/2016.
 */
public class RequestAdapter extends FragmentPagerAdapter{

    public RequestAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
