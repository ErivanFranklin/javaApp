package com.example.erivan.marvelapp.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";
    private RecyclerView recyclerView;
    private CharacterRecyclerViewAdapter characterRecyclerViewAdapter;
    private List<Character> characterList;
    private RequestQueue requestQueue;
    private  View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.tab1_fragment,container,false);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        requestQueue = Volley.newRequestQueue(getActivity());

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewTab1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        characterList = new ArrayList<>();

        characterList = getCharacters("hd");

        characterRecyclerViewAdapter = new CharacterRecyclerViewAdapter(getActivity(), characterList);
        recyclerView.setAdapter(characterRecyclerViewAdapter);
        characterRecyclerViewAdapter.notifyDataSetChanged();
        Log.e("characterRecycler", characterRecyclerViewAdapter.toString());
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
