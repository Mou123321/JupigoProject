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
 * This fragment inflates the sub two tab
 */
public class Fragment_Sub_Tab_Two extends Fragment {

    EditText mAnimal;

    public Fragment_Sub_Tab_Two() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_sub_tab_two, container, false);

        mAnimal = (EditText) view.findViewById(R.id.animal);

        return view;
    }

}
