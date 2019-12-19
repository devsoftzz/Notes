package com.devsoftzz.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.devsoftzz.notes.Models.note;

public class NoteActivity extends AppCompatActivity {

    private static final String TAG = "Notes";
    private note mNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        if(getIntent().hasExtra("SelectedNote")){
            mNote = getIntent().getParcelableExtra("SelectedNote");
            Log.d(TAG, "onCreate: "+mNote.toString());
        }
    }
}
