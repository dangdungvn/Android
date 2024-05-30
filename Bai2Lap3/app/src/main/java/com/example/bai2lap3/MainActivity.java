package com.example.bai2lap3;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView lvXem;
    List<DuLieu> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lvXem = findViewById(R.id.lvDuLieu);
        list.add(new DuLieu(R.drawable.anh1, "Nhẫn", "99.99"));
        list.add(new DuLieu(R.drawable.anh2, "Vòng", "199.99"));
        list.add(new DuLieu(R.drawable.anh3, "Nhẫn", "299.99"));
        list.add(new DuLieu(R.drawable.anh4, "Vòng", "399.99"));
        list.add(new DuLieu(R.drawable.anh5, "Nhẫn", "499.99"));
        list.add(new DuLieu(R.drawable.anh6, "Nhẫn", "599.99"));
        list.add(new DuLieu(R.drawable.anh7, "Vòng", "699.99"));
        list.add(new DuLieu(R.drawable.anh8, "Nhẫn", "799.99"));
        DuLieuAdapter adapter = new DuLieuAdapter(this, R.layout.activity_line_du_lieu, list);
        lvXem.setAdapter(adapter);
    }
}