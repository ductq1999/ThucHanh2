package com.ptit.thuchanh2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText code;
    Button add,list;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blindControl();
        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        if (sharedPreferences.contains("username")) {
            title.setText(sharedPreferences.getString("username", ""));
            name.setVisibility(View.INVISIBLE);
            code.setVisibility(View.INVISIBLE);
            add.setVisibility(View.INVISIBLE);
        }

    }
    void blindControl() {
        name = findViewById(R.id.edit_name);
        code = findViewById(R.id.edit_code);
        add = findViewById(R.id.btn_add);
        title = findViewById(R.id.txt_header);
        add.setOnClickListener(v -> {
            String username = "Xin chào: "+ name.getText() + " " + code.getText();
            SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
            sharedPreferences.edit().putString("username", username).apply();
            MainActivity mainActivity = MainActivity.this;
            mainActivity.finish();
            mainActivity.startActivity(mainActivity.getIntent());
        });
        list=findViewById(R.id.btn_list);
        list.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListImage.class);
            MainActivity.this.startActivity(intent);
        });
    }
}