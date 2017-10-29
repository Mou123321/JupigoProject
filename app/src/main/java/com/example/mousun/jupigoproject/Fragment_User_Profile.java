package com.example.mousun.jupigoproject;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_User_Profile extends Fragment {

    TextView mProfile_name, mProfile_code, mProfile_color;
    String name, code, color;

    public Fragment_User_Profile() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public Fragment_User_Profile(String name, String code, String color) {
        this.name = name;
        this.code = code;
        this.color = color;
    }

    @SuppressLint("ValidFragment")


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment_user_profile, container, false);

        mProfile_name = (TextView) view.findViewById(R.id.profile_name);
        mProfile_code = (TextView) view.findViewById(R.id.profile_code);
        mProfile_color = (TextView) view.findViewById(R.id.profile_color);

        mProfile_name.setText(name);
        mProfile_code.setText(code);
        mProfile_color.setText(color);

        return view;
    }

}
