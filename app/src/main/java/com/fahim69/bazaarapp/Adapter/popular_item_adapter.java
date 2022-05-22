package com.fahim69.bazaarapp.Adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fahim69.bazaarapp.ModelClass.popular_item_model;
import com.fahim69.bazaarapp.R;

import java.util.ArrayList;

public class popular_item_adapter extends RecyclerView.Adapter<popular_item_adapter.viewholder> {

    ArrayList<popular_item_model> item;


    public popular_item_adapter(ArrayList<popular_item_model> item) {
        this.item = item;
    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_popular_layout,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        popular_item_model model = item.get(position);

        holder.item_name.setText(model.getItem_name());
        holder.item_price.setText(model.getItem_price());
        holder.img.setImageResource(model.getItem_images());
        holder.item_cat.setText(model.getItem_category());

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView item_name, item_price, item_cat;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_picture);
            item_name = itemView.findViewById(R.id.item_name);
            item_price = itemView.findViewById(R.id.item_price);
            item_cat = itemView.findViewById(R.id.item_category);
        }
    }
}
