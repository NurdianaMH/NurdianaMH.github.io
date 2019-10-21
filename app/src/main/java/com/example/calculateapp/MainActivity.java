package com.example.calculateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.calculateapp.R;

public class MainActivity extends AppCompatActivity {

    private TextView exprBig;
    public String toEvalExpression;
    public String enteredExpression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
