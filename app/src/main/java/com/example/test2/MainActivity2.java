package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.week2new.R;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        final boolean[] variable = {false};

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //if fllwing alrd, button shows 'Unfollow'
                if (variable[0] == false){
                    button.setText("Unfollow");
                    variable[0] = true;
                }
                //if not fllwing yet, button shows 'Follow'
                else if (variable[0] == true){
                    button.setText("Follow");
                    variable[0] = false;
                }
            }
        });
    }


}