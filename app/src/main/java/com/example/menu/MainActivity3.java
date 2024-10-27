package com.example.menu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private List<ListaDeElementos3> InstitutosList;
    private ListAdapter3 adapter2;
    private static final int REQUEST_FAVORITOS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Inicializar la lista de colegios
        InstitutosList = new ArrayList<>();
        // Agregar colegios a la lista
        InstitutosList.add(new ListaDeElementos3(
                "Universidad de la Serena",
                "La Serena",
                "Descripción de la Universidad de la Serena",
                R.drawable.logo_uls_8,
                "Avenida Raúl Bitrán Nachary",
                "123456789",
                "http://www.Usn.com"
        ));
        // Agrega más colegios según sea necesario

        // Configuración del RecyclerView para colegios
        RecyclerView recyclerViewIntitutos = findViewById(R.id.listRecycledViewInstitutos);
        recyclerViewIntitutos.setLayoutManager(new LinearLayoutManager(this));

        // Inicialización del adaptador para colegios
        adapter2 = new ListAdapter3(InstitutosList, this, (item, position) -> {
            item.setFavorito(!item.isFavorito()); // Cambiar el estado de favorito
            adapter2.notifyItemChanged(position);
        });
        recyclerViewIntitutos.setAdapter(adapter2);

        // Configuración del RecyclerView para instituciones
        // ... (código existente para configurar el RecyclerView de instituciones)
    }

    // Resto del código sin cambios
}