package com.fahim69.bazaarapp.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fahim69.bazaarapp.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class Personal_info_Fragment extends Fragment {
    TextView name_tv, email_tv, phone_tv;
    CircleImageView profile_pic_show;
    Toolbar personal_toolbar;


    public Personal_info_Fragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_personal_info_, container, false);
        name_tv = view.findViewById(R.id.user_name_tv);
        email_tv = view.findViewById(R.id.email_tv);
        phone_tv = view.findViewById(R.id.phone_number_tv);
        profile_pic_show = view.findViewById(R.id.profile_picture);
        personal_toolbar = view.findViewById(R.id.personal_data);

        return view;
    }
}