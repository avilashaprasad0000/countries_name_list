package com.example.countries_name_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class NameDisplay extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    String CountryName,CountryCode,CountryCapital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_display);

        CountryName = getIntent().getStringExtra("CountryName");
        CountryCode=  getIntent().getStringExtra("CountryCode");
        CountryCapital=  getIntent().getStringExtra("CountryCapital");

        tv1.setText(CountryName);
        tv1.setText(CountryCode);
        tv1.setText(CountryCapital);

    }
}
