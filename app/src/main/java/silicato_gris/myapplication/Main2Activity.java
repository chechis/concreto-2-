package silicato_gris.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import silicato_gris.myapplication.alertas.AlertaIngreso;
import silicato_gris.myapplication.apoyo.AdapterProporcion;
import silicato_gris.myapplication.apoyo.Concreto;
import silicato_gris.myapplication.apoyo.ConcretoAlerta;
import silicato_gris.myapplication.apoyo.almacenamiento.BaseDatos;
import silicato_gris.myapplication.apoyo.almacenamiento.Estructura;
import silicato_gris.myapplication.apoyo.almacenamiento.Servicio;
import silicato_gris.myapplication.apoyo.tabla_calculo.Calculos;

public class Main2Activity extends AppCompatActivity implements AlertaIngreso.IngresoListener,
                                                        AdapterProporcion.ProporcionListener{

    AdapterProporcion adapterProporcion;
    RecyclerView recyclerView;
    private  List<Concreto> listaConcreto = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actualizarLista();
        llenandoAdapter(listaConcreto);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertaIngreso alertaIngreso = new AlertaIngreso();
                alertaIngreso.show(getSupportFragmentManager(), "alertaIngreso");
            }
        });
    }

    private void llenandoAdapter (List<Concreto> lista){
        adapterProporcion = new AdapterProporcion(lista);
        adapterProporcion.setProporcionListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_proporcion);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterProporcion);
    }
    private void regresar(){
        actualizarLista();
        llenandoAdapter(listaConcreto);
    }
    private void actualizarLista(){

        BaseDatos baseDatos = new BaseDatos(this);
        SQLiteDatabase myDatabase;

        myDatabase = baseDatos.getWritableDatabase();

        Cursor cursor = myDatabase.rawQuery("SELECT * FROM "+ Estructura.EstructuraBase.TABLE_NAME+";", null);
        listaConcreto.clear();
        if (cursor.moveToFirst()){
            do {
                int id = cursor.getInt(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_ID));
                String nombreProyecto = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PROYECTO));
                String resistencia = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_RESISTENCIA));
                String asentamiento= cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_ELEMENTO));
                String tmn = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_TMN));
                String relAC = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_RELACION_AC));
                String propUniCemento = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_CEMENTO));
                String propUniFino = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_ARENA));
                String propUniGrueso = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_PIEDRIN));
                String propUniAgua = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_AGUA));
                String propVolFino = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PROP_VOLUMETRICA_ARENA));
                String propVolGrueso = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PROP_VOLUMETRICA_PIEDRIN));
                String costalFino = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_COSTAL_ARENA));
                String costalGrueso = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_COSTAL_PIEDRIN));
                String costalAgua = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_COSTAL_AGUA));

                listaConcreto.add(new Concreto(id, nombreProyecto, resistencia, asentamiento, tmn, relAC, propUniCemento,
                        propUniFino, propUniGrueso, propUniAgua, propVolFino, propVolGrueso, costalFino, costalGrueso, costalAgua));
            }while (cursor.moveToNext());
        }
        cursor.close();
    }

    @Override
    public void agregarMezcla(ConcretoAlerta concreto) {

        BaseDatos baseDatos = new BaseDatos(Main2Activity.this);
        SQLiteDatabase sq = baseDatos.getWritableDatabase();
        Servicio servicio = new Servicio("resistencia", Main2Activity.this);
        servicio.guardarDatos(concreto.getNombreProyecto(), concreto.getResistencia(), concreto.getFactor(), concreto.getAsentamiento(), concreto.getTmn(),
                concreto.getPesoConcreto(), concreto.getPesoFinoSuelto(), concreto.getPesofinoCompacto(),
                concreto.getPesoGruesoSuelto(), concreto.getPesoGruesoComacto(), concreto.getRelAC(), concreto.getPropUniCemento(), concreto.getPropUniAgregados(),
                concreto.getPropUniFino(), concreto.getPropUniGrueso(), concreto.getPropUniAgua(), concreto.getPropVolFino(), concreto.getPropVolGrueso(),
                concreto.getComprarCemento(), concreto.getComprarArena(), concreto.getComprarPiedrin(), concreto.getComprarAgua(), concreto.getCostalFino(), concreto.getComprarPiedrin(),
                concreto.getCostalAgua(), baseDatos, Main2Activity.this);
        sq.close();
        actualizarLista();
        adapterProporcion.notifyDataSetChanged();
    }

    @Override
    public void deleteProporcion(int position) {
        final int posicion = position;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Está seguro de que desea eliminar el diseño?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        BaseDatos baseDatos = new BaseDatos(Main2Activity.this);
                        Concreto concreto = listaConcreto.get(posicion);
                        Servicio servicio = new Servicio("resistencia", Main2Activity.this);
                        servicio.eliminarDato(concreto, baseDatos, Main2Activity.this);
                        actualizarLista();
                        adapterProporcion.notifyDataSetChanged();

                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    @Override
    public void editProporcion(int position) {

    }

    @Override
    public void verProporcion(int position) {

    }
}
