package com.doberan.study.daialogsample;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by doberanmac on 2018/01/13.
 */

public class CreateDialogFragment extends DialogFragment {
    MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if(activity instanceof MainActivity == false){
            throw new UnsupportedOperationException("MainActivityから生成されたわけではありません");
        }
        mainActivity = (MainActivity)activity;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        return new AlertDialog.Builder(mainActivity)
                .setTitle("title")
                .setMessage("message")
                .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        mainActivity.dialogPositiveClick();
                    }
                }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        mainActivity.dialogNegativeClick();
                    }
                }).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity = null;
    }
}
