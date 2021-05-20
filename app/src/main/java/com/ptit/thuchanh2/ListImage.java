package com.ptit.thuchanh2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ListImage extends AppCompatActivity {
    private Spinner spnCategory;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_image);
        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        blindControl();
        if (sharedPreferences.contains("username")) {
            title.setText(sharedPreferences.getString("username", ""));
        }
    }

    void blindControl() {

        title = findViewById(R.id.txt_header);
        spnCategory=findViewById(R.id.spn_category);
        List<String> list = Arrays.asList("Điện thoại","Máy tính","Phụ kiện");
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnCategory.setAdapter(adapter);

    }
}