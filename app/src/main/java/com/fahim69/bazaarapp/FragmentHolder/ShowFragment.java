package com.fahim69.bazaarapp.FragmentHolder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ActivityNavigator;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.fahim69.bazaarapp.Fragment.CartFragment;
import com.fahim69.bazaarapp.Fragment.CategoryFragment;
import com.fahim69.bazaarapp.Fragment.HomeFragment;
import com.fahim69.bazaarapp.Fragment.ProfileFragment;
import com.fahim69.bazaarapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ShowFragment extends AppCompatActivity {
    BottomNavigationView bottomnav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_fragment);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bottomnav = findViewById(R.id.nav_bar);
        replacefragment(new HomeFragment(), "home_fragment");

        bottomnav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        replacefragment(new HomeFragment(), "home_fragment");
                        //bottomnav.setVisibility(View.VISIBLE);
                        break;
                    case R.id.nav_category:
                        replacefragment(new CategoryFragment(), "category_fragment");
                        //bottomnav.setVisibility(View.VISIBLE);
                        break;
                    case R.id.nav_cart:
                        replacefragment(new CartFragment(), "cart_fragment");
                        //bottomnav.setVisibility(View.VISIBLE);
                        break;
                    case R.id.nav_profile:
                        replacefragment(new ProfileFragment(), "profile_fragment");
                        //bottomnav.setVisibility(View.VISIBLE);
                        break;

                }

                return true;
            }
        });


    }

    private void replacefragment(Fragment fragment, String name) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        //fragmentManager.popBackStack();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, name);
        if (name != "home_fragment") {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 1) {
            fm.popBackStack();
        } else {
            super.onBackPressed();
        }

    }

}