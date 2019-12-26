package com.devsoftzz.notes.Async;

import android.os.AsyncTask;

import com.devsoftzz.notes.Models.note;
import com.devsoftzz.notes.Persistance.NoteDao;

public class deleteNoteAsync extends AsyncTask<note, Void, Void> {

    private NoteDao mNoteDao;
    public deleteNoteAsync(NoteDao dao) {
        mNoteDao=dao;
    }

    @Override
    protected Void doInBackground(note... notes) {
        mNoteDao.deleteNotes(notes);
        return null;
    }
}
