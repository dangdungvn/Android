package com.example.listview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    List<String> listMonHoc = new  ArrayList<>();
    ArrayAdapter adapter;
    EditText edtMonHoc;
    Button btnAdd, btnEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        mapping();
        taoListMonHoc();
        themMonHoc();
        edtMonHoc();
    }

    private void edtMonHoc() {
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtMonHoc.setText(listMonHoc.get(position));
                btnEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listMonHoc.set(position, edtMonHoc.getText().toString());
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int index = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listMonHoc.remove(index);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                return false;
            }
        });
    }

    private void themMonHoc() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listMonHoc.add(edtMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void taoListMonHoc() {
        listMonHoc.add("Toan");
        listMonHoc.add("Ly");
        listMonHoc.add("Hoa");
        listMonHoc.add("Sinh");
        listMonHoc.add("Van");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listMonHoc);
        lvMonHoc.setAdapter(adapter);
    }

    private void mapping() {
        lvMonHoc = findViewById(R.id.lvMonHoc);
        edtMonHoc = findViewById(R.id.edtMonHoc);
        btnAdd = findViewById(R.id.btnAdd);
        btnEdit = findViewById(R.id.btnEdit);
    }
}