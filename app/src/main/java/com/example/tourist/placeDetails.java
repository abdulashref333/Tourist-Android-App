package com.example.tourist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class placeDetails extends AppCompatActivity {
    ImageView im;
    TextView placNameView;
    TextView placeDetailsView;
    Button placeBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);
       Integer[] images = new Integer[]{R.drawable.aswan, R.drawable.luxor, R.drawable.qena, R.drawable.karanak, R.drawable.comombo, R.drawable.abosimple, R.drawable.edfo, R.drawable.elgorna, R.drawable.engineering};

        placeDetailsView = findViewById(R.id.placeDetails);
        placNameView = findViewById(R.id.placeName);
        placeBtn = findViewById(R.id.placeBtn);
        im = findViewById(R.id.placeImage);

        // get the data values....
        Intent intent = getIntent();
        String placeNameValue = intent.getStringExtra("name");
        String placeDetailsValue = intent.getStringExtra("details");
        int placeImageIndex = intent.getIntExtra("index", 0);

        placeDetailsView.setText(placeDetailsValue);
        placNameView.setText(placeNameValue);
//        System.out.println("place name " + placeNameValue);
//        System.out.println("place details " + placeDetailsValue);
//        System.out.println(images[0]);
//        im.setImageResource(getResources().getIdentifier(
//                "aswan", "drawable", "com.package.application"));

        im.setImageResource(images[placeImageIndex]);

        placeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("i am here ...");
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q= " + placeNameValue);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
            }
        });
    }
}

