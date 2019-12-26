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

import silicato_gris.myapplication.alertas.AlertaEditProp;
import silicato_gris.myapplication.alertas.AlertaIngreso;
import silicato_gris.myapplication.apoyo.AdapterProporcion;
import silicato_gris.myapplication.apoyo.Concreto;
import silicato_gris.myapplication.apoyo.ConcretoAlerta;
import silicato_gris.myapplication.apoyo.ConcretoEditar;
import silicato_gris.myapplication.apoyo.almacenamiento.BaseDatos;
import silicato_gris.myapplication.apoyo.almacenamiento.Estructura;
import silicato_gris.myapplication.apoyo.almacenamiento.Servicio;
import silicato_gris.myapplication.apoyo.tabla_calculo.Calculos;

public class Main2Activity extends AppCompatActivity implements AlertaIngreso.IngresoListener,
                                                        AdapterProporcion.ProporcionListener, AlertaEditProp.EditarListener{

    AdapterProporcion adapterProporcion;
    RecyclerView recyclerView;
    private  List<Concreto> listaConcreto = new ArrayList<>();
    private  List<ConcretoEditar> listaEditar = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actualizarLista();
        actualizarEditar();
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

    private void actualizarEditar(){

        BaseDatos baseDatos = new BaseDatos(this);
        SQLiteDatabase myDatabase;

        myDatabase = baseDatos.getWritableDatabase();

        Cursor cursor = myDatabase.rawQuery("SELECT * FROM "+ Estructura.EstructuraBase.TABLE_NAME+";", null);
        listaEditar.clear();
        if (cursor.moveToFirst()){
            do {
                int id = cursor.getInt(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_ID));
                String nombreProyecto = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PROYECTO));
                String resistencia = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_RESISTENCIA));
                String factor = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_FACTOR));
                String asentamiento= cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_ELEMENTO));
                String tmn = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_TMN));
                String pesoConcreto = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PESO_CONCRETO));
                String pesoFinoSuelto = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PESO_SUELTO_FINO));
                String pesoFinoCompac = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PESO_COMPACTADO_FINO));
                String pesoGruesoSuelto = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PESO_SUELTO_GRUESO));
                String pesoGruesoCompac = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PESO_COMPACTADO_GRUESO));
                String relacionAC = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_RELACION_AC));
                String propUnitariaCemento = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_CEMENTO));
                String propUnitariaAgregados = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_AGREGADOS));
                String propUnitariaArena = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_ARENA));
                String propUnitariaPiedrin = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_PIEDRIN));
                String propUnitariaAgua = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PROP_UNITARIA_AGUA));
                String propVolArena = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PROP_VOLUMETRICA_ARENA));
                String propVolPiedrin = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PROP_VOLUMETRICA_PIEDRIN));
                String comprarCemento = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_COMPRAR_CEMENTO));
                String comprarArena = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_COMPRAR_ARENA));
                String comprarPiedrin = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_COMPRAR_PIEDRIN));
                String comprarAgua = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_COMPRAR_AGUA));
                String costalArena = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_COSTAL_ARENA));
                String costalPiedrin = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_COSTAL_PIEDRIN));
                String costalAgua = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_COSTAL_AGUA));
                String volumen = cursor.getString(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_VOLUMEN));

                listaEditar.add(new ConcretoEditar(id, nombreProyecto, resistencia, factor, asentamiento, tmn, pesoConcreto, pesoFinoSuelto, pesoFinoCompac,
                        pesoGruesoSuelto,pesoGruesoCompac,relacionAC, propUnitariaCemento, propUnitariaAgregados,
                        propUnitariaArena, propUnitariaPiedrin, propUnitariaAgua, propVolArena, propVolPiedrin,
                        comprarCemento, comprarArena, comprarPiedrin, comprarAgua, costalArena, costalPiedrin, costalAgua, volumen));
            }while (cursor.moveToNext());
        }
        cursor.close();
    }

    @Override
    public void agregarMezcla(ConcretoAlerta concreto) {
        int asentamiento = concreto.getAsentamiento();
        if (asentamiento== 2){
            asentamiento = 12;
        }
        if (asentamiento == 1) {
            asentamiento =8;
        }if (asentamiento ==0){
            asentamiento = 5;
        }
        int tmn = concreto.getTmn();
        String tmnText = "tmn";
        if (tmn == 0){
            tmnText = "3/8";
        }if (tmn == 1){
            tmnText = "1/2";
        }if (tmn == 2){
            tmnText = "3/4";
        }if (tmn == 3){
            tmnText = "1";
        }if (tmn == 4){
            tmnText = "1 1/2";
        }

        BaseDatos baseDatos = new BaseDatos(Main2Activity.this);
        SQLiteDatabase sq = baseDatos.getWritableDatabase();
        Servicio servicio = new Servicio("resistencia", Main2Activity.this);
        servicio.guardarDatos(concreto.getNombreProyecto(), concreto.getResistencia(), concreto.getFactor(), asentamiento, tmnText,
                concreto.getPesoConcreto(), concreto.getPesoFinoSuelto(), concreto.getPesofinoCompacto(),
                concreto.getPesoGruesoSuelto(), concreto.getPesoGruesoComacto(), concreto.getRelAC(), concreto.getPropUniCemento(), concreto.getPropUniAgregados(),
                concreto.getPropUniFino(), concreto.getPropUniGrueso(), concreto.getPropUniAgua(), concreto.getPropVolFino(), concreto.getPropVolGrueso(),
                concreto.getComprarCemento(), concreto.getComprarArena(), concreto.getComprarPiedrin(), concreto.getComprarAgua(), concreto.getCostalFino(), concreto.getCostalGrueso(),
                concreto.getCostalAgua(), concreto.getVolConcreto(), baseDatos, Main2Activity.this);
        sq.close();
        actualizarLista();
        actualizarEditar();
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
        actualizarEditar();
        ConcretoEditar concreto = listaEditar.get(position);
        int id = concreto.getId();
        String proyecto = concreto.getNombreProyecto();
        String resistencia = concreto.getResistencia();
        String volumen= concreto.getVolumen();
        String factor = concreto.getFactor();
        String asentamiento = concreto.getAsentamiento();
        String tmn = concreto.getTmn();
        String pesoConcreto = concreto.getPesoConcreto();
        String pesoFinoSuelto = concreto.getPesoFinoSuelto();
        String pesoFinoCompactado = concreto.getPesofinoCompacto();
        String pesoGruesoSuelto = concreto.getPesoGruesoSuelto();
        String pesoGruesoCompactado = concreto.getPesoGruesoComacto();

        AlertaEditProp alertaEditProp = new AlertaEditProp();
        alertaEditProp.show(getSupportFragmentManager(), "Editar mezcla");

        alertaEditProp.setId(id);
        alertaEditProp.setNombre(proyecto);
        alertaEditProp.setResistencia(resistencia);
        alertaEditProp.setPesoConcreto(pesoConcreto);
        alertaEditProp.setPesoFinoSuelto(pesoFinoSuelto);
        alertaEditProp.setPesoFinoCompactado(pesoFinoCompactado);
        alertaEditProp.setPesoGruesoSuelto(pesoGruesoSuelto);
        alertaEditProp.setPesoGruesoCompactado(pesoGruesoCompactado);
        alertaEditProp.setVolumen(volumen);
        alertaEditProp.setFactorAlerta("Factor de seguridad:  "+ factor+"\n TMN:  "+tmn+"\n Asentamiento: "+asentamiento);
    }

    @Override
    public void verProporcion(int position) {


    }

    @Override
    public void editarMezcla(ConcretoAlerta concreto) {

        int asentamiento = concreto.getAsentamiento();
        if (asentamiento== 2){
            asentamiento = 12;
        }
        if (asentamiento == 1) {
            asentamiento =8;
        }if (asentamiento ==0){
            asentamiento = 5;
        }

        int tmn = concreto.getTmn();
        String tmnText = "tmn";
        if (tmn == 0){
            tmnText = "3/8";
        }if (tmn == 1){
            tmnText = "1/2";
        }if (tmn == 2){
            tmnText = "3/4";
        }if (tmn == 3){
            tmnText = "1";
        }if (tmn == 4){
            tmnText = "1 1/2";
        }
        BaseDatos baseDatos = new BaseDatos(Main2Activity.this);
        SQLiteDatabase sq = baseDatos.getWritableDatabase();
        Servicio servicio = new Servicio("resistencia", Main2Activity.this);

        servicio.modificarDatos(concreto.getId(),concreto.getNombreProyecto(), concreto.getResistencia(), concreto.getFactor(), asentamiento, tmnText,
                concreto.getPesoConcreto(), concreto.getPesoFinoSuelto(), concreto.getPesofinoCompacto(),
                concreto.getPesoGruesoSuelto(), concreto.getPesoGruesoComacto(), concreto.getRelAC(), concreto.getPropUniCemento(), concreto.getPropUniAgregados(),
                concreto.getPropUniFino(), concreto.getPropUniGrueso(), concreto.getPropUniAgua(), concreto.getPropVolFino(), concreto.getPropVolGrueso(),
                concreto.getComprarCemento(), concreto.getComprarArena(), concreto.getComprarPiedrin(), concreto.getComprarAgua(), concreto.getCostalFino(), concreto.getCostalGrueso(),
                concreto.getCostalAgua(), concreto.getVolConcreto(), baseDatos, Main2Activity.this);
        //sq.close();
        actualizarLista();
        adapterProporcion.notifyDataSetChanged();

    }
}
