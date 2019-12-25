package silicato_gris.myapplication.fragmento;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import silicato_gris.myapplication.R;
import silicato_gris.myapplication.apoyo.AdapterProporcion;
import silicato_gris.myapplication.apoyo.Concreto;
import silicato_gris.myapplication.apoyo.almacenamiento.BaseDatos;
import silicato_gris.myapplication.apoyo.almacenamiento.Estructura;
import silicato_gris.myapplication.apoyo.almacenamiento.Servicio;

public class Proporcion extends Fragment implements AdapterProporcion.ProporcionListener{

    AdapterProporcion adapterProporcion;
    RecyclerView recyclerView;
    Context context = getContext();
    private  List<Concreto> listaConcreto = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_proporcion, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        actualizarLista();
        llenandoAdapter(listaConcreto, view);


    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Propocion de la mezcla");
    }

    private void llenandoAdapter (List<Concreto> lista, View view){
        adapterProporcion = new AdapterProporcion(lista);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_proporcion);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterProporcion);
    }
    private void regresar(View view){
        actualizarLista();
        llenandoAdapter(listaConcreto, view);
    }
    private void actualizarLista(){

        BaseDatos baseDatos = new BaseDatos(getContext());
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
    public void deleteProporcion(int position) {
        final int posicion = position;
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("¿Está seguro de que desea eliminar el diseño?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        BaseDatos baseDatos = new BaseDatos(getContext());
                        Concreto concreto = listaConcreto.get(posicion);
                        Servicio servicio = new Servicio("resistencia", getContext());
                        servicio.eliminarDato(concreto, baseDatos, getContext());
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
        Toast.makeText(getContext(), "hola", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void verProporcion(int position) {
        getActivity().setTitle("Propocion");
    }
}
