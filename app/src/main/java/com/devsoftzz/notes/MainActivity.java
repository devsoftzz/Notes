package com.devsoftzz.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.devsoftzz.notes.Adapters.NotesRecyclerAdapter;
import com.devsoftzz.notes.Models.note;
import com.devsoftzz.notes.Util.RecyclerDecore;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NotesRecyclerAdapter.onNoteListner {

    private static final String TAG = "Notes";
    private RecyclerView mRecyclerView;

    private ArrayList<note> mNotes = new ArrayList<>();
    private NotesRecyclerAdapter mNotesRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        setTitle("Notes");
        mRecyclerView = findViewById(R.id.recyclerView);

        initRecyclerView();
        insertFakeNotes();
    }

    private void insertFakeNotes() {
        for(int i=0;i<1000;i++){
            note note = new note();
            note.setTitle("Title #"+i);
            note.setContent("Hellowww, Content #"+i);
            note.setTimestamp("26 Mar");
            mNotes.add(note);
        }
        mNotesRecyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        RecyclerDecore recyclerDecore = new RecyclerDecore(12);
        mRecyclerView.addItemDecoration(recyclerDecore);
        mNotesRecyclerAdapter = new NotesRecyclerAdapter(mNotes,this,this);
        mRecyclerView.setAdapter(mNotesRecyclerAdapter);
    }

    @Override
    public void onNoteClickListner(int position) {

        Log.d(TAG, "onNoteClickListner: "+position);
        Intent intent = new Intent(this,NoteActivity.class);
        intent.putExtra("SelectedNote",mNotes.get(position));
        startActivity(intent);
    }
}
