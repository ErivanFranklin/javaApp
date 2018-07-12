package com.example.erivan.marvelapp.Data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.erivan.marvelapp.Model.Character;
import com.example.erivan.marvelapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CharacterRecyclerViewAdapter extends RecyclerView.Adapter<CharacterRecyclerViewAdapter.ViewHolder>{
    Context context;
    List<Character> charactersList;

    public CharacterRecyclerViewAdapter(Context context, List<Character> character) {
        this.context = context;
        charactersList = character;
    }

    @NonNull
    @Override
    public CharacterRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.character_row, parent,false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(CharacterRecyclerViewAdapter.ViewHolder holder, int position) {
        Character character = charactersList.get(position);

        String posterLink = character.getPoster();
        Picasso.get()
                .load(posterLink)
                .placeholder(R.drawable.avangers_logo)
                .into(holder.poster);

        holder.name.setText(character.getName());
    }

    @Override
    public int getItemCount() {

        return charactersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name;
        ImageView poster;

        public ViewHolder(View itemView, Context ctx) {
            super(itemView);
            context = ctx;

            name = (TextView) itemView.findViewById(R.id.TextViewNameID);
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
