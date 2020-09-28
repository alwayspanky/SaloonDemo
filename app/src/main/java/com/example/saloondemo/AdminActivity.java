package com.example.saloondemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.gridlayout.widget.GridLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminActivity extends AppCompatActivity {

    GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        gridLayout = findViewById(R.id.admin_grid);
        setSingleEvent(gridLayout);
    }

    private void setSingleEvent(GridLayout gridLayout) {

        for(int i= 0; i<gridLayout.getChildCount();i++){

            CardView cardView   = (CardView)gridLayout.getChildAt(i);
            final int finalI = i;


            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    switch (finalI){
                        case 0:

                        case 1:
                            Intent comIntent = new Intent(AdminActivity.this,EmployeeActivity.class);
                            startActivity(comIntent);
                            break;
                        case 2:


                        case 3:


                        default:
                            break;

                    }
                }
            });
        }
    }
}