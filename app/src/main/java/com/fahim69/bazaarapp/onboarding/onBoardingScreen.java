package com.fahim69.bazaarapp.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fahim69.bazaarapp.Adapter.onBoardingAdapter;
import com.fahim69.bazaarapp.Login.LoginPage;
import com.fahim69.bazaarapp.Login.Signup;
import com.fahim69.bazaarapp.R;

public class onBoardingScreen extends AppCompatActivity {
    ViewPager pager;
    LinearLayout dotslayout;
    onBoardingAdapter onBoardingAdapter;
    TextView[] dots;
    Button letsGoBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        pager = findViewById(R.id.pager);
        dotslayout = findViewById(R.id.dots_layout);
        letsGoBtn = findViewById(R.id.get_started_btn);
        onBoardingAdapter = new onBoardingAdapter(this);
        pager.setAdapter(onBoardingAdapter);


        addDots(0);
        pager.addOnPageChangeListener(changeListener);

        letsGoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void addDots(int position)
    {
        dots = new TextView[3];
        dotslayout.removeAllViews();
        for(int i=0;i<dots.length;i++)
        {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);

            dotslayout.addView(dots[i]);
        }

        if(dots.length>0)
        {
            dots[position].setTextColor(getResources().getColor(R.color.redforapp));
        }

    }
    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
        addDots(position);

        if(position!=dots.length-1)
        {
            letsGoBtn.setVisibility(View.INVISIBLE);
        }
        else
        {
            letsGoBtn.setVisibility(View.VISIBLE);
        }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}