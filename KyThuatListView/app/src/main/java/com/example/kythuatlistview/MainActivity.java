package com.example.kythuatlistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtHoTen,edtMota;
    RadioButton rbNam,rbNu;
    Button btnUpLoadImg, btnTao, btnXoa, btnXemTT;
    CheckBox cbVB2;
    ImageView pngAnh;
    List<DuLieu> list= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        anhXa();
        upLoadImg();
        tao();
        xoa();
        xemTT();
    }

    private void xoa() {
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtHoTen.setText("");
                edtMota.setText("");
                cbVB2.setChecked(false);
                Toast.makeText(MainActivity.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void xemTT() {
        btnXemTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, XemDuLieu.class);
                intent.putExtra("list", (Serializable) list);
                startActivity(intent);
            }
        });
    }
    private void tao() {
        btnTao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = edtHoTen.getText().toString();
                int hinh = pngAnh.getId();
                String mota = edtMota.getText().toString();
                boolean vb2;
                if (cbVB2.isChecked()) {
                    vb2 = true;
                } else {
                    vb2 = false;
                }
                String gioiTinh = "";
                if (rbNam.isChecked()) {
                    gioiTinh = "Nam";
                } else if (rbNu.isChecked()) {
                    gioiTinh = "Nu";
                }
                list.add(new DuLieu(ten, hinh, mota, vb2, gioiTinh));
                Toast.makeText(MainActivity.this, "Add Du lieu thanh cong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void upLoadImg() {
        btnUpLoadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void anhXa() {
        edtHoTen = findViewById(R.id.edtHoTen);
        pngAnh = findViewById(R.id.pngAnh);
        edtMota = findViewById(R.id.edtMoTa);
        rbNam = findViewById(R.id.rbNam);
        rbNu = findViewById(R.id.rbNu);
        btnUpLoadImg = findViewById(R.id.btnUpLoadImg);
        btnTao = findViewById(R.id.btnTao);
        btnXoa = findViewById(R.id.btnXoa);
        btnXemTT = findViewById(R.id.btnXemTT);
        cbVB2 = findViewById(R.id.cbVB2);
    }
}