package com.fahim69.bazaarapp.Fragment;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.fahim69.bazaarapp.Adapter.offershowAdapter;
import com.fahim69.bazaarapp.Adapter.popular_item_adapter;
import com.fahim69.bazaarapp.ModelClass.OfferModelClass;
import com.fahim69.bazaarapp.ModelClass.popular_item_model;
import com.fahim69.bazaarapp.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    RecyclerView offer_rv, popular_item_rv;
    ConstraintLayout constraintLayout;
    TextView offer_textview, popular_textview;
    ScrollView scrollView;
    ArrayList<OfferModelClass> modelarray;
    ArrayList<popular_item_model> itemarray;
    int[] cover_img = {R.drawable.orange, R.drawable.aarongmilkonelitre, R.drawable.orange, R.drawable.aarongmilkonelitre, R.drawable.orange, R.drawable.aarongmilkonelitre, R.drawable.orange, R.drawable.aarongmilkonelitre};
    String[] item_name = {"Orange", "Aarong Milk", "Orange", "Aarong Milk", "Orange", "Aarong Milk", "Orange", "Aarong Milk"};
    String[] item_category = {"Fruit", "Dairy", "Fruit", "Dairy", "Fruit", "Dairy", "Fruit", "Dairy"};
    String[] item_price = {"$5.00", "$3.89", "$5.00", "$3.89", "$5.00", "$3.89", "$5.00", "$3.89"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        offer_rv = view.findViewById(R.id.offer_rv);
        popular_item_rv = view.findViewById(R.id.popular_rv);
        offer_textview = view.findViewById(R.id.offer_tv);
        popular_textview = view.findViewById(R.id.popular_tv);
//        constraintLayout=view.findViewById(R.id.inner_layout);
        offer_rv.setHasFixedSize(true);
        offer_rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        //popular_item_recyclerview_size_and_type
        popular_item_rv.setHasFixedSize(true);
        popular_item_rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        //Adding offer pages
        modelarray = new ArrayList<>();
        /*modelarray.add(new OfferModelClass("GET UPTO 50%","OFF ON ONLINE","PAYMENT"));
        modelarray.add(new OfferModelClass("BUY 2 PRODUCTS ","GET INSTANT 20%","CASHBACK"));
        modelarray.add(new OfferModelClass("GET FREE HOME","DELIVERY ON","1000TK PURCHASE"));
        offershowAdapter offershow = new offershowAdapter(modelarray);
        offer_rv.setAdapter(offershow);*/
        modelarray.add(new OfferModelClass(R.drawable.discounted_pic));
        modelarray.add(new OfferModelClass(R.drawable.delivery));
        modelarray.add(new OfferModelClass(R.drawable.cash_on_delivery));
        offershowAdapter offershow = new offershowAdapter(modelarray);
        offer_rv.setAdapter(offershow);

        //Adding popular_items
        itemarray = new ArrayList<>();
        for (int i = 0; i < cover_img.length; i++) {
            itemarray.add(new popular_item_model(cover_img[i], item_name[i], item_category[i], item_price[i]));
        }
        popular_item_adapter item_adapter = new popular_item_adapter(itemarray);
        popular_item_rv.setAdapter(item_adapter);
        return view;
    }
}