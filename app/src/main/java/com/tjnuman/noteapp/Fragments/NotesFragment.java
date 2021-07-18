package com.tjnuman.noteapp.Fragments;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tjnuman.noteapp.Activities.InsertNoteActivity;
import com.tjnuman.noteapp.Adapter.NotesAdapter;
import com.tjnuman.noteapp.Model.NotesEntity;
import com.tjnuman.noteapp.R;
import com.tjnuman.noteapp.ViewModel.NotesViewModel;
import com.tjnuman.noteapp.databinding.FragmentNotesBinding;


public class NotesFragment extends Fragment {
  FloatingActionButton newNotebutton;
    NotesViewModel notesViewModel;
    RecyclerView recyclerView;
    NotesAdapter adapter;
    NotesEntity notesEntity,notesEntity1;


    public NotesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        newNotebutton = view.findViewById(R.id.newnotebtn);
        recyclerView = view.findViewById(R.id.recyclerview);
        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);


        newNotebutton.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), InsertNoteActivity.class);
            startActivity(intent);
        });

        notesViewModel.getAllNotes.observe(getViewLifecycleOwner(), notesEntities -> {



            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
            adapter = new NotesAdapter(getContext(),notesEntities);
            recyclerView.setAdapter(adapter);





        });

        return view;
    }
}