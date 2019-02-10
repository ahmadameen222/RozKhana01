package com.example.dell.rozkhana01;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Hallfinder extends AppCompatActivity {

    /*Button logout_btn;*/

    private static int SPLASH_TIME_OUT = 4000;

    String Title, Description, Ingredients;
    int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hallfinder);

/*
        logout_btn = (Button)findViewById(R.id.logout_btn);
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();

                Intent i = new Intent(Hallfinder.this, MainActivity.class);
                startActivity(i);

            }
        });
*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Hallfinder.this, FoodActivityLoggedIn.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
