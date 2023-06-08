package com.example.week2new;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<User> userList = new ArrayList<User>();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //ArrayList<User> userList = generateUserList(20);
        generateUserList(userList, 20);

        UserAdapter uAdapter = new UserAdapter(userList);

        LinearLayoutManager uLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(uLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(uAdapter);

        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(true);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                intent.putExtra("Key", );
                startActivity(intent); //changes to the destination activity
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //action
            }
        });

        ImageView image = findViewById(R.id.imageView);
        image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View image) {
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
*/
    }

    //User View Holder
    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView profilePicture;
        public TextView contactName;
        public TextView messagePreview;

        public UserViewHolder(View itemView) {
            super(itemView);
            profilePicture = itemView.findViewById(R.id.imageView);
            contactName = itemView.findViewById(R.id.textView);
            messagePreview = itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int row = getLayoutPosition();

            if (contactName.getText().toString().endsWith("7"))
            {

            }

            AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
            builder.setTitle("Profile");
            builder.setMessage(contactName.getText().toString());
            builder.setCancelable(true);
            builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Intent intent = new Intent(ListActivity.this, MainActivity.class);
                    intent.putExtra("Key", contactName.getText().toString());
                    startActivity(intent); //changes to the destination activity
                }
            });
            builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //action
                }
            });

            AlertDialog alert = builder.create();
            alert.show();

//            ImageView image = findViewById(R.id.imageView);
//            image.setOnClickListener(new View.OnClickListener()
//            {
//                @Override
//                public void onClick(View image) {
//                    AlertDialog alert = builder.create();
//                    alert.show();
//                }
//            });

            //Toast.makeText(itemView.getContext(), String.valueOf(row), Toast.LENGTH_SHORT).show();
        }
    }

    public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
        ArrayList<User> userList;

        public UserAdapter(ArrayList<User> data) {
            this.userList = data;
            Log.v("MAD", "Size is " + String.valueOf(userList.size()));
        }

        public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View item = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.view_holder,
                    parent,
                    false);
            return new UserViewHolder(item);
        }

        public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
            User user = userList.get(position);
            holder.contactName.setText(user.getName());
            holder.messagePreview.setText(user.getDesc());

            Log.v("MAD", user.getName() + " is at " + String.valueOf(position));
        }

        public int getItemCount() {
            return userList.size();
        }

    }

    // method to create userList
    public ArrayList<User> generateUserList(ArrayList<User> userList, int count) {
        //ArrayList<User> userList = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            User user = new User();
            user.setId(i);
            userList.add(user);
            //Log.v("MAD", user.getName());
        }

        return userList;
    }
}

    /*
    public String generateRandom() {
        String name = "";

        Random randomNum = new Random();

        long min1 = 100000000L;  // Minimum 9-digit number
        long max1 = 9999999999L; // Maximum 10-digit number
        long randomNumber1 = min1 + ((long) (randomNum.nextDouble() * (max1 - min1)));
        name = "MAD " + randomNumber1;

        return name;
    }
     */

/*
    public static void main(String[] args) {
        List<User> userList = generateUserList(20);

        // Print the details of each user
        for (User user : userList) {
            System.out.println("ID: " + user.getId());
            System.out.println("Name: " + user.getName());
            System.out.println("Desc: " + user.getDesc());
            System.out.println("Followed: " + user.isFollowed());
            System.out.println();
        }
    }
 */

