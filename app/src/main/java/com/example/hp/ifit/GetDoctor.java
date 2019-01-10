package com.example.hp.ifit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class GetDoctor extends AppCompatActivity {
    private ArrayList<GetDoctorDao> beddaolist = new ArrayList<GetDoctorDao>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_doctor);
        initGetDoctorRecycler();
    }

    private void initGetDoctorRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.doctor_recycler);
        recyclerView.setLayoutManager(layoutManager);
        beddaolist = new ArrayList<GetDoctorDao>();
        for (int i = 0; i < GetDoctorData.dname.length; i++) {
            beddaolist.add(new GetDoctorDao(
                    GetDoctorData.dname[i],
                    GetDoctorData.doctorimage[i],
                    GetDoctorData.docdegree[i],
                    GetDoctorData.dspeciality[i]
            ));
        }



        GetDoctorAdapter adapter = new GetDoctorAdapter( beddaolist);
        recyclerView.setAdapter(adapter);
    }
}
