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
    Button btnGiai;
    EditText edtDelta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giai_ket_qua);
        anhXa();
        Intent intent = getIntent();
        int a = intent.getIntExtra("a", 0);
        int b = intent.getIntExtra("b", 0);
        int c = intent.getIntExtra("c", 0);
        double delta = Math.pow(b, 2) - 4 * a * c;
        edtDelta.setText("" + delta);
        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("delta", delta);
                setResult(2, intent);
                finish();
            }
        });
    }

    private void anhXa() {
        btnGiai = findViewById(R.id.btnGiai);
        edtDelta = findViewById(R.id.edtDelta);
    }
}