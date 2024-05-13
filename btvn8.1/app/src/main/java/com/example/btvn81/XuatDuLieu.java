package com.example.btvn81;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class XuatDuLieu extends AppCompatActivity {
    ListView lvDuLieu;
    Intent intent;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_xuat_du_lieu);
        lvDuLieu = findViewById(R.id.lvDuLieu);
        intent = getIntent();
        List<String> list = intent.getStringArrayListExtra("list");
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        lvDuLieu.setAdapter(adapter);
    }
}