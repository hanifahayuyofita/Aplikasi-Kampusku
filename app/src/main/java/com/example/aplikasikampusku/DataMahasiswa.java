package com.example.aplikasikampusku;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class DataMahasiswa extends AppCompatActivity {

    ListView listView;
    Button btnDataMahasiswa;
    FloatingActionButton fab;
    DatabaseHelper db2;
    List<Note> notesList;
    ArrayAdapter<String> adapter;
    List<String> titlesList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_mahasiswa);

        listView = findViewById(R.id.listView);
        fab = findViewById(R.id.fab);

        notesList = new ArrayList<>();
        titlesList = new ArrayList<>();

        btnDataMahasiswa = findViewById(R.id.btnDataMahasiswa);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataMahasiswa.this, InputData.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DataMahasiswa.this, DetailData.class);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                new FragmentDialogBox().show(getSupportFragmentManager(), "fragmentDialog");
                return false;
            }
        });

        btnDataMahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataMahasiswa.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }
}