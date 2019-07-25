package silicato_gris.myapplication.fragmento;


import android.content.Context;
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

import silicato_gris.myapplication.R;
import silicato_gris.myapplication.apoyo.Concreto;
import silicato_gris.myapplication.apoyo.almacenamiento.BaseDatos;
import silicato_gris.myapplication.apoyo.almacenamiento.Servicio;

public class Ingreso extends Fragment {

    private TextInputLayout editResistencia, editPesoConcreto, editPesoFinoSuelto,
            editPesoFinoComp, editPesoGruesoSuelto, editPesoGruesoCompac;
    private Spinner spnFactor, spnElemento, spnTMN;

    int tmn, asentamiento, factor;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ingreso, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editResistencia = (TextInputLayout) view.findViewById(R.id.edit_resistencia);
        editPesoConcreto = (TextInputLayout) view.findViewById(R.id.edit_peso_concreto);
        editPesoFinoSuelto = (TextInputLayout) view.findViewById(R.id.edit_peso_fino_suelto);
        editPesoFinoComp = (TextInputLayout) view.findViewById(R.id.edit_peso_fino_compactado);
        editPesoGruesoSuelto = (TextInputLayout) view.findViewById(R.id.edit_peso_grueso_suelto);
        editPesoGruesoCompac = (TextInputLayout) view.findViewById(R.id.edit_peso_grueso_compactado);

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

    }

    private void agregarMezcla (){

        Context context = getContext();
        Concreto concreto = new Concreto();

        boolean login = true;
        if (editResistencia !=null && editPesoConcreto != null){
            double resistencia = Integer.parseInt(editResistencia.getEditText().getText().toString());
            int pesoConcreto = Integer.parseInt(editPesoConcreto.getEditText().getText().toString());
            int pesoFinoSuelto = Integer.parseInt(editPesoFinoSuelto.getEditText().getText().toString());
            int pesoFinoCompac = Integer.parseInt(editPesoFinoComp.getEditText().getText().toString());
            int pesoGruesoSuelto = Integer.parseInt(editPesoGruesoSuelto.getEditText().getText().toString());
            int pesoGruesoCompac = Integer.parseInt(editPesoGruesoCompac.getEditText().getText().toString());

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
                    asentamiento = 10;
                    break;
                case 1:
                    asentamiento = 8;
                    break;
                case 2:
                    asentamiento = 5;
                    break;
            }


            switch (spnFactor.getSelectedItemPosition()){
                case 0:
                    tmn = 1;
                    break;
                case 1:
                    tmn = 2;
                    break;
                case 2:
                    tmn = 3;
                    break;
                case 3:
                    tmn = 4;
                    break;
                case 4:
                    tmn = 5;
                    break;

            }

            BaseDatos baseDatos = new BaseDatos(getContext());

            SQLiteDatabase sq = baseDatos.getWritableDatabase();
            Servicio servicio = new Servicio("resistencia", context);
            servicio.guardarDatos(resistencia,factor,asentamiento,tmn,pesoConcreto,pesoFinoSuelto,pesoFinoCompac,pesoGruesoSuelto,pesoGruesoCompac,baseDatos,context);
            sq.close();
        }

    }

  //colocar un metodo para hacer calculos y ponerlo arriba

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Ingreso de datos");
    }
}
