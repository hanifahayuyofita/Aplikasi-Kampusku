package com.example.aplikasikampusku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    Button btnLihatData, btnInputData, btnInformasi;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnLihatData = findViewById(R.id.btnLihatData);
        btnInputData = findViewById(R.id.btnInputData);
        btnInformasi = findViewById(R.id.btnInformasi);

        btnLihatData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, DataMahasiswa.class);
                startActivity(intent);
            }
        });

        btnInputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, InputData.class);
                startActivity(intent);
            }
        });

        btnInformasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, TentangAplikasi.class);
                startActivity(intent);
            }
        });
    }
}