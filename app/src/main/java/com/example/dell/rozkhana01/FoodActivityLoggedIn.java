package com.example.dell.rozkhana01;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.service.autofill.Transformation;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;
/*
import static com.example.dell.rozkhana01.R.id.fragment;*/

public class FoodActivityLoggedIn extends AppCompatActivity {

    String[] splitIngredients;
    private TextView store_tv, tvtitle, tvdescription, tvIng, ing1_tv, ing2_tv, ing3_tv, ing4_tv, ing5_tv, ing6_tv, ing7_tv, txtDescription, add_item_tv;
    private EditText ing1_et, ing2_et, ing3_et, ing4_et, ing5_et, ing6_et, ing7_et, ing1_name_hidden_et, ing2_name_hidden_et, ing3_name_hidden_et, ing4_name_hidden_et, ing5_name_hidden_et, ing1_quantity_hidden_et, ing2_quantity_hidden_et, ing3_quantity_hidden_et, ing4_quantity_hidden_et, ing5_quantity_hidden_et;
    private ImageView img;
    private Button rating_btn, logout_btn, order_final_btn, place_order_final_btn;
    String title, desc, ing, ing_names_only;
    LinearLayout linearLayoutIng1, linearLayoutIng2, linearLayoutIng3, linearLayoutIng4, linearLayoutIng5, linearLayoutIng6, linearLayoutIng7, ingredients_layout, ing1_hidden_layout, ing2_hidden_layout, ing3_hidden_layout, ing4_hidden_layout, ing5_hidden_layout;
    //long animationDuration  = 1000;
    int myImg;
    static int count = 0;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_logged_in);

//        Firebase ref = new Firebase(Config.FIREBASE_URL);

        //databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        logout_btn = (Button) findViewById(R.id.logout_btn);
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();

                Intent i = new Intent(FoodActivityLoggedIn.this, MainActivity.class);
                startActivity(i);

            }
        });

        //cart items hidden for order

        ing1_tv = (TextView) findViewById(R.id.ing1_tv);
        ing2_tv = (TextView) findViewById(R.id.ing2_tv);
        ing3_tv = (TextView) findViewById(R.id.ing3_tv);
        ing4_tv = (TextView) findViewById(R.id.ing4_tv);
        ing5_tv = (TextView) findViewById(R.id.ing5_tv);
        //ing6_tv = (TextView) findViewById(R.id.ing6_tv);
        //ing7_tv = (TextView) findViewById(R.id.ing7_tv);

        ing1_et = (EditText) findViewById(R.id.ing1_et);
        ing2_et = (EditText) findViewById(R.id.ing2_et);
        ing3_et = (EditText) findViewById(R.id.ing3_et);
        ing4_et = (EditText) findViewById(R.id.ing4_et);
        ing5_et = (EditText) findViewById(R.id.ing5_et);
       // ing6_et = (EditText) findViewById(R.id.ing6_et);
       // ing7_et = (EditText) findViewById(R.id.ing7_et);

        linearLayoutIng1 = (LinearLayout) findViewById(R.id.ing1_layout);
        linearLayoutIng2 = (LinearLayout) findViewById(R.id.ing2_layout);
        linearLayoutIng3 = (LinearLayout) findViewById(R.id.ing3_layout);
        linearLayoutIng4 = (LinearLayout) findViewById(R.id.ing4_layout);
        linearLayoutIng5 = (LinearLayout) findViewById(R.id.ing5_layout);
        //linearLayoutIng6 = (LinearLayout) findViewById(R.id.ing6_layout);
        //linearLayoutIng7 = (LinearLayout) findViewById(R.id.ing7_layout);

        ingredients_layout = (LinearLayout) findViewById(R.id.ingredients_layout);

        //hidden items edit texts

        ing1_name_hidden_et = (EditText) findViewById(R.id.ing1_name_hidden_et);
        ing2_name_hidden_et = (EditText) findViewById(R.id.ing2_name_hidden_et);
        ing3_name_hidden_et = (EditText) findViewById(R.id.ing3_name_hidden_et);
        ing4_name_hidden_et = (EditText) findViewById(R.id.ing4_name_hidden_et);
        ing5_name_hidden_et = (EditText) findViewById(R.id.ing5_name_hidden_et);

        ing1_quantity_hidden_et = (EditText) findViewById(R.id.ing1_quantity_hidden_et);
        ing2_quantity_hidden_et = (EditText) findViewById(R.id.ing2_quantity_hidden_et);
        ing3_quantity_hidden_et = (EditText) findViewById(R.id.ing3_quantity_hidden_et);
        ing4_quantity_hidden_et = (EditText) findViewById(R.id.ing4_quantity_hidden_et);
        ing5_quantity_hidden_et = (EditText) findViewById(R.id.ing5_quantity_hidden_et);

        rating_btn = (Button) findViewById(R.id.rating_btn);


        //add Items

        add_item_tv = (TextView) findViewById(R.id.add_item_tv);

        //Hidden items

        ing1_name_hidden_et = (EditText) findViewById(R.id.ing1_name_hidden_et);
        ing2_name_hidden_et = (EditText) findViewById(R.id.ing2_name_hidden_et);
        ing3_name_hidden_et = (EditText) findViewById(R.id.ing3_name_hidden_et);
        ing4_name_hidden_et = (EditText) findViewById(R.id.ing4_name_hidden_et);
        ing5_name_hidden_et = (EditText) findViewById(R.id.ing5_name_hidden_et);

        ing1_quantity_hidden_et = (EditText) findViewById(R.id.ing1_quantity_hidden_et);
        ing2_quantity_hidden_et = (EditText) findViewById(R.id.ing2_quantity_hidden_et);
        ing3_quantity_hidden_et = (EditText) findViewById(R.id.ing3_quantity_hidden_et);
        ing4_quantity_hidden_et = (EditText) findViewById(R.id.ing4_quantity_hidden_et);
        ing5_quantity_hidden_et = (EditText) findViewById(R.id.ing5_quantity_hidden_et);

        //hidden layouts for add_item

        ing1_hidden_layout = (LinearLayout) findViewById(R.id.ing1_hidden_layout);
        ing2_hidden_layout = (LinearLayout) findViewById(R.id.ing2_hidden_layout);
        ing3_hidden_layout = (LinearLayout) findViewById(R.id.ing3_hidden_layout);
        ing4_hidden_layout = (LinearLayout) findViewById(R.id.ing4_hidden_layout);
        ing5_hidden_layout = (LinearLayout) findViewById(R.id.ing5_hidden_layout);

        //final int counter=0;

        add_item_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                if (count == 1) {
                    ing1_hidden_layout.setVisibility(View.VISIBLE);
                } else if (count == 2) {
                    ing2_hidden_layout.setVisibility(View.VISIBLE);
                } else if (count == 3) {
                    ing3_hidden_layout.setVisibility(View.VISIBLE);
                } else if (count == 4) {
                    ing4_hidden_layout.setVisibility(View.VISIBLE);
                } else if (count == 5) {
                    ing5_hidden_layout.setVisibility(View.VISIBLE);
                    count = 0;
                } else {

                }
            }
        });

        store_tv = (TextView) findViewById(R.id.store_tv);

        order_final_btn = (Button) findViewById(R.id.order_final_btn);
        order_final_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvdescription.setVisibility(View.GONE);
                rating_btn.setVisibility(View.GONE);
                txtDescription.setVisibility(View.GONE);
                order_final_btn.setVisibility(View.GONE);

                //img.setImageResource(R.drawable.ic_action_cart);
                img.setBackgroundResource(R.drawable.ic_action_cart);
                splitIngredients = ing_names_only.toString().split("\\s+");

                store_tv.setVisibility(View.VISIBLE);

                ingredients_layout.setVisibility(View.VISIBLE);
                linearLayoutIng1.setVisibility(View.VISIBLE);
                linearLayoutIng2.setVisibility(View.VISIBLE);
                linearLayoutIng3.setVisibility(View.VISIBLE);
                linearLayoutIng4.setVisibility(View.VISIBLE);
                linearLayoutIng5.setVisibility(View.VISIBLE);

                ing1_tv.setText(splitIngredients[0]);
                ing2_tv.setText(splitIngredients[1]);
                ing3_tv.setText(splitIngredients[2]);
                ing4_tv.setText(splitIngredients[3]);
                ing5_tv.setText(splitIngredients[4]);
            }
        });

        place_order_final_btn = (Button) findViewById(R.id.place_order_final_btn);
        place_order_final_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ing1 = ing1_et.getText().toString().trim();
                String ing2 = ing2_et.getText().toString().trim();
                String ing3 = ing3_et.getText().toString().trim();
                String ing4 = ing4_et.getText().toString().trim();
                String ing5 = ing5_et.getText().toString().trim();

                String ing_n_hidden_1 = ing1_name_hidden_et.getText().toString().trim();
                String ing_n_hidden_2 = ing2_name_hidden_et.getText().toString().trim();
                String ing_n_hidden_3 = ing3_name_hidden_et.getText().toString().trim();
                String ing_n_hidden_4 = ing4_name_hidden_et.getText().toString().trim();
                String ing_n_hidden_5 = ing5_name_hidden_et.getText().toString().trim();

                String ing_q_hidden_1 = ing1_quantity_hidden_et.getText().toString().trim();
                String ing_q_hidden_2 = ing2_quantity_hidden_et.getText().toString().trim();
                String ing_q_hidden_3 = ing3_quantity_hidden_et.getText().toString().trim();
                String ing_q_hidden_4 = ing4_quantity_hidden_et.getText().toString().trim();
                String ing_q_hidden_5 = ing5_quantity_hidden_et.getText().toString().trim();

                //databaseReference.child("Orders").setValue("1");

                databaseReference.child("Orders").child("Order By:" + " " + FirebaseAuth.getInstance().getUid()).push().setValue(splitIngredients[0] + " " + ing1);
                databaseReference.child("Orders").child("Order By:" + " " + FirebaseAuth.getInstance().getUid()).push().setValue(splitIngredients[0] + " " + ing1);
                databaseReference.child("Orders").child("Order By:" + " " + FirebaseAuth.getInstance().getUid()).push().setValue(splitIngredients[1] + " " + ing2);
                databaseReference.child("Orders").child("Order By:" + " " + FirebaseAuth.getInstance().getUid()).push().setValue(splitIngredients[2] + " " + ing3);
                databaseReference.child("Orders").child("Order By:" + " " + FirebaseAuth.getInstance().getUid()).push().setValue(splitIngredients[3] + " " + ing4);
                databaseReference.child("Orders").child("Order By:" + " " + FirebaseAuth.getInstance().getUid()).push().setValue(splitIngredients[4] + " " + ing5);
                databaseReference.child("Orders").child("Order By:" + " " + FirebaseAuth.getInstance().getUid()).push().setValue(ing_n_hidden_1 + " " + ing_q_hidden_1);
                databaseReference.child("Orders").child("Order By:" + " " + FirebaseAuth.getInstance().getUid()).push().setValue(ing_n_hidden_2 + " " + ing_q_hidden_2);
                databaseReference.child("Orders").child("Order By:" + " " + FirebaseAuth.getInstance().getUid()).push().setValue(ing_n_hidden_3 + " " + ing_q_hidden_3);
                databaseReference.child("Orders").child("Order By:" + " " + FirebaseAuth.getInstance().getUid()).push().setValue(ing_n_hidden_4 + " " + ing_q_hidden_4);
                databaseReference.child("Orders").child("Order By:" + " " + FirebaseAuth.getInstance().getUid()).push().setValue(ing_n_hidden_5 + " " + ing_q_hidden_5);
                databaseReference.child("Orders").child("Order By:" + " " + FirebaseAuth.getInstance().getUid()).push().setValue("Phone Number Id:" + " " + FirebaseAuth.getInstance().getUid());

                //dialogue box
/*
                Note note = new Note();
                note.setThumbnail(databaseReference.child("notes").push().getKey());
                note.setTitle("dasf");
                note.setDescription("dasf");
                databaseReference.child("notes").child(note.getThumbnail()).setValue(note);
*/
//                finish();

                final AlertDialog.Builder builder = new AlertDialog.Builder(FoodActivityLoggedIn.this);
                builder.setMessage("Your Order Has Been Placed!");
                builder.setTitle("ORDER");
                builder.setIcon(R.drawable.ic_action_cart);

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(FoodActivityLoggedIn.this, FoodActivityLoggedIn.class));
                        Toast.makeText(FoodActivityLoggedIn.this, "Order Placed Successfully!", Toast.LENGTH_SHORT).show();
                    }
                });

                final AlertDialog alertDialog = builder.create();
                alertDialog.setCancelable(false);
                alertDialog.show();

            }
        });

        tvtitle = (TextView) findViewById(R.id.txttitle);
        tvdescription = (TextView) findViewById(R.id.txtDesc);
        tvIng = (TextView) findViewById(R.id.txtIngredients);
        img = (ImageView) findViewById(R.id.bookthumbnail);
        txtDescription = (TextView) findViewById(R.id.txtDescription);

        SharedPreferences sharedPreferences = getSharedPreferences("FoodDetails", Context.MODE_PRIVATE);
        title = sharedPreferences.getString("Title", "");
        ing = sharedPreferences.getString("Ingredients", "");
        desc = sharedPreferences.getString("Desc", "");
        myImg = sharedPreferences.getInt("Thumbnail", 0);
        ing_names_only = sharedPreferences.getString("ingNamesOnly", "");

        tvtitle.setText(title);
        tvdescription.setText(desc);
        img.setImageResource(myImg);
        tvIng.setText(ing);
    }
}

