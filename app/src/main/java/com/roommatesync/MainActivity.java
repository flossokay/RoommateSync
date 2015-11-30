package com.roommatesync;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.InjectView;

public class MainActivity extends RoboActionBarActivity {

    private final Button[] navbarButtonsArr;
    private FragmentManager fragmentManager;

    @InjectView(R.id.button_newsfeed) private Button newsfeedButton;
    @InjectView(R.id.button_money_management) private Button moneyManagementButton;
    @InjectView(R.id.button_chore_management) private Button choreMangementButton;
    @InjectView(R.id.button_household_needs) private Button householdNeedsButton;
    @InjectView(R.id.button_house_details) private Button houseDetailsButton;
    @InjectView(R.id.button_settings) private Button settingsButton;

    @InjectView(R.id.drawer_layout) private DrawerLayout drawer;
    @InjectView(R.id.toolbar) private Toolbar toolbar;

    public MainActivity() {
        navbarButtonsArr = new Button[6];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        //navdrawer set up
        addNavbarButtonsToArr();

        //actionbar setup
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navdrawer_open, R.string.navdrawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        fragmentManager = getFragmentManager();

        //set up the first activity
        newsFeedClick(newsfeedButton);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(fragmentManager.getBackStackEntryCount() != 1){
            //since we always want a fragment showing the condition is != 1 rather than != 0
            fragmentManager.popBackStack();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.news_feed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // private methods
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////
    private void addNavbarButtonsToArr(){
        navbarButtonsArr[0] = newsfeedButton;
        navbarButtonsArr[1] = moneyManagementButton;
        navbarButtonsArr[2] = choreMangementButton;
        navbarButtonsArr[3] = householdNeedsButton;
        navbarButtonsArr[4] = houseDetailsButton;
        navbarButtonsArr[5] = settingsButton;
    }

    /**
     * Sets the selected view background to the color it was when it was pressed
     * @param selectedView - the selected view
     */
    private void setSelectedNavDrawerView(View selectedView){
        for(View v : navbarButtonsArr){
            if(selectedView.getId() == v.getId()) {
                v.setBackgroundResource(R.color.navdrawer_item_pressed);
            }else {
                //having state persisted is harder in android
                //thus we'll just iterate through the whole array for now.
                //Found a solution but I don't like it.  (feels too hacky)
                //see http://stackoverflow.com/questions/4747311/how-can-i-keep-one-button-as-pressed-after-click-on-it
                v.setBackgroundResource(R.drawable.selector_navdrawer_items);
            }
        }
    }

    private void showFragmentOnMainView(Fragment fragment){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.drawer_layout_content,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // OnClickListeners
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void newsFeedClick(View view) {
        drawer.closeDrawer(GravityCompat.START);
        setSelectedNavDrawerView(view);
        showFragmentOnMainView(new NewsfeedFragment());
    }

    public void moneyManageManagementClick(View view) {
        drawer.closeDrawer(GravityCompat.START);
        setSelectedNavDrawerView(view);
    }

    public void choreManagementClick(View view) {
        drawer.closeDrawer(GravityCompat.START);
        setSelectedNavDrawerView(view);
    }

    public void houseHoldNeedsClick(View view) {
        drawer.closeDrawer(GravityCompat.START);
        setSelectedNavDrawerView(view);
    }

    public void houseDetailsClick(View view) {
        drawer.closeDrawer(GravityCompat.START);
        setSelectedNavDrawerView(view);
    }

    public void settingsClick(View view) {
        drawer.closeDrawer(GravityCompat.START);
        setSelectedNavDrawerView(view);
    }

}
