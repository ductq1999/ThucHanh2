package com.ptit.thuchanh2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProductActivity extends AppCompatActivity {
    private Spinner spnCategory,spnimage;
    Button add, refresh;
    EditText name,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        blindControl();
    }

    void blindControl() {

        spnCategory=findViewById(R.id.spn_category_add);
        List<String> list = Arrays.asList("Điện thoại","Máy tính","Phụ kiện");
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnCategory.setAdapter(adapter);

        spnimage=findViewById(R.id.spn_image);
        ImageAdapter imageAdapter=new ImageAdapter(getApplicationContext());
        spnimage.setAdapter(imageAdapter);

        add.setOnClickListener(v ->{
           String cate=(String) spnCategory.getSelectedItem();
           String image=(String)spnimage.getSelectedItem();
           SanPham  sanPham=new SanPham(name.getText().toString(),price.getText().toString(),image,cate);
           DatabaseHandler.getInstance().onInsert(sanPham);

        });


    }
}