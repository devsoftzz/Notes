package com.devsoftzz.notes.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devsoftzz.notes.Models.note;
import com.devsoftzz.notes.R;

import java.util.ArrayList;

public class NotesRecyclerAdapter extends RecyclerView.Adapter<NotesRecyclerAdapter.ViewHolder>{

    private ArrayList<note> mNotes;
    private note Note;
    private Context mContext;
    private onNoteListner onNoteListner;

    public NotesRecyclerAdapter(ArrayList<note> mNotes, Context context, onNoteListner listner) {
        this.mNotes = mNotes;
        this.mContext = context;
        this.onNoteListner=listner;
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new ViewHolder(view, onNoteListner);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Note = mNotes.get(position);
        holder.Title.setText(Note.getTitle());
        holder.Timestamp.setText(Note.getTimestamp());

        holder.mItem.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_in));
        holder.Title.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_in));
        holder.Timestamp.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_in));
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView Title,Timestamp;
        LinearLayout mItem;
        onNoteListner onNoteListner;
        public ViewHolder(@NonNull View itemView, onNoteListner listner) {
            super(itemView);

            Title = itemView.findViewById(R.id.title);
            Timestamp = itemView.findViewById(R.id.timestamp);
            mItem = itemView.findViewById(R.id.item);
            this.onNoteListner=listner;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListner.onNoteClickListner(getAdapterPosition());
        }
    }

    public interface onNoteListner{
        void onNoteClickListner(int position);
    }
}
