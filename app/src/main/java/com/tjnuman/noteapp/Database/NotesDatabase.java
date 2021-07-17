package com.tjnuman.noteapp.Database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.tjnuman.noteapp.Dao.NotesDao;
import com.tjnuman.noteapp.Model.NotesEntity;


@Database(entities = {NotesEntity.class},version = 2)
public abstract class NotesDatabase extends RoomDatabase {

    public abstract NotesDao notesDao();
    public static NotesDatabase  INSTANCE;

    public static NotesDatabase getDatabaseInstance(Context context)
    {
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    NotesDatabase.class,
                    "Notes Database").build();
        }


        return INSTANCE;
    }

}
