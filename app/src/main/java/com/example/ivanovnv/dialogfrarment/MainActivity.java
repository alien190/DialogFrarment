package com.example.ivanovnv.dialogfrarment;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements InfoDialogFragment.DialogCallback {

    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = findViewById(R.id.button);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences(getString(R.string.pref_name), Context.MODE_PRIVATE);

                InfoDialogFragment.showString(getFragmentManager(),prefs.getString("value",""));

            }
        });
    }

    @Override
    public void setPositiveResult(String result) {
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
        SharedPreferences prefs = getSharedPreferences(getString(R.string.pref_name), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("value",result)
                .commit();
    }
}
