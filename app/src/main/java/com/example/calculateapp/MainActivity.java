package com.example.calculateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.calculateapp.R;

public class MainActivity extends AppCompatActivity {

    private TextView bigTextView, smallTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bigTextView = findViewById(R.id.textViewBig);
        smallTextView = findViewById(R.id.textViewSmall);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.


        savedInstanceState.putString("exprText", bigTextView.getText().toString());
        savedInstanceState.putString("ansText", smallTextView.getText().toString());

        super.onSaveInstanceState(savedInstanceState);
    }

    //onRestoreInstanceState

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.


        String expr = savedInstanceState.getString("exprText");
        String ans = savedInstanceState.getString("ansText");
        bigTextView.setText(expr);
        smallTextView.setText(ans);
    }
}
