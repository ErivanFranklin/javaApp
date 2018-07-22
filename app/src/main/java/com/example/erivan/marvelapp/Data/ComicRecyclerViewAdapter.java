package com.example.erivan.marvelapp.Data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.erivan.marvelapp.Model.Character;
import com.example.erivan.marvelapp.Model.Comics;
import com.example.erivan.marvelapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ComicRecyclerViewAdapter extends RecyclerView.Adapter<ComicRecyclerViewAdapter.ViewHolder> {

    Context context;
    List<Comics> comicsList;


    public ComicRecyclerViewAdapter(Context context, List<Comics> comics) {
        this.context = context;
        comicsList = comics;
    }

    @NonNull
    @Override
    public ComicRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comics_row, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ComicRecyclerViewAdapter.ViewHolder holder, int position) {
        Comics comics = comicsList.get(position);

        String posterLink = comics.getPoster();
        Picasso.get()
                .load(posterLink)
                .placeholder(R.drawable.avangers_logo)
                .into(holder.poster);

        holder.title.setText(comics.getTitle());
        holder.format.setText(comics.getFormat());
        holder.variantDescription.setText(comics.getVariantDescription());
    }


    @Override
    public int getItemCount() {
        return comicsList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        TextView format;
        TextView variantDescription;
        ImageView poster;

        public ViewHolder(View itemView, Context ctx) {
            super(itemView);
            context = ctx;
            title = (TextView) itemView.findViewById(R.id.TextViewTitleID);
            format = (TextView) itemView.findViewById(R.id.TextViewFormatID);
            variantDescription = (TextView) itemView.findViewById(R.id.TextViewVariantDescriptionID);
            poster = (ImageView) itemView.findViewById(R.id.imageViewID);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Row Trapped!!!", Toast.LENGTH_LONG).show();
                }
            });

        }

        @Override
        public void onClick(View v) {

        }
    }
}
