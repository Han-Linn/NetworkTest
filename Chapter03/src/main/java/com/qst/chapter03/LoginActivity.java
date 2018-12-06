package com.qst.chapter03;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 用于模拟登录的Activity
 */
public class LoginActivity extends AppCompatActivity {
    EditText userNameTxt;
    EditText passwordTxt;
    Button loginBtn;
    TextView tipsTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        userNameTxt = findViewById(R.id.userNameTxt);
        passwordTxt = findViewById(R.id.passwordTxt);
        tipsTv = findViewById(R.id.tipsTxt);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = userNameTxt.getText().toString();
                String password = passwordTxt.getText().toString();
                if (!"admin".equals(userName)) {
                    tipsTv.setText("用户名不存在!");
                    tipsTv.setVisibility(View.VISIBLE);
                    return;
                }
                if (!"1".equals(password)) {
                    tipsTv.setText("密码不正确!");
                    tipsTv.setVisibility(View.VISIBLE);
                    return;
                }
                if ("admin".equals(userName) && "1".equals(password)) {
                    tipsTv.setText("登录成功!");
                    tipsTv.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}