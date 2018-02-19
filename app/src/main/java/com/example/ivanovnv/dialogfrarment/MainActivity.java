package com.example.ivanovnv.dialogfrarment;

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
            InfoDialogFragment.show(getFragmentManager());

            }
        });
    }

    @Override
    public void setPositiveResult(String result) {
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
    }
}
