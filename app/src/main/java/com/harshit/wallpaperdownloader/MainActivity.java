package com.harshit.wallpaperdownloader;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText searchEt;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        searchEt = findViewById(R.id.editText);
        img = findViewById(R.id.image);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mySearch = searchEt.getText().toString();
                if(!mySearch.isEmpty()){

                    Glide.with(view)
                            .load(mySearch)
                            .into(img);

                }

            }
        });




    }
}