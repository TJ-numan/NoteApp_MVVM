package com.tjnuman.noteapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.provider.ContactsContract;

import com.tjnuman.noteapp.Model.NotesEntity;
import com.tjnuman.noteapp.ViewModel.NotesViewModel;
import com.tjnuman.noteapp.databinding.ActivityInsertNoteBinding;

public class InsertNoteActivity extends AppCompatActivity {
    ActivityInsertNoteBinding insertNoteBinding;
    String title,note;
    NotesViewModel notesViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        insertNoteBinding = ActivityInsertNoteBinding.inflate(getLayoutInflater());
        setContentView(insertNoteBinding.getRoot());
        NotesViewModel notesViewModel;

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);



        insertNoteBinding.donebutton.setOnClickListener(v -> {

            title = insertNoteBinding.title.getText().toString();
            note = insertNoteBinding.notedetail.getText().toString();
            CreatNotes(title, note);

        });


    }

    private void CreatNotes(String title, String note) {
        NotesEntity notes1 = new NotesEntity();
        notes1.notesTitle = title;
        notes1.notes = note;
        notesViewModel.insertNotes(notes1);
    }
}