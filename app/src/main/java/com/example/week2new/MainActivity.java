package com.example.week2new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        final boolean[] variable = {false};

        Intent receivingEnd = getIntent();
        String message = receivingEnd.getStringExtra("Key");
        TextView myTextView = findViewById(R.id.editTextText2);
        myTextView.setText(message);

        button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //if fllwing alrd, button shows 'Unfollow'
                if (variable[0] == false)
                {
                    button.setText("Unfollow");
                    variable[0] = true;
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }
                //if not fllwing yet, button shows 'Follow'
                else if (variable[0] == true)
                {
                    button.setText("Follow");
                    variable[0] = false;
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button button2 = findViewById(R.id.button2);

        //passing info via intent
        button2.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent message = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(message);
            }
        });

    }
}