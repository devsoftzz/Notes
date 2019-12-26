package com.devsoftzz.notes.Async;

import android.os.AsyncTask;

import com.devsoftzz.notes.Models.note;
import com.devsoftzz.notes.Persistance.NoteDao;

public class updateNoteAsync extends AsyncTask<note, Void, Void> {

    private NoteDao mNoteDao;
    public updateNoteAsync(NoteDao dao) {
        mNoteDao=dao;
    }

    @Override
    protected Void doInBackground(note... notes) {
        mNoteDao.updateNotes(notes);
        return null;
    }
}
