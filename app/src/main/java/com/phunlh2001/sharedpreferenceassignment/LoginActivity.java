package com.phunlh2001.sharedpreferenceassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final String PREF_NAME = "PrefDemo";
    public static final String KEY_USERNAME = "Username";

    private EditText inputUsername, inputPassword;
    private Button btnLogin;
    private SharedPreferences pref;

    private void init() {
        inputUsername = findViewById(R.id.inputUsername);
        inputPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnLogin);
        pref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        btnLogin.setOnClickListener(v -> {
            String username = inputUsername.getText().toString();
            String password = inputPassword.getText().toString();

            if (!username.isEmpty() && !password.isEmpty()) {
                SharedPreferences.Editor editor = pref.edit();
                editor.putString(KEY_USERNAME, username);
                boolean isLogin = editor.commit();

                if (isLogin) {
                    Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}