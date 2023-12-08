package com.snowchild.app;

import static android.app.ProgressDialog.show;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class MainActivity2 extends AppCompatActivity {

    private EditText name,username,pass1,pass2,email;
    private Button Cnew;
    private FirebaseAuth mAuth;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        img = findViewById(R.id.backbutton);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

        mAuth = FirebaseAuth.getInstance();

        name = (EditText) findViewById(R.id.TextFullName);
        username = (EditText) findViewById(R.id.TextUserName);
        pass1 = (EditText) findViewById(R.id.TextPassword1);
        pass2 = (EditText) findViewById(R.id.TextPassword2);
        email = (EditText) findViewById(R.id.TextEmailAddress);

        Cnew = (Button) findViewById(R.id.Create_button);
        Cnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registeruser();
            }
        });

    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

   public void registeruser(){
    String fullname = name.getText().toString().trim();
       String uname = username.getText().toString().trim();
       String password1 = pass1.getText().toString().trim();
       String password2 = pass2.getText().toString().trim();
       String Email = email.getText().toString().trim();

       if(fullname.isEmpty()){
           name.setError("Name Required!!!");
           name.requestFocus();
           return;
       }

       if(uname.isEmpty()){
           username.setError("Username Required!!!");
           username.requestFocus();
           return;
       }


       if(password1.isEmpty()){
           pass1.setError("Password Required!!!");
           pass1.requestFocus();
           return;
       }

       if(password1.length() < 6){
           pass1.setError("Min password length is 6 characters");
           pass1.requestFocus();
           return;
       }

       if(password2.isEmpty()){
           pass2.setError("Re-enter the Password!!!");
           pass2.requestFocus();
           return;
       }

       if(password1 == password2){
           pass2.setError("Your Password doesn't match");
           pass2.requestFocus();
           return;
       }

       if(Email.isEmpty()){
           email.setError("Email Required!!!");
           email.requestFocus();
           return;
       }

       if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
           email.setError("Enter Valid Email Address!!!");
           email.requestFocus();
           return;
       }
       openLoading();
       mAuth.createUserWithEmailAndPassword(Email,password1)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Users users = new Users(fullname,uname,password1,Email);

                        FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(users);
                    }
                });
    }

    public void openLoading(){
        Intent intent1 = new Intent(this, Loading.class);
        startActivity(intent1);
    }
}