package silicato_gris.myapplication.fragmento;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import silicato_gris.myapplication.R;
import silicato_gris.myapplication.apoyo.Concreto;
import silicato_gris.myapplication.apoyo.almacenamiento.BaseDatos;
import silicato_gris.myapplication.apoyo.almacenamiento.Estructura;
import silicato_gris.myapplication.apoyo.almacenamiento.Servicio;
import silicato_gris.myapplication.apoyo.tabla_calculo.Calculos;
import silicato_gris.myapplication.apoyo.tabla_calculo.Tablas;

public class Ingreso extends Fragment {

    private TextInputLayout editResistencia, editPesoConcreto, editPesoFinoSuelto,
            editPesoFinoComp, editPesoGruesoSuelto, editPesoGruesoCompac , editVolumen;
    private Spinner spnFactor, spnElemento, spnTMN;

    int tmn, asentamiento, factor;

    private Calculos calculo = new Calculos();


    private double relacionAC, propUnitariaCemento, propUnitariaAgregados, propUnitariaArena, propUnitariaPiedrin,
            propUnitariaAgua, propVolArena, propVolPiedrin, comprarCemento, comprarArena, comprarPiedrin,
            comprarAgua, costalArena, costalPiedrin, costalAgua;


    TextView pruebaText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ingreso, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pruebaText = (TextView) view.findViewById(R.id.prueba);

        editResistencia = (TextInputLayout) view.findViewById(R.id.edit_resistencia);
        editPesoConcreto = (TextInputLayout) view.findViewById(R.id.edit_peso_concreto);
        editPesoFinoSuelto = (TextInputLayout) view.findViewById(R.id.edit_peso_fino_suelto);
        editPesoFinoComp = (TextInputLayout) view.findViewById(R.id.edit_peso_fino_compactado);
        editPesoGruesoSuelto = (TextInputLayout) view.findViewById(R.id.edit_peso_grueso_suelto);
        editPesoGruesoCompac = (TextInputLayout) view.findViewById(R.id.edit_peso_grueso_compactado);
        editVolumen = (TextInputLayout) view.findViewById(R.id.edit_volumen);

        spnFactor = (Spinner) view.findViewById(R.id.spinner_factor);
        spnElemento = (Spinner) view.findViewById(R.id.spinner_elemento);
        spnTMN = (Spinner) view.findViewById(R.id.spinner_tmn);


        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.ingreso_btn_flotante);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                agregarMezcla();

            }
        });

        FloatingActionButton prueba =  (FloatingActionButton) view.findViewById(R.id.ingreso_btn);
        prueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leerBase();
            }
        });

    }

    private void leerBase() {
        Context context = getContext();
        BaseDatos baseDatos = new BaseDatos(getContext());
        SQLiteDatabase myDatabase;


        myDatabase = baseDatos.getWritableDatabase();

        Cursor cursor = myDatabase.rawQuery("SELECT * FROM "+ Estructura.EstructuraBase.TABLE_NAME+";", null);
        //listaTarea.clear();
        if (cursor.moveToFirst()){
            do {
                int id = cursor.getInt(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_ID));
                Double resistencia = cursor.getDouble(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_RESISTENCIA));
                int factor = cursor.getInt(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_FACTOR));
                int elemento = cursor.getInt(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_ELEMENTO));
                int tmn = cursor.getInt(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_TMN));
                int pesoConcreto = cursor.getInt(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PESO_CONCRETO));
                int pesoSueltoFino = cursor.getInt(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PESO_SUELTO_FINO));
                int pesoCompactadoFino = cursor.getInt(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PESO_COMPACTADO_FINO));
                int pesoSueltoGrueso = cursor.getInt(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PESO_SUELTO_GRUESO));
                int pesoCompactadoGrueso = cursor.getInt(cursor.getColumnIndex(Estructura.EstructuraBase.COLUMN_NAME_PESO_COMPACTADO_GRUESO));

                /*Toast.makeText(context, "id"+id+ " resistencia"+resistencia+ "  factor"+factor+ "  elemento"+elemento+"  tmn"+tmn+
                                "  peso Concreto"+pesoConcreto+"  pesos Finos "+pesoSueltoFino+pesoCompactadoFino+ "pesos Gruesos"+pesoSueltoGrueso+pesoCompactadoGrueso, Toast.LENGTH_LONG).show();
*/

                Tablas tablas = new Tablas(asentamiento, tmn);
                Calculos calculos = new Calculos();

                Double ac = calculos.relacionAC(resistencia);
                Double acRedon = calculos.redondeo(ac, 3);

                int cantidadAgua = tablas.tablaAgua(asentamiento, tmn);
                Double cantidadArena = tablas.tablaArena(tmn);

                Toast.makeText(context, "Agua lt"+cantidadAgua+"  Cantidad de arena"+cantidadArena+" Rel AC"+acRedon, Toast.LENGTH_LONG).show();

               // listaTarea.add(new Tarea(id, nombreTarea, estudiante, asignatura, nota));
            }while (cursor.moveToNext());
        }
        cursor.close();

    }

    private void agregarMezcla (){

        Context context = getContext();
        Concreto concreto = new Concreto();

        boolean login = true;
        if (editResistencia !=null && editPesoConcreto != null){
            double resistencia = Double.parseDouble(editResistencia.getEditText().getText().toString());
            int pesoConcreto = Integer.parseInt(editPesoConcreto.getEditText().getText().toString());
            int pesoFinoSuelto = Integer.parseInt(editPesoFinoSuelto.getEditText().getText().toString());
            int pesoFinoCompac = Integer.parseInt(editPesoFinoComp.getEditText().getText().toString());
            int pesoGruesoSuelto = Integer.parseInt(editPesoGruesoSuelto.getEditText().getText().toString());
            int pesoGruesoCompac = Integer.parseInt(editPesoGruesoCompac.getEditText().getText().toString());
            double volumen = Double.parseDouble(editVolumen.getEditText().getText().toString());

            switch (spnFactor.getSelectedItemPosition()){
                case 0:
                    factor = 25;
                    break;
                case 1:
                    factor = 30;
                    break;
                case 2:
                    factor = 35;
                    break;
                case 3:
                    factor = 40;
                    break;
                case 4:
                    factor = 50;
                    break;
                case 5:
                    factor = 0;
                    break;
            }


            switch (spnElemento.getSelectedItemPosition()){
                case 0:
                    asentamiento = 2;
                    break;
                case 1:
                    asentamiento = 1;
                    break;
                case 2:
                    asentamiento = 0;
                    break;
            }


            switch (spnTMN.getSelectedItemPosition()){
                case 0:
                    tmn = 0;
                    break;
                case 1:
                    tmn = 1;
                    break;
                case 2:
                    tmn = 2;
                    break;
                case 3:
                    tmn = 3;
                    break;
                case 4:
                    tmn = 4;
                    break;

            }

            Tablas tablas = new Tablas(asentamiento, tmn);

            double fc = resistencia+Double.parseDouble(String.valueOf(factor));
            relacionAC = calculo.relacionAC(fc);

            propUnitariaAgua = tablas.tablaAgua(asentamiento, tmn);
            propUnitariaCemento = calculo.cantidadCemento(tablas.tablaAgua(asentamiento, tmn),relacionAC);
            propUnitariaAgregados = calculo.cantidadAgregados(tablas.tablaAgua(asentamiento, tmn), propUnitariaCemento, pesoConcreto);
            propUnitariaArena = calculo.cantidadFino(propUnitariaAgregados, tablas.tablaArena(tmn));
            propUnitariaPiedrin = calculo.cantidadGrueso(propUnitariaAgregados, tablas.tablaArena(tmn));

            propVolArena = calculo.propArena(propUnitariaCemento, propUnitariaArena);
            propVolPiedrin = calculo.propPiedrin(propUnitariaCemento, propUnitariaPiedrin);

            comprarCemento = calculo.comprarCemento(propUnitariaCemento, volumen);
            comprarArena = calculo.comprarArena(propUnitariaArena, volumen, pesoFinoCompac);
            comprarPiedrin = calculo.comprarPiedrin(propUnitariaPiedrin, volumen, pesoGruesoCompac);
            comprarAgua = calculo.comprarAgua(propUnitariaAgua, volumen);

            costalArena = calculo.costalArena(pesoFinoSuelto, propVolArena);
            costalPiedrin = calculo.costalPiedrin(pesoGruesoSuelto, propVolPiedrin);
            costalAgua = calculo.costalAgua(relacionAC);

            pruebaText.setText(relacionAC+"\n"+propUnitariaAgua+"\n"+propUnitariaCemento+"\n"+propUnitariaAgregados+"\n"
                    +propUnitariaArena+"\n"+propUnitariaPiedrin+"\n"+propVolArena+"\n"+propVolPiedrin+"\n"+comprarCemento+"\n"+comprarArena+"\n"
                    +comprarPiedrin+"\n"+comprarAgua+"\n"+costalArena+"\n"+costalPiedrin+"\n"+costalAgua+"\n");

            BaseDatos baseDatos = new BaseDatos(getContext());

            SQLiteDatabase sq = baseDatos.getWritableDatabase();
            Servicio servicio = new Servicio("resistencia", context);
            servicio.guardarDatos(resistencia,factor,asentamiento,tmn,pesoConcreto,pesoFinoSuelto,pesoFinoCompac,pesoGruesoSuelto,pesoGruesoCompac,baseDatos,context);
            sq.close();
        }

    }


    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Ingreso de datos");
    }
}
