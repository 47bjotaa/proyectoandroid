package com.example.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ListadoDeElementos> institucionList;
    private ListAdapter adapter;
    private static final int REQUEST_FAVORITOS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        institucionList = new ArrayList<>();
        // Agregar instituciones a la lista
        institucionList.add(new ListadoDeElementos(
                "Universidad de la Serena",
                "La Serena",
                "Descripción de la Universidad de la Serena",
                R.drawable.uls,
                "Avenida Raúl Bitrán Nachary",
                "123456789",
                "http://www.Usn.com"
        ));
        institucionList.add(new ListadoDeElementos(
                "Universidad de Chile",
                "Santiago",
                "Descripción de la Universidad de Chile",
                R.drawable.logoucn,
                "Avenida Libertador Bernardo O'Higgins",
                "987654321",
                "http://www.uchile.cl"
        ));
        institucionList.add(new ListadoDeElementos(
                "Universidad Catolica Del Norte",
                "Coquimbo",
                "La Universidad Católica del Norte (UCN) es una institución de educación superior chilena privada, perteneciente a la Iglesia católica.",
                R.drawable.logocatolica,
                "Larrondo 1281, Coquimbo",
                "987654321",
                "http://www.Ucn.com"
        ));

        institucionList.add(new ListadoDeElementos(
                "Santo Tomas",
                "La Serena",
                "La Universidad Santo Tomás, comúnmente llamada por sus siglas UST, es una universidad privada chilena fundada en 1988.",
                R.drawable.santo,
                "Ruta 5",
                "987654321",
                "http://www.St.com"
        ));

        institucionList.add(new ListadoDeElementos(
                "IpChile",
                "La Serena",
                "IPCHILE es una institución acreditada que ofrece carreras técnicas y profesionales, cursos y diplomados en modalidades presencial.",
                R.drawable.ipchile,
                "Avenida Francisco de Aguirre 388 1710128 La Serena Coquimbo",
                "987654321",
                "http://www.IpChile.com"
        ));

        institucionList.add(new ListadoDeElementos(
                "Inacap",
                "La Serena",
                "INACAP ofrece carreras técnicas, profesionales y de educación continua en diversas áreas y modalidades.",
                R.drawable.inacap,
                "Av. Francisco De Aguirre #0389 1700000 La Serena Coquimbo.",
                "987654321",
                "http://www.Inacap.com"
        ));
        // Agrega más instituciones según sea necesario

        RecyclerView recyclerView = findViewById(R.id.listRecycledView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ListAdapter(institucionList, this, (item, position) -> {
            item.setFavorito(!item.isFavorito()); // Cambiar el estado de favorito
            adapter.notifyItemChanged(position); // Notificar que solo este elemento ha cambiado
        });
        recyclerView.setAdapter(adapter);

        Button btnFavoritos = findViewById(R.id.btnFavoritos);
        btnFavoritos.setOnClickListener(v -> {
            ArrayList<ListadoDeElementos> favoritosList = new ArrayList<>();
            for (ListadoDeElementos institucion : institucionList) {
                if (institucion.isFavorito()) {
                    favoritosList.add(institucion);
                }
            }
            Intent intent = new Intent(MainActivity.this, FavoritosActivity.class);
            intent.putParcelableArrayListExtra("favoritos", favoritosList);
            startActivityForResult(intent, REQUEST_FAVORITOS);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_FAVORITOS && resultCode == RESULT_OK) {
            ArrayList<ListadoDeElementos> actualizados = data.getParcelableArrayListExtra("actualizados");
            if (actualizados != null) {
                // Restablecer el estado de favoritos en la lista principal
                for (ListadoDeElementos institucion : institucionList) {
                    institucion.setFavorito(false); // Desmarcar todos
                }

                // Marcar solo los elementos que están en la lista de favoritos actualizada
                for (ListadoDeElementos actualizado : actualizados) {
                    for (ListadoDeElementos institucion : institucionList) {
                        if (institucion.getNombre().equals(actualizado.getNombre())) {
                            institucion.setFavorito(actualizado.isFavorito()); // Marcar según el estado actual
                            break;
                        }
                    }
                }

                adapter.notifyDataSetChanged(); // Actualizar la vista
            }
        }
    }
    //public void goToOtherActivity(View view) {
    // Crea un Intent para la nueva Activity
    //Intent intent = new Intent(this, menu.class);

    // Inicia la nueva Activity
    //startActivity(intent);
    //}
}