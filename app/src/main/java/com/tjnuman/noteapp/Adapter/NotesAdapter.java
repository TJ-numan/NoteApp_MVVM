package com.tjnuman.noteapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tjnuman.noteapp.Fragments.NotesFragment;
import com.tjnuman.noteapp.Model.NotesEntity;
import com.tjnuman.noteapp.R;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {


    List<NotesEntity> notesEntities;

    public NotesAdapter(Context context, List<NotesEntity> notesEntities) {

        this.notesEntities = notesEntities;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notes,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NotesEntity  notesEntity = notesEntities.get(position);

        holder.title.setText(notesEntity.notesTitle);
        holder.notes.setText(notesEntity.notes);
        holder.date.setText(notesEntity.notesDate);

    }

    @Override
    public int getItemCount() {
        return notesEntities.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title,notes,date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title =  itemView.findViewById(R.id.itemTitle);
            notes =  itemView.findViewById(R.id.itemNote);
            date = itemView.findViewById(R.id.itemDate);


        }
    }
}
