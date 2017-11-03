package com.example.mousun.jupigoproject;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */

/*
 * This fragment inflates the tab one
 */
public class Fragment_Tab_One extends Fragment implements TextWatcher{

    Button mColorBtn, mSubmitBtn;
    EditText mCode, mName;
    private Communicater mCommunicater;

    Spinner mSpinner;
    ArrayAdapter<String> mSpinnerAdapter;

    boolean selectColorFlag = false;

    public Fragment_Tab_One() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_tab_one, container, false);

        mColorBtn = (Button) view.findViewById(R.id.ColorButton);
        mCode = (EditText) view.findViewById(R.id.Code);
        mName = (EditText) view.findViewById(R.id.UserName);
        mSubmitBtn = (Button) view.findViewById(R.id.SubmitBtn);

        mCommunicater = (Communicater) getActivity();

        colorBtnInit();
        mColorBtn.addTextChangedListener(this);
        mCode.addTextChangedListener(this);
        mName.addTextChangedListener(this);


        if (savedInstanceState == null){
            Log.d("tabOne", "State  = null");
        }else {

            Log.d("tabOne", "saved State");
        }

        submitUser();

        return view;
    }

    /*
     *  This private method to set up the button for color selecting
     *  When the button is clicked, it shows a dialog with a spinner with
     *    some color options for the user, after user select a color and
     *    click the done button, the button text will show the color which
     *    user is chose
     */
    private void colorBtnInit(){
        mColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = getLayoutInflater().inflate(R.layout.fragment_fragment_dialog_select_color, null);
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
                mBuilder.setTitle("Select a Color");

                mSpinner = (Spinner) view.findViewById(R.id.spinner);

                mSpinnerAdapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_spinner_item,
                        getResources().getStringArray(R.array.ColorList));
                mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                mSpinner.setAdapter(mSpinnerAdapter);

                mBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String mSting = mSpinner.getSelectedItem().toString();

                        if (!mSting.equalsIgnoreCase("Select a Color")){
                            selectColorFlag = true;
                            mColorBtn.setText(mSting);
                        }else {
                            selectColorFlag = false;
                            mColorBtn.setText("Select a Color");
                        }

                    }
                });

                mBuilder.setView(view);

                AlertDialog mDialog = mBuilder.create();
                mDialog.setCancelable(false);
                mDialog.show();
            }
        });
    }

    /*
     *  This private method to save and pass the information of a submit user
     *  When the button is clicked, it will send the username, code, and color
     *      to the main activity
     */
    private void submitUser(){
        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int code = Integer.parseInt(mCode.getText().toString());
                String name = mName.getText().toString();
                String color = mColorBtn.getText().toString();
                mCommunicater.creatListName(code,name,color);
                mName.setText("");
                mColorBtn.setText("Select Color");
                mCode.setText("");
                selectColorFlag = false;
            }
        });
    }

    @Override
    public void onDestroy() {
        Log.d("tabOne", "tab one destroy");
        super.onDestroy();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    /*
     *  This method will detect the changes in the text fields
     *  If all the requirements are met, it will change the color of submit and enable the clickable
     *      functionality
     */
    @Override
    public void afterTextChanged(Editable s) {
        try {
            int num = Integer.parseInt(mCode.getText().toString());

            if (num < 1000 || num > 9999 || mName.getText().toString().length() == 0 ||
                    mCode.getText().toString().length() == 0 || !selectColorFlag) {

                mSubmitBtn.setBackgroundColor(mSubmitBtn.getContext().getResources().getColor(android.R.color.darker_gray));
                mSubmitBtn.setEnabled(false);
            }
            else {
                mSubmitBtn.setEnabled(true);
                mSubmitBtn.setBackgroundColor(mSubmitBtn.getContext().getResources().getColor(R.color.colorPrimaryDark));
            }

        }catch(NumberFormatException e){}
    }
}
