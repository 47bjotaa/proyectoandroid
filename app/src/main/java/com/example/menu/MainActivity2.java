package com.example.menu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private List<ListaDeElementos2> colegiosList;
    private listadapter2 adapter1; // Cambio de nombre a ListAdapter2
    private static final int REQUEST_FAVORITOS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Inicializar la lista de colegios
        colegiosList = new ArrayList<>();
        // Agregar colegios a la lista
        colegiosList.add(new ListaDeElementos2(
                "Universidad de la Serena",
                "La Serena",
                "Descripción de la Universidad de la Serena",
                R.drawable.logo_uls_8,
                "Avenida Raúl Bitrán Nachary",
                "123456789",
                "http://www.Usn.com"
        ));
        // Agrega más colegios según sea necesario

        // Inicializar la lista de instituciones
        // Agregar instituciones a la lista
        // ... (código existente para agregar instituciones)

        // Configuración del RecyclerView para colegios
        RecyclerView recyclerViewColegios = findViewById(R.id.listRecycledViewColegios);
        recyclerViewColegios.setLayoutManager(new LinearLayoutManager(this));

        // Inicialización del adaptador para colegios
        adapter1 = new listadapter2(colegiosList, this, (item, position) -> {
            item.setFavorito(!item.isFavorito()); // Cambiar el estado de favorito
            adapter1.notifyItemChanged(position);
        });
        recyclerViewColegios.setAdapter(adapter1);

        // Configuración del RecyclerView para instituciones



        // Resto del código sin cambios
    }

    // Resto del código sin cambios
}
