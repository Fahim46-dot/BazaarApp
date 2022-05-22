package com.fahim69.bazaarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.fahim69.bazaarapp.onboarding.onBoardingScreen;

public class Splashscreen extends AppCompatActivity {
    TextView applogo;
    LottieAnimationView animationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        //Binding views
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        applogo = findViewById(R.id.logo);
        animationView = findViewById(R.id.lottie);

        //splash screen duration & all

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), onBoardingScreen.class);
                startActivity(intent);
                finish();

            }
        }, 4000);


    }


}