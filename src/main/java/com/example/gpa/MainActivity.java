package com.example.gpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText CH;
    EditText CG;
    LinearLayout layout;
    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout)findViewById(R.id.layout);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        CH = (EditText) findViewById(R.id.CH);
        CG = (EditText) findViewById(R.id.CG);

        layout.setOnClickListener(myClickListener);
    }

    View.OnClickListener myClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            hideKeyboard();
            switch (v.getId())
            {
                case R.id.layout :
                    break;
            }
        }
    };

    private void hideKeyboard()
    {
        imm.hideSoftInputFromWindow(CH.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(CG.getWindowToken(), 0);
    }

    public void onClick(View view) {
        String ch = CH.getText().toString() ;
        int chI = Integer.parseInt(ch);
        String cg = CG.getText().toString();
        int cgI = Integer.parseInt(cg);

        Intent intent = new Intent(this, SubActivity.class);
        intent.putExtra("credit", chI);
        intent.putExtra("gpa", cgI);
        switch (view.getId()) {
            case R.id.btn_cal:
                if (ch.isEmpty() && cg.isEmpty()) {
                    Toast.makeText(this, "Nothing typed", Toast.LENGTH_SHORT).show();
                } else if (cg.isEmpty()) {
                    Toast.makeText(this, "Cumulative GPA is not typed", Toast.LENGTH_SHORT).show();
                }  else if (ch.isEmpty()) {
                    Toast.makeText(this, "Credit Hour is not typed", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(intent);
                }
            case R.id.btn_reset:
                CH.getText().clear();
                CG.getText().clear();
        }
    }
}
