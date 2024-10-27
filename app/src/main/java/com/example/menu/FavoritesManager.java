package com.example.menu;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class FavoritesManager {
    private Context context;
    private List<ListadoDeElementos> favorites;

    public FavoritesManager(Context context) {
        this.context = context;
        this.favorites = new ArrayList<>();
    }

    public List<ListadoDeElementos> getFavorites() {
        return new ArrayList<>(favorites);
    }

    public boolean isFavorite(ListadoDeElementos item) {
        return favorites.contains(item);
    }

    public void addFavorite(ListadoDeElementos item) {
        if (!favorites.contains(item)) {
            favorites.add(item);
        }
    }

    public void removeFavorite(ListadoDeElementos item) {
        favorites.remove(item);
    }

    public void updateFavorites(ArrayList<ListadoDeElementos> updatedFavorites) {
        this.favorites = new ArrayList<>(updatedFavorites);
    }
}