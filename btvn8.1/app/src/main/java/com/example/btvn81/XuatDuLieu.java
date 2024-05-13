package com.example.btvn81;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class XuatDuLieu extends AppCompatActivity {
    ListView lvDuLieu;
    DuLieuAdapter adapter;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_xuat_du_lieu);
        lvDuLieu = findViewById(R.id.lvDuLieu);
        intent = getIntent();
        Bundle bundle = intent.getExtras();
        List<DuLieu> list = (List<DuLieu>) bundle.getSerializable("list");

    }
}