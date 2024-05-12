package com.example.btvn7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KetQua extends AppCompatActivity {
    EditText edtKq;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ket_qua);
        anhXa();
        ketQua();
        back();
    }

    private void back() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void ketQua() {
        Intent intent = getIntent();
        int a = intent.getIntExtra("a", 0);
        int b = intent.getIntExtra("b", 0);
        if(a == 0){
            if(b == 0){
                edtKq.setText("vo so nghiem");
            }else {
                edtKq.setText("vo nghiem");
            }
        }
        else {
            edtKq.setText("x = " + (-b/a));
        }
    }

    private void anhXa() {
        edtKq = findViewById(R.id.edtKq);
        btnBack = findViewById(R.id.btnBack);
    }
}