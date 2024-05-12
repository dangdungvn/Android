package com.example.btvn7;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button btnTinh, btnXoa;
    EditText edtA, edtB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        mapping();
        tinhPhuongTrinh();
        xoa();
    }

    private void xoa() {
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtA.setText("");
                edtB.setText("");
            }
        });
    }

    private void tinhPhuongTrinh() {
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KetQua.class);
                if(edtA.getText().toString().isEmpty() || edtB.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Không hợp lệ, vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                }else {
                    int a = Integer.parseInt(edtA.getText().toString());
                    int b = Integer.parseInt(edtB.getText().toString());
                    intent.putExtra("a", a);
                    intent.putExtra("b", b);
                    startActivity(intent);
                }
            }
        });
    }

    private void mapping() {

        btnTinh = findViewById(R.id.btnTinh);
        btnXoa = findViewById(R.id.btnXoa);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
    }

}