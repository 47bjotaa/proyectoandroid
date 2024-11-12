package com.example.menu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

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
                "Bernardo O'Higgins",
                "Coquimbo",
                "El Colegio Bernardo O'Higgins es una institución educativa ubicada en La Serena, Chile. Ofrece una formación integral a sus estudiantes, enfocándose en valores como la responsabilidad y el respeto. ",
                R.drawable.logobernardo,
                "Matta 490",
                "987654321",
                "http://www.b_o.com"
        ));
        colegiosList.add(new ListaDeElementos2(
                "Geronimo Rendic",
                "La Serena",
                "El Colegio Geronimo Rendic es una institución educativa en La Serena, Chile, que se centra en la formación integral de sus estudiantes. Ofrece una sólida educación básica y media, promoviendo valores como la disciplina y el respeto. ",
                R.drawable.rendic,
                "Las Casas 986, 1720085 La Serena, Coquimbo",
                "123123123",
                "http://www.gr.com"
        ));
        colegiosList.add(new ListaDeElementos2(
                "Gabriel González Videla",
                "La Serena",
                "El Colegio Gabriel González Videla es una institución educativa ubicada en La Serena, Chile. Se dedica a proporcionar una educación de calidad, enfocándose en el desarrollo académico y personal de sus estudiantes. Con un ambiente inclusivo, fomenta valores como la solidaridad y el respeto, preparando a sus alumnos para ser ciudadanos responsables y comprometidos con su comunidad.",
                R.drawable.logogabriel,
                "Pedro Pablo Muñoz 4",
                "456456456",
                "http://www.ggv.com"
        ));

        // Configuración del RecyclerView para colegios
        RecyclerView recyclerViewColegios = findViewById(R.id.listRecycledViewColegios);
        recyclerViewColegios.setLayoutManager(new LinearLayoutManager(this));




        // Inicialización del adaptador para colegios
        adapter1 = new listadapter2(colegiosList, this, (item, position) -> {
            item.setFavorito(!item.isFavorito()); // Cambiar el estado de favorito
            adapter1.notifyItemChanged(position);
        });




        recyclerViewColegios.setAdapter(adapter1);






    }



}