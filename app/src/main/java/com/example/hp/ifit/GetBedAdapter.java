package com.example.hp.ifit;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GetBedAdapter extends RecyclerView.Adapter<GetBedAdapter.ViewHolder> {

    private ArrayList<GetBedDao> beddao;
    private Context context;

    public GetBedAdapter(Context context,ArrayList<GetBedDao> getBedDao){
        this.context= context;
        this.beddao= getBedDao;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hospital_list_binder, viewGroup, false);
        final ViewHolder mViewHolder = new ViewHolder(view);
        return mViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.hospname.setText(beddao.get(i).getHospname());
        viewHolder.hospimage.setImageResource(beddao.get(i).getHospimage());
        viewHolder.address.setText(beddao.get(i).getAddress());
        viewHolder.rrr.setText(beddao.get(i).getRrr());
       /* viewHolder.cat.setText(beddao.get(i).getAbout());
        viewHolder.bedimage.setImageResource(beddao.get(i).getImage());
        viewHolder.price.setText(String.valueOf(beddao.get(i).getPrice()));*/
        viewHolder.callambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "The Ambulance will arrive soon", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.getroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "No Rooms Avaialble currently!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return beddao.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView hospname,address,rrr;
        ImageView hospimage;
        Button callambulance, getroom;
/*
        TextView id;
        TextView price;
        TextView cat;
        ImageView bedimage;*/

        public ViewHolder(View itemView) {
            super(itemView);
            hospname= itemView.findViewById(R.id.hospname);
            address= itemView.findViewById(R.id.hospaddress);
            rrr= itemView.findViewById(R.id.rrrtext);
            hospimage= itemView.findViewById(R.id.hospital_image);
            callambulance= itemView.findViewById(R.id.bookambulancebutton);
            getroom= itemView.findViewById(R.id.bookroombutton);
            /*price= itemView.findViewById(R.id.bedprice);
            cat= itemView.findViewById(R.id.bedcat);
            bedimage= itemView.findViewById(R.id.bedimage);*/


        }
    }
}

