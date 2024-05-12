package com.example.btvn72;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == 2){
            double delta = data.getDoubleExtra("delta", 0);
            int a = Integer.parseInt(edtA.getText().toString());
            int b = Integer.parseInt(edtB.getText().toString());
            int c = Integer.parseInt(edtC.getText().toString());
            if(delta < 0){
                Toast.makeText(MainActivity.this, "Phuong trinh vo nghiem", Toast.LENGTH_SHORT).show();
            }
            else if (delta == 0){
                Toast.makeText(MainActivity.this, "Phuong trinh co nghiem kep x = " + (-b/(2*a)), Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this, "Phuong trinh co 2 nghiem phan biet", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "x1 = " + ((-b + Math.sqrt(delta))/(2*a)) + "    x2 = " + ((-b - Math.sqrt(delta))/(2*a)), Toast.LENGTH_SHORT).show();
            }
        }
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
//                    startActivity(intent);
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