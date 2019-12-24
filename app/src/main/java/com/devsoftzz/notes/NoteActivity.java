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

public class NoteActivity extends AppCompatActivity implements
        View.OnTouchListener,
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private static final String TAG = "Notes";
    private note mNote;
    private ImageButton mBack,mEdit;
    private TextView mTitle,mMessage;
    private EditTextWithLines mText;
    private EditText mEditTitle;
    private boolean NewNote;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        mBack = findViewById(R.id.backBtn);
        mEdit = findViewById(R.id.checkBtn);
        mTitle = findViewById(R.id.textview);
        mText = findViewById(R.id.edittext);
        mMessage = findViewById(R.id.editmessage);
        mEditTitle = findViewById(R.id.editview);

        if(isNewNote()){
            editConfig();
        }else {
            viewCongig();
        }

        mText.setOnTouchListener(this);
        mGestureDetector = new GestureDetector(this,this);
    }

    private void viewCongig() {
        mMessage.setVisibility(View.VISIBLE);
        mBack.setVisibility(View.VISIBLE);
        mEdit.setVisibility(View.GONE);
        mEditTitle.setVisibility(View.GONE);
        mTitle.setVisibility(View.VISIBLE);
        mText.setText(mNote.getContent());
        mTitle.setText(mNote.getTitle());
    }

    private void editConfig() {
        mMessage.setVisibility(View.GONE);
        mBack.setVisibility(View.GONE);
        mEdit.setVisibility(View.VISIBLE);
        mEditTitle.setVisibility(View.VISIBLE);
        mTitle.setVisibility(View.GONE);
        if(NewNote){
            mEditTitle.setText("Note Title");
            mText.setText("");
        }else {
            mEditTitle.setText(mNote.getTitle());
            mText.setText(mNote.getContent());
        }
    }

    private boolean isNewNote(){
        if(getIntent().hasExtra("SelectedNote")){
            mNote = getIntent().getParcelableExtra("SelectedNote");
            NewNote = false;
            return false;
        }
        NewNote = true;
        return true;
    }



    @Override
    public boolean onDoubleTap(MotionEvent e) {
        editConfig();
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }
    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }
    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }
    @Override
    public void onShowPress(MotionEvent e) {

    }
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }
}
