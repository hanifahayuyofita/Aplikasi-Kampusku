package com.example.aplikasikampusku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TentangAplikasi extends AppCompatActivity {
    Button btnTentangAplikasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_aplikasi);
        btnTentangAplikasi = findViewById(R.id.btnTentangAplikasi);

        btnTentangAplikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TentangAplikasi.this, Dashboard.class);
                startActivity(intent);
            }
        });


    }
}