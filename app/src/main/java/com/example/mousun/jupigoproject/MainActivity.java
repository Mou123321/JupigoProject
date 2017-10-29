package com.example.mousun.jupigoproject;

import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


/*
 *  MainActivity is only one activity which contains all the fragments
 *  It keeps all the variables which are used in inter-fragment communication
 *  it implements a custom interface which handel all the inter-fragment communication
 */
public class MainActivity extends AppCompatActivity implements Communicater{

    private Fragment_List_Name f_list_name;
    private Fragment_User_Profile f_user_pro;

    private ArrayList<UserObject> mUserObjectList;
    private ArrayList<String> mUserNameList;

    private CustomViewPager mViewPager;
    private final boolean DISABLE_SWIPE = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserObjectList = new ArrayList<UserObject>();
        mUserNameList = new ArrayList<String>();

        createBottomTabs();
    }

    /*
     *  this is a private helper method to crete three main tabs at bottom
     *  using viewPager to handle the click and swipe events of the tabs
     */
    private void createBottomTabs(){
        mViewPager = (CustomViewPager) findViewById(R.id.container_bottom);
        mViewPager.setOffscreenPageLimit(2);
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        mViewPager.setPagingEnabled(DISABLE_SWIPE);
        adapter.addFragment(new Fragment_Tab_One(), "Tab One");
        adapter.addFragment(new Fragment_Tab_Two(), "Tab Two");
        adapter.addFragment(new Fragment_Tab_Three(), "Tab Three");
        mViewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_bottom);
        tabLayout.setupWithViewPager(mViewPager);
    }

    /*
     *  This is a override method from the interface Communication
     *  This method is called to create and update the submited list name
     */
    @Override
    public void creatListName(int code, String name, String color) {
        mUserObjectList.add(new UserObject(code, name, color));
        mUserNameList.add(name);
        f_list_name = new Fragment_List_Name(mUserNameList);

        updateTabThree();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.tabs_1_layout,f_list_name);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    /*
     *   This is a override method from the interface Communication
     *  This method is to create a user profile page with name, code, and color
     */
    @Override
    public void creatUserProfile(int position) {
        String name, code, color;
        name = "Name: " + mUserObjectList.get(position).getUser_name();
        code = "Code: " + String.valueOf(mUserObjectList.get(position).getUser_code());
        color = "Color: " + mUserObjectList.get(position).getUesr_color();

        f_user_pro = new Fragment_User_Profile(name, code, color);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.list_name_layout, f_user_pro);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    /*
     *  This is a override method from the interface Communication
     *  This method is to update the tab_3 name list content
     */
    @Override
    public void updateTabThree() {
        Fragment_Tab_Three.mUserNameList.clear();
        Fragment_Tab_Three.mUserNameList.addAll(mUserNameList);
        Fragment_Tab_Three.mUserNameListAdapter.notifyDataSetChanged();
    }

    /*
     *  This is a override method from the interface Communication
     *  This method is to get the clicked user object in the tab_3
     */
    @Override
    public UserObject getClickedUser(int position) {
        return mUserObjectList.get(position);
    }
}
