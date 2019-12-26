package com.devsoftzz.notes.Persistance;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.devsoftzz.notes.Async.addNoteAsync;
import com.devsoftzz.notes.Async.deleteNoteAsync;
import com.devsoftzz.notes.Async.updateNoteAsync;
import com.devsoftzz.notes.Models.note;

import java.util.List;

public class NoteRepository {

    private NoteDatabase mNotedatabase;

    public NoteRepository(Context context) {
        mNotedatabase = NoteDatabase.getInstance(context);
    }

    public void insertNoteTask(note note){
        new addNoteAsync(mNotedatabase.getNoteDao()).execute(note);
    }

    public void updateNoteTask(note note){
        new updateNoteAsync(mNotedatabase.getNoteDao()).execute(note);
    }

    public void deleteNoteTask(note note){
        new deleteNoteAsync(mNotedatabase.getNoteDao()).execute(note);
    }

    public LiveData<List<note>> retriveNotesTask(){
        return mNotedatabase.getNoteDao().getAllNotes();
    }
}
