package com.example.tourist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listId);
//
        ArrayList<String> places = new ArrayList<String>();
        places.add("aswan");
        places.add("Luxor");
        places.add("Qena");
        places.add("Karanak");
        places.add("Kom-Ombo");
        places.add("Abo-Simple");
        places.add("Edffo");
        places.add("Elqourna");
        places.add("Faculty Of Engineering Aswan");


        ArrayList<Place> placesWithDetails = new ArrayList<Place>();
        placesWithDetails.add(new Place("Aswan", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\n" +
                "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..."));
        placesWithDetails.add(new Place("Luxor", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\n" +
                "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..."));
        placesWithDetails.add(new Place("Qena", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\n" +
                "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..."));
        placesWithDetails.add(new Place("Karanak", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\n" +
                "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..."));
        placesWithDetails.add(new Place("Kom-Ombo", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\n" +
                "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..."));
        placesWithDetails.add(new Place("Abo-Simple", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\n" +
                "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..."));
        placesWithDetails.add(new Place("Edffo", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\n" +
                "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..."));
        placesWithDetails.add(new Place("Elqourna", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\n" +
                "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..."));
        placesWithDetails.add(new Place("Faculty Of Engineering Aswan", "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\n" +
                "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..."));

        ArrayAdapter placesAdapter = new ArrayAdapter(this, R.layout.row, R.id.text_view_item,places);
        listView.setAdapter(placesAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, " " + i + ":",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, placeDetails.class);
                intent.putExtra("name", placesWithDetails.get(i).name);
                intent.putExtra("details", placesWithDetails.get(i).details);
                intent.putExtra("index", i);
                startActivity(intent);
            }
        });
    }
}