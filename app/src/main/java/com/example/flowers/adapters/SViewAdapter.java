package com.example.flowers.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowers.R;
import com.example.flowers.models.Flowers;

import java.util.ArrayList;


public class SViewAdapter extends RecyclerView.Adapter<SViewAdapter.MenuViewHolder> {

    ArrayList<Flowers> flowers ;


    public SViewAdapter(ArrayList<Flowers>flowers) {
        this.flowers = flowers;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.s_flower_cardview, viewGroup, false);
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
        TextView txt_id ,txt_tittle, txt_des,txt_add  ;
        ImageView img_add , img_flower ;

        Flowers flower;


        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_id = itemView.findViewById(R.id.s_id_txt);
            txt_tittle = itemView.findViewById(R.id.s_title);
            txt_des = itemView.findViewById(R.id.s_des);
            txt_add = itemView.findViewById(R.id.s_add);
            img_add = itemView.findViewById(R.id.s_bt_add);
            img_flower = itemView.findViewById(R.id.s_img);



        }
        public void bind (Flowers flower){
            this.flower = flower ;
            txt_id.setText(String.valueOf(flower.getId()));
            txt_tittle.setText(flower.getTittle());
            txt_des.setText(flower.getDes());



        }


    }
}
