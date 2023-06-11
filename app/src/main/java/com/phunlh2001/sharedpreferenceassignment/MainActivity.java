package com.phunlh2001.sharedpreferenceassignment;

import static com.phunlh2001.sharedpreferenceassignment.LoginActivity.KEY_USERNAME;
import static com.phunlh2001.sharedpreferenceassignment.LoginActivity.PREF_NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogout = findViewById(R.id.btnLogout);
        pref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        String username = pref.getString(KEY_USERNAME, "");
        if (username.isEmpty()) {
            Logout();
        } else {
            Toast.makeText(this, "Hello " + username, Toast.LENGTH_SHORT).show();
        }

        btnLogout.setOnClickListener(v -> {
            SharedPreferences.Editor editor = pref.edit();
            editor.remove(KEY_USERNAME);
            editor.apply();

            Logout();
        });
    }

    private void Logout() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}