package com.example.roman.juevesdb.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roman on 11-01-18.
 */

public class CrudMascota {

    private SQLiteDatabase db;
    private ContentValues values;
    private ConexionHelper helper;

    public CrudMascota(Context context){
        helper = new ConexionHelper(context);
        values = new ContentValues();
    }

    public void insertar(Mascota m){
        db = helper.getWritableDatabase();
        values.clear();
        values.put(ConexionHelper.COLUMN_NOMBRE,m.getNombre());
        values.put(ConexionHelper.COLUMN_RAZA,m.getRaza());
        values.put(ConexionHelper.COLUMN_GENERO,m.getGenero());
        values.put(ConexionHelper.COLUMN_PESO,m.getPeso());
        db.insert(ConexionHelper.TABLE_NAME,null,values);
    }

    public void eliminar(int id){
        String cod = String.valueOf(id);
        db = helper.getWritableDatabase();
        db.delete(ConexionHelper.TABLE_NAME, "id=?", new String[]{cod});
    }

    public void actualizar(Mascota m){
        String cod = String.valueOf(m.getId());
        db = helper.getWritableDatabase();
        values.clear();
        values.put(ConexionHelper.COLUMN_NOMBRE,m.getNombre());
        values.put(ConexionHelper.COLUMN_RAZA,m.getRaza());
        values.put(ConexionHelper.COLUMN_GENERO,m.getGenero());
        values.put(ConexionHelper.COLUMN_PESO,m.getPeso());
        db.update(ConexionHelper.TABLE_NAME,
                    values,
                    ConexionHelper.COLUMN_ID+"=?",
                    new String[]{cod});
    }

    public Mascota buscar(int id){
        String cod = String.valueOf(id);
        db = helper.getReadableDatabase();
        Cursor c;
        c=db.rawQuery("SELECT * FROM "+ConexionHelper.TABLE_NAME, new String[]{cod});

        if (c.moveToNext()){
            Mascota m = new Mascota();
            m.setId(id);
            m.setNombre(c.getString(1));
            m.setRaza(c.getString(2));
            m.setGenero(c.getString(3));
            m.setPeso(c.getDouble(4));
            return m;
        }
        return null;
    }

    public List<Mascota> mascotaList(){
        ArrayList<Mascota> list = new ArrayList<>();
        db = helper.getReadableDatabase();
        Cursor c;
        c=db.rawQuery("SELECT * FROM "+ConexionHelper.TABLE_NAME, null);
        while (c.moveToNext()){
            Mascota m = new Mascota();
            m.setId(c.getInt(0));
            m.setNombre(c.getString(1));
            m.setRaza(c.getString(2));
            m.setGenero(c.getString(3));
            m.setPeso(c.getDouble(4));
            list.add(m);
        }
        return list;
    }

}
