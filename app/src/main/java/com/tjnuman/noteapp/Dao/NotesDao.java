package com.tjnuman.noteapp.Dao;


import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.tjnuman.noteapp.Model.NotesEntity;

import java.util.List;

@androidx.room.Dao
public interface NotesDao {

    @Query("Select * from `Notes Database`")
    LiveData<List<NotesEntity>> GetAllNotes();

    @Insert
    void insertNotes(NotesEntity notes);

    @Query("Delete from `Notes Database` where id = :id")
    void deleteNotes(int id);

    @Update
    void updateNotes(NotesEntity notes);
}
