package com.example.btvn82;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnThemMoi, btnInDS;
    RadioButton rdNam, rdNu;
    EditText edtHoTen, edtQueQuan;
    List<DuLieu> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        anhXa();
        addDanhSach();
        inDanhSach();

    }

    private void inDanhSach() {
        btnInDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, XuatDuLieu.class);
                intent.putExtra("list", (Serializable) list);
                startActivity(intent);
            }
        });
    }

    private void addDanhSach() {
        btnThemMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoTen = edtHoTen.getText().toString();
                String queQuan = edtQueQuan.getText().toString();
                String gioiTinh = "";
                if(rdNam.isChecked()){
                    gioiTinh = "Nam";
                }else if(rdNu.isChecked()){
                    gioiTinh = "Nu";
                }
                list.add(new DuLieu(hoTen,gioiTinh,queQuan));
                Toast.makeText(MainActivity.this, "Đã thêm dữ liệu", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void anhXa() {
        btnThemMoi = findViewById(R.id.btnThemMoi);
        btnInDS = findViewById(R.id.btnInDS);
        rdNam = findViewById(R.id.rdNam);
        rdNu = findViewById(R.id.rdNu);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtQueQuan = findViewById(R.id.edtQueQuan);
    }
}