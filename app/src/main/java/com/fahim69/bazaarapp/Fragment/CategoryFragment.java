package com.fahim69.bazaarapp.Fragment;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fahim69.bazaarapp.Category.FruitCategory;
import com.fahim69.bazaarapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class CategoryFragment extends Fragment {
    CardView fruit, fish, meat, vegetable, cooking, dairy, frozen, snacks, bread, beverage, personal_care, hygiene, baby_care, homekitchen, petcare;
    ImageView fruit_img, fish_img, meat_img, vegetable_img, cooking_img, dairy_img, frozen_img, snacks_img, bread_img, beverage_img, personal_img, hygiene_img, baby_img, home_img, pet_img;
    TextView fruit_tv, fish_tv, meat_tv, vegetable_tv, cooking_tv, dairy_tv, frozen_tv, snacks_tv, bread_tv, beverage_tv, personal_tv, hygiene_tv, baby_tv, home_tv, pet_tv;


    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        fruit = view.findViewById(R.id.fruitname);
        fish = view.findViewById(R.id.Fish);
        meat = view.findViewById(R.id.meat);
        vegetable = view.findViewById(R.id.vegetable);
        cooking = view.findViewById(R.id.cooking);
        dairy = view.findViewById(R.id.dairy);
        frozen = view.findViewById(R.id.frozenAndCanned);
        snacks = view.findViewById(R.id.Snacks);
        bread = view.findViewById(R.id.breadandbakery);
        beverage = view.findViewById(R.id.beverages);
        personal_care = view.findViewById(R.id.Personalcare);
        hygiene = view.findViewById(R.id.Hygiene);
        baby_care = view.findViewById(R.id.BabyCare);
        homekitchen = view.findViewById(R.id.HomeandKitchen);
        petcare = view.findViewById(R.id.Petcare);


        fruit_img = view.findViewById(R.id.fruitpic);
        fish_img = view.findViewById(R.id.fish_category_img);
        meat_img = view.findViewById(R.id.meatpic);
        vegetable_img = view.findViewById(R.id.vegetablepic);
        cooking_img = view.findViewById(R.id.cookingpic);
        dairy_img = view.findViewById(R.id.dairypic);
        frozen_img = view.findViewById(R.id.frozenandcannedimg);
        snacks_img = view.findViewById(R.id.snackscatimg);
        bread_img = view.findViewById(R.id.breadandbakeryimg);
        beverage_img = view.findViewById(R.id.beveragesimg);
        personal_img = view.findViewById(R.id.personalcare_img);
        hygiene_img = view.findViewById(R.id.hygiene_img);
        baby_img = view.findViewById(R.id.babycare_img);
        home_img = view.findViewById(R.id.homeandkitchen_img);
        pet_img = view.findViewById(R.id.petcareimg);


        fruit_tv = view.findViewById(R.id.fruit_name_tv);
        fish_tv = view.findViewById(R.id.fish_category_tv);
        meat_tv = view.findViewById(R.id.meat_cat_tv);
        vegetable_tv = view.findViewById(R.id.vegetable_cat_tv);
        cooking_tv = view.findViewById(R.id.cooking_cat_tv);
        dairy_tv = view.findViewById(R.id.dairy_cat_tv);
        frozen_tv = view.findViewById(R.id.frozen_cat_tv);
        snacks_tv = view.findViewById(R.id.snacks_tv);
        bread_tv = view.findViewById(R.id.breadbackery_tv);
        beverage_tv = view.findViewById(R.id.Beverage_tv);
        personal_tv = view.findViewById(R.id.personal_care_tv);
        hygiene_tv = view.findViewById(R.id.hygiene_tv);
        baby_tv = view.findViewById(R.id.babycare_tv);
        home_tv = view.findViewById(R.id.homeandkitchen_tv);
        pet_tv = view.findViewById(R.id.petcare_tv);
        BottomNavigationView item = getActivity().findViewById(R.id.nav_bar);



        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FruitCategory();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                //manager.popBackStack();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        return view;
    }

}