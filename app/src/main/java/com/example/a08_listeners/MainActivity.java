package com.example.a08_listeners;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener
{
    Button shortButton, longButton, results;
    ImageView imageView;
    int shorti;
    int longi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.comp);

        shortButton = (Button)findViewById(R.id.shortButton);
        longButton = (Button)findViewById(R.id.longButton);
        results = (Button)findViewById(R.id.results);
        shorti=0;
        longi=0;

        shortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shorti++;

            }
        });
        longButton.setOnLongClickListener(this);

    }



    public void onClickResults(View view) {
        Intent si = new Intent(this, results_activity.class);
        si.putExtra("long", longi);
        si.putExtra("short", shorti);

        startActivityForResult(si,1);
    }


    @Override
    protected void onActivityResult(int source, int good, @Nullable Intent data_back) {
        super.onActivityResult(source, good, data_back);
        if (data_back != null) {
            longi = data_back.getIntExtra("longi", 0);
            shorti = data_back.getIntExtra("shorti", 0);

        }
    }
    
    @Override
    public boolean onLongClick (View v){
        longi += 2;
        return true;
    }


        }