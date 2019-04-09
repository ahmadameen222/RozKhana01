package com.example.dell.rozkhana01;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.ArrayList;
import java.util.List;

import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

public class MainActivity extends AppCompatActivity {

    private FlipperLayout flipperLayout;
    private List<Food> foodList;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private Firebase firebase;
    private DatabaseReference databaseReference;
    private ListView listView;
    ArrayList foodArrayList = new ArrayList();
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipperLayout = (FlipperLayout) findViewById(R.id.flipper);
        setLayout();
        flipperLayout.setVisibility(View.VISIBLE);

        //firebase = new Firebase("https://rozkhana01.firebaseio.com/");
        //databaseReference = FirebaseDatabase.getInstance().getReference("Foods");

        /*Foods artist = new Foods(id, name, genre);
        databaseReference.child(id).setValue(artist);
        */

       // databaseReference = FirebaseDatabase.getInstance().getReference().child("Foods").child("1");

        final ArrayList arrayList = new ArrayList();

        foodList = new ArrayList<>();
        foodList.add(new Food("Chinese Foods", "Description book", R.drawable.thevigitarian));
        foodList.add(new Food("Indian Foods", "Description book", R.drawable.thewildrobot));
        foodList.add(new Food("Beef Dishes", "Description book", R.drawable.mariasemples));
        foodList.add(new Food("Chicken Dishes", "Description book", R.drawable.themartian));
        foodList.add(new Food("Fried Foods", "Description book", R.drawable.hediedwith));
        foodList.add(new Food("Turkish Foods", "Description book", R.drawable.thevigitarian));
        foodList.add(new Food("Fast Foods", "Description book", R.drawable.thewildrobot));
        foodList.add(new Food("Salads", "Description book", R.drawable.mariasemples));
        foodList.add(new Food("Diet food", "Description book", R.drawable.thevigitarian));
        foodList.add(new Food("Natural foods", "Description book", R.drawable.thewildrobot));
        foodList.add(new Food("Seasonal food", "Description book", R.drawable.mariasemples));
        foodList.add(new Food("Frozen food", "Description book", R.drawable.themartian));
        foodList.add(new Food("Organic food", "Description book", R.drawable.hediedwith));
        foodList.add(new Food("Traditional food", "Description book", R.drawable.thevigitarian));

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_id);
        adapter = new RecyclerViewAdapter(this, foodList);
        //adapter = new RecyclerViewAdapter(this, arrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(adapter);

    }

    private void setLayout() {

        String url[] = new String[]{
                "https://i.pinimg.com/564x/79/05/7e/79057efbd3adb70527b006739a5e5386.jpg",
                "https://i.pinimg.com/564x/79/8f/85/798f850d9daf8f86662935861893cd09.jpg",
                "https://i.pinimg.com/564x/a9/ae/b6/a9aeb68de25aff15ca67eda67ee70707.jpg",
                "https://i.pinimg.com/564x/ff/77/95/ff77952869486680d375e4751e9b1260.jpg",
                "https://i.pinimg.com/564x/e0/05/97/e0059799aef73b0346a80b42f5eb5f09.jpg"
        };

        for (int i = 0; i < 5; i++) {
            FlipperView view = new FlipperView(getBaseContext());
            view.setImageUrl(url[i])
                    .setDescription(" ");
            flipperLayout.addFlipperView(view);

            view.setOnFlipperClickListener(new FlipperView.OnFlipperClickListener() {
                @Override
                public void onFlipperClick(FlipperView flipperView) {
                    //    Toast.makeText()
                }
            });

        }
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

                flipperLayout.setVisibility(View.GONE);

//              adapter.getFilter().filter(query);

                String userInput = newText.toLowerCase();
                List<Food> newList = new ArrayList<>();

                for (Food name : foodList) {
                    if (name.title.toLowerCase().contains(userInput)) {
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
