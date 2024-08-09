package com.example.aplikasikampusku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputData extends AppCompatActivity {

    EditText etNIM, etNAMA, etTTL, etJK, etALAMAT;
    Button btnSave, btnInput;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        etNIM = findViewById(R.id.etNIM);
        etNAMA = findViewById(R.id.etNAMA);
        etTTL = findViewById(R.id.etTTL);
        etJK =findViewById(R.id.etJK);
        etALAMAT = findViewById(R.id.etALAMAT);
        btnSave = findViewById(R.id.btnSimpan);
        btnInput = findViewById(R.id.btnInput);





        db = new DatabaseHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NIM = etNIM.getText().toString();
                String NAMA = etNAMA.getText().toString();
                String TTL = etTTL.getText().toString();
                String JK = etTTL.getText().toString();
                String ALAMAT = etALAMAT.getText().toString();
                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(InputData.this, Dashboard.class);
                startActivity(intent);
            }
        });

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InputData.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }
}