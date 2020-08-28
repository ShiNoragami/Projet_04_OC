package com.sn.maru.utilities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.sn.maru.R;

public class DialogDatePickerFragment extends DialogFragment {

    public interface DialogDatePickerListener {
        public void onDialogDatePikerValidateClick(DialogDatePickerFragment dialogDatePickerFragment);
    }

    DialogDatePickerListener mListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog_date_picker, null))
                .setMessage("Date de réunion")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onDialogDatePikerValidateClick(DialogDatePickerFragment.this);
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DialogDatePickerFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (DialogDatePickerListener) getTargetFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement DialogDatePickerListener");
        }
    }
}