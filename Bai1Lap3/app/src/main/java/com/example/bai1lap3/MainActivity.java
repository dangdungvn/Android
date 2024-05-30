package com.example.bai1lap3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvDuLieu;
    List<DuLieu> list = new ArrayList<>();
    DuLieuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lvDuLieu = findViewById(R.id.lvDuLieu);
        list.add(new DuLieu(R.drawable.anh1, "Nhẫn", "99.99"));
        list.add(new DuLieu(R.drawable.anh2, "Nhẫn", "199.99"));
        list.add(new DuLieu(R.drawable.anh3, "Nhẫn", "299.99"));
        list.add(new DuLieu(R.drawable.anh4, "Nhẫn", "399.99"));
        list.add(new DuLieu(R.drawable.anh5, "Nhẫn", "499.99"));
        list.add(new DuLieu(R.drawable.anh6, "Vòng", "599.99"));
        list.add(new DuLieu(R.drawable.anh7, "Vòng", "699.99"));
        list.add(new DuLieu(R.drawable.anh8, "Vòng", "799.99"));
        adapter = new DuLieuAdapter(this, R.layout.view_item, list);
        lvDuLieu.setAdapter(adapter);
    }
}