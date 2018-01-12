package com.example.roman.juevesdb.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by roman on 11-01-18.
 */

public class ConexionHelper extends SQLiteOpenHelper{

    private static final String NAME_DB = "mascotas";
    private static final int VERSION = 1;

    public static final String TABLE_NAME = "mascota";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_RAZA = "raza";
    public static final String COLUMN_GENERO = "genero";
    public static final String COLUMN_PESO = "peso";


    public ConexionHelper(Context context){
        super(context, NAME_DB,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_NAME + " ( ";
        sql += COLUMN_ID     + " integer primary key autoincrement, ";
        sql += COLUMN_NOMBRE + " text, ";
        sql += COLUMN_RAZA   + " text, ";
        sql += COLUMN_GENERO + " text, ";
        sql += COLUMN_PESO   + " double );";

        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.execSQL("insert into "+TABLE_NAME+" values(null,'Boby','Pastor Ingles','Macho',2)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
