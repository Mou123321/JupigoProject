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
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */

/*
 *  This fragment inflates the user list witch will show in the tab_3
 */
public class Fragment_Tab_Three extends Fragment {

    public static ExpandableListView listView;
    public static ExpandableListAdapter listAdapter;
    public static HashMap<String, List<String>> listHashMap;

    Communicater communicater;

    public Fragment_Tab_Three() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_tab_three, container, false);

        communicater = (Communicater) getActivity();

        listView = (ExpandableListView) view.findViewById(R.id.lvExp);

        listHashMap = new HashMap<>();


        listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            int preiousGroup = -1;
            @Override
            public void onGroupExpand(int groupPosition) {

                if (groupPosition != preiousGroup){
                    listView.collapseGroup(preiousGroup);
                }
                preiousGroup = groupPosition;
            }
        });

        return view;
    }

}
