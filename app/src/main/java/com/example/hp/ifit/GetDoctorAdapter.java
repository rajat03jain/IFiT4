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

import java.util.ArrayList;
import java.util.List;

public class GetDoctorAdapter extends RecyclerView.Adapter<GetDoctorAdapter.ViewHolder> {


    public GetDoctorAdapter(ArrayList<GetDoctorDao> beddaolist) {
        doctordao= beddaolist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.get_doctor_binder, viewGroup, false);
        final ViewHolder mViewHolder = new ViewHolder(view);
        return mViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.doctordegree.setText(doctordao.get(i).getDoctordegree());
        viewHolder.doctorimage.setImageResource(doctordao.get(i).getDoctorinmage());
        viewHolder.doctorname.setText(doctordao.get(i).getDoctorname());
        viewHolder.doctorspeciality.setText(doctordao.get(i).getDoctorspeciality()  );



    }

    @Override
    public int getItemCount() {
        return doctordao.size();
    }

    private ArrayList<GetDoctorDao> doctordao;
    private Context context;


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView doctorname, doctorspeciality, doctordegree;
        ImageView doctorimage;

/*
        TextView id;
        TextView price;
        TextView cat;
        ImageView bedimage;*/

        public ViewHolder(View itemView) {
            super(itemView);
            doctorname = itemView.findViewById(R.id.doctorname);
            doctorspeciality = itemView.findViewById(R.id.doctor_speciality);
            doctordegree = itemView.findViewById(R.id.doctordegree);
            doctorimage = itemView.findViewById(R.id.doctor_image);
            /*price= itemView.findViewById(R.id.bedprice);
            cat= itemView.findViewById(R.id.bedcat);
            bedimage= itemView.findViewById(R.id.bedimage);*/


        }

    }
}
