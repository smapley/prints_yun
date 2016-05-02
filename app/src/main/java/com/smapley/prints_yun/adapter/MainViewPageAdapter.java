package com.smapley.prints_yun.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by smapley on 15/10/15.
 */
public class MainViewPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> list ;

    public MainViewPageAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }
    public void setList(List<Fragment> list){
        this.list=list;
        notifyDataSetChanged();

    }


    public void addItem(Fragment fragment){
        this.list.add(fragment);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        if(list==null){
            return 0;
        }else {
            return list.size();
        }
    }
}
