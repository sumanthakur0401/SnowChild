package com.snowchild.app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.hariprasanths.bounceview.BounceView;
import com.skydoves.progressview.ProgressView;

import java.util.Timer;
import java.util.TimerTask;

import javax.crypto.Cipher;

public class Personal_profile extends AppCompatActivity {

   private ImageView backbuttonicon,menuB,editB;
   Dialog dialog;
   private ProgressBar pb;
   private TextView profileUN;
   int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_profile);

        prog();

        profileUN = findViewById(R.id.profileusername);

        dialog = new Dialog(this);

        editB = findViewById(R.id.edit_button);
        editB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openeditmenu();
            }
        });

        menuB = findViewById(R.id.menu_button);
        menuB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmenu();
            }
        });

        backbuttonicon =  findViewById(R.id.backbuttonicon);
        backbuttonicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goback();
            }
        });
    }


    public void openeditmenu(){
        dialog.setContentView(R.layout.edit_menu);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        BounceView.addAnimTo(dialog);
        dialog.show();

    }

    public void openmenu(){
        dialog.setContentView(R.layout.menu_profile);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        BounceView.addAnimTo(dialog);
        dialog.show();

    }

    public void prog(){
        pb = (ProgressBar) findViewById(R.id.pbar);

        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter++;
                pb.setProgress(counter);
                if(counter == 35){
                    profileUN.setTextColor(getResources().getColor(R.color.officialblue));
                }
                else
                if(counter==100)
                {
                    t.cancel();
                }

            }
        };
        t.schedule(tt,0,100);
    }

    private void goback() {
        Intent intent = new Intent(this,afterLogin.class);
        startActivity(intent);
        finish();
    }
}