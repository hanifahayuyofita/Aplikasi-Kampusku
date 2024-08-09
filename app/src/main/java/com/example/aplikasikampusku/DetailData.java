package com.example.aplikasikampusku;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import android.os.Bundle;

public class DetailData extends AppCompatActivity {
    private EditText etNIM, etNAMA, etTTL, etJK, etALAMAT;
    private Button btnDetailData;
    private DatabaseHelper2 db2;
    private Note note;
    private boolean isEdit = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);
        etNIM = findViewById(R.id.etNIM);
        etNAMA = findViewById(R.id.etNAMA);
        etTTL = findViewById(R.id.etTTL);
        etJK = findViewById(R.id.etJK);
        etALAMAT = findViewById(R.id.etALAMAT);
        btnDetailData = findViewById(R.id.btnDetailData);
        db2 = new DatabaseHelper2(this);

        if (getIntent().hasExtra("note_id")) {
            int noteId = getIntent().getIntExtra("note_id", -1);

            if (note != null) {
                etNIM.setText(note.getNIM());
                etNAMA.setText(note.getNAMA());
                etTTL.setText(note.getTTL());
                etJK.setText(note.getJK());
                etALAMAT.setText(note.getALAMAT());
                isEdit = true;
            }
        }
    }

}