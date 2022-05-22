package com.fahim69.bazaarapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fahim69.bazaarapp.ModelClass.OfferModelClass;
import com.fahim69.bazaarapp.R;

import java.util.ArrayList;

public class offershowAdapter extends RecyclerView.Adapter<offershowAdapter.viewholder> {

    ArrayList<OfferModelClass> model;

    public offershowAdapter(ArrayList<OfferModelClass> model) {
        this.model = model;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_fragment_layout, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        OfferModelClass offer = model.get(position);
//        holder.first_line.setText(offer.getFirst());
//        holder.second_line.setText(offer.getSecond());
//        holder.third_line.setText(offer.getThird());
        holder.cover_img.setImageResource(offer.getImage());
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        //TextView first_line, second_line, third_line;
        ImageView cover_img;

        public viewholder(@NonNull View itemView) {
            super(itemView);
//            first_line = itemView.findViewById(R.id.frst_line);
//            second_line = itemView.findViewById(R.id.scnd_line);
//            third_line = itemView.findViewById(R.id.thrd_line);
            cover_img = itemView.findViewById(R.id.coverphoto);
        }
    }
}
