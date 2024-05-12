package com.example.btvn4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity{
    EditText user, pass;
    CheckBox remember;
    Button login;
    Map<String, String> usersss = new HashMap<>();
    private void mapping() {
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        remember = findViewById(R.id.remember);
        login = findViewById(R.id.login);
    }
    private void init() {
        usersss.put("admin", "admin");
        usersss.put("user", "user");
    }

    private void action() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usersss.containsKey(user.getText().toString()) && usersss.get(user.getText().toString()).equals(pass.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void check() {
        remember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(remember.isChecked()) {
                    usersss.put(user.getText().toString(), pass.getText().toString());
                    Toast.makeText(MainActivity.this, "Tài khoản đã được lưu", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        mapping();
        init();
        action();
        check();
    }
}