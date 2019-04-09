package com.example.dell.rozkhana01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodActivity extends AppCompatActivity {

    private TextView tvtitle, tvdescription, tvIng;
    private ImageView img;
/*
    String Title, Description, Ingredients;
    int image;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        tvtitle = (TextView) findViewById(R.id.txttitle);
        tvdescription = (TextView) findViewById(R.id.txtDesc);
        tvIng = (TextView) findViewById(R.id.txtIngredients);
        img = (ImageView) findViewById(R.id.bookthumbnail);

        // Receive data
/*
        Intent intent = getIntent();
         Title = intent.getExtras().getString("Title");
         Description = intent.getExtras().getString("Desc");
         Ingredients = intent.getExtras().getString("Ingredients");
         image = intent.getExtras().getInt("Thumbnail");
*/

        Bundle extras = getIntent().getExtras();
        String title=extras.getString("Title");
        String desc=extras.getString("Ingredients");
        int myImg=extras.getInt("Thumbnail");
        String ing=extras.getString("Desc");
        String ing_names_only = extras.getString("ingNamesOnly");
        // Setting values

        tvtitle.setText(title);
        tvdescription.setText(desc);
        img.setImageResource(myImg);
        tvIng.setText(ing);

        Button order_btn = (Button) findViewById(R.id.order_btn);
        order_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // Intent intent = new Intent(FoodActivity.this, FirebaseAuthenticationActivity.class);
               // startActivity(intent);

                Intent intent = new Intent(FoodActivity.this, FirebaseActivity.class);
                //Intent intent = new Intent(FoodActivity.this, FoodActivityLoggedIn.class);
                startActivity(intent);
            }
        });
    }
}




