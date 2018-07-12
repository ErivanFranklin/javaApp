package com.example.erivan.marvelapp.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.erivan.marvelapp.Data.CharacterRecyclerViewAdapter;
import com.example.erivan.marvelapp.Model.Character;
import com.example.erivan.marvelapp.R;
import com.example.erivan.marvelapp.Util.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Characters extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CharacterRecyclerViewAdapter characterRecyclerViewAdapter;
    private List<Character> characterList;
    private RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        requestQueue = Volley.newRequestQueue(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        characterList = new ArrayList<>();



        characterList = getCharacters("hd");


        characterRecyclerViewAdapter = new CharacterRecyclerViewAdapter(this, characterList);
        recyclerView.setAdapter(characterRecyclerViewAdapter);
        characterRecyclerViewAdapter.notifyDataSetChanged();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    public List<Character> getCharacters(String search){
        characterList.clear();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Constants.URL_TODO, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject data = response.getJSONObject("data");
                    JSONArray results = data.getJSONArray("results");


                    for (int i = 0; i < results.length(); i++ ){
                        try {
                            Character character = new Character();
                            JSONObject resultsObject = results.getJSONObject(i);
                            character.setName(resultsObject.getString("name"));

                            JSONObject thumbnail = resultsObject.getJSONObject("thumbnail");
                            character.setPoster(thumbnail.getString("path") + Constants.PORTRAIT_FANTASTIC + thumbnail.getString("extension"));
                            Log.e("POSTER", character.getPoster());

                            characterList.add(character);
                        }catch (JSONException e){

                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue.add(jsonObjectRequest);
        return characterList;
    }

}
