package com.example.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  private Button checkBtn;
  private TextView pass,login;
  private EditText passInput,loginInput;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    pass = findViewById(R.id.pass);
    passInput = findViewById(R.id.passInput);
    login = findViewById(R.id.login);
    loginInput = findViewById(R.id.loginInput);
    checkBtn = findViewById(R.id.checkBtn);
    checkBtn.setOnClickListener(v -> {
      Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
      intent.putExtra("pass",passInput.getText().toString());
      intent.putExtra("login",loginInput.getText().toString());
      startActivity(intent);
    });
  }

}