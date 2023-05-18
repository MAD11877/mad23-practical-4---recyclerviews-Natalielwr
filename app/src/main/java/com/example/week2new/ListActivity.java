package com.example.week2new;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.view.View.OnClickListener;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        String name = generateRandom();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(true);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                intent.putExtra("Key", name);
                startActivity(intent); //changes to the destination activity
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //action
            }
        });

        ImageView image = findViewById(R.id.imageView3);

        image.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View image) {
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
    private String generateRandom() {
        String name = "";

        Random randomNum = new Random();

        long min1 = 100000000L;  // Minimum 9-digit number
        long max1 = 9999999999L; // Maximum 10-digit number
        long randomNumber1 = min1 + ((long) (randomNum.nextDouble() * (max1 - min1)));
        name = "MAD " + randomNumber1;

        return name;
    }
}