package com.example.restraunt;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainCourseAdapter extends FragmentPagerAdapter {
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;
    public MainCourseAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext=context;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }
    @Override
    public Fragment getItem(int i) {
        Fragment fragment=null;
        switch (i){
            case 0:
                //fragment=new St_Veg();
                fragment= new Main_Veg();
                break;
            case 1:
                fragment=new Main_Non();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
