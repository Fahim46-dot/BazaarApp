package com.fahim69.bazaarapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.fahim69.bazaarapp.R;

public class onBoardingAdapter extends PagerAdapter {
    private Context context;
     LayoutInflater layoutInflater;
    public onBoardingAdapter(Context context) {
        this.context = context;
    }
    //For Images
    int Images[]={R.drawable.img1,R.drawable.img2, R.drawable.img3};

    //For the first heading
    int heading1[]={R.string.Fresh, R.string.Home, R.string.Cash};

    //For the second heading
    int[] heading2 ={R.string.Everything, R.string.Delivery, R.string.OnDelivery};

    //For the Descriptions

    int description[]={R.string.ForFirst1, R.string.ForSecond1,R.string.ForThird1};



    @Override
    public int getCount() {
        return description.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_onboarding_layout, container, false);

        ImageView imageView = view.findViewById(R.id.photo);
        TextView firstheading= view.findViewById(R.id.firstheading);
        TextView scnheanding = view.findViewById(R.id.scnheading);
        TextView desc = view.findViewById(R.id.thirdheading);

        //fatching data

        imageView.setImageResource(Images[position]);
        firstheading.setText(heading1[position]);
        scnheanding.setText(heading2[position]);
        desc.setText(description[position]);

        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
