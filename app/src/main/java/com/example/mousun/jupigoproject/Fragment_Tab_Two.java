package com.example.mousun.jupigoproject;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */

/*
 * This fragment creates three sub tabs under the tab two content
 */
public class Fragment_Tab_Two extends Fragment {

    private ViewPager mViewPager;

    public Fragment_Tab_Two() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_tab_two, container, false);

        mViewPager = (ViewPager) view.findViewById(R.id.container);
        SectionPageAdapter adapter = new SectionPageAdapter(getChildFragmentManager());
        adapter.addFragment(new Fragment_Sub_Tab_One(), "Sub Tab one");
        adapter.addFragment(new Fragment_Sub_Tab_Two(), "Sub Tab two");
        adapter.addFragment(new Fragment_Sub_Tab_Three(), "Sub Tab three");
        mViewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        return view;
    }
}
