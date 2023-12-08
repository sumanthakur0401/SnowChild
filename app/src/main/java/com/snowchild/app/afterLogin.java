package com.snowchild.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;


import com.github.hariprasanths.bounceview.BounceView;

import java.util.ArrayList;
import java.util.List;


public class afterLogin extends AppCompatActivity {

    Dialog dialog;
    private ImageView myButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_login);

        dialog = new Dialog(this);

        myButton = findViewById(R.id.myButton);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmyBox();



                Button myprofile = (Button) dialog.findViewById(R.id.PersonalProfile);
                Button updates = (Button) dialog.findViewById(R.id.Updates);
                Button ping = (Button) dialog.findViewById(R.id.Ping);
                Button arounyou = (Button) dialog.findViewById(R.id.Arounyou);
                Button logout = (Button) dialog.findViewById(R.id.Logout);

                myprofile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openmyProfile();
                    }
                });

                updates.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openUpdates();
                    }
                });

                ping.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openPing();
                    }
                });

                arounyou.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openAroudYou();
                    }
                });

                logout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openLogoutbox();

                        Button yes=(Button) dialog.findViewById(R.id.Yes);
                        Button no=(Button) dialog.findViewById(R.id.No);

                        yes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                openLogout();
                            }
                        });

                        no.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });
                    }
                });

                }
        });
    }

    private void openmyBox() {

        dialog.setContentView(R.layout.my_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        BounceView.addAnimTo(dialog);

        dialog.show();

    }

    private void openmyProfile() {
        Intent intent = new Intent(this, Personal_profile.class);
        startActivity(intent);
    }

    private void openUpdates(){
        Intent intent = new Intent(this,Updates.class);
        startActivity(intent);
    }

    private void openPing(){
        Intent intent = new Intent(this,ping_something.class);
        startActivity(intent);
    }

    private void openAroudYou(){
        Intent intent = new Intent(this,Around_you.class);
        startActivity(intent);
    }

    private void openLogoutbox(){
        dialog.setContentView(R.layout.activity_logout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        BounceView.addAnimTo(dialog);
        dialog.show();
    }

    private void openLogout() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}