package com.example.testfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register_Activity extends AppCompatActivity {
    private EditText etEmail,etPass;
    private Button btnregis;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        btnregis = findViewById(R.id.btnregis);

        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }
    private void register(){
        String Email,Pass;
        Email = etEmail.getText().toString();
        Pass = etPass.getText().toString();

        if(TextUtils.isEmpty(Email)) {
            Toast.makeText(this,"Vui lòng nhập email!",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Pass)) {
            Toast.makeText(this,"Vui lòng nhập password!",Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(Email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Tạo tài khoản thành công!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register_Activity.this, MainActivity.class);
                    startActivity(intent);
                }else Toast.makeText(getApplicationContext(),"Tạo tài khoản thất bại!",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
