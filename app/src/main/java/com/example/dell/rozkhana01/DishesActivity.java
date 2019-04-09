package com.example.dell.rozkhana01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import technolifestyle.com.imageslider.FlipperLayout;

public class DishesActivity extends AppCompatActivity {

    List<Dishes> dishesList;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapterDishes adapter;

    public static final String API_URL = "http://192.168.56.1:8000/app/sendDishes/";
    /*
        RequestQueue rq;
    */
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishes);

/*
        rq=Volley.newRequestQueue(this);
        rq.start();
*/

        Bundle extras = getIntent().getExtras();
        title = extras.getString("Title");

/*
        StringRequest putReq = new StringRequest(Request.Method.POST, API_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    Toast.makeText(DishesActivity.this, "RESPONSE FROM SERVER", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("category",title );


                return params;
            }

        };
              rq.add(putReq);
*/


        dishesList = new ArrayList<>();
        if (title.equals("Chinese Foods"))

        {
            dishesList.add(new Dishes("- Sugar  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Chow Mein", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbgff, "Chinese Foods", "Sugar Oil Dates Choco Milk"));
            dishesList.add(new Dishes("- Sugjn  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Kung Pao Chicken", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbg, "Chinese Foods", "Sugar Oil Dates Choco Milk"));
            dishesList.add(new Dishes("- Sugar  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Ma Po Tofu", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbgf, "Chinese Foods", "Sugar Oil Dates Choco Milk"));
            dishesList.add(new Dishes("- Sugar  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Wontons", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbgff, "Chinese Foods", "Sugar Oil Dates Choco Milk"));
            dishesList.add(new Dishes("- Sugar  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Dumplings", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbg, "Chinese Foods", "Sugar Oil Dates Choco Milk"));
            dishesList.add(new Dishes("- Sugar  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Peking Roasted Duck", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbgf, "Chinese Foods", "Sugar Oil Dates Choco Milk"));
            dishesList.add(new Dishes("- Sugar  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Beijing Xi'an", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbgff, "Chinese Foods", "Sugar Oil Dates Choco Milk"));
            dishesList.add(new Dishes("- Sugar  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Spring Rolls", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbg, "Chinese Foods", "Sugar Oil Dates Choco Milk"));
            dishesList.add(new Dishes("- Sugar  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Peking duck ", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbgf, "Chinese Foods", "Sugar Oil Dates Choco Milk"));
            dishesList.add(new Dishes("- Sugar  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Chow Mein", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbgff, "Chinese Foods", "Sugar Oil Dates Choco Milk"));
        } else if (title.equals("Indian Foods"))

        {
            dishesList.add(new Dishes("- Sugar  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Butter Chicken", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbgf, "Indian Foods", "Sugar Oil Dates Choco Milk"));
            dishesList.add(new Dishes("- Sugar  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Bhatura", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbgff, "Indian Foods", "Sugar Oil Dates Choco Milk"));
            dishesList.add(new Dishes("- Sugar  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Biryani", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbg, "Indian Foods", "Sugar Oil Dates Choco Milk"));
            dishesList.add(new Dishes("- Sugar  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Chaat", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbgf, "Indian Foods", "Sugar Oil Dates Choco Milk"));
            dishesList.add(new Dishes("- Sugar  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Chicken Tikka", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbgff, "Indian Foods", "Sugar Oil Dates Choco Milk"));
            dishesList.add(new Dishes("- Sugar  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Chicken Tikka masala", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbg, "Indian Foods", "Sugar Oil Dates Choco Milk"));
            dishesList.add(new Dishes("- Sugar  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Gajar ka halwa", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbgf, "Indian Foods", "Sugar Oil Dates Choco Milk"));
            dishesList.add(new Dishes("- Sugar  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Imarti", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbgff, "Indian Foods", "Sugar Oil Dates Choco Milk"));
            dishesList.add(new Dishes("- Sugar  1/2 Kg \n\n - Oil   0.25 Kg \n\n - Dates   0.25 Kg \n\n - Choco   0.25 Kg \n\n - Milk   0.25 Kg", "Kachori", "Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, along with exposition, argumentation, and narration. In practice it would be difficult to write literature that drew on just one of the four basic modes.", R.drawable.foodbg, "Indian Foods", "Sugar Oil Dates Choco Milk"));
        } else

        {

            Toast toast = Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT);
            toast.show();

        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_dish_id);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapterDishes(this, dishesList);
//      rcecyclerView.setLayoutManager(new RecyclerView.LayoutManager(this, 3);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.commonmenu, menu);
        MenuItem item = menu.findItem(R.id.app_bar_search);

        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


//                adapter.getFilter().filter(query);
                String userInput = newText.toLowerCase();
                List<Dishes> newList = new ArrayList<>();

                for (Dishes name : dishesList) {
                    if (name.dish_title.toLowerCase().contains(userInput)) {
                        newList.add(name);
                    }
                }

                adapter.UpdateList(newList);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.app_bar_search) {

        }

        if (id == R.id.app_bar_settings) {

        }

        return super.onOptionsItemSelected(item);
    }
}
