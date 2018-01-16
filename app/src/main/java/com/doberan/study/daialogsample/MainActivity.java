package com.doberan.study.daialogsample;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.hello_text);
        text.setClickable(true);
        text.setOnClickListener(positiveClick);

    }

    View.OnClickListener positiveClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fragmentManager = getFragmentManager();
            CreateDialogFragment createDialogFragment = new CreateDialogFragment();
            createDialogFragment.show(fragmentManager,null);
        }
    };

    public void dialogPositiveClick(){
        text.setText("ダイアログのOKを押したよ！");
    }

    public void dialogNegativeClick(){
        text.setText("ダイアログのCANCELを押したよ！");
    }
}
