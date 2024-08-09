package com.example.aplikasikampusku;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
public class DatabaseHelper2 extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "Datadiri.db";
    private static final String TABLE_NAME = "Datadiri";
    private static final String COLUMN_1 = "nim";
    private static final String COLUMN_2 = "nama";
    private static final String COLUMN_3 = "ttl";
    private static final String COLUMN_4 = "jeniskelamin";
    private static final String COLUMN_5 = "alamat";


    public DatabaseHelper2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db2) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_2 + " TEXT, "
                + COLUMN_3 + " TEXT, "
                + COLUMN_4 + " TEXT, "
                + COLUMN_5 + " TEXT)";
        db2.execSQL(createTable);
    }

    public void onUpgrade(SQLiteDatabase db2, int oldVersion, int newVersion) {
        db2.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db2);
    }

    public long addNote(Note note) {
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_2, note.getNAMA());
        values.put(COLUMN_3, note.getNAMA());
        values.put(COLUMN_4, note.getJK());
        values.put(COLUMN_5, note.getALAMAT());
        long id = db2.insert(TABLE_NAME, null, values);
        db2.close();
        return id;
    }



    public List<Note> getAllNotes() {
        List<Note> notes = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + COLUMN_1 + " DESC";
        SQLiteDatabase db2 = this.getReadableDatabase();
        Cursor cursor = db2.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Note note = new Note();
                note.setNIM(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_1)));
                note.setNAMA(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_2)));
                note.setTTL(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_3)));
                note.setJK(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_4)));
                note.setALAMAT(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_5)));
                notes.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return notes;
    }

    public int updateNote(Note note) {
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_2, note.getNAMA());
        values.put(COLUMN_3, note.getTTL());
        values.put(COLUMN_4, note.getJK());
        return db2.update(TABLE_NAME, values, COLUMN_1 + " = ?",
                new String[]{String.valueOf(note.getNIM())});
    }

    public void deleteNote(Note note) {
        SQLiteDatabase db2 = this.getWritableDatabase();
        db2.delete(TABLE_NAME, COLUMN_1 + " = ?",
                new String[]{String.valueOf(note.getNIM())});
        db2.close();
    }

    public List<Note> searchNotes(String keyword) {
        List<Note> notes = new ArrayList<>();
        String searchQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_2 + " LIKE ? OR " + COLUMN_3 + " LIKE ? ORDER BY " + COLUMN_4 + " DESC";
        SQLiteDatabase db2 = this.getReadableDatabase();
        Cursor cursor = db2.rawQuery(searchQuery, new String[]{"%" + keyword + "%", "%" + keyword + "%"});
        if (cursor.moveToFirst()) {
            do {
                Note note = new Note();
                note.setNIM(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_1)));
                note.setNAMA(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_2)));
                note.setTTL(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_3)));
                note.setJK (cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_4)));
                note.setALAMAT (cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_5)));
                notes.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return notes;
    }
}
