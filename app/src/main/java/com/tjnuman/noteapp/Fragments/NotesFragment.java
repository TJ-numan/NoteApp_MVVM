package com.tjnuman.noteapp.Fragments;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tjnuman.noteapp.Activities.InsertNoteActivity;
import com.tjnuman.noteapp.R;
import com.tjnuman.noteapp.databinding.FragmentNotesBinding;


public class NotesFragment extends Fragment {
  FloatingActionButton newNotebutton;


    public NotesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);


        newNotebutton = view.findViewById(R.id.newnotebtn);

        newNotebutton.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), InsertNoteActivity.class);
            startActivity(intent);
        });



        return view;
    }
}