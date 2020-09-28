package com.example.saloondemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.gridlayout.widget.GridLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SelectTimeActivity extends AppCompatActivity {

    GridLayout gridLayout;
    private TextView textView;
    private Button apt_button;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_time);

        apt_button = findViewById(R.id.appo_button);
        apt_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectTimeActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                Toast.makeText(SelectTimeActivity.this,"Appointment booked",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        gridLayout = findViewById(R.id.gridLayout2);
        setSingleEvent(gridLayout);

        //Select Specialist
        recyclerView = findViewById(R.id.select_recycler);
        LinearLayoutManager horizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(horizontal);
        recyclerView.setAdapter(new SpecialistAdapter());

    }

    private void setSingleEvent(GridLayout gridLayout) {


        for(int i= 0; i<gridLayout.getChildCount();i++){

            final CardView cardView   = (CardView)gridLayout.getChildAt(i);
            final int finalI = i;


            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}