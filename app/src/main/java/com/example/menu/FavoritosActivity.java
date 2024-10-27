package com.example.menu;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {
    private ArrayList<ListadoDeElementos> favoritos; // Lista de favoritos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_favoritos);

        // Manejo de insets para evitar superposición con la barra de estado
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupUI();
    }

    private void setupUI() {
        TextView title = findViewById(R.id.title);
        if (title != null) {
            title.setText("Mis Favoritos");
        }

        // Obtener la lista de favoritos de la intención
        favoritos = getIntent().getParcelableArrayListExtra("favoritos");

        RecyclerView recyclerView = findViewById(R.id.recyclerViewFavoritos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Crear el adaptador y pasar la lógica para manejar el clic en el ícono de favorito
        ListAdapter adapter = new ListAdapter(favoritos, this, this::onFavoritoClicked);
        recyclerView.setAdapter(adapter);
    }

    private void onFavoritoClicked(ListadoDeElementos item, int position) {
        // Cambiar el estado de favorito
        item.setFavorito(false); // Desmarcar como favorito
        favoritos.remove(position); // Eliminar de la lista de favoritos

        // Notificar que el elemento fue eliminado
        RecyclerView recyclerView = findViewById(R.id.recyclerViewFavoritos);
        recyclerView.getAdapter().notifyItemRemoved(position);

        // Si quieres hacer algo más, como mostrar un mensaje, puedes hacerlo aquí
    }

    @Override
    public void onBackPressed() {
        // Crear un nuevo Intent para regresar a MainActivity con la lista de favoritos actualizada
        Intent resultIntent = new Intent();
        resultIntent.putParcelableArrayListExtra("actualizados", favoritos);
        setResult(RESULT_OK, resultIntent);
        super.onBackPressed(); // Cierra la actividad
    }
}