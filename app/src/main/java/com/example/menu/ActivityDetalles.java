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
            tvNombre.setText("Santo Tomas");
            tvCiudad.setText("La Serena");
            tvDescripcion.setText("La Universidad Santo Tomás, comúnmente llamada por sus siglas UST, es una universidad privada chilena fundada en 1988.");
            tvDireccion.setText("Ruta 5 1837");
            tvTelefono.setText("987654321");
            tvSitioWeb.setText("http://www.SantoTomas.com");
            ivLogo.setImageResource(R.drawable.santo);
        }
        else if ("Inacap".equals(nombre)) {
            // Similar a lo anterior, pero para la Universidad Católica del Norte.
            tvNombre.setText("Inacap");
            tvCiudad.setText("La Serena");
            tvDescripcion.setText("INACAP ofrece carreras técnicas, profesionales y de educación continua en diversas áreas y modalidades");
            tvDireccion.setText("Francisco de aguirre 1209");
            tvTelefono.setText("987654321");
            tvSitioWeb.setText("http://www.Inacap.com");
            ivLogo.setImageResource(R.drawable.inacap);
        }
        else if ("AIEP".equals(nombre)) {
            // Similar a lo anterior, pero para la Universidad Católica del Norte.
            tvNombre.setText("Aiep");
            tvCiudad.setText("La Serena");
            tvDescripcion.setText("El Instituto Profesional AIEP en La Serena es una institución de educación superior que ofrece una amplia variedad de programas académicos orientados a la formación técnica y profesional. ");
            tvDireccion.setText("Francisco de aguirre 1209");
            tvTelefono.setText("987654321");
            tvSitioWeb.setText("http://www.Inacap.com");
            ivLogo.setImageResource(R.drawable.logoaiepnuevo);
        }
        else if ("IpChile".equals(nombre)) {
            tvNombre.setText("Ip Chile");
            tvCiudad.setText("La Serena");
            tvDescripcion.setText("IPCHILE es una institución acreditada que ofrece carreras técnicas y profesionales, cursos y diplomados en modalidades presencial.");
            tvDireccion.setText("Francisco de Aguirre 729");
            tvTelefono.setText("987654321");
            tvSitioWeb.setText("http://www.IPchile.com");
            ivLogo.setImageResource(R.drawable.ipchile);
        }
        else if ("Geronimo Rendic".equals(nombre)) {
            tvNombre.setText("Colegio Geronimo Rendic");
            tvCiudad.setText("La Serena");
            tvDescripcion.setText("El Colegio Geronimo Rendic se centra en la formación integral de sus estudiantes, promoviendo la disciplina y el respeto.");
            tvDireccion.setText("Dirección del Colegio Geronimo Rendic");
            tvTelefono.setText("987654321");
            tvSitioWeb.setText("http://www.geronimorendic.cl");
            ivLogo.setImageResource(R.drawable.rendic);
        }
        else if ("Bernardo O'Higgins".equals(nombre)) {
            tvNombre.setText("Colegio Bernardo O'Higgins");
            tvCiudad.setText("La Serena");
            tvDescripcion.setText("El Colegio Bernardo O'Higgins ofrece una formación integral, enfocándose en valores como la responsabilidad y el respeto.");
            tvDireccion.setText("Dirección del Colegio Bernardo O'Higgins");
            tvTelefono.setText("987654321");
            tvSitioWeb.setText("http://www.bernardoochiggins.cl");
            ivLogo.setImageResource(R.drawable.logobernardo);
        }
        else if ("Gabriel González Videla".equals(nombre)) {
            tvNombre.setText("Gabriel Gonzales Videla");
            tvCiudad.setText("La Serena");
            tvDescripcion.setText("Colegio Gabriel González Videla imparte formación pre-escolar y escolar, con Educación de Párvulos, en los niveles de Pre-Kinder y Kinder, Enseñanza Básica y Enseñanza Media Polivalente con formación Científica-Humanística y Técnico Profesional, entregando la Especialidad de Gastronomía");
            tvDireccion.setText("Balmaceda 367");
            tvTelefono.setText("987654321");
            tvSitioWeb.setText("http://www.GabrielGonzalezVidela.cl");
            ivLogo.setImageResource(R.drawable.logogabriel);
        }

        // Se repiten condiciones similares para otras universidades como Santo Tomás, IpChile, e Inacap.
        // Esto permite que la aplicación sea escalable, agregando más instituciones fácilmente.

        // Cada sección de código establece el texto de los TextViews y la imagen del ImageView
        // basado en el nombre de la institución, permitiendo que el usuario vea detalles relevantes.
    }
}