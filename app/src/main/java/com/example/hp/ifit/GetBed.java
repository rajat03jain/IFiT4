package com.example.hp.ifit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class GetBed extends AppCompatActivity {
    private ArrayList<GetBedDao> beddaolist = new ArrayList<GetBedDao>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_bed);
        initGetBedRecycler();
    }



    private void initGetBedRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.getbed_recycler);
        recyclerView.setLayoutManager(layoutManager);
        beddaolist = new ArrayList<GetBedDao>();
        for (int i = 0; i < HospitalBedData.hname.length-1; i++) {
            beddaolist.add(new GetBedDao(
                    HospitalBedData.hname[i],
                    HospitalBedData.haddress[i],
                    HospitalBedData.rr[i],
                    HospitalBedData.himage[i]
            ));
        }



        GetBedAdapter adapter = new GetBedAdapter(this, beddaolist);
        recyclerView.setAdapter(adapter);
    }
}

