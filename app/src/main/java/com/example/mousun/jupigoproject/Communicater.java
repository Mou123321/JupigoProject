package com.example.mousun.jupigoproject;

import android.support.v4.view.ViewPager;

import java.util.ArrayList;

/**
 * Created by mousun on 10/25/17.
 */


/*
 *  Conmunicater is a custom interface which handel all the inter-fragment communication
 */
public interface Communicater {

    /*
     *  This method is to create and update the submited list name
     *  This is called from tab_1 fragment when the submit button is clicked
     *  Params are the variables of a single user object
     */
    public void creatListName(int code, String name, String color);

    /*
     *  This method is to create a user profile page
     *  This is called from user name list in tab_1 when a name is clicked
     *  The param tells the position of a specific user in the name list
     */
    public void creatUserProfile(int position);

    /*
     *  This method is to update the tab_3 name list content
     *  This method is called when the submit button in the tab_1 is called
     */
    public void updateTabThree();

    /*
     *  This method is to get the clicked user object
     *  This method is called when the list name in the tab_3 is clicked
     *  return the a user object in the specific position
     */
    public UserObject getClickedUser(int position);
}
