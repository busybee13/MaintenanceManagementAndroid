package com.torchacademy.maintenancemanagement.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.torchacademy.maintenancemanagement.fragments.FragmentUserRequestsAll;
import com.torchacademy.maintenancemanagement.fragments.FragmentUserRequestsCompleted;
import com.torchacademy.maintenancemanagement.fragments.FragmentUserRequestsOngoing;
import com.torchacademy.maintenancemanagement.fragments.FragmentUserRequestsPending;

/**
 * Created by omar.halabi on 6/23/2016.
 */
public class RequestAdapter extends FragmentPagerAdapter{

    public RequestAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentUserRequestsAll();
                break;
            case 1:
                fragment = new FragmentUserRequestsPending();
                break;
            case 2:
                fragment = new FragmentUserRequestsOngoing();
                break;
            case 3:
                fragment = new FragmentUserRequestsCompleted();
                break;
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Frag " + position;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
