package com.example.chuyen_doi_nhiet_do;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtdoC,edtdoF;
    Button btncf,btnfc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtdoC = findViewById(R.id.txtCel);
        edtdoF = findViewById(R.id.txtFar);
        btncf = findViewById(R.id.btnFar);
        btnfc = findViewById(R.id.btnCel);
        btncf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf=new DecimalFormat("#.00");
                float C=Integer.parseInt("0"+edtdoC.getText());
                edtdoF.setText(dcf.format(C* 9F /5+32));

            }
        });
        btnfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf=new DecimalFormat("#.00");
                float F=Float.parseFloat("0"+edtdoF.getText());
                edtdoC.setText(dcf.format((F-32) * 5F/9));
            }
        });

    }
}