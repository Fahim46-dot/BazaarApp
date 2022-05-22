package com.fahim69.bazaarapp.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fahim69.bazaarapp.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment {
    TextView profile, manage_address, order_history, payment_history;
    CircleImageView headline_photo;
    Toolbar profile_toolbar;


    public ProfileFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        profile = view.findViewById(R.id.personal_info);
        manage_address = view.findViewById(R.id.manage_address);
        order_history = view.findViewById(R.id.Order_history);
        payment_history = view.findViewById(R.id.payment);
        headline_photo = view.findViewById(R.id.profile_photo);
        profile_toolbar = view.findViewById(R.id.profil_toolbar);


        //Personal_info page open
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment personal = new Personal_info_Fragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment_container, personal);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        //FindViewById

        return view;
    }


}