package com.tjnuman.noteapp.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.tjnuman.noteapp.Dao.NotesDao;
import com.tjnuman.noteapp.Database.NotesDatabase;
import com.tjnuman.noteapp.Model.NotesEntity;

import java.util.List;

public class NotesRepository {
    public NotesDao notesDao;
    public LiveData<List<NotesEntity>> getAllNotes;

    public NotesRepository(Application application){

        NotesDatabase database = NotesDatabase.getDatabaseInstance(application);
        notesDao = database.notesDao();
        getAllNotes = notesDao.GetAllNotes();

    }

    public void insertNotes(NotesEntity notes){
        notesDao.insertNotes(notes);
    }


    public void deleteNotes(int id){
        notesDao.deleteNotes(id);
    }


    public void updateNotes(NotesEntity notes){
        notesDao.updateNotes(notes);
    }

}
