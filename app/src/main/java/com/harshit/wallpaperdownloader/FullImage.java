package com.harshit.wallpaperdownloader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class FullImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        Intent get = getIntent();
        String url = get.getStringExtra("imageUrl");

        ImageView imageView = findViewById(R.id.fullImage);
        Glide.with(getApplicationContext())
                .load(url)
                .into(imageView);

    }
}