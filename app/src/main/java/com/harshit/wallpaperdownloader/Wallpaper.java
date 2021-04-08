package com.harshit.wallpaperdownloader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Wallpaper extends AppCompatActivity {

    private static final String TAG = "Wallpaper";

    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<ImageList> arrayList;
    RecyclerView recyclerView;
    ImageView searchBt;
    EditText searchEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);


        //init
        searchBt = findViewById(R.id.search);
        searchEt = findViewById(R.id.searchEt);


        recyclerView = findViewById(R.id.recycler);
        arrayList = new ArrayList<>();
        recyclerViewAdapter = new RecyclerViewAdapter(arrayList,getApplicationContext(), this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);

        searchBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String et = searchEt.getText().toString();
                searchImage(et);
            }
        });
        searchImage("");

    }

    public void searchImage(String s) {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://pixabay.com/api/?key=17722502-a97d71ebd63cefda99f7e1b20&q="+s+"&image_type=photo&pretty=true";
        arrayList.clear();
        recyclerViewAdapter.notifyDataSetChanged();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            String total = response.getString("total");
                            JSONArray data = response.getJSONArray("hits");

                            if(data.length() == 0){
                                Toast.makeText(getApplicationContext(),"No result found",Toast.LENGTH_LONG).show();
                                return;
                            }

                            for(int i = 0; i<data.length(); i++ ) {

                                JSONObject obj = data.getJSONObject(i);
                                String id = obj.getString("id");
                                String previewURL = obj.getString("previewURL");
                                String webformatURL = obj.getString("webformatURL");
                                String largeImageURL = obj.getString("largeImageURL");
                                String imageSize = obj.getString("imageSize");
                                String views = obj.getString("views");
                                String downloads = obj.getString("downloads");
                                String favorites = obj.getString("favorites");
                                String likes = obj.getString("likes");
                                arrayList.add(new ImageList(id,previewURL,webformatURL,
                                        largeImageURL,imageSize,likes,downloads,views,favorites));


                            }
                            recyclerView.setAdapter(recyclerViewAdapter);

                        }catch (Exception e){
                            e.getMessage();
                            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
        queue.add(jsonObjectRequest);
    }

}