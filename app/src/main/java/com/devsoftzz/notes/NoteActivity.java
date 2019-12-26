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
import com.devsoftzz.notes.Persistance.NoteDao;
import com.devsoftzz.notes.Persistance.NoteRepository;
import com.devsoftzz.notes.Util.EditTextWithLines;
import com.devsoftzz.notes.Util.Utility;

public class NoteActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Notes";
    private note mNote;
    private note mFinalNote;
    private ImageButton mBack;
    private EditTextWithLines mText;
    private EditText mTitle;
    private boolean NewNote;
    private NoteRepository mNoteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        mBack = findViewById(R.id.backBtn);
        mBack.setOnClickListener(this);
        mText = findViewById(R.id.edittext);
        mTitle = findViewById(R.id.editview);
        mNoteRepository = new NoteRepository(this);
        mNote = new note();
        mFinalNote = new note();

        if(!getIntent().hasExtra("SelectedNote")){
            NewNote = true;
        }else {
            NewNote = false;
            mNote = getIntent().getParcelableExtra("SelectedNote");
            mText.setText(mNote.getContent());
            mTitle.setText(mNote.getTitle());
        }
    }

    @Override
    public void onBackPressed() {
        mBack.callOnClick();
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        mFinalNote.setTitle(mTitle.getText().toString().trim());
        mFinalNote.setContent(mText.getText().toString().trim());
        mFinalNote.setTimestamp(Utility.getTimeStamp());

        if(NewNote){
            if((mFinalNote.getTitle().equals("") || mFinalNote.getTitle().equals("Title")) && mFinalNote.getContent().equals("")){
                finish();
                return;
            }
            mNoteRepository.insertNoteTask(mFinalNote);
        }else {
            mFinalNote.setId(mNote.getId());
            if((mFinalNote.getTitle().equals("") || mFinalNote.getTitle().equals("Title")) && mFinalNote.getContent().equals("")){
                mNoteRepository.deleteNoteTask(mFinalNote);
                finish();
            }
            mNoteRepository.updateNoteTask(mFinalNote);
        }
        finish();
    }
}
