package com.example.flowers.adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.flowers.models.Tab;

import java.util.ArrayList;

public class FraAdapter extends FragmentStatePagerAdapter {
    ArrayList<Tab>tabs = new ArrayList<>();
    public FraAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addTab(Tab tab){
        tabs.add(tab);
    }
    @Override
    public Fragment getItem(int i) {
     return tabs.get(i).getFragment();
    }

    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }
    @Override
    public int getCount() {
        return tabs.size();
    }
}
