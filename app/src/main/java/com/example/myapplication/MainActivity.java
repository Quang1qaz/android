package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText NameEditText, IdEditText, ExtraInfoEditText;
    CheckBox ReadNewspaperCheckBox, ReadBookCheckBox, ReadCodeCheckBox;
    Button SendButton;
    RadioGroup DegreeRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NameEditText = findViewById(R.id.NameEditText);
        IdEditText = findViewById(R.id.IdEditText);
        ExtraInfoEditText = findViewById(R.id.ExtraInfoEditText);
        ReadNewspaperCheckBox = findViewById(R.id.ReadNewspaperCheckBox);
        ReadCodeCheckBox = findViewById(R.id.ReadCodeCheckBox);
        ReadBookCheckBox = findViewById(R.id.ReadBookCheckBox);
        SendButton = findViewById(R.id.SendButton);
        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                doShowInformation();
            }
        });
    }


    public void doShowInformation() {
        String ten = NameEditText.getText().toString();
        ten = ten.trim();
        if (ten.length() < 3) {
            NameEditText.requestFocus();
            NameEditText.selectAll();
            Toast.makeText(this, "Tên phải >= 3 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        String cmnd = IdEditText.getText().toString();
        cmnd = cmnd.trim();
        if (cmnd.length() != 9) {
            IdEditText.requestFocus();
            IdEditText.selectAll();
            Toast.makeText(this, "CMND phải đúng 9 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        String bang = "";
        DegreeRadioGroup = findViewById(R.id.DegreeRadioGroup);
        int id = DegreeRadioGroup.getCheckedRadioButtonId();// Trả về Id
        if (id == -1) {
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_LONG).show();
            return;
        }
        RadioButton rad = findViewById(id);
        bang = rad.getText() + "";

        String sothich = "";
        if (ReadNewspaperCheckBox.isChecked()) sothich += ReadNewspaperCheckBox.getText() + "\n";
        if (ReadBookCheckBox.isChecked()) sothich += ReadBookCheckBox.getText() + "\n";
        if (ReadCodeCheckBox.isChecked()) sothich += ReadCodeCheckBox.getText() + "\n";
        String bosung = ExtraInfoEditText.getText() + "";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        String msg = ten + "\n";
        msg += cmnd + "\n";
        msg += bang + "\n";
        msg += sothich;
        msg += "—————————–\n";
        msg += "Thông tin bổ sung:\n";
        msg += bosung + "\n";
        msg += "—————————–";
        builder.setMessage(msg);//thiết lập nội dung
        builder.create().show();//hiển thị Dialog
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        b.setTitle("Question");
        b.setMessage("Are you sure you want to exit?");
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        b.setNegativeButton("No", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        b.create().show();
    }
}