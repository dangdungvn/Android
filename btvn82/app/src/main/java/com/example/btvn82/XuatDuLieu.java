package com.example.btvn82;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class XuatDuLieu extends AppCompatActivity {
    ListView lvDuLieu;
    Button btnThoat;
    List <DuLieu> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_xuat_du_lieu);
        anhXa();
        xuatDuLieu();
        thoat();
    }

    private void thoat() {
        btnThoat.setOnClickListener(v -> {
            finish();
        });
    }

    private void xuatDuLieu() {
        Intent intent = getIntent();
        list = (List<DuLieu>) intent.getSerializableExtra("list");
        DuLieuAdapter adapter = new DuLieuAdapter(this, R.layout.activity_line_du_lieu, list);
        lvDuLieu.setAdapter(adapter);
    }

    private void anhXa() {
        lvDuLieu = findViewById(R.id.lvDuLieu);
        btnThoat = findViewById(R.id.btnThoat);
    }
}