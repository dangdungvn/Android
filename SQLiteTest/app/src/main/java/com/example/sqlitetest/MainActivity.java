package com.example.sqlitetest;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sqlitetest.databinding.ActivityMainBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    List<DuLieu> list = new ArrayList<>();
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = openOrCreateDatabase("test.db", MODE_PRIVATE, null);
        try {
            String sql = "CREATE TABLE tblDuLieu(id integer primary key autoincrement, ten text,hinh integer, mota text, vb2 boolean, gioitinh text)";
            db.execSQL(sql);
        }catch (Exception e){
            Log.e("Error", e.toString());
        }
        binding.btnTao.setOnClickListener(v -> {
            String ten = binding.edtHoTen.getText().toString();
            String mota = binding.edtMoTa.getText().toString();
            boolean vb2;
            if (binding.cbVB2.isChecked()) {
                vb2 = true;
            } else {
                vb2 = false;
            }
            String gioiTinh = "";
            if (binding.rbNam.isChecked()) {
                gioiTinh = "Nam";
            } else if (binding.rbNu.isChecked()) {
                gioiTinh = "Nu";
            }
            ContentValues dlDV = new ContentValues();
            dlDV.put("ten", ten);
            dlDV.put("mota", mota);
            dlDV.put("vb2", vb2);
            dlDV.put("gioitinh", gioiTinh);
            String msg = "";
            if(db.insert("tblDuLieu", null, dlDV) < 0){
                msg = "Them du lieu khong thanh cong";
            } else {
                msg = "Them du lieu thanh cong";
            }
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        });
        binding.btnXemTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, XemDuLieu.class);
                Cursor c = db.query("tblDuLieu", null, null, null, null, null, null);
                while (c.moveToNext()){
                    DuLieu dulieu = new DuLieu();
                    dulieu.setTen(c.getString(1));
                    dulieu.setMota(c.getString(3));
                    dulieu.setVb2(c.getInt(4) == 1);
                    dulieu.setGioiTinh(c.getString(5));
                    list.add(dulieu);
                }
                c.close();
                intent.putExtra("list", (Serializable) list);
                startActivity(intent);
            }
        });
    }
}