package com.sn.maru.ui.meeting_list.mainactivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sn.maru.R;
import com.sn.maru.model.Meeting;
import com.sn.maru.utilities.DeleteEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MeetingItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_list_title)
    TextView meet;
    @BindView(R.id.item_list_pastil)
    ImageView color;
    @BindView(R.id.delete_item_iv)
    ImageView delete;
    @BindView(R.id.item_mail_list)
    TextView mails;

    private String mail = "";

    public MeetingItemViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void update(Meeting meeting) {
        this.color.getDrawable().setTint(meeting.getRoom().getColor());
        this.meet.setText(meeting.getName() + " - " + meeting.getRoom() + " - " +
                meeting.getTimeFormated() + "\n" + meeting.getDateFormated());

        List<String> mails = meeting.getMail();
        for (int i = 0; i < mails.size(); i++) {
            mail += mails.get(i);
            if (i == mails.size() - 1) {
                mail += ".";
            } else {
                mail += ",";
            }
        }
        this.mails.setText(mail);

        this.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new DeleteEvent(meeting));
            }
        });
    }
}
