package com.sn.maru.utilities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.sn.maru.R;
import com.sn.maru.model.Room;

import java.util.List;

import static com.sn.maru.service.DummyMeetingGenerator.ROOM_LIST;

public class DialogPlaceSpinner extends DialogFragment {

    public interface DialogPlaceSpinnerListener {
        public void onDialogPlaceSpinnerValidateClick(DialogFragment dialog);
    }

    DialogPlaceSpinnerListener mListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_place_spinner, null);
        builder.setView(v)
                .setMessage("Lieu de réunion")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onDialogPlaceSpinnerValidateClick(DialogPlaceSpinner.this);
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DialogPlaceSpinner.this.getDialog().cancel();
                    }
                });

        Spinner listRooms = (Spinner) v.findViewById(R.id.dialog_room_spinner_sp);
        List<Room> rooms = ROOM_LIST;
        listRooms.setAdapter(new ArrayAdapter<Room>(getContext()
                , android.R.layout.simple_spinner_dropdown_item, rooms));
        listRooms.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Room selectedRoom = (Room) listRooms.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (DialogPlaceSpinnerListener) getTargetFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement DialogTimePickerListener");
        }
    }
}