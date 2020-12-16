package com.example.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class SecondActivity extends AppCompatActivity {

  private TextView passAnswer,loginAnswer;
  private Button back;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    String pattern = "^(?=\\S*?[a-z])(?=\\S*?[A-Z])(?=\\S*?\\d)(.){8,}$";
    String patternLog = "^(?=.*[a-z])(?=.*[A-Z])(.){4,}$";
    passAnswer = findViewById(R.id.passAnswer);
    back = findViewById(R.id.back);
    loginAnswer = findViewById(R.id.loginAnswer);
    Bundle bundle = getIntent().getExtras();
    if(bundle != null) {
      String valueLogin = bundle.getString("login");
      String valuePass = bundle.getString("pass");
      if(Pattern.matches(pattern, valuePass)) {
        passAnswer.setText("Пароль правильный");
      } else {
        passAnswer.setText("В пароле должно быть от 8 символов, а также буквы обоих регистров и хотя бы одна цифра");
      }
      if(Pattern.matches(patternLog, valueLogin)) {
        loginAnswer.setText("Логин правильный");
      } else {
        loginAnswer.setText("В логине должно быть от 4 символов, а также буквы обоих регистров");
      }
    }
    back.setOnClickListener(v -> {
      Intent intent = new Intent(getApplicationContext(),MainActivity.class);
      startActivity(intent);
    });
  }
}