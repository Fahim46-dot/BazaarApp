package com.fahim69.bazaarapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fahim69.bazaarapp.ModelClass.fruit_model_class;
import com.fahim69.bazaarapp.R;

import java.util.ArrayList;

public class fruit_category_adapter extends RecyclerView.Adapter<fruit_category_adapter.viewholder> {
    ArrayList<fruit_model_class> array;
    public fruit_category_adapter(ArrayList<fruit_model_class> array) {
        this.array = array;
    }



    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_holder, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        fruit_model_class model = array.get(position);
        holder.fruit_img.setImageResource(model.getImageview());
        holder.fruit_name.setText(model.getName());
        holder.fruit_category.setText(model.getCategory());
        holder.fruit_price.setText(model.getPrice());

    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView fruit_img;
        TextView fruit_name, fruit_category, fruit_price;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            fruit_img = itemView.findViewById(R.id.item_picture);
            fruit_name = itemView.findViewById(R.id.item_name);
            fruit_category = itemView.findViewById(R.id.item_category);
            fruit_price = itemView.findViewById(R.id.item_price);
        }
    }
}
