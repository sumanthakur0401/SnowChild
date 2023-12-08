package com.snowchild.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ping_something extends AppCompatActivity {

    private ImageView goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping_something);

        goBack = findViewById(R.id.backbuttonicon1);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Goback();
            }
        });
    }
    private void Goback(){
        Intent intent = new Intent(this,afterLogin.class);;
        startActivity(intent);
    }

}