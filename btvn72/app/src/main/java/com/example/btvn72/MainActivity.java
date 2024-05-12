package com.example.btvn72;

import android.content.Intent;
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
    Button btnTinh, btnXoa;
    EditText edtA, edtB, edtC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        anhXa();
        tinhPhuongTrinhBac2();
        xoaDuLieu();
    }

    private void xoaDuLieu() {
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtA.setText("");
                edtB.setText("");
                edtC.setText("");
            }
        });
    }

    private void tinhPhuongTrinhBac2() {
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtA.getText().toString().equals("") || edtB.getText().toString().equals("") || edtC.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Dữ liệu không hợp lệ", Toast.LENGTH_SHORT).show();
                }else {
                    int a = Integer.parseInt(edtA.getText().toString());
                    int b = Integer.parseInt(edtB.getText().toString());
                    int c = Integer.parseInt(edtC.getText().toString());
                    Intent intent = new Intent(MainActivity.this, GiaiKetQua.class);
                    intent.putExtra("a", a);
                    intent.putExtra("b", b);
                    intent.putExtra("c", c);
                    startActivityForResult(intent, 1);
                }
            }
        });
    }
    private void anhXa() {
        btnTinh = findViewById(R.id.btnTinh);
        btnXoa = findViewById(R.id.btnXoa);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtC = findViewById(R.id.edtC);
    }
}