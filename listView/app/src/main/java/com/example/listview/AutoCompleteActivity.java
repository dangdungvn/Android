package com.example.listview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteActivity extends AppCompatActivity {
    AutoCompleteTextView actMonHoc;
    ArrayAdapter adapter;
    List<String> listMonHoc = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomplete);
        mapping();
        taoListMonHoc();
    }

    private void mapping() {
        actMonHoc = findViewById(R.id.actMonHoc);
    }
    private void taoListMonHoc() {
        listMonHoc.add("Toan");
        listMonHoc.add("Ly");
        listMonHoc.add("Hoa");
        listMonHoc.add("Sinh");
        listMonHoc.add("Van");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, listMonHoc);
        actMonHoc.setAdapter(adapter);
        actMonHoc.setThreshold(1);
    }
}
