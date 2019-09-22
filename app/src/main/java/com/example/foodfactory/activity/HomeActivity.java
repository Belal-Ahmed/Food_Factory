package com.example.foodfactory.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.foodfactory.R;
import com.example.foodfactory.fragment.Cart;
import com.example.foodfactory.fragment.HomeFragment;
import com.example.foodfactory.fragment.NearbyRestaurant;
import com.example.foodfactory.fragment.Profile;
import com.example.foodfactory.fragment.SearchHistory;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity{

    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private NearbyRestaurant nearbyRestaurant;
    private SearchHistory searchHistory;
    private Cart cart;
    private Profile profile;

    private static final String TAG = "HomeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //initializing wiz
        initwiz();

        //Replace fragment with home fragment
        Log.d(TAG, "Home fragment replaced in home screen");
        replaceFragment(homeFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Log.d(TAG,"onNavigationItemSelected");
                switch (menuItem.getItemId()){
                    case R.id.home_id:{
                        replaceFragment(homeFragment);
                        Log.d(TAG,"onNavigationItemSelected: Home Replaced");
                        return true;
                    }
                    case R.id.near_by_id:{
                        replaceFragment(nearbyRestaurant);
                        Log.d(TAG,"onNavigationItemSelected: nearby restaurant replaced");
                        return true;
                    }
                    case R.id.search_history_id:{
                        replaceFragment(searchHistory);
                        Log.d(TAG,"onNavigationItemSelected: Search history replaced");
                        return true;
                    }
                    case R.id.cart_id:{
                        replaceFragment(cart);
                        Log.d(TAG,"onNavigationItemSelected: cart replaced");
                        return true;
                    }
                    case R.id.profile_id:{
                        replaceFragment(profile);
                        Log.d(TAG,"onNavigationItemSelected: profile fragment replaced");
                        return true;
                    }
                    default:{
                        Log.d(TAG,"onNavigationItemSelected: noting happened");
                        return false;
                    }
                }
            }
        });
    }

    private void initwiz() {
        Log.d(TAG, "initializing wiz and creating instance");
        //Creating Object of all fragments
        homeFragment = new HomeFragment();
        nearbyRestaurant = new NearbyRestaurant();
        searchHistory = new SearchHistory();
        cart = new Cart();
        profile = new Profile();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }


    //Just replace the one fragment to another fragment
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, fragment);
        fragmentTransaction.commit();

    }
}
