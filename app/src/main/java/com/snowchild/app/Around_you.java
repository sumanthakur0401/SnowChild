package com.snowchild.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Around_you extends AppCompatActivity {

    private ImageView goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_around_you);

        goBack = findViewById(R.id.backbuttonicon2);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Goback();
            }
        });

    }

    private void Goback(){
        Intent intent = new Intent(this,afterLogin.class);
        startActivity(intent);
    }
}