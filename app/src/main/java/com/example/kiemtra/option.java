package com.example.kiemtra;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class option extends AppCompatActivity {
    Button btnNhanVien,btnDonVi;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<NhanVien> nhanVienList = new ArrayList<>();
    private List<MainActivity> donViList = new ArrayList<>();
    private List<String> currentList = new ArrayList<>();
    private Map<String, Object> objectMap = new HashMap<>();  // Khai báo objectMap

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option);

        btnNhanVien = findViewById(R.id.btnNhanVien);
        btnDonVi =  findViewById(R.id.btnDonVi);

        btnNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(option.this, MainActivity.class));
            }
        });

        btnDonVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(option.this, MainActivity.class));
            }
        });

    }
}
