package com.bignerdranch.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by lfs-ios on 2017/2/14.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
