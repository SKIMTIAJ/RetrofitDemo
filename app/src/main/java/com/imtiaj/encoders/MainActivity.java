package com.imtiaj.encoders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.imtiaj.encoders.databinding.DataActivity;
import com.imtiaj.encoders.post_method_project.PostActivity;
import com.imtiaj.encoders.team.TeamActivity;
import com.imtiaj.encoders.team.TeamInterface;

public class MainActivity extends AppCompatActivity {

    Button dataBindingButton;
    Button getButton;
    Button postButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dataBindingButton = findViewById(R.id.dataBindingButton);
        getButton = findViewById(R.id.getMethodButton);
        postButton = findViewById(R.id.postMethodButton);

        dataBindingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DataActivity.class));
            }
        });

        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TeamActivity.class));
            }
        });

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PostActivity.class));
            }
        });


    }
}