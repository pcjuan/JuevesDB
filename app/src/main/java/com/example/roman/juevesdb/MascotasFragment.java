package com.example.roman.juevesdb;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roman.juevesdb.adapter.AdapterMascota;
import com.example.roman.juevesdb.modelo.CrudMascota;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotasFragment extends Fragment {


    public MascotasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_mascotas, container, false);

        RecyclerView recycler=view.findViewById(R.id.recycler_mascota);

        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);

        CrudMascota crud = new CrudMascota(getActivity());

        recycler.setLayoutManager(lm);
        recycler.setAdapter(new AdapterMascota(crud.mascotaList(),
                            R.layout.item_mascota,getActivity()));


        return view;
    }

}
