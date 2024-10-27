package com.example.menu;

import android.os.Parcel;
import android.os.Parcelable;

public class ListaDeElementos3 implements Parcelable {  // Implements Parcelable
    private String nombre;
    private String ciudad;
    private String descripcion;
    private int imageResId;
    private String direccion;
    private String telefono;
    private String sitioWeb;
    private boolean favorito;

    // Constructor
    public ListaDeElementos3(String nombre, String ciudad, String descripcion, int imageResId,
                             String direccion, String telefono, String sitioWeb) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.descripcion = descripcion;
        this.imageResId = imageResId;
        this.direccion = direccion;
        this.telefono = telefono;
        this.sitioWeb = sitioWeb;
        this.favorito = false; // Initially not a favorite
    }

    // Parcel constructor
    protected ListaDeElementos3(Parcel in) {
        nombre = in.readString();
        ciudad = in.readString();
        descripcion = in.readString();
        imageResId = in.readInt();
        direccion = in.readString();
        telefono = in.readString();
        sitioWeb = in.readString();
        favorito = in.readByte() != 0; // 1 is true, 0 is false
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(ciudad);
        dest.writeString(descripcion);
        dest.writeInt(imageResId);
        dest.writeString(direccion);
        dest.writeString(telefono);
        dest.writeString(sitioWeb);
        dest.writeByte((byte) (favorito ? 1 : 0)); // 1 is true, 0 is false
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ListaDeElementos3> CREATOR = new Creator<ListaDeElementos3>() { // Fixed the Creator type
        @Override
        public ListaDeElementos3 createFromParcel(Parcel in) {
            return new ListaDeElementos3(in);
        }

        @Override
        public ListaDeElementos3[] newArray(int size) {
            return new ListaDeElementos3[size];
        }
    };

    // Getters and Setters
    public String getNombre() { return nombre; }
    public String getCiudad() { return ciudad; }
    public String getDescripcion() { return descripcion; }
    public int getImageResId() { return imageResId; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public String getSitioWeb() { return sitioWeb; }
    public boolean isFavorito() { return favorito; }
    public void setFavorito(boolean favorito) { this.favorito = favorito; }
}