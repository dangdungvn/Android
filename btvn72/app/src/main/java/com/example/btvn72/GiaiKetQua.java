package com.example.btvn72;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GiaiKetQua extends AppCompatActivity {
    EditText edtDelta;
    Button btnGiai;
    Intent intent = getIntent();

    int a = intent.getIntExtra("a", 0);
    int b = intent.getIntExtra("b", 0);
    int c = intent.getIntExtra("c", 0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giai_ket_qua);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        anhXa();
        giaiPTBac2();
    }

    private void giaiPTBac2() {
        double delta = Math.pow(b, 2) - (4 * a * c);
        if (delta < 0) {
            edtDelta.setText("Phuong trinh vo nghiem");
        }
        else if (delta == 0) {
            edtDelta.setText("Phuong trinh co nghiem kep x = " + (-b / (2 * a)));
        }
        else {
            edtDelta.setText("Phuong trinh co 2 nghiem phan biet ");
        }
        edtDelta.setText(String.valueOf(delta));
        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("delta", delta);
            }
        });
    }

    private void anhXa() {
        edtDelta = findViewById(R.id.edtDelta);
        btnGiai = findViewById(R.id.btnGiai);
    }
}