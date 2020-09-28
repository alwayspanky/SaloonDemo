package com.example.saloondemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.gridlayout.widget.GridLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.request.RequestOptions;
import com.glide.slider.library.SliderLayout;
import com.glide.slider.library.slidertypes.BaseSliderView;
import com.glide.slider.library.slidertypes.TextSliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    SliderLayout sliderLayout;
    RecyclerView recyclerView, recyclerSpecial ;
    ArrayList<itemModel> arrayList;
    int icons[] = {R.drawable.haircut,R.drawable.coloring,R.drawable.hairstyle,R.drawable.hairdryyer,
            R.drawable.hairspa,R.drawable.shampoo,R.drawable.shaving,R.drawable.massage};
    String iconsName[] ={"Haircut","Coloring","Hairstyle","Hairdryer","HairSpa","Shampoo","Shaving","Massage"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler_view);
        arrayList = new ArrayList<>();

        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        for (int i = 0; i < icons.length; i++) {
            itemModel itemModel = new itemModel();
            itemModel.setImage(icons[i]);
            itemModel.setName(iconsName[i]);
            arrayList.add(itemModel);
        }

        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(), arrayList);
        recyclerView.setAdapter(adapter);


        ///Hair Specialist
        recyclerSpecial = findViewById(R.id.recycler_special);
        LinearLayoutManager horizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerSpecial.setLayoutManager(horizontal);
        recyclerSpecial.setAdapter(new SpecialistAdapter());

        //////// Slider Layout
        sliderLayout = findViewById(R.id.banner_layout);
        sliderLayout.startAutoCycle();
        setupSlider();
    }

    private void setupSlider() {
        ArrayList<String> listUrl = new ArrayList<>();

        listUrl.add("https://previews.123rf.com/images/pivden/pivden1609/pivden160900064/62188006-head-hipster-and-equipment-for-barbershop-with-comb-razor-shaving-brush-pole-scissors-and-bottle-spr.jpg");
        listUrl.add("https://previews.123rf.com/images/pivden/pivden1609/pivden160900141/63081918-set-tool-for-barbershop-with-comb-razor-shaving-brush-pole-scissors-bottle-spray-and-hair-cutting-ma.jpg");
        listUrl.add("https://previews.123rf.com/images/pivden/pivden1609/pivden160900056/62187998-head-hipster-and-equipment-for-barbershop-with-comb-razor-shaving-brush-scissors-and-bottle-spray-ve.jpg");

        for(int i = 0; i < listUrl.size(); i++)
        {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.centerCrop();

            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .image(listUrl.get(i))
                    .setRequestOption(requestOptions)
                    .setProgressBarVisible(true)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView baseSliderView) {
                            return;
                        }
                    });

            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.stopCyclingWhenTouch(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.home_menu){

            Intent i = new Intent(MainActivity.this,AdminActivity.class);
            startActivity(i);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

}