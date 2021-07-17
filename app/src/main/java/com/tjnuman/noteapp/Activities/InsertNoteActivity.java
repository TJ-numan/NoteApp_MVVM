package com.tjnuman.noteapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Toast;

import com.tjnuman.noteapp.Model.NotesEntity;
import com.tjnuman.noteapp.ViewModel.NotesViewModel;
import com.tjnuman.noteapp.databinding.ActivityInsertNoteBinding;

import java.util.Date;

public class InsertNoteActivity extends AppCompatActivity {
    ActivityInsertNoteBinding insertNoteBinding;
    String title, noteDetail;
    NotesViewModel notesViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        insertNoteBinding = ActivityInsertNoteBinding.inflate(getLayoutInflater());
        setContentView(insertNoteBinding.getRoot());

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);



        insertNoteBinding.donebutton.setOnClickListener(v -> {

            title = insertNoteBinding.title.getText().toString();
            noteDetail = insertNoteBinding.notedetail.getText().toString();
            CreatNotes(title, noteDetail);

        });


    }

    private void CreatNotes(String title, String note) {

        Date date = new Date();
        CharSequence charSequence = DateFormat.format("dd,mm,yyy",date.getTime());

        NotesEntity notes1 = new NotesEntity();
        notes1.notesTitle = title;
        notes1.notes = note;
        notes1.notesDate = charSequence.toString();
        notesViewModel.insertNotes(notes1);


        Toast.makeText(this, "Note Created successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}