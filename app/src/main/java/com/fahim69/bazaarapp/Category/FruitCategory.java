package com.fahim69.bazaarapp.Category;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fahim69.bazaarapp.Adapter.fruit_category_adapter;
import com.fahim69.bazaarapp.FragmentHolder.ShowFragment;
import com.fahim69.bazaarapp.ModelClass.fruit_model_class;
import com.fahim69.bazaarapp.R;

import java.util.ArrayList;


public class FruitCategory extends Fragment {
    RecyclerView fruitrv;
    int[] images_fruit = {R.drawable.naspati, R.drawable.naspati, R.drawable.naspati, R.drawable.naspati, R.drawable.naspati, R.drawable.naspati,R.drawable.naspati, R.drawable.naspati, R.drawable.naspati};
    String[] name_fruit = {"Naspati","Naspati","Naspati","Naspati","Naspati","Naspati","Naspati","Naspati","Naspati"};
    String[] category = {"Fruit","Fruit","Fruit","Fruit","Fruit","Fruit","Fruit","Fruit","Fruit"};
    String[] price_fruit = {"$5.00","$5.00","$5.00","$5.00","$5.00","$5.00","$5.00","$5.00","$5.00"};

    ArrayList<fruit_model_class> arrayList = new ArrayList<>();


    public FruitCategory() {
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
        View view = inflater.inflate(R.layout.fragment_fruit_category, container, false);
        fruitrv = view.findViewById(R.id.fruit_category);
        fruitrv.setLayoutManager(new GridLayoutManager(getActivity(), 2));


        for(int i=0;i<images_fruit.length;i++)
        {
            arrayList.add(new fruit_model_class(name_fruit[i],category[i],price_fruit[i],images_fruit[i] ));
        }

        fruit_category_adapter adapter = new fruit_category_adapter(arrayList);
        fruitrv.setAdapter(adapter);



        return view;
    }
}