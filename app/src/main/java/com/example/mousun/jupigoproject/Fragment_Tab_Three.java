package com.example.mousun.jupigoproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */

/*
 *  This fragment inflates the user list witch will show in the tab_3
 */
public class Fragment_Tab_Three extends Fragment {

    public static ArrayList<String> mUserNameList;

    public static ArrayAdapter<String> mUserNameListAdapter;

    ListView mListView;

    TextView tv_1, tv_2;

    Communicater communicater;

    public Fragment_Tab_Three() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_tab_three, container, false);
        mUserNameList = new ArrayList<String>();

        communicater = (Communicater) getActivity();

        mListView = (ListView) view.findViewById(R.id.list_tab_3);

        tv_1 = (TextView) view.findViewById(R.id.tv1_tab_3);
        tv_2 = (TextView) view.findViewById(R.id.tv2_tab_3);

        mUserNameListAdapter = new ArrayAdapter<String>(getActivity(),R.layout.list_single_item , R.id.list_item_tv, mUserNameList);

        mListView.setAdapter(mUserNameListAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               UserObject clickedUser = communicater.getClickedUser(position);

               tv_1.setText("Color: " + clickedUser.getUesr_color());
               tv_2.setText("Code: " + clickedUser.getUser_code());

               tv_1.setVisibility(View.VISIBLE);
               tv_2.setVisibility(View.VISIBLE);

            }
        });

        return view;
    }

}
