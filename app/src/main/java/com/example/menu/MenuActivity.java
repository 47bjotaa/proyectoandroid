package com.example.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.menu.databinding.ActivityMenuBinding;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMenuBinding binding;
    private FavoritesManager favoritesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMenu.toolbar);
        binding.appBarMenu.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_Universidades, R.id.nav_Colegios)
                .setOpenableLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menu);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Inicializar el FavoritesManager
        favoritesManager = new FavoritesManager(this);

        // Listener para los elementos del menú
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                // Iniciar la actividad de favoritos
                Intent intent = new Intent(MenuActivity.this, FavoritosActivity.class);
                intent.putParcelableArrayListExtra("favoritos", new ArrayList<>(favoritesManager.getFavorites()));
                startActivityForResult(intent, REQUEST_CODE_FAVORITES);
                return true;
            }
            if (id == R.id.nav_Universidades) {
                // Iniciar la actividad principal
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
                return true;
            }
            if (id == R.id.nav_Contactanos) {
                // Iniciar la actividad principal
                Intent intent = new Intent(MenuActivity.this, Contactanos.class);
                startActivity(intent);
                return true;
            }
            if (id == R.id.nav_Servicios) {
                // Iniciar la actividad principal
                Intent intent = new Intent(MenuActivity.this, servicios.class);
                startActivity(intent);
                return true;
            }
            if (id == R.id.nav_Institutos) {
                // Iniciar la actividad principal
                Intent intent = new Intent(MenuActivity.this, MainActivity3.class);
                startActivity(intent);
                return true;
            }
            if (id == R.id.nav_Colegios) {
                // Iniciar la actividad principal
                Intent intent = new Intent(MenuActivity.this, MainActivity2.class);
                startActivity(intent);
                return true;
            }


            // Manejar otros elementos de menú si es necesario
            return NavigationUI.onNavDestinationSelected(item, navController)
                    || super.onOptionsItemSelected(item);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menu);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private static final int REQUEST_CODE_FAVORITES = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_FAVORITES && resultCode == RESULT_OK && data != null) {
            ArrayList<ListadoDeElementos> updatedFavorites = data.getParcelableArrayListExtra("actualizados");
            if (updatedFavorites != null) {
                favoritesManager.updateFavorites(updatedFavorites);
            }
        }
    }

    private void toggleFavorite(ListadoDeElementos institution) {
        if (favoritesManager.isFavorite(institution)) {
            favoritesManager.removeFavorite(institution);
            // Actualizar el estado visual de la estrella
        } else {
            favoritesManager.addFavorite(institution);
            // Actualizar el estado visual de la estrella
        }
    }
}