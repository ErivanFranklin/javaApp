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
import com.example.erivan.marvelapp.Model.Comics;
import com.example.erivan.marvelapp.R;
import com.example.erivan.marvelapp.Util.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tab2Fragment  extends Fragment{
    private static final String TAG = "Tab2Fragment";
    private RecyclerView recyclerView;
    private CharacterRecyclerViewAdapter characterRecyclerViewAdapter;
    private Constants constants = new Constants();
    private List<Comics> comicsList;
    private RequestQueue requestQueue;
    private View view;
    private String URL = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab2_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        requestQueue = Volley.newRequestQueue(getActivity());

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewTab2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        comicsList = new ArrayList<>();

        URL = constants.Constants("comics", "", "27-05-2018", "10");

        comicsList = getComics("hd");

        int i = 0;
        synchronized (getActivity()){

            while (i < 80){
                try {
                    Thread.sleep(10);
                    i++;
                    if (i == 69){
//                        characterRecyclerViewAdapter = new CharacterRecyclerViewAdapter(getActivity(), comicsList);
//                        recyclerView.setAdapter(characterRecyclerViewAdapter);
//                        characterRecyclerViewAdapter.notifyDataSetChanged();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Comics> getComics(String search){
        comicsList.clear();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject data = response.getJSONObject("data");
                    JSONArray results = data.getJSONArray("results");


                    for (int i = 0; i < results.length(); i++ ){
                        try {
                            Comics comics = new Comics();
                            JSONObject resultsObject = results.getJSONObject(i);
                            comics.setTitle(resultsObject.getString("title"));
                            comics.setFormat(resultsObject.getString("format"));
                            comics.setVariantDescription(resultsObject.getString("variantDescription"));

                            JSONObject thumbnail = resultsObject.getJSONObject("thumbnail");
                            comics.setPoster(thumbnail.getString("path") + Constants.PORTRAIT_FANTASTIC + thumbnail.getString("extension"));
                            Log.e("GET A", comics.getPoster());
                            Log.e("GET B", comics.getFormat());
                            Log.e("GET C", comics.getTitle());
                            Log.e("GET D", comics.getVariantDescription());

                            comicsList.add(comics);
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
        return comicsList;
    }
}
