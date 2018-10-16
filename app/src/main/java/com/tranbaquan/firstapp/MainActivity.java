package com.tranbaquan.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tranbaquan.firstapp.lab2.EmployeeActivity;
import com.tranbaquan.firstapp.lab3.ListViewAdvanceActivity;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lab2 = findViewById(R.id.lab2);
        Button lab3 = findViewById(R.id.lab3);

        lab2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EmployeeActivity.class);
                startActivity(intent);
            }
        });

        lab3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListViewAdvanceActivity.class);
                startActivity(intent);
            }
        });
    }
}
