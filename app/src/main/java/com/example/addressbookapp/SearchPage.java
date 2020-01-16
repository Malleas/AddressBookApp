package com.example.addressbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class SearchPage extends AppCompatActivity {

    Button btn_search, btn_updateNo, btn_updateYes;
    TextView tv_updateQuestion;
    EditText et_searchName, et_searchCity, et_searchDescription, et_searchId;
    ListView lv_searchResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        btn_search = findViewById(R.id.btn_search);
        btn_updateYes = findViewById(R.id.btn_updateYes);
        btn_updateNo = findViewById(R.id.btn_updateNo);
        tv_updateQuestion = findViewById(R.id.tv_updateQuestion);
        et_searchCity = findViewById(R.id.et_searchCity);
        et_searchName = findViewById(R.id.et_searchName);
        et_searchId = findViewById(R.id.et_searchId);
        et_searchDescription = findViewById(R.id.et_searchDescription);
        lv_searchResults = findViewById(R.id.lv_searchResults);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //search array list for a given input.
            }
        });

        btn_updateYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UpdateContact.class);
                startActivity(intent);
            }
        });

        btn_updateNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
