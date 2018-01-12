package com.example.roman.juevesdb;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.roman.juevesdb.modelo.CrudMascota;
import com.example.roman.juevesdb.modelo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NuevaMascotaFragment extends Fragment {

    private EditText txtNombre, txtRaza, txtPeso;
    private Spinner txtGenero;
    private Button  bt;

    public NuevaMascotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_nueva_mascota, container, false);
        txtNombre = view.findViewById(R.id.txtNuevoNombre);
        txtGenero = view.findViewById(R.id.txtNuevoGenero);
        txtRaza = view.findViewById(R.id.txtNuevoRaza);
        txtPeso = view.findViewById(R.id.txtNuevoPeso);
        bt = view.findViewById(R.id.btNuevoAdd);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarMascota();
            }
        });

        return view;
    }

    public void guardarMascota(){
        CrudMascota crud = new CrudMascota(getActivity());
        String nombre = txtNombre.getText().toString();
        String raza = txtRaza.getText().toString();
        String strPeso = txtPeso.getText().toString();
        String genero = txtGenero.getSelectedItem().toString();

        Mascota m = new Mascota(nombre,
                                raza,
                                genero,
                                Double.parseDouble(strPeso)
                                );

        crud.insertar(m);
        Log.e("INFO", "TAM:"+crud.mascotaList().size());
    }


}


