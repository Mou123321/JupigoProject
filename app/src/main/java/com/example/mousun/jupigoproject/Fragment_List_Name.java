package com.example.mousun.jupigoproject;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */


/*
 * This fragment inflate the list name screen after the submit button is clicked
 */
public class Fragment_List_Name extends Fragment {

    ArrayList<String> mUserNameList;

    ArrayAdapter<String> mUserNameListAdapter;

    private static ListView mListView;

    Communicater communicater;

    public Fragment_List_Name() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public Fragment_List_Name(ArrayList<String> mUserNameList) {
        this.mUserNameList = mUserNameList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.list_name, container, false);

        if (mUserNameList != null) {
            communicater = (Communicater) getActivity();
            mListView = (ListView) view.findViewById(R.id.list_name);
            mUserNameListAdapter = new ArrayAdapter<String>(getActivity(),R.layout.list_single_item , R.id.list_item_tv, mUserNameList);
            mListView.setAdapter(mUserNameListAdapter);
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    communicater.creatUserProfile(position);
                }
            });
        }
        return view;
    }

}
