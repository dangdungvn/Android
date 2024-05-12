package com.example.btvn3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CheckBox checkboxNam, checkboxNu, checkboxKhac;
    Button button;
    private void mapping() {
        checkboxNam = findViewById(R.id.checkboxNam);
        checkboxNu = findViewById(R.id.checkboxNu);
        checkboxKhac = findViewById(R.id.checkboxKhac);
        button = findViewById(R.id.button);
    }
    private void event() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkboxNam.isChecked() && checkboxNu.isChecked() && checkboxKhac.isChecked()) {
                    Toast.makeText(MainActivity.this, "Da check all!", Toast.LENGTH_SHORT).show();
                }
                else if (checkboxNam.isChecked() && checkboxNu.isChecked()) {
                    Toast.makeText(MainActivity.this, "Da check Nam va Nu!", Toast.LENGTH_SHORT).show();
                }
                else if (checkboxNam.isChecked() && checkboxKhac.isChecked()) {
                    Toast.makeText(MainActivity.this, "Da check Nam va Khac!", Toast.LENGTH_SHORT).show();
                }
                else if (checkboxNu.isChecked() && checkboxKhac.isChecked()) {
                    Toast.makeText(MainActivity.this, "Da check Nu va Khac!", Toast.LENGTH_SHORT).show();
                }
                else if (checkboxNam.isChecked()) {
                    Toast.makeText(MainActivity.this, "Da check Nam!", Toast.LENGTH_SHORT).show();
                }
                else if (checkboxNu.isChecked()) {
                    Toast.makeText(MainActivity.this, "Da check Nu!", Toast.LENGTH_SHORT).show();
                }
                else if (checkboxKhac.isChecked()) {
                    Toast.makeText(MainActivity.this, "Da check Khac!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        mapping();
        event();
    }
}