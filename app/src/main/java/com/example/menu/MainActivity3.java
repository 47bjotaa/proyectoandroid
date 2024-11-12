package com.example.menu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

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
                "AIEP",
                "La Serena",
                "El Instituto Profesional AIEP en La Serena es una institución de educación superior que ofrece una amplia variedad de programas académicos orientados a la formación técnica y profesional. ",
                R.drawable.logoaiepnuevo,
                "Huanhuali 105, La Serena, Coquimbo",
                "123456789",
                "http://www.aiep.com"
        ));
        InstitutosList.add(new ListaDeElementos3(
                "IpChile",
                "La Serena",
                "IPCHILE es una institución acreditada que ofrece carreras técnicas y profesionales, cursos y diplomados en modalidades presencial.",
                R.drawable.ipchile,
                "Avenida Francisco de Aguirre 388 1710128 La Serena Coquimbo",
                "987654321",
                "http://www.IpChile.com"
        ));

        InstitutosList.add(new ListaDeElementos3(
                "Inacap",
                "La Serena",
                "INACAP ofrece carreras técnicas, profesionales y de educación continua en diversas áreas y modalidades.",
                R.drawable.inacap,
                "Av. Francisco De Aguirre #0389 1700000 La Serena Coquimbo.",
                "987654321",
                "http://www.Inacap.com"
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



    }




    }

