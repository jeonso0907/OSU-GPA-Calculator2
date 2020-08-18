package com.example.gpa;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView result = (TextView) findViewById(R.id.aa);

        Intent intent = getIntent();
        int ch = Integer.parseInt(intent.getStringExtra("credit"));
        int cg = Integer.parseInt(intent.getStringExtra("gpa"));



        result.setText(ch);
    }

    public void onClick(View view) {
        finish();
    }
}
