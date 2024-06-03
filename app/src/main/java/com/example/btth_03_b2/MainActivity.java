package com.example.btth_03_b2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<String> arraywork;
    ArrayAdapter<String> arrAdapater;
    EditText edtwork,edth,edtm;
    TextView txtdate;
    Button btnwork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edth = findViewById(R.id.edthour);
        edtm = findViewById(R.id.edtmi);
        edtwork = findViewById(R.id.edtwork);
        btnwork = findViewById(R.id.btnadd);
        lv = findViewById(R.id.ListView1);
        txtdate = findViewById(R.id.txtdate);

        arraywork = new ArrayList<>();

        arrAdapater = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arraywork);
        lv.setAdapter(arrAdapater);

        Date currentDate = Calendar.getInstance().getTime();
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText("Hôm Nay: "+simpleDateFormat.format(currentDate));

        btnwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtwork.getText().toString().equals("")|| edth.getText().toString().equals("") ||edtm.getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Info missing");
                    builder.setMessage("Please enter all information of the work");
                    builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}
                    });
                    builder.show();
                }
                else {
                    String str = edtwork.getText().toString() + " - "+ edth.getText().toString() + ":"+edtm.getText().toString();
                    arraywork.add(str);

                    arrAdapater.notifyDataSetChanged();
                    edth.setText("");
                    edtm.setText("");
                    edtwork.setText("");
                }
            }
        });

    }
}