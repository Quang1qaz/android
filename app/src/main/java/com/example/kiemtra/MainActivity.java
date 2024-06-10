package com.example.kiemtra;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button btn_themdv,btn_suadv,btn_xoadv;
    EditText etMadv,etTendv,etEmail,etWeb,etLogo,etDiachi,etSdt,etMadvcha;
    SQLiteDatabase mydatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       mydatabase = openOrCreateDatabase("qldanhba.db",MODE_PRIVATE,null);

       try {
           String sql = "CREATE TABLE donvi(madonvi TEXT primary key,tendonvi TEXT,email TEXT,website TEXT,Logo TEXT,diachi TEXT,sdt TEXT,madonvicha NULLABLE)";
           String sql1 = "CREATE TABLE nhanvien(manhanvien TEXT primary key,hoten TEXT,chucvu TEXT,email TEXT,sdt TEXT,anhdaidien BLOB,madonvi TEXT,FOREIGN KEY(madonvi) REFERENCES donvi(madonvi))";
           mydatabase.execSQL(sql);
           mydatabase.execSQL(sql1);
       }
       catch(Exception e)
       {
           Log.e("Error","Table đã tồn tại");
       }

        etMadv = findViewById(R.id.etMadv);
        etTendv = findViewById(R.id.etTendv);
        etEmail = findViewById(R.id.etEmail);
        etWeb = findViewById(R.id.etWeb);
        etLogo = findViewById(R.id.etLogo);
        etDiachi = findViewById(R.id.etDiachi);
        etSdt = findViewById(R.id.etSdt);
        etMadvcha = findViewById(R.id.etMadvcha);

        btn_themdv = findViewById(R.id.btn_themdv);
        btn_themdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Madv = etMadv.getText().toString();
                String Tendv = etTendv.getText().toString();
                String Email = etEmail.getText().toString();
                String Web = etWeb.getText().toString();
                String Logo = etLogo.getText().toString();
                String Diachi = etDiachi.getText().toString();
                String Sdt = etSdt.getText().toString();
                String Madvcha = etMadvcha .getText().toString();
                ContentValues myvalue = new ContentValues();
                myvalue.put("madonvi",Madv);
                myvalue.put("tendonvi",Tendv);
                myvalue.put("email",Email);
                myvalue.put("website",Web);
                myvalue.put("Logo",Logo);
                myvalue.put("diachi",Diachi);
                myvalue.put("sdt",Sdt);
                myvalue.put("madonvicha",Madvcha);
                String msg = "";
                if(mydatabase.insert("donvi",null,myvalue) == -1)
                    msg = "Fail insert record!";
                else msg = "insert record Sucessfully!";
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });

        btn_suadv = findViewById(R.id.btn_suadv);
        btn_suadv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Madv = etMadv.getText().toString();
                String Tendv = etTendv.getText().toString();
                String Email = etEmail.getText().toString();
                String Web = etWeb.getText().toString();
                String Logo = etLogo.getText().toString();
                String Diachi = etDiachi.getText().toString();
                String Sdt = etSdt.getText().toString();
                String Madvcha = etMadvcha .getText().toString();
                ContentValues myvalue = new ContentValues();
                myvalue.put("madonvi",Madv);
                myvalue.put("tendonvi",Tendv);
                myvalue.put("email",Email);
                myvalue.put("website",Web);
                myvalue.put("Logo",Logo);
                myvalue.put("diachi",Diachi);
                myvalue.put("sdt",Sdt);
                myvalue.put("madonvicha",Madvcha);
                int n = mydatabase.update("donvi",myvalue,"madonvi = ?",new String[]{Madv});
                String msg ="";
                if(n==0) msg = "no record to Update!";
                else msg = n+"record Update Sucessfully!";
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });

        btn_xoadv = findViewById(R.id.btn_xoadv);
        btn_xoadv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Madv = etMadv.getText().toString();
                int n = mydatabase.delete("donvi","madonvi = ?",new String[]{Madv});
                String msg = "";
                if(n==0) msg = "Fail Delete record!";
                else msg = n+"Delete record Sucessfully!";
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
    }
}