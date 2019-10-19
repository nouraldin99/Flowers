package com.example.flowers.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowers.R;
import com.example.flowers.models.Flowers;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class FViewAdapter extends RecyclerView.Adapter<FViewAdapter.MenuViewHolder> {

    ArrayList<Flowers> flowers ;


    public FViewAdapter(ArrayList<Flowers>flowers) {
        this.flowers = flowers;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f_folwer_cardview, viewGroup, false);
        MenuViewHolder holder = new MenuViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder menuViewHolder, int i) {
        Flowers flower = flowers.get(i);
        menuViewHolder.bind(flower);

    }



    @Override
    public int getItemCount() {
        return flowers.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder {
        ImageView img ;
        TextView txt_tittle, txt_des, txt_price;
        RatingBar rate;
        Flowers flower;


        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.flower_img);
            txt_tittle = itemView.findViewById(R.id.home_et_title);
            txt_des = itemView.findViewById(R.id.home_et_des);
            txt_price = itemView.findViewById(R.id.home_et_price);
            rate = itemView.findViewById(R.id.home_rate);


        }
        public void bind (Flowers flower){
        this.flower = flower ;
        Picasso.with(itemView.getContext()).load(flower.getImg()).into(img);
        txt_tittle.setText(flower.getTittle());
        txt_des.setText(flower.getDes());
        txt_price.setText(String.valueOf(flower.getPrice()));
        rate.setRating(flower.getRate());


        }


    }
}
