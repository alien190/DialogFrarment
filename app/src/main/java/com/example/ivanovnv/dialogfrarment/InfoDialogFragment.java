package com.example.ivanovnv.dialogfrarment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


/**
 * Created by IvanovNV on 19.02.2018.
 */

public class InfoDialogFragment extends DialogFragment {

    private EditText mEditText;
    public static final String TAG = InfoDialogFragment.class.getSimpleName();
    private DialogCallback mCallback;
    private String initString;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder  builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.di_info,null);
        mEditText = inflate.findViewById(R.id.et_info);
        mEditText.setText(initString);

        builder.setTitle("Info")
                .setView(inflate)
                .setPositiveButton("true", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(mEditText.getText().length()>0){
                            mCallback.setPositiveResult(mEditText.getText().toString());
                        }
                    }
                });
        return builder.create();

    }


    public static void showString(FragmentManager manager,String txt) {
        InfoDialogFragment infoDialogFragment = new InfoDialogFragment();
        infoDialogFragment.initString = txt;
        infoDialogFragment.show(manager,TAG);
    }

    public interface DialogCallback {
        void setPositiveResult (String result);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DialogCallback){
            mCallback = (DialogCallback) context;

        }
        else {
            throw new ClassCastException(context.toString()+" must implement DialogCallback");
        }
        }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }
}

