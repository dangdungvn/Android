package com.example.btvn81;

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
                list.add(new DuLieu(hoTen, queQuan, gioiTinh));
                Toast.makeText(MainActivity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();
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