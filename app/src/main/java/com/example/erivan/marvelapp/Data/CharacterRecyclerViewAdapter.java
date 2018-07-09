package com.example.erivan.marvelapp.Data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.erivan.marvelapp.Model.Character;
import com.example.erivan.marvelapp.R;

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
    public CharacterRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_characters, parent,false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterRecyclerViewAdapter.ViewHolder holder, int position) {
        Character character = charactersList.get(position);

        // TODO: Should back to work on background of poster(Movie Directory party 3 - Picasso Library)

        holder.name.setText(character.getName());
    }

    @Override
    public int getItemCount() {
        return charactersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name;

        public ViewHolder(View itemView, Context ctx) {
            super(itemView);
            context = ctx;

            name = (TextView) itemView.findViewById(R.id.TextViewNameID);

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
