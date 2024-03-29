package com.devsoftzz.notes.Persistance;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.devsoftzz.notes.Models.note;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    long[] insertNotes(note... notes);

    @Query("SELECT * FROM Notes")
    LiveData<List<note>> getAllNotes();

    @Delete
    int deleteNotes(note... notes);

    @Update
    int updateNotes(note... notes);
}
