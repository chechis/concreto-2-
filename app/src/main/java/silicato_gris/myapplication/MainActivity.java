package silicato_gris.myapplication;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import silicato_gris.myapplication.apoyo.AdapterProporcion;
import silicato_gris.myapplication.apoyo.Concreto;
import silicato_gris.myapplication.apoyo.almacenamiento.BaseDatos;
import silicato_gris.myapplication.apoyo.almacenamiento.Servicio;
import silicato_gris.myapplication.fragmento.Cantidad;
import silicato_gris.myapplication.fragmento.Ingreso;
import silicato_gris.myapplication.fragmento.Proporcion;

public class MainActivity extends AppCompatActivity implements AdapterProporcion.ProporcionListener{

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager().
                            beginTransaction().replace(R.id.contenedor, new Ingreso()).commit();
                    break;
                case R.id.navigation_dashboard:
                    getSupportFragmentManager().
                            beginTransaction().replace(R.id.contenedor, new Proporcion()).commit();
                    break;
                case R.id.navigation_notifications:
                    getSupportFragmentManager().
                            beginTransaction().replace(R.id.contenedor, new Cantidad()).commit();
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().
                add(R.id.contenedor, new Ingreso()).commit();

    }

    @Override
    public void deleteProporcion(int position) {

    }

    @Override
    public void editProporcion(int position) {
        MainActivity.this.setTitle("Propocion");
    }

    @Override
    public void verProporcion(int position) {

    }
}
