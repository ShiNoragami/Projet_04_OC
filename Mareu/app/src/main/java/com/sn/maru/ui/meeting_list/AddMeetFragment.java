package com.sn.maru.ui.meeting_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.sn.maru.R;
import com.sn.maru.Repository.MeetingRepository;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddMeetFragment extends Fragment {

    @BindView(R.id.add_nameLyt)
    TextInputLayout nameInput;
    @BindView(R.id.add_roomLyt)
    TextInputLayout roomInput;
    @BindView(R.id.time_txt)
    Button timeInput;
    @BindView(R.id.date_txt)
    Button dateInput;
    @BindView(R.id.add_mailLyt)
    TextInputLayout mailInput;
    @BindView(R.id.add_save)
    MaterialButton save;
    @BindView(R.id.add_return)
    ImageView back;

    public MeetingRepository mMeetingRepository;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_add_meet, container, false);
        ButterKnife.bind(this, view);
        //LIE AU REPOSITORY TO DO
        return view;
    }

    /**
     * Used to navigate to this activity
     *
     * @param activity
     */
    public static void navigate(FragmentActivity activity) {
        Intent intent = new Intent(activity, AddMeetFragment.class);
        ActivityCompat.startActivity(activity, intent, null);
    }
}


