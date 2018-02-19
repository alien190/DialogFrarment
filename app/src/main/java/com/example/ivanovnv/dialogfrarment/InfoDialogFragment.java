package com.example.ivanovnv.dialogfrarment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by IvanovNV on 19.02.2018.
 */

public class InfoDialogFragment extends DialogFragment {

    private EditText mEditText;
    public static final String TAG = InfoDialogFragment.class.getSimpleName();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder  builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.di_info,null);
        mEditText = inflate.findViewById(R.id.et_info);

        builder.setTitle("Info")
                .setView(inflate)
                .setPositiveButton("true",null);
        return builder.create();

    }


    public static void show(FragmentManager manager) {
        InfoDialogFragment infoDialogFragment = new InfoDialogFragment();
        infoDialogFragment.show(manager,TAG);
    }
}
