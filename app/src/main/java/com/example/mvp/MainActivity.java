package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoginInterface {

    private EditText edtEmail, edtPassword;
    private TextView tvMessage;
    private Button btnLogin;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        tvMessage = findViewById(R.id.tv_message);
        btnLogin = findViewById(R.id.btn_login);
        mLoginPresenter = new LoginPresenter(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickLogin();
            }
        });
    }

    private void clickLogin() {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        User user = new User(email, password);
        mLoginPresenter.login(user);
    }

    @Override
    public void loginSuccess() {
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setText("Login Success");
    }

    @Override
    public void loginError() {
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setText("Email or password invalid");
    }
}