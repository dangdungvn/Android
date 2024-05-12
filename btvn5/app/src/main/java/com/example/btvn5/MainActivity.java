package com.example.btvn5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnXinChao, btnThoat;
    EditText name;
    public void mapping(){
        btnXinChao = findViewById(R.id.btnXinChao);
        btnThoat = findViewById(R.id.btnThoat);
        name = findViewById(R.id.name);
    }
    public void setBtnXinChao(){
        btnXinChao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = name.getText().toString();
                Toast.makeText(MainActivity.this, "Xin chao " + ten + "!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void setBtnThoat(){
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        mapping();
        setBtnXinChao();
        setBtnThoat();
    }
}