package com.tjnuman.noteapp.Model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.jar.Attributes;

@Entity(tableName = "Notes Database")
public class NotesEntity {
    @PrimaryKey (autoGenerate = true)
    public int id;

    @ColumnInfo(name = "notes_title")
    public String notesTitle;

    @ColumnInfo(name = "notes_subtitle")
    public String notesSubTitle;

    @ColumnInfo(name = "notes")
    public String notes;

    @ColumnInfo(name = "notes_Date")
    public String notesDate;

    @ColumnInfo(name = "notes_priority")
    public String notesPriority;
}
