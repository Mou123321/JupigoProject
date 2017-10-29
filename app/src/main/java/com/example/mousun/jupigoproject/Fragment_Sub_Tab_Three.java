package com.example.mousun.jupigoproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */


/*
 * This fragment inflates the sub three tab
 */
public class Fragment_Sub_Tab_Three extends Fragment {

    EditText mColor;

    public Fragment_Sub_Tab_Three() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_sub_tab_three, container, false);

        mColor = (EditText) view.findViewById(R.id.color);

        return view;
    }

}
