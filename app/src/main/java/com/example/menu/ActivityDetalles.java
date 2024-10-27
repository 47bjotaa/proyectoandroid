package com.example.menu;

// Importamos clases necesarias para el manejo de la interfaz de usuario y la actividad.
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// Clase principal que extiende AppCompatActivity para crear una nueva actividad.
public class ActivityDetalles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Método que se llama cuando se crea la actividad.
        super.onCreate(savedInstanceState);
        // Establece el diseño de la actividad a partir de un archivo XML.
        setContentView(R.layout.activity_detalles);

        // Inicializamos los elementos de la interfaz de usuario que se encuentran en el layout.
        TextView tvNombre = findViewById(R.id.tvDetailNombre);
        TextView tvCiudad = findViewById(R.id.tvDetailCiudad);
        TextView tvDescripcion = findViewById(R.id.tvDetailDescripcion);
        TextView tvDireccion = findViewById(R.id.tvDetailDireccion);
        TextView tvTelefono = findViewById(R.id.tvDetailTelefono);
        TextView tvSitioWeb = findViewById(R.id.tvDetailSitioWeb);
        ImageView ivLogo = findViewById(R.id.ivDetailLogo);

        // Obtenemos el nombre de la institución desde el Intent que inició esta actividad.
        String nombre = getIntent().getStringExtra("nombre");

        // Usamos una serie de condiciones para mostrar los datos específicos de cada institución.
        // Esto permite que la actividad sea dinámica y muestre diferentes datos según el nombre recibido.
        if ("Universidad de la Serena".equals(nombre)) {
            tvNombre.setText("Universidad de la Serena");
            tvCiudad.setText("la serena");
            tvDescripcion.setText("La Universidad de La Serena es una de las 16 universidades tradicionales de Chile, perteneciente al Consejo de Rectores de las Universidades Chilenas");
            tvDireccion.setText("Avenida Raúl Bitrán Nachary");
            tvTelefono.setText("123456789");
            tvSitioWeb.setText("http://www.Usn.com");
            ivLogo.setImageResource(R.drawable.logo_uls_8);

        } else if ("Universidad de Chile".equals(nombre)) {
            // Similar a lo anterior, pero para la Universidad Católica del Norte.
            tvNombre.setText("Universidad Catolica  Norte");
            tvCiudad.setText("Coquimbo");
            tvDescripcion.setText("La Universidad Católica del Norte (UCN) es una institución de educación superior chilena privada, perteneciente a la Iglesia católica.");
            tvDireccion.setText("Larrondo 1281, Coquimbo");
            tvTelefono.setText("987654321");
            tvSitioWeb.setText("http://www.UCN.com");
            ivLogo.setImageResource(R.drawable.logoucn);
        }
        else if ("Universidad Catolica Del Norte".equals(nombre)) {
            // Similar a lo anterior, pero para la Universidad Católica del Norte.
            tvNombre.setText("Universidad Catolica  Norte");
            tvCiudad.setText("Coquimbo");
            tvDescripcion.setText("La Universidad Católica del Norte (UCN) es una institución de educación superior chilena privada, perteneciente a la Iglesia católica.");
            tvDireccion.setText("Larrondo 1281, Coquimbo");
            tvTelefono.setText("987654321");
            tvSitioWeb.setText("http://www.UCN.com");
            ivLogo.setImageResource(R.drawable.logoucn);
        }
        else if ("Santo Tomas".equals(nombre)) {
            // Similar a lo anterior, pero para la Universidad Católica del Norte.
            tvNombre.setText("Universidad Catolica  Norte");
            tvCiudad.setText("Coquimbo");
            tvDescripcion.setText("La Universidad Católica del Norte (UCN) es una institución de educación superior chilena privada, perteneciente a la Iglesia católica.");
            tvDireccion.setText("Larrondo 1281, Coquimbo");
            tvTelefono.setText("987654321");
            tvSitioWeb.setText("http://www.UCN.com");
            ivLogo.setImageResource(R.drawable.logoucn);
        }
        else if ("Inacap".equals(nombre)) {
            // Similar a lo anterior, pero para la Universidad Católica del Norte.
            tvNombre.setText("Universidad Catolica  Norte");
            tvCiudad.setText("Coquimbo");
            tvDescripcion.setText("La Universidad Católica del Norte (UCN) es una institución de educación superior chilena privada, perteneciente a la Iglesia católica.");
            tvDireccion.setText("Larrondo 1281, Coquimbo");
            tvTelefono.setText("987654321");
            tvSitioWeb.setText("http://www.UCN.com");
            ivLogo.setImageResource(R.drawable.logoucn);
        }
        else if ("IpChile".equals(nombre)) {
            // Similar a lo anterior, pero para la Universidad Católica del Norte.
            tvNombre.setText("Universidad Catolica  Norte");
            tvCiudad.setText("Coquimbo");
            tvDescripcion.setText("La Universidad Católica del Norte (UCN) es una institución de educación superior chilena privada, perteneciente a la Iglesia católica.");
            tvDireccion.setText("Larrondo 1281, Coquimbo");
            tvTelefono.setText("987654321");
            tvSitioWeb.setText("http://www.UCN.com");
            ivLogo.setImageResource(R.drawable.logoucn);
        }
        // Se repiten condiciones similares para otras universidades como Santo Tomás, IpChile, e Inacap.
        // Esto permite que la aplicación sea escalable, agregando más instituciones fácilmente.

        // Cada sección de código establece el texto de los TextViews y la imagen del ImageView
        // basado en el nombre de la institución, permitiendo que el usuario vea detalles relevantes.
    }
}