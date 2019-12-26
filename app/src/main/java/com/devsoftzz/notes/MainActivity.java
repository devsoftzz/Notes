package com.devsoftzz.notes;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.devsoftzz.notes.Adapters.NotesRecyclerAdapter;
import com.devsoftzz.notes.Models.note;
import com.devsoftzz.notes.Persistance.NoteRepository;
import com.devsoftzz.notes.Util.RecyclerDecore;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NotesRecyclerAdapter.onNoteListner {

    private static final String TAG = "Notes";
    private RecyclerView mRecyclerView;

    private ArrayList<note> mNotes = new ArrayList<>();
    private NotesRecyclerAdapter mNotesRecyclerAdapter;
    private NoteRepository mNoteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        setTitle("Notes");
        mRecyclerView = findViewById(R.id.recyclerView);

        mNoteRepository = new NoteRepository(this);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NoteActivity.class));
            }
        });

        initRecyclerView();
        retriveNotes();
        //insertFakeNotes();
    }

    private void retriveNotes() {
        mNoteRepository.retriveNotesTask().observe(this, new Observer<List<note>>() {
            @Override
            public void onChanged(List<note> notes) {
                if(mNotes.size()>0){
                    mNotes.clear();
                }
                if(notes!=null){
                    mNotes.addAll(notes);
                }
                mNotesRecyclerAdapter.notifyDataSetChanged();
            }
        });
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
        new ItemTouchHelper(simpleCallback).attachToRecyclerView(mRecyclerView);
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

    private ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            deleteNote(viewHolder.getAdapterPosition());
        }
    };

    private void deleteNote(int index) {
        mNoteRepository.deleteNoteTask(mNotes.get(index));
        mNotes.remove(index);
        mNotesRecyclerAdapter.notifyItemRemoved(index);
    }
}
