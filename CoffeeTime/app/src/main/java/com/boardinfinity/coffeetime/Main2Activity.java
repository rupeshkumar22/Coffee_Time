package com.boardinfinity.coffeetime;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

/*
Created By- Rupesh Kumar at July 2019
A part of open source project GitHub Link
https://github.com/rupesh-kumar-lpu/Coffee_Time
 */


public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    final OrderDatabase db2=new OrderDatabase(Main2Activity.this);

    private static String Email;
    String data;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ViewPager vp_pages= (ViewPager) findViewById(R.id.vp_pages);
        PagerAdapter pagerAdapter=new FragmentAdapter(getSupportFragmentManager());
        vp_pages.setAdapter(pagerAdapter);

        TabLayout tbl_pages= (TabLayout) findViewById(R.id.tbl_pages);
        tbl_pages.setupWithViewPager(vp_pages);
        final MyDatabase myDatabase= new MyDatabase(Main2Activity.this);
        final SharedPreferences sharedPreferences=getSharedPreferences("Data",Context.MODE_PRIVATE);
        boolean bstatus=sharedPreferences.getBoolean("LOGGED_IN_PREF",false);
        boolean remem=sharedPreferences.getBoolean("RememberMe",false);




        if(bstatus){


            Bundle extras=getIntent().getExtras();
            Email=extras.getString("Email");




            if(Email!=null){
                if(!(db2.checkEmailAlready(Email))) {
                    db2.insertRegisterDataInTable(Email);

                }

                Cursor crr=myDatabase.getalldatarow(Email);
                if (crr.moveToFirst()) // data?{
                {
                    Integer id=crr.getInt(crr.getColumnIndex("Id"));

                    String usrnn=crr.getString(crr.getColumnIndex("Username"));

                    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
                    View headerView = navigationView.getHeaderView(0);
                    TextView navUsername = (TextView) headerView.findViewById(R.id.tview);
                    navUsername.setText("Welcomes You  "+ usrnn);


                    }


            }
            else{
                String emaill=sharedPreferences.getString("Email","nothing");
                if(emaill!=null){
                    if(!(db2.checkEmailAlready(emaill))) {
                        db2.insertRegisterDataInTable(emaill);

                    }


                    Cursor crr=myDatabase.getalldatarow(emaill);
                    if (crr.moveToFirst()) // data?{
                    {
                        Integer id=crr.getInt(crr.getColumnIndex("Id"));
                        String usrnn=crr.getString(crr.getColumnIndex("Username"));
                        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
                        View headerView = navigationView.getHeaderView(0);
                        TextView navUsername = (TextView) headerView.findViewById(R.id.tview);
                        navUsername.setText(usrnn);

                    }
                    }

            }




        }
        if(remem){
            Toast.makeText(this,"Remembered For Next Time Login",Toast.LENGTH_SHORT).show();
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    HomeFragment home = new HomeFragment();
                    return home;
                case 1:
                    AboutFragment about = new AboutFragment();
                    return about;
                case 2:
                    ContactFragment contact = new ContactFragment();
                    return contact;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                //
                //Your tab titles
                //
                case 0:return "Popular Drinks";
                case 1:return "World Wide Drinks";
                case 2: return "Other Food Items";
                default:return null;
            }
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Logout) {
            final SharedPreferences sharedPreferences=getSharedPreferences("Data",Context.MODE_PRIVATE);
            final SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putBoolean("LOGGED_IN_PREF", false);
            editor.commit();
            Intent intent = new Intent(Main2Activity.this, LoginScreen.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(Main2Activity.this, Orders.class);
            startActivity(intent);

        } else if (id == R.id.nav_manage) {

            final SharedPreferences sharedPreferences=getSharedPreferences("Data",Context.MODE_PRIVATE);
            final SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putBoolean("LOGGED_IN_PREF", false);
            editor.commit();
            Intent intent = new Intent(Main2Activity.this, LoginScreen.class);
            startActivity(intent);
            finish();



        } else if (id == R.id.nav_share) {
            Intent intent = new Intent(Main2Activity.this, Credits.class);
            startActivity(intent);

        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(Main2Activity.this, Share.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
