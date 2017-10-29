package com.example.mousun.jupigoproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */

/*
 * This fragment inflates the sub one tab
 */
public class Fragment_Sub_Tab_One extends Fragment {

    EditText mFood;

    public Fragment_Sub_Tab_One() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_sub_tab_one, container, false);

        mFood = (EditText) view.findViewById(R.id.food);

        return view;
    }

}
