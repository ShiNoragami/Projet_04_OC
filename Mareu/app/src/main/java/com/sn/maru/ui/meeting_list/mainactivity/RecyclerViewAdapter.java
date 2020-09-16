package com.sn.maru.ui.meeting_list.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sn.maru.R;
import com.sn.maru.model.Meeting;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MeetingItemViewHolder> {

    public List<Meeting> mMeeting;

    public RecyclerViewAdapter(List<Meeting> meetingList) {
        this.mMeeting = meetingList;
    }

    @NonNull
    @Override
    public MeetingItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.meeting_item, viewGroup, false);
        return new MeetingItemViewHolder(view);
    }

    public void updateList(List<Meeting> meetingList) {
        this.mMeeting = meetingList;
        this.notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingItemViewHolder meetingItemViewHolder, final int i) {
        meetingItemViewHolder.update(this.mMeeting.get(i));
    }

    @Override
    public int getItemCount() {
        return mMeeting.size();
    }
}

