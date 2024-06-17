package com.example.sqlitetest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.List;

public class XemDuLieu extends AppCompatActivity {
    ListView lvXem;
    List<DuLieu> list = new ArrayList<>();
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_xem_du_lieu);
        anhXa();
        xem();
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

    }

    private void xem() {
        Intent intent = getIntent();
        list = (List<DuLieu>) intent.getSerializableExtra("list");
        DuLieuAdapter adapter = new DuLieuAdapter(this, R.layout.awnitem_activity, list);
        lvXem.setAdapter(adapter);
    }

    private void anhXa() {
        lvXem = findViewById(R.id.lvXem);

    }
}