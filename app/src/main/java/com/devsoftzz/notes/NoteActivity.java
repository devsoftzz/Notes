package com.devsoftzz.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.devsoftzz.notes.Models.note;
import com.devsoftzz.notes.Util.EditTextWithLines;

public class NoteActivity extends AppCompatActivity{

    private static final String TAG = "Notes";
    private note mNote;
    private ImageButton mBack;
    private EditTextWithLines mText;
    private EditText mTitle;
    private boolean NewNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        mBack = findViewById(R.id.backBtn);
        mText = findViewById(R.id.edittext);
        mTitle = findViewById(R.id.editview);

        if(!getIntent().hasExtra("SelectedNote")){
            NewNote = true;
        }else {
            NewNote = false;
            mNote = getIntent().getParcelableExtra("SelectedNote");
            mText.setText(mNote.getContent());
            mTitle.setText(mNote.getTitle());
        }

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                //Add Data To Database / Update Data
                //Go Back
                finish();
            }
        });
    }
}
