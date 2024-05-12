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
                    double a = Integer.parseInt(edtA.getText().toString());
                    double b = Integer.parseInt(edtB.getText().toString());
                    double c = Integer.parseInt(edtC.getText().toString());
                    double delta =(double) b * b - 4 * a * c;
                    Intent intent = new Intent(MainActivity.this, GiaiKetQua.class);
                    intent.putExtra("a", a);
                    intent.putExtra("b", b);
                    intent.putExtra("c", c);
                    intent.putExtra("delta", delta);
                    startActivity(intent);
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